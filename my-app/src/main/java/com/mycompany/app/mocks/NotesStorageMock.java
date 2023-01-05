package com.mycompany.app.mocks;

import java.util.List;

import com.mycompany.app.classes.Note;
import com.mycompany.app.interfaces.NotesStorage;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class NotesStorageMock implements NotesStorage {
    private Multimap<String, Note> notesByName;

    public NotesStorageMock() {
        notesByName = ArrayListMultimap.create();
    }

    @Override
    public void add(Note note) {
        notesByName.put(note.getName(), note);
    }

    @Override
    public List<Note> getAllNotesOf(String name) {
        return (List<Note>) notesByName.get(name);
    }

    @Override
    public void clear() {
        notesByName.clear();
    }
}