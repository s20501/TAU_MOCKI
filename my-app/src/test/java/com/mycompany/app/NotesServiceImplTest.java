package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.app.classes.Note;
import com.mycompany.app.mocks.NotesStorageMock;
import com.mycompany.app.services.NotesServiceImpl;

public class NotesServiceImplTest {
    private NotesStorageMock storageServiceMock;
    private NotesServiceImpl service;

    @Before
    public void setUp() {
        storageServiceMock = new NotesStorageMock();
        service = NotesServiceImpl.createWith(storageServiceMock);
    }

    @Test
    public void testAdd() {
        final Note note = new Note("John", 3.5f);
        service.add(note);

        final List<Note> notes = storageServiceMock.getAllNotesOf("John");
        assertEquals(note, notes.get(0));
    }

    @Test
    public void testAddSize() {
        final Note note = new Note("John", 3.5f);
        service.add(note);

        final List<Note> notes = storageServiceMock.getAllNotesOf("John");
        assertEquals(1, notes.size());
    }

    @Test
    public void testAverageOf() {
        final Note note1 = new Note("John", 3.5f);
        final Note note2 = new Note("John", 4.0f);
        final Note note3 = new Note("John", 2.5f);
        service.add(note1);
        service.add(note2);
        service.add(note3);

        final float average = service.averageOf("John");
        assertEquals(3.33f, average, 0.01f);
    }

    @Test
    public void testClear() {
        final Note note1 = new Note("John", 3.5f);
        final Note note2 = new Note("John", 4.0f);
        service.add(note1);
        service.add(note2);

        service.clear();

        final List<Note> notes = storageServiceMock.getAllNotesOf("John");
        assertEquals(0, notes.size());
    }
}