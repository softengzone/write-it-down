package com.softengzone.api.wid.entities.note;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softengzone.api.wid.exception.ObjectNotFoundException;

@Service
public class WidNoteService implements NoteService {

	@Autowired
	private NoteRepository noteRepository;
	
	@Override
	public List<Note> findAll() {
		return noteRepository.findAll();
	}

	@Override
	public Note findById(Long id) throws ObjectNotFoundException {
		Optional<Note> noteOptional = noteRepository.findById(id);
		noteOptional.orElseThrow(() -> new ObjectNotFoundException("Note " + id + " cannot be found"));
		return noteOptional.get();
	}

	@Override
	public Note save(Note t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Note t) {
		
	}
	
	@Override
	public void deleteAll() {
		noteRepository.findAll().forEach(n -> noteRepository.delete(n));
	}

	@Override
	public List<Note> findAllBySubject(String subject) {
		return noteRepository.findAllBySubjectLike(subject);
	}
	
	@Override
	public List<Note> findAllByKeyword(String keyword) {
		return noteRepository.findAllByKeyword(keyword);
	}
	
	public void loadSampleData() {
		noteRepository.save(new Note("Oracle PL/SQL", "Databases", "Int questions"));
		noteRepository.save(new Note("Spring HETEOS", "Spring Core 4.3", "It containst details about Spring HETEOS package"));
		noteRepository.save(new Note("Java 8 Lambda expressions", "Java 8", "Using lambda expression to filter a stream"));
		noteRepository.save(new Note("Spring MVC", "Spring Corte 4.3", "It containst details about Spring MVC package"));
		noteRepository.save(new Note("Spring", "Spring - Solutions to common problems", "Spring examples"));
		noteRepository.save(new Note("Web Development", "Web development frameworks", "Struts 2, Scala, AngularJS, Angular, Spring"));
	}

	
	
}
