package com.softengzone.api.wid.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.softengzone.api.wid.entities.note.Note;
import com.softengzone.api.wid.entities.note.NoteService;
import com.softengzone.api.wid.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value="/", produces="application/json")
public class NoteController {

	@Autowired
	NoteService noteService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public Note createNote(@RequestBody Note note) {
		return noteService.save(note);
	}
	
	@RequestMapping(value="note/{id}", method = RequestMethod.GET)
	public Note findById(@PathVariable(name="id") Long id) throws ObjectNotFoundException {
		System.out.println("findById");
		return noteService.findById(id);		
	}
	
	@GetMapping(value="notes/subject")
	public List<Note> findAllBySubject(@RequestParam(name="subject") String subject) {
		System.out.println("findAllBySubject");
		return noteService.findAllBySubject(subject);
	}
	
	@GetMapping(value="notes")
	public List<Note> findAllByKeyword(@RequestParam(name="keyword") String keyword) {
		return noteService.findAllByKeyword(keyword);
	}
	
	@GetMapping(value="notes/all")
	public List<Note> findAllNotes() {
		System.out.println("findAll");
		return noteService.findAll();
	}
	
	@DeleteMapping(value="notes")
	public void deleteAll() {
		noteService.deleteAll();
	}
	
	@PostMapping(value="/notes/load")
	public void loadSampleData() {
//		noteService.loadSampleData();
	}
	
}
