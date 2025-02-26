package es.upm.miw.devops.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SystemResource {

    public static final String VERSION_BADGE = "/version-badge";

    @Value("${info.app.artifact}")
    private String artifact;
    @Value("${info.app.version}")
    private String version;
    @Value("${info.app.build}")
    private String build;

    @GetMapping
    public String applicationInfo() {
        String appInfo = "{\"version\":\"" + this.artifact + "::" + this.version + "::" + this.build + "\"} <br> <br>";
        appInfo += "/version-badge <br><br>";
        appInfo += "/actuator/info <br> /actuator/health <br><br>";
        appInfo += "/swagger-ui.html  <br> /v3/api-docs <br>";
        return appInfo;
    }

    @GetMapping(value = VERSION_BADGE, produces = {"image/svg+xml"})
    public byte[] generateBadge() {
        return new Badge().generateBadge("Render", "v" + version).getBytes();
    }


}
