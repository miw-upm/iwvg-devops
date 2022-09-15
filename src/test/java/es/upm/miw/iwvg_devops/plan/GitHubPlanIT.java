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
        String token = "kkk"; //Account>>settings>>Developer settings>>Personal access tokens
        String origin = "iwvg-devops";
        String repo = "iwvg-devops-bernal-jesus";
        this.gitHubServices.deleteAllLabels(owner, token, repo);
        List<Label> labels = this.gitHubServices.readLabels(origin);
        labels.forEach(label -> this.gitHubServices.createLabel(label, owner, token, repo));
    }

    //@Test
    void testCreateStoryLabels() {
        String owner = "miw-upm";
        String token = "kkk"; //Account>>settings>>Developer settings>>Personal access tokens
        String repo = "betca-tpv";
        List<Label> labels = List.of(
                new Label("story: articles-family-crud", "Articles Family CRUD", "666666"),
                new Label("story: articles-family-view", "Articles Family View", "666666"),
                new Label("story: articles-sizes-family-creator", "Articles Sizes Family Creator", "666666"),
                new Label("story: budget", "Budget", "666666"),
                new Label("story: cashier", "Cashier", "666666"),
                new Label("story: credit", "Credit", "666666"),
                new Label("story: customer-discount", "Customer Discount", "666666"),
                new Label("story: customer-points", "Customer Points", "666666"),
                new Label("story: customer-reviews", "Customer Reviews", "666666"),
                new Label("story: data-protection-act", "Data Protection Act", "666666"),
                new Label("story: gift-ticket", "Gift Ticket", "666666"),
                new Label("story: invoice", "Invoice", "666666"),
                new Label("story: messenger", "Messenger", "666666"),
                new Label("story: offer", "Offer", "666666"),
                new Label("story: online-order", "Online Order", "666666"),
                new Label("story: order", "Order", "666666"),
                new Label("story: provider-invoice", "Provider Invoice", "666666"),
                new Label("story: salesPeople", "SalesPeople", "666666"),
                new Label("story: staff", "Staff", "666666"),
                new Label("story: stock-alarm", "Stock Alarm", "666666"),
                new Label("story: stock-audit", "Stock Audit", "666666"),
                new Label("story: stock-manager", "Stock Manager", "666666"),
                new Label("story: tag", "Tag", "666666"),
                new Label("story: ticket", "Ticket", "666666"),
                new Label("story: ticket-tracking", "Ticket Tracking", "666666"),
                new Label("story: user", "User", "666666"),
                new Label("story: vat-management", "VAT Management", "666666"),
                new Label("story: voucher", "Voucher", "666666"),
                new Label("story: e29", "Order", "666666"),
                new Label("story: e30", "Order", "666666"),
                new Label("story: e31", "Order", "666666"),
                new Label("story: e32", "Order", "666666"),
                new Label("story: e33", "Order", "666666"),
                new Label("story: e34", "Order", "666666")

        );
        labels.forEach(
                label -> {
                    this.gitHubServices.deleteLabel(label.getName(), owner, token, repo);
                    this.gitHubServices.createLabel(label, owner, token, repo);
                }
        );
    }

}