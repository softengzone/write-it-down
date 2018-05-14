package com.softengzone.api.wid.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.softengzone.api.wid.entities.note.Note;
import com.softengzone.api.wid.entities.note.NoteRepository;
import com.softengzone.api.wid.exception.ObjectNotFoundException;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NoteRepositoryTest {

	@Autowired
	private NoteRepository noteRepository;
	
	@Before
	public void setUp() {
		Note note1 = new Note("Spring MVC", "Spring Core 4.3", "It containst details about Spring MVC package");
		Note note2 = new Note("Spring HETEOS", "Spring Core 4.3", "It containst details about Spring HETEOS package");
		Note note3 = new Note("Java 8 Lambda expressions", "Java 8", "Using lambda expression to filter a stream");
		assertNull(note1.getNoteId());
		assertNull(note2.getNoteId());
		assertNull(note3.getNoteId());
		noteRepository.save(note1);
		noteRepository.save(note2);
		noteRepository.save(note3);
		assertNotNull(note1.getNoteId());
		assertNotNull(note2.getNoteId());
		assertNotNull(note3.getNoteId());
	}
	
	@Test
	public void findNoteById_noteWithGivenIdIsReturned() throws ObjectNotFoundException {
		Optional<Note> note = noteRepository.findById(1L);
		assertNotNull(note);
		if (note.isPresent()) {
			assertThat(note.get().getSubject(), equalTo("Spring MVC"));
		} else {
			throw new ObjectNotFoundException("Note doesn't exist");
		}
	}
	
	@Test
	public void findNoteById_noteWithGivenIdDoesntExist() {
		Optional<Note> note = noteRepository.findById(99L);
		assertTrue(!note.isPresent());
	}
	
	@Test
	public void findAll_allNotesAreReturned() {
		List<Note> notes = noteRepository.findAll();	
		assertNotNull(notes);
		assertThat(notes.size(), equalTo(3));
	}
	
	@Test
	@DirtiesContext
	public void updateNoteDetails_noteIsUpdated() throws ObjectNotFoundException {
		String body = "Lambda expressions with streams";
		Optional<Note> noteOptional = noteRepository.findById(3L);
		noteOptional.orElseThrow(() -> new ObjectNotFoundException("Note doesn't exist"));
		noteOptional.get().setBody(body); 
		noteRepository.save(noteOptional.get());
		
		assertThat(noteRepository.findById(3L).get().getBody(), equalTo(body));		
	}
	
	@Test
	@DirtiesContext
	public void deleteNote_noteRemoved() {
		Long noteId = 2L;
		noteRepository.delete(noteRepository.findById(noteId).get());
		
		Optional<Note> noteOptional = noteRepository.findById(noteId);
		assertTrue(!noteOptional.isPresent());
	}
	
	
}

