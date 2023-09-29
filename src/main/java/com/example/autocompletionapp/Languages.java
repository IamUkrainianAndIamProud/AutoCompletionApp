package com.example.autocompletionapp;

public enum Languages {
    ENG("src/main/resources/Languages/EnglishWords.txt"),
    UKR("src/main/resources/Languages/UkrainianWords.txt");
    private String path;
    Languages(String path){
        this.path = path;
    }
    public String getPath(){
        return path;
    }
}
