package com.softengzone.api.wid.entities.note;

import java.util.List;

import com.softengzone.api.wid.service.Service;

public interface NoteService extends Service<Note, Long> {

	List<Note> findAllBySubject(String subject);
	
	List<Note> findAllByKeyword(String keyword);
	
}
