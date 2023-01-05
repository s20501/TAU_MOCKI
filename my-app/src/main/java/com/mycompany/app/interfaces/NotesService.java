package com.mycompany.app.interfaces;

import com.mycompany.app.classes.Note;

public interface NotesService {
	void add(Note note);

	float averageOf(String name);

	void clear();
}