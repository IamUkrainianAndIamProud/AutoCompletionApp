package com.example.autocompletionapp;

import java.util.List;

public class Language extends Completable {
    private WordsToComplete wordsToComplete = new WordsToComplete();

    public Language() {
        changeLanguage("src/main/resources/Languages/EnglishWords.txt");
    }

    public void changeLanguage(String filePath) {
        wordsToComplete.getCompletionWords().clear();
        setupLanguage(this, filePath);
    }

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
