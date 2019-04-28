package com.example.testjavaconcepts.GitHubHttpClientPOC;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import com.google.common.base.Throwables;

import java.io.IOException;

public class GitHubHttpClient {

    public String mostRecentQuestionAbout(String tag) {
        return fetchTitleOnline(tag);
    }


    public Document mostRecentQuestionsAbout(String tag) {
        try {
            return Jsoup
                    .connect("https://www.stackoverflow.com/questions/tagged/" + tag)
                    .get();
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    private String fetchTitleOnline(String tag) {
        return mostRecentQuestionsAbout(tag).select("a.question-hyperlink").get(0).text();
    }
}
