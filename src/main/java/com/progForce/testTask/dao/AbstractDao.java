package com.progForce.testTask.dao;

import com.progForce.testTask.model.Good;
import com.progForce.testTask.util.JdbcConnector;
import com.progForce.testTask.util.StringConver;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AbstractDao<T, ID> implements CrudDao<T, ID> {
    private static final Logger logger = Logger.getLogger(AbstractDao.class);
    protected final Connection connection = JdbcConnector.getConnection();
    protected final Class<T> clazz;
    private Field[] fields;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
        fields = this.clazz.getDeclaredFields();
    }

    @Override
    public Optional<T> save(T entity) {
        String query = getSaveQuery(entity);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.error("Check your sql query " + e);
        }
        return Optional.of(entity);
    }

    @Override
    public Optional<Good> deleteById(ID id) {
        String query = getDeleteQuery(id);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.error("Check your sql query " + e);
        }
        return null;
    }

    @Override
    public Optional<T> readById(ID id) {
        String query = getSelectQuery(id);
        T entity = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                entity = clazz.newInstance();
                for (Field field : fields) {
                    field.setAccessible(true);
                    field.set(entity, resultSet.getObject(field.getName()));
                }
            }
        } catch (Exception e) {
            logger.error("Check your sql query " + e);
        }
        return Optional.of(entity);
    }

    @Override
    public void update(T entity) {
        String query = getUpdateQuery(entity);
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.error("Check your sql query " + e);
        }
    }

    @Override
    public List<T> getAll() {
        String query = getSelectAllQuery();
        T eintity = null;
        List<T> entityList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                eintity = clazz.newInstance();
                for (Field field : fields) {
                    field.setAccessible(true);
                    field.set(eintity, resultSet.getObject(field.getName()));
                }
                entityList.add(eintity);
            }
        } catch (Exception e) {
            logger.error("Check your sql query " + e);
        }
        return entityList;
    }

    private String getSaveQuery(T entity) {
        StringBuilder query = new StringBuilder("INSERT INTO ");
        query.append(StringConver.toSnakeCase(clazz.getSimpleName()) + " VALUES (");
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                String buf;
                if (field.getName().equals("id")) {
                    buf = "NULL";

                } else if (!field.getType().isPrimitive()) {
                    buf = '\'' + field.get(entity).toString() + '\'';
                } else {
                    buf = field.get(entity).toString();
                }
                query.append(buf + ", ");

            } catch (IllegalAccessException e) {
                logger.error("Check this exception " + e);
            }
        }
        query = new StringBuilder(query.substring(0, query.length() - 2));
        query.append(");");
        return query.toString();
    }

    private String getDeleteQuery(ID id) {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(StringConver.toSnakeCase(clazz.getSimpleName()) + " WHERE id = " + id + ';');
        return query.toString();
    }

    private String getSelectQuery(ID id) {
        StringBuilder query = new StringBuilder("SELECT * FROM ");
        query.append(StringConver.toSnakeCase(clazz.getSimpleName()) + " WHERE id = " + id + ';');
        return query.toString();
    }

    private String getSelectAllQuery() {
        StringBuilder query = new StringBuilder("SELECT * FROM ");
        query.append(StringConver.toSnakeCase(clazz.getSimpleName()) + ';');
        return query.toString();
    }

    private String getUpdateQuery(T entity) {
        StringBuilder query = new StringBuilder("UPDATE ");
        query.append(StringConver.toSnakeCase(clazz.getSimpleName()) + " SET ");
        String buf = "";
        String bufer = "";
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.getName().equals("id")) {
                    bufer = "ID = " + field.get(entity);
                } else {
                    if (!field.getType().isPrimitive()) {
                        buf = field.getName() + " = '" + field.get(entity).toString() + '\'';
                    } else {
                        buf = field.getName() + " = " + field.get(entity).toString();
                    }
                    query.append(buf + ", ");
                }
            } catch (IllegalAccessException e) {
                logger.error("Check this exception " + e);
            }
        }
        query = new StringBuilder(query.substring(0, query.length() - 2));
        query.append(" WHERE " + bufer + " ;");
        return query.toString();
    }
}
