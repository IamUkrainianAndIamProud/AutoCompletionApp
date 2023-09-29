package com.example.autocompletionapp;

import java.util.List;

public class Language {
    private WordsToComplete wordsToComplete = new WordsToComplete();


    public void addWords(String... words) {
        wordsToComplete.addWords(words);
    }

    public WordsToComplete getWordsToComplete() {
        return wordsToComplete;
    }

    public List<String> getCompletionWords() {
        return wordsToComplete.getCompletionWords();
    }
}