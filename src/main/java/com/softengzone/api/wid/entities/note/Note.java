package com.softengzone.api.wid.entities.note;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="WID_NOTE")
public class Note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="note_id")
	private Long noteId;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="tag")
	private String tag;
	
	@Column(name="body")
	private String body;
	
	public Note() {}
	
	public Note(String subject, String tag, String body) {
		super();
		this.subject = subject;
		this.tag = tag;
		this.body = body;
	}

	public Long getNoteId() {
		return noteId;
	}
	
	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	

}
