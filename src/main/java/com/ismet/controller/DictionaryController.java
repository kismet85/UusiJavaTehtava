package com.ismet.controller;

import com.ismet.model.Dictionary;
import com.ismet.view.DictionaryView;

public class DictionaryController {
    private Dictionary dictionary;
    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String searchWord(String word) {
        return dictionary.searchWord(word);
    }

    public static void main(String[] args) {
        DictionaryView.launch(DictionaryView.class);
    }
}