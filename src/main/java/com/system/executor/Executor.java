package com.system.executor;

import com.system.Configuration;
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
     * @param connection       connection
     * @param mappedStatement  mappedStatement
     * @param args             args
     * @param underlineAndHump underlineAndHump
     * @return 查询结果结合
     * @throws Exception 异常信息
     */
    List<Object> queryList(Connection connection, MappedStatement mappedStatement, Object[] args, Configuration configuration) throws Exception;

    /**
     * 查询单个接口
     *
     * @param connection       connection
     * @param mappedStatement  mappedStatement
     * @param args             args
     * @param underlineAndHump underlineAndHump
     * @return 查询结果
     * @throws SQLException              SQLException
     * @throws ClassNotFoundException    ClassNotFoundException
     * @throws InvocationTargetException InvocationTargetException
     * @throws NoSuchMethodException     NoSuchMethodException
     * @throws IllegalAccessException    IllegalAccessException
     * @throws InstantiationException    InstantiationException
     */
    Object queryOne(Connection connection, MappedStatement mappedStatement, Object[] args, Configuration configuration) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException;

    /**
     * 修改接口
     *
     * @param connection      connection
     * @param mappedStatement mappedStatement
     * @param args            args
     * @return 影响行数
     * @throws SQLException              SQLException
     * @throws ClassNotFoundException    ClassNotFoundException
     * @throws InvocationTargetException InvocationTargetException
     * @throws NoSuchMethodException     NoSuchMethodException
     * @throws IllegalAccessException    IllegalAccessException
     */
    int update(Connection connection, MappedStatement mappedStatement, Object[] args, Configuration configuration) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;
}
