package com.ismet.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Notebook {
    private HashMap<String, String> notes = new HashMap<>();
    private List<String> noteTitles = new ArrayList<>();
    private int currentIndex = -1;

    public void addNote(Note note) {
        String title = note.getNoteTitle();
        String text = note.getNote();
        notes.put(title, text);
        noteTitles.add(title);
        currentIndex = noteTitles.size() - 1;
    }

    public String getCurrentNote() {
        if (currentIndex >= 0 && currentIndex < noteTitles.size()) {
            return notes.get(noteTitles.get(currentIndex));
        }
        return null;
    }

    public String getNextNote() {
        if (currentIndex < noteTitles.size() - 1) {
            currentIndex++;
            return notes.get(noteTitles.get(currentIndex));
        }
        return null;
    }

    public String getPreviousNote() {
        if (currentIndex > 0) {
            currentIndex--;
            return notes.get(noteTitles.get(currentIndex));
        }
        return null;
    }
}
