package es.upm.miw.iwvg_devops.plan;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
@TestPropertySource(locations = "classpath:test.properties")
class GitHubPlanIT {

    @Autowired
    private GitHubPlan gitHubServices;


    // @Test
    void testCopyLabels() {
        String owner = "miw-upm";
        String password = "???";
        List<Label> labels = this.gitHubServices.readLabels();
        labels.forEach(
                label -> {
                    this.gitHubServices.deleteLabel(label.getName(), owner, password, "devops-in-action");
                    this.gitHubServices.createLabel(label, owner, password, "devops-in-action");
                }
        );
    }

}