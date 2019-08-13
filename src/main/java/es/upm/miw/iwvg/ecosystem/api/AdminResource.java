package es.upm.miw.iwvg.ecosystem.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AdminResource.ADMINS)
public class AdminResource {

    public static final String ADMINS = "/api";

    @Value("${application.name}")
    private String applicationName;

    @Value("${build.version}")
    private String buildVersion;

    @Value("${build.timestamp}")
    private String buildTimestamp;

    @GetMapping
    public String applicationInfo() { // http://localhost:8080/api
        return "Hello World!!! ("
                + this.applicationName + "::" + this.buildVersion + "::" + this.buildTimestamp
                + ")";
    }

}
