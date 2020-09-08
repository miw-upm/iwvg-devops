package es.upm.miw.iwvg_devops.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.web.reactive.function.client.ExchangeFilterFunctions.basicAuthentication;

@Service
public class GitHubPlan {

    private WebClient.Builder webClientBuilder;

    @Autowired
    public GitHubPlan(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public List<Label> readLabels() {
        Label[] res = webClientBuilder.build()
                .get()
                .uri("https://api.github.com/repos/miw-upm/iwvg-devops/labels")
                .exchange()
                .onErrorResume(exception ->
                        Mono.error(new RuntimeException("Unexpected error: " + exception.getMessage())))
                .flatMap(response -> {
                    if (response.statusCode().isError()) {
                        return Mono.error(new RuntimeException("Unexpected error: " + response.statusCode()));
                    } else {
                        return response.bodyToMono(Label[].class);
                    }
                })
                .block();
        if (res != null) {
            return Arrays.asList(res);
        } else {
            return Collections.emptyList();
        }
    }

    public void deleteLabel(String labelName, String owner, String password, String repo) {
        webClientBuilder.build()
                .mutate().filter(basicAuthentication(owner, password)).build()
                .delete()
                .uri("https://api.github.com/repos/" + owner + "/" + repo + "/labels/" + labelName)
                .exchange()
                .onErrorResume(exception ->
                        Mono.error(new RuntimeException("Unexpected error: " + exception.getMessage())))
                .flatMap(response -> {
                    if (response.statusCode().isError()) {
                        return Mono.error(new RuntimeException("Unexpected error: " + response.statusCode()));
                    } else {
                        return response.bodyToMono(Object.class);
                    }
                })
                .block();
    }

    public void createLabel(Label label, String owner, String password, String repo) {
        webClientBuilder.build()
                .mutate().filter(basicAuthentication(owner, password)).build()
                .post()
                .uri("https://api.github.com/repos/" + owner + "/" + repo + "/labels")
                .body(BodyInserters.fromValue(label))
                .exchange()
                .onErrorResume(exception ->
                        Mono.error(new RuntimeException("Unexpected error: " + exception.getMessage())))
                .flatMap(response -> {
                    if (response.statusCode().isError()) {
                        return Mono.error(new RuntimeException("Unexpected error: " + response.statusCode()));
                    } else {
                        return response.bodyToMono(Object.class);
                    }
                })
                .block();
    }
}

