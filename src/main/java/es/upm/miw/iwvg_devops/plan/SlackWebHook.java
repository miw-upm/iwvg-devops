package es.upm.miw.iwvg_devops.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SlackWebHook {
    private static final String
            SLACK_URL = "https://hooks.slack.com/services/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"; //invalid
    private WebClient.Builder webClientBuilder;

    @Autowired
    public SlackWebHook(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder; // this.slackUrl = this.environment.getProperty("miw.slack.uri");
    }

    public void publish(Message message) {
        webClientBuilder.build()
                .post()
                .uri(SLACK_URL)
                .body(BodyInserters.fromValue(message))
                .exchange()
                .onErrorResume(exception ->
                        Mono.error(new RuntimeException("Unexpected error: " + exception.getMessage())))
                .block(); // reactive programming to synchronous programming
    }

}

