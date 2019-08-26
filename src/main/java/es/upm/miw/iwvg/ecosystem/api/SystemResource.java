package es.upm.miw.iwvg.ecosystem.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SystemResource.SYSTEM)
public class SystemResource {

    public static final String SYSTEM = "/system";
    public static final String BADGE = "/badge";
    public static final String VERSION = "/version";

    private static final String badge =
            "<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" width=\"108\" height=\"20\">"
                    + "<linearGradient id=\"b\" x2=\"0\" y2=\"100%\">"
                    + "<stop offset=\"0\" stop-color=\"#bbb\" stop-opacity=\".1\"/>"
                    + "<stop offset=\"1\" stop-opacity=\".1\"/></linearGradient>"
                    + "<clipPath id=\"a\"><rect width=\"108\" height=\"20\" rx=\"3\" fill=\"#fff\"/></clipPath>"
                    + "<g clip-path=\"url(#a)\"><path fill=\"#555\" d=\"M0 0h49v20H0z\"/>"
                    + "<path fill=\"#4c1\" d=\"M49 0h59v20H49z\"/><path fill=\"url(#b)\" d=\"M0 0h108v20H0z\"/></g>"
                    + "<g fill=\"#fff\" text-anchor=\"middle\" font-family=\"DejaVu Sans,Verdana,Geneva,sans-serif\" font-size=\"110\">"
                    + "<text x=\"255\" y=\"150\" fill=\"#010101\" fill-opacity=\".3\" transform=\"scale(.1)\" textLength=\"390\">"
                    + "heroku</text>"
                    + "<text x=\"255\" y=\"140\" transform=\"scale(.1)\" textLength=\"390\">heroku</text>"
                    + "<text x=\"775\" y=\"150\" fill=\"#010101\" fill-opacity=\".3\" transform=\"scale(.1)\" textLength=\"490\">"
                    + "deployed</text>"
                    + "<text x=\"775\" y=\"140\" transform=\"scale(.1)\" textLength=\"490\">deployed</text></g> </svg>";

    @Value("${application.name}")
    private String applicationName;

    @Value("${build.version}")
    private String buildVersion;

    @Value("${build.timestamp}")
    private String buildTimestamp;

    @GetMapping(value = BADGE, produces = {"image/svg+xml"})
    public byte[] generateBadge() { // http://localhost:8080/system/badge
        return badge.getBytes();
    }

    @GetMapping(value = VERSION)
    public String applicationInfo() {
        return this.applicationName + "::" + this.buildVersion + "::" + this.buildTimestamp;
    }

}
