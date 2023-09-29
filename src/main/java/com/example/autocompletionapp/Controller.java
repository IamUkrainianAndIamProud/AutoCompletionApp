package com.example.autocompletionapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public final class Controller extends javafx.application.Application implements Completable {
    @FXML
    private ComboBox<String> hintsBox;

    @FXML
    private TextArea mainTextArea;

    private String selectedWord;
    private int caretPos;

    private Language english = new Language();


    @FXML
    void onTyped(KeyEvent event) {
        caretPos = mainTextArea.getCaretPosition();
        ArrayList<String> completionWord = new ArrayList<>();
        String inputWords = mainTextArea.getText(mainTextArea.getText().lastIndexOf(" ") + 1, caretPos);
        System.out.println(inputWords);
        System.out.println(english.getCompletionWords());
        for (String word : english.getCompletionWords()) {
            if (word.contains(inputWords)) {
                if (!completionWord.contains(word)) {
                    completionWord.add(word);
                }
            }
        }

        ObservableList<String> completionComboBoxList = FXCollections.observableArrayList(completionWord);
        if (!inputWords.equals("")) {
            hintsBox.setItems(completionComboBoxList);
            hintsBox.setLayoutX(mainTextArea.getCaretPosition() + 50);
            hintsBox.show();
            hintsBox.setVisible(true);
        } else {
            hintsBox.setVisible(false);
        }
        selectedWord = hintsBox.getValue();
    }

    @FXML
    void writeWord(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ALT)) {
            String allText = mainTextArea.getText();
            int startIndex = allText.lastIndexOf(" ");
            int endIndex = caretPos;
            StringBuilder strBuilder = new StringBuilder(allText);
            strBuilder.replace(startIndex, endIndex, " " + selectedWord);
            mainTextArea.setText(String.valueOf(strBuilder));
            mainTextArea.positionCaret(startIndex + selectedWord.length() + 1);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Application app = new Application();

        setupLanguage(english, "src/main/resources/Languages/EnglishWords.txt");

        app.run(stage, "TEST", "main-view.fxml");
    }

    @Override
    public void setupLanguage(Language language, String filePath) {
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
