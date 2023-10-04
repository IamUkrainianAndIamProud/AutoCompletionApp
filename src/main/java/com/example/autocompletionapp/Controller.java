package com.example.autocompletionapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.util.ArrayList;


public final class Controller {
    @FXML
    private ComboBox<String> hintsBox;
    @FXML
    private TextArea mainTextArea;
    @FXML
    private Button english_Button;
    @FXML
    private Button unity_Button;

    private String selectedWord;
    private int caretPos;
    private boolean englishFlag = true;

    private Language language = new Language();


    @FXML
    void onTyped(KeyEvent event) {
        caretPos = mainTextArea.getCaretPosition();
        ArrayList<String> completionWord = new ArrayList<>();
        String inputWords = mainTextArea.getText(mainTextArea.getText().lastIndexOf(" ") + 1, caretPos);
        for (String word : language.getWords()) {
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
        if (event.getCode().equals(KeyCode.ENTER)) {
            String allText = mainTextArea.getText();
            int startIndex = allText.lastIndexOf(" ");
            int endIndex = caretPos;
            StringBuilder strBuilder = new StringBuilder(allText);
            strBuilder.replace(startIndex, endIndex, " " + selectedWord);
            mainTextArea.setText(String.valueOf(strBuilder));
            mainTextArea.positionCaret(startIndex + selectedWord.length() + 1);
        }
    }

    @FXML
    void changeLanguageToEnglish(ActionEvent event) {
        language.changeLanguage(Languages.ENG.getPath());
    }

    @FXML
    void changeLanguageToUnity(ActionEvent event) {
        language.changeLanguage(Languages.CSharp.getPath());
    }
}
