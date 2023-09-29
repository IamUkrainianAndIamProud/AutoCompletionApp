package com.example.autocompletionapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Language {
    private List<String> words = new ArrayList<>();


    public Language() {
        changeLanguage(Languages.ENG.getPath());
    }

    public void changeLanguage(String filePath) {
        words.clear();
        setupLanguage(filePath);
    }

    public void addWords(String... wordsToAdd) {
        Collections.addAll(words, wordsToAdd);
    }

    public List<String> getWords() {
        return words;
    }

    private void setupLanguage(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                this.addWords(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}
