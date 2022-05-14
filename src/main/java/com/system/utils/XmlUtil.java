package com.system.utils;

import com.system.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author xuwei
 */
public class XmlUtil {
    /**
     * 解析Configuration
     *
     * @param file
     * @return
     */
    public Map<String, Object> analysisConfig(File file) {
        Map<String, Object> config = new HashMap<>();
        SAXReader reader = new SAXReader();
        List<String> mappers = new ArrayList<>();
        Document document = null;
        try {
            document = reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        assert document != null;
        Element root = document.getRootElement();
        List<Element> childElements = root.elements();
        for (Element child : childElements) {
            if (!child.elements().isEmpty()) {
                for (Element c : child.elements()) {
                    if ("driver".equals(c.attributeValue("name"))) {
                        config.put("driver", c.attributeValue("value"));
                    }
                    if ("url".equals(c.attributeValue("name"))) {
                        config.put("url", c.attributeValue("value"));
                    }
                    if ("username".equals(c.attributeValue("name"))) {
                        config.put("username", c.attributeValue("value"));
                    }
                    if ("password".equals(c.attributeValue("name"))) {
                        config.put("password", c.attributeValue("value"));
                    }
                    if ("underlineAndHump".equals(c.attributeValue("name"))) {
                        config.put("underlineAndHump", c.attributeValue("value"));
                    }
                    if ("openTheCatch".equals(c.attributeValue("name"))) {
                        config.put("openTheCatch", c.attributeValue("value"));
                    }
                    if ("catchSize".equals(c.attributeValue("name"))) {
                        config.put("catchSize", c.attributeValue("value"));
                    }
                    if (!"".equals(c.attributeValue("resource")) && c.attributeValue("resource") != null) {
                        mappers.add(c.attributeValue("resource"));
                    }
                }
            }
        }
        config.put("mappers", mappers);
        return config;
    }

    /**
     * 获取mapper
     * @param className
     * @param mappers
     * @return
     */
    public String getMapperFile(String className, List<String> mappers) {
        for (String mapper : mappers) {
            SAXReader reader = new SAXReader();
            Document document = null;
            try {
                document = reader.read(new File(mapper));
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            assert document != null;
            if (className.equals(document.getRootElement().attributeValue("namespace"))) {
                return mapper;
            }
        }
        return null;
    }

    /**
     * 获取mapper
     * @param mappers
     * @return
     */
    public Map<String, MappedStatement> getMappedStatements(List<String> mappers) {
        Map<String, MappedStatement> mappedStatementMap = new HashMap<>();
        for (String mapper : mappers) {
            SAXReader reader = new SAXReader();
            Document document = null;
            try {
                document = reader.read(new File(mapper));
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            assert document != null;
            Element root = document.getRootElement();
            List<Element> childElements = root.elements();
            for (Element child : childElements) {
                MappedStatement mappedStatement = new MappedStatement(child.attributeValue("id"),
                        child.attributeValue("resultType"),
                        child.attributeValue("parameterType"),
                        "select".equals(child.getName()),
                        child.getTextTrim());
                mappedStatementMap.put(root.attributeValue("namespace") + "." + child.attributeValue("id"), mappedStatement);
            }
        }
        return mappedStatementMap;
    }
}
