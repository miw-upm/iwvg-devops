package es.upm.miw.apaw_api_themes.api_controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(AdminResource.ADMINS)
public class AdminResource {

    public static final String ADMINS = "/admins";

    @Value("${application.name}")
    private String applicationName;

    @Value("${build.version}")
    private String buildVersion;

    @Value("${build.timestamp}")
    private String buildTimestamp;

    @GetMapping
    public String applicationInfo() { // http://localhost:8080/admins/info
        return "{\"version\":\""
                +this.applicationName + "::" + this.buildVersion + "::" + this.buildTimestamp
                + "\"}";
    }
}