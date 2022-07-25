package com.system;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName SimpleCatch
 * @Author xuwei
 * @DATE 2022/4/9
 */
public class SimpleCatch {
    /**
     * 保存key和使用次数
     */
    static class KeyNum {
        private String key;
        private Integer num;

        public KeyNum() {

        }

        public KeyNum(String key, Integer num) {
            this.key = key;
            this.num = num;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
    }

    private final KeyNum[] keyNums;
    private final Map<String, ResultSet> simpleCatch;
    private Integer initialCapacity = 16;
    private Integer size = 0;

    public SimpleCatch() {
        this.keyNums = new KeyNum[initialCapacity];
        this.simpleCatch = new HashMap<>(initialCapacity);
    }

    public SimpleCatch(Integer catchSize) {
        this.initialCapacity = catchSize;
        this.keyNums = new KeyNum[initialCapacity];
        this.simpleCatch = new HashMap<>(initialCapacity);
    }

    /**
     * 判断是否包含key
     *
     * @param key
     * @return
     */
    public boolean containsKey(String key) {
        return simpleCatch.containsKey(key);
    }

    /**
     * 返回当前缓存中数据数量
     *
     * @return
     */
    public Integer size() {
        return this.size;
    }

    /**
     * 向缓存中添加数据
     * 先判断缓存是否满,如果未满,直接添加,如果满了的话则判断哪个使用次数最少,移除并覆盖
     *
     * @param key
     * @param resultSet
     */
    public void put(String key, ResultSet resultSet) {
        if (size < initialCapacity) {
            keyNums[size++] = new KeyNum(key, 0);
            simpleCatch.put(key, resultSet);
        } else {
            int index = 0;
            int minUsedNum = keyNums[0].num;
            for (int i = 0; i < size; ++i) {
                if (keyNums[i].num < minUsedNum) {
                    index = i;
                    minUsedNum = keyNums[i].num;
                }
            }
            simpleCatch.remove(keyNums[index].key);
            keyNums[index] = new KeyNum(key, 0);
            simpleCatch.put(key, resultSet);
        }
    }

    /**
     * 获取缓存中的数据
     *
     * @param key
     * @return
     */
    public ResultSet get(String key) {
        for (int i = 0; i < size; ++i) {
            if (key.equals(keyNums[i].key)) {
                keyNums[i].num++;
                return simpleCatch.get(key);
            }
        }
        return null;
    }

    /**
     * 清空缓存
     */
    public void clear() {
        for (int i = 0; i < initialCapacity; ++i) {
            keyNums[i] = null;
        }
        simpleCatch.clear();
        size = 0;
    }
}
