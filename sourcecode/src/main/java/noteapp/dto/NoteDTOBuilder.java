package noteapp.dto;

import java.util.Date;

public class NoteDTOBuilder {
	private Integer noteId;
	private Integer userId;
	private String noteTitle;
	private String noteContent;
	private Date createdAt;
	private Date updatedAt;
	private Integer isMarked;
//	private String noteProcessedContent;
	
	private NoteDTOBuilder (NoteBuilder noteBuilder) {
		this.noteId = noteBuilder.noteId;
		this.userId = noteBuilder.userId;
		this.noteTitle = noteBuilder.noteTitle;
		this.noteContent = noteBuilder.noteContent;
//		this.noteProcessedContent = noteBuilder.noteProcessedContent;
		this.createdAt = noteBuilder.createdAt;
		this.updatedAt = noteBuilder.updatedAt;
		this.isMarked = noteBuilder.isMarked;
	}
	
	public static class NoteBuilder {
		private Integer noteId;
		private Integer userId;
		private String noteTitle;
		private String noteContent;
		private Date createdAt;
		private Date updatedAt;
		private Integer isMarked;
//		private String noteProcessedContent;
		
		public NoteBuilder setNoteId(Integer noteId) {
			this.noteId = noteId;
			return this;
		}
		
		public NoteBuilder setUserId(Integer userId) {
			this.userId = userId;
			return this;
		}
		
		public NoteBuilder setNoteTitle(String noteTitle) {
			this.noteTitle = noteTitle;
			return this;
		}
		
		public NoteBuilder setNoteContent(String noteContent) {
			this.noteContent = noteContent;
			return this;
		}
		
		public NoteBuilder setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
			return this;
		}
		
		public NoteBuilder setIsMarked(Integer isMarked) {
			this.isMarked = isMarked;
			return this;
		}
		
//		public NoteBuilder setNoteProcessedContent(String noteProcessedContent) {
//			this.noteProcessedContent = noteProcessedContent;
//			return this;
//		}
		
		public NoteDTOBuilder build() {
            return new NoteDTOBuilder(this);
        }
	}

	public Integer getNoteId() {
		return noteId;
	}
		
	public Integer getUserId() {
		return userId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Integer getIsMarked() {
		return isMarked;
	}

//	public String getNoteProcessedContent() {
//		return noteProcessedContent;
//	}
}
