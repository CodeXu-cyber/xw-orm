package com.system;

import com.utils.XmlUtil;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author xuwei
 */
public class Configuration {
    private static volatile Configuration configuration;
    private String driver = null;
    private String url = null;
    private String username = null;
    private String password = null;
    private boolean openTheCatch = false;
    private SimpleCatch simpleCatch = null;
    private boolean underlineAndHump = false;
    private Map<String, MappedStatement> mappedStatementMap;

    public static Configuration getConfiguration(String pathName) {
        if (configuration == null) {
            synchronized (Configuration.class) {
                if (configuration == null) {
                    configuration = new Configuration(pathName);
                }
            }
        }
        return configuration;
    }

    private Configuration(String pathName) {
        File file = new File(pathName);
        if (file.exists()) {
            XmlUtil xmlUtil = new XmlUtil();
            Map<String, Object> config = xmlUtil.analysisConfig(file);
            this.driver = (String) config.get("driver");
            this.url = (String) config.get("url");
            this.username = (String) config.get("username");
            this.password = (String) config.get("password");
            this.openTheCatch = "true".equals(config.get("openTheCatch"));
            this.underlineAndHump = "true".equals(config.get("underlineAndHump"));
            this.mappedStatementMap = xmlUtil.getMappedStatements((List<String>) config.get("mappers"));
            if (openTheCatch) {
                if (config.get("catchSize") != null) {
                    if (Integer.parseInt((String) config.get("catchSize")) > 0) {
                        simpleCatch = new SimpleCatch(Integer.parseInt((String) config.get("catchSize")));
                    }
                } else {
                    simpleCatch = new SimpleCatch();
                }
            }
        } else {
            System.out.println("配置文件不存在");
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

    public boolean isUnderlineAndHump() {
        return underlineAndHump;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public boolean isOpenTheCatch() {
        return openTheCatch;
    }

    public SimpleCatch getSimpleCatch() {
        return simpleCatch;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", underlineAndHump=" + underlineAndHump +
                ", mappedStatementMap=" + mappedStatementMap +
                '}';
    }
}
