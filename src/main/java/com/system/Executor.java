package com.system;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Executor {
    List<Object> queryList(Connection connection, MappedStatement mappedStatement, Object[] args) throws Exception;
    Object queryOne(Connection connection,MappedStatement mappedStatement, Object[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException;
    int update(Connection connection,MappedStatement mappedStatement, Object[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;
}
