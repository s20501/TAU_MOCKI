package com.mycompany.app.interfaces;

import java.util.List;

import com.mycompany.app.classes.Note;

public interface NotesStorage {
    void add(Note note);

    List<Note> getAllNotesOf(String name);

    void clear();
}