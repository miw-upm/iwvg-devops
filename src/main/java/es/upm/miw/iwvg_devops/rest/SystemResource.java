package es.upm.miw.iwvg_devops.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SystemResource.SYSTEM)
public class SystemResource {
    static final String SYSTEM = "/system";

    static final String APP_INFO = "/app-info";
    static final String VERSION_BADGE = "/version-badge";

    @Value("${application.name}")
    private String applicationName;
    @Value("${build.version}")
    private String buildVersion;
    @Value("${build.timestamp}")
    private String buildTimestamp;

    @GetMapping(value = VERSION_BADGE, produces = {"image/svg+xml"})
    public byte[] generateBadge() { // http://localhost:8080/system/badge
        return new Badge().generateBadge("Heroku", "v" + buildVersion).getBytes();
    }

    @GetMapping(value = APP_INFO)
    public String applicationInfo() {
        return "{\"version\":\"" + this.applicationName + "::" +
                this.buildVersion + "::" + this.buildTimestamp + "\"}";
    }
}
