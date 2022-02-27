package com.system;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class XSqlSession implements InvocationHandler {
    private String className;
    private final Configuration configuration;

    public XSqlSession(String pathName) {
        this.configuration = new Configuration(pathName);
    }

    public Object getMapper(Class cls){
        className = cls.getName();
        return Proxy.newProxyInstance(
                cls.getClassLoader(),
                new Class[] { cls },
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //到configuration中去获取方法对应的MappedStatement
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(className+"."+method.getName());
        //建立数据库连接
        Class.forName(configuration.getDriver());
        Connection connection = DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(), configuration.getPassword());
        //建立执行器
        BaseExecutor baseExecutor = new BaseExecutor();
        Object obj = null;
        if (mappedStatement.isQuery()){
            if (method.getReturnType().isInstance(new ArrayList<>())){
                obj = baseExecutor.queryList(connection,mappedStatement,args,configuration.isUnderlineAndHump());
            }else {
                obj = baseExecutor.queryOne(connection,mappedStatement,args,configuration.isUnderlineAndHump());
            }
        }else {
            obj =  baseExecutor.update(connection,mappedStatement,args);
        }
        connection.close();
        return obj;
    }
}
