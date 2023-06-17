package es.upm.miw.iwvg_devops.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SystemResource {

    static final String VERSION_BADGE = "/version-badge";

    @Value("${application.name}")
    private String applicationName;
    @Value("${build.version}")
    private String buildVersion;
    @Value("${build.timestamp}")
    private String buildTimestamp;

    @GetMapping
    public String applicationInfo() {
        String appInfo="{\"version\":\"" + this.applicationName + "::" +
                this.buildVersion + "::" + this.buildTimestamp + "\"} <br> <br>";
        appInfo += "/version-badge <br><br>";
        appInfo += "/actuator/info <br> /actuator/health <br><br>";
        appInfo += "/swagger-ui.html  <br> /v3/api-docs <br>";
        return appInfo;
    }

    @GetMapping(value = VERSION_BADGE, produces = {"image/svg+xml"})
    public byte[] generateBadge() {
        return new Badge().generateBadge("Heroku", "v" + buildVersion).getBytes();
    }


}
