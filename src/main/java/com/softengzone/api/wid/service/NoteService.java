package com.softengzone.api.wid.service;

import java.util.List;

import com.softengzone.api.wid.entity.Note;

public interface NoteService extends Service<Note, Long> {

	List<Note> findAllBySubject(String subject);
	List<Note> findAllByKeyword(String keyword);
	void loadSampleData();
	
}
