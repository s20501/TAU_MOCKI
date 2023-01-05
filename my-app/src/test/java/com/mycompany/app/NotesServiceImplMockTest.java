package com.mycompany.app;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.mycompany.app.classes.Note;
import com.mycompany.app.interfaces.NotesStorage;
import com.mycompany.app.services.NotesServiceImpl;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

public class NotesServiceImplMockTest {

    private static final String NAME = "John";
    private static final Note NOTE1 = new Note(NAME, 3.0f);
    private static final Note NOTE2 = new Note(NAME, 4.0f);
    private static final Note NOTE3 = new Note(NAME, 5.0f);
    private static final List<Note> NOTES = Arrays.asList(NOTE1, NOTE2, NOTE3);

    private final NotesStorage storage = createMock(NotesStorage.class);
    private final NotesServiceImpl service = NotesServiceImpl.createWith(storage);

    @Test
    public void testAdd() {
        storage.add(NOTE1);
        replay(storage);

        service.add(NOTE1);

        verify(storage);
    }

    @Test
    public void testAverageOf() {
        expect(storage.getAllNotesOf(NAME)).andReturn(NOTES);
        replay(storage);

        final float average = service.averageOf(NAME);

        verify(storage);
        assertEquals(4.0f, average, 0.01f);
    }

    @Test
    public void testClear() {
        storage.clear();
        replay(storage);

        service.clear();

        verify(storage);
    }
}