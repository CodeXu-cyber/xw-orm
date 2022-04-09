package com.system;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName SimpleCatch
 * @Author xuwei
 * @DATE 2022/4/9
 */
public class SimpleCatch {
    private final Map<String, ResultSet> simpleCatch = new HashMap<>(128);

    /**
     * 缓存中是否包含此sql对应数据
     * @param sql
     * @return
     */
    public boolean contains(String sql) {
        return simpleCatch.containsKey(sql);
    }

    /**
     * 根据sql获取缓存
     * @param sql
     * @param resultSet
     */
    public void updateCatch(String sql, ResultSet resultSet) {
        simpleCatch.put(sql, resultSet);
    }

    /**
     * 更新对应缓存
     * @param sql
     * @return
     */
    public ResultSet getForCatch(String sql) {
        return simpleCatch.get(sql);
    }
}
