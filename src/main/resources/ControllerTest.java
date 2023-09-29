public class ControllerTest {
    @FXML
    private TextArea mainTextArea;
    @FXML
    private ComboBox<String> hintsBox;

    private String selectedWord;
    private int caretPos;

    @FXML
    void onTyped(KeyEvent event) {
        caretPos = mainTextArea.getCaretPosition();
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, "Artem", "Petro", "Auto", "Auto Completion");
        ArrayList<String> completionWord = new ArrayList<>();
        String inputWords = mainTextArea.getText(mainTextArea.getText().lastIndexOf(" ") + 1, caretPos);
        System.out.println(inputWords);
        System.out.println(words);
        for (String word : words) {
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
        }
    }
}
