package com.example.testjavaconcepts.GitHubHttpClientPOC;

import org.jsoup.nodes.Document;

public class Main {

    public static void main(String[] args) {
        GitHubHttpClient cliente = new GitHubHttpClient();
        String question = cliente.mostRecentQuestionAbout("java");
        System.out.println(question);
    }
}
