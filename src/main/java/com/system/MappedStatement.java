package com.system;

public class MappedStatement {
    //sql节点的id,对应接口方法名
    private final String id;
    //sql的返回参数类型
    private final String resultType;
    //sql的入参类型
    private final String parameterType;
    //sql是否为查询
    private final boolean query;
    //sql语句
    private final String sql;

    public MappedStatement(String id, String resultType, String parameterType, boolean query, String sql) {
        this.id = id;
        this.resultType = resultType;
        this.parameterType = parameterType;
        this.query = query;
        this.sql = sql;
    }

    public String getId() {
        return id;
    }

    public String getResultType() {
        return resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public boolean isQuery() {
        return query;
    }

    public String getSql() {
        return sql;
    }

    @Override
    public String toString() {
        return "MappedStatement{" +
                "id='" + id + '\'' +
                ", resultType='" + resultType + '\'' +
                ", parameterType='" + parameterType + '\'' +
                ", query=" + query +
                ", sql='" + sql + '\'' +
                '}';
    }
}
