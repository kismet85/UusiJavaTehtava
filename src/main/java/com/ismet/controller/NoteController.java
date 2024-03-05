package com.ismet.controller;

import com.ismet.model.Note;
import com.ismet.model.Notebook;
import com.ismet.view.NoteBookView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NoteController {
    @FXML
    public TextArea showNote;
    private Notebook notebook;
    private NoteBookView noteBookView;

    @FXML
    private TextField titleNote;

    @FXML
    private TextArea textNote;

    @FXML
    private Button addNoteButton;

    @FXML
    private Button previousNoteButton;

    @FXML
    private Button nextNoteButton;

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public void setNoteBookView(NoteBookView noteBookView) {
        this.noteBookView = noteBookView;
    }

    @FXML
    private void initialize() {
        addNoteButton.setOnAction(event -> addNote());
        previousNoteButton.setOnAction(event -> showPreviousNote());
        nextNoteButton.setOnAction(event -> showNextNote());
    }

    private void addNote() {
        String title = titleNote.getText();
        String text = textNote.getText();
        Note note = new Note();
        note.setTitleNote(title);
        note.setTextNote(text);
        notebook.addNote(note);
        showNote.setText(text);

    }



    private void showNextNote() {
        String note = notebook.getNextNote();
        showNote.setText(note);
    }

    private void showPreviousNote() {
        String note = notebook.getPreviousNote();
        showNote.setText(note);
    }

    public static void main(String[] args) {
        NoteBookView.launch(NoteBookView.class);
    }
}
