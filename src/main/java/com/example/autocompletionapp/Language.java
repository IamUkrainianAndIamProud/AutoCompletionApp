package com.example.autocompletionapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Language {
    WordsStorage wordsStorage = new WordsStorage();
    private String currentLang;

    public Language() {
        currentLang = Languages.ENG.getPath();
    }

    public void changeLanguage(Languages selectLang) {
        currentLang = selectLang.getPath();
    }

    public void addWords(String... wordsToAdd) {
        Collections.addAll(words, wordsToAdd);
    }

    public List<String> getWords() {
        return wordsStorage.getWordsFromFile(currentLang);
    }

    private void setupLanguage(String filePath) {
    }
}
