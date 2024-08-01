package noteapp.service;

import java.util.List;
import java.util.Map;

import noteapp.dto.NoteDTO;

public interface NoteService {
	public Map<String, List<NoteDTO>> findNotesDefault(Integer userId);
	public Map<String, List<NoteDTO>> findNotesIsMarked(Integer userId);
	void createNewNote(NoteDTO noteDTO, Integer userId);
	NoteDTO updateNote(NoteDTO noteDTO);
	boolean deleteNote(Integer noteId);
	NoteDTO updateMarkedNote(Integer noteId);
}
