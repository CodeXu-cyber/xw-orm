package com.system.executor;

import com.system.MappedStatement;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xuwei
 */
public interface Executor {
    /**
     * 查询列表接口
     *
     * @param connection
     * @param mappedStatement
     * @param args
     * @param underlineAndHump
     * @return
     * @throws Exception
     */
    List<Object> queryList(Connection connection, MappedStatement mappedStatement, Object[] args, boolean underlineAndHump) throws Exception;

    /**
     * 查询单个接口
     *
     * @param connection
     * @param mappedStatement
     * @param args
     * @param underlineAndHump
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    Object queryOne(Connection connection, MappedStatement mappedStatement, Object[] args, boolean underlineAndHump) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException;

    /**
     * 修改接口
     *
     * @param connection
     * @param mappedStatement
     * @param args
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     */
    int update(Connection connection, MappedStatement mappedStatement, Object[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;
}
