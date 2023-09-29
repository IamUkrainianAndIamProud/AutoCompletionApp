package com.example.autocompletionapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class WordsToComplete {
    private List<String> completionWords = new ArrayList<>();

    public List<String> addWords(String... words) {
        Collections.addAll(completionWords, words);

        return completionWords;
    }

    public List<String> getCompletionWords() {
        return completionWords;
    }
}
