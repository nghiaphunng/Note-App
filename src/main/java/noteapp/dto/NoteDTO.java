package noteapp.dto;

import java.util.Date;

public class NoteDTO {
	private Integer noteId;
	private Integer userId;
	private String noteTitle;
	private String noteContent;
	private Date createdAt;
	private Date updatedAt;
	private Integer isMarked;
//	private String noteProcessedContent;
	public Integer getNoteId() {
		return noteId;
	}
	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public Integer getIsMarked() {
		return isMarked;
	}
	public void setIsMarked(Integer isMarked) {
		this.isMarked = isMarked;
	}
//	public String getNoteProcessedContent() {
//		return noteProcessedContent;
//	}
//	public void setNoteProcessedContent(String noteProcessedContent) {
//		this.noteProcessedContent = noteProcessedContent;
//	}
}
