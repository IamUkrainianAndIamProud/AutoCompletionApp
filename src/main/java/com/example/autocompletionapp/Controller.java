package com.example.autocompletionapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;


import java.util.ArrayList;


public final class Controller {
    @FXML
    private ComboBox<String> hintsBox;
    @FXML
    private TextArea textArea_Tab0;
    @FXML
    private TextArea textArea_Tab1;
    @FXML
    private TextArea mainTextArea;
    @FXML
    private Tab tab0;
    @FXML
    private Tab tab1;
    @FXML
    private TextField fileName_TextField;
    @FXML
    private Text language_Text;

    private String selectedWord;
    private int caretPos;
    private String mainFileName;

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
        if (event.getCode() == KeyCode.CONTROL || event.getCode() == KeyCode.ALT) {
            String allText = mainTextArea.getText();
            int startIndex = allText.lastIndexOf(" ");
            int endIndex = caretPos;
            StringBuilder strBuilder = new StringBuilder(allText);
            strBuilder.replace(startIndex, endIndex , " " + selectedWord);
            mainTextArea.setText(String.valueOf(strBuilder));
            mainTextArea.positionCaret(startIndex + selectedWord.length() + 1);
        }
    }

    @FXML
    void changeLanguageToEnglish(ActionEvent event) {
        language.changeLanguage(Languages.ENG.getPath());
        language_Text.setText("English");
    }

    @FXML
    void changeLanguageToUnity(ActionEvent event) {
        language.changeLanguage(Languages.CSharp.getPath());
        language_Text.setText("UnityC#");
    }


    @FXML
    void setFileName(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            mainFileName = fileName_TextField.getText();
            System.out.println(mainFileName);
        }
    }

    @FXML
    void setMainTab(Event event) {
        if (tab0.isSelected()) {
            mainTextArea = textArea_Tab0;
        } else if (tab1.isSelected()) {
            mainTextArea = textArea_Tab1;
        }
    }
}
