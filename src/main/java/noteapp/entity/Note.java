package noteapp.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="note")
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noteId;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	@Column(name="note_title")
	private String noteTitle;
	
	@Column(name="note_content")
	private String noteContent;
	
//	@Column(name="note_processed_content")
//	private String noteProcessedContent;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	@Column(name="is_marked")
	private Integer isMarked;
	
//	public String getNoteProcessedContent() {
//		return noteProcessedContent;
//	}
//
//	public void setNoteProcessedContent(String noteProcessedContent) {
//		this.noteProcessedContent = noteProcessedContent;
//	}

	public Integer getIsMarked() {
		return isMarked;
	}

	public void setIsMarked(Integer isMarked) {
		this.isMarked = isMarked;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
