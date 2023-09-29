package com.example.autocompletionapp;

import java.util.ArrayList;
import java.util.Scanner;

public class WordsStorage {
    public ArrayList<String> getWordsFromFile(String fileName){
        ArrayList<String> words = new ArrayList<>();
        Scanner scanner = new Scanner(fileName);
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            words.add(word);
        }
        return words;
    }


}
