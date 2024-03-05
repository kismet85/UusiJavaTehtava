package com.ismet.model;

public class Note {

    private String titleNote;
    private String textNote;

    public Note() {

    }

    public Note(String titleNote, String textNote) {
        this.titleNote = titleNote;
        this.textNote = textNote;
    }

    public String getNoteTitle() {
        return titleNote;
    }

    public void setTitleNote(String titleNote) {
        this.titleNote = titleNote;
    }

    public String getNote() {
        return textNote;
    }

    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }
}
