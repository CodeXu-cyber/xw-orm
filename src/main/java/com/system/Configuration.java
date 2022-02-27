package com.system;

import com.utils.XmlUtil;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author xuwei
 */
public class Configuration {
    private String driver = null;
    private String url = null;
    private String username = null;
    private String password = null;
    private boolean underlineAndHump = false;
    private Map<String, MappedStatement> mappedStatementMap;

    public Configuration(String pathName) {
        File file = new File(pathName);
        if (file.exists()) {
            XmlUtil xmlUtil = new XmlUtil();
            Map<String, Object> config = xmlUtil.analysisConfig(file);
            this.driver = (String) config.get("driver");
            this.url = (String) config.get("url");
            this.username = (String) config.get("username");
            this.password = (String) config.get("password");
            this.underlineAndHump = "true".equals(config.get("underlineAndHump"));
            this.mappedStatementMap = xmlUtil.getMappedStatements((List<String>) config.get("mappers"));
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
