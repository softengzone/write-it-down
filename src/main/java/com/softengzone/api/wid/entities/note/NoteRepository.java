package com.softengzone.api.wid.entities.note;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoteRepository extends JpaRepository<Note, Long> {

	@Query("select n from #{#entityName} n where n.subject like %?1%")
	List<Note> findAllBySubjectLike(String subject);
	
	@Query("select n from #{#entityName} n where n.subject like %?1% or n.tag like %?1% or n.body like %?1%")
	List<Note> findAllByKeyword(String keyword);
	
}
