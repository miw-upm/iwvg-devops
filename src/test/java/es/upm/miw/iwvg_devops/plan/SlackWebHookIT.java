package es.upm.miw.iwvg_devops.plan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
@TestPropertySource(locations = "classpath:test.properties")
class SlackWebHookIT {

    @Autowired
    private SlackWebHook slackWebHook;


    @Test
    void testCopyLabels() {
        this.slackWebHook.publish(new Message("Hola, desde spring!!"));
    }

}
