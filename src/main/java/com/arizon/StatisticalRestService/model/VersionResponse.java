package com.arizon.StatisticalRestService.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class VersionResponse {
    String version = "";
    private Logger log = LoggerFactory.getLogger(this.getClass());
    public VersionResponse() {
        final Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
            version = properties.getProperty("project.version");
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
        }
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
