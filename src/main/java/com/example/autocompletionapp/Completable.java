package com.example.autocompletionapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Completable {
    void setupLanguage(Language language, String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                language.addWords(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}
