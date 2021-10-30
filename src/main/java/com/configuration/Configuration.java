package com.configuration;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Configuration {
    private String driver = null;
    private String url = null;
    private String username = null;
    private String password = null;
    private List<String> mappers;

    public Configuration() {
        File file = new File("src/main/resources/xuwei-mybatis.xml");
        if (file.exists()) {
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
                            this.driver = c.attributeValue("value");
                        }
                        if ("url".equals(c.attributeValue("name"))) {
                            this.url = c.attributeValue("value");
                        }
                        if ("username".equals(c.attributeValue("name"))) {
                            this.username = c.attributeValue("value");
                        }
                        if ("password".equals(c.attributeValue("name"))) {
                            this.password = c.attributeValue("value");
                        }
                        if (!"".equals(c.attributeValue("resource")) && c.attributeValue("resource") != null) {
                            mappers.add("src/main/resources/" + c.attributeValue("resource"));
                        }
                    }
                }
            }
            this.mappers = mappers;
        }
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getMappers() {
        return mappers;
    }
}
