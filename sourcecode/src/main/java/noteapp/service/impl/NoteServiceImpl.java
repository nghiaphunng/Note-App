package noteapp.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noteapp.dto.NoteDTO;
import noteapp.entity.Note;
import noteapp.entity.User;
import noteapp.repository.NoteRepository;
import noteapp.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService{
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Map<String, List<NoteDTO>> findNotesDefault(Integer userId) {
		List<Note> notes = noteRepository.findByUserIdOrderByCreatedAtDesc(userId);
		Map<String, List<NoteDTO>> notesByDay = new LinkedHashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        for(Note note : notes) {
        	NoteDTO noteDTO = modelMapper.map(note, NoteDTO.class);
        	String dateKey = sdf.format(note.getCreatedAt());
        	notesByDay.computeIfAbsent(dateKey, k -> new ArrayList<>()).add(noteDTO);
        }
        return notesByDay;
	}

	@Override
	public void createNewNote(NoteDTO noteDTO, Integer userId) {
		Note note = modelMapper.map(noteDTO, Note.class);
		User user = new User();
		user.setUserId(userId);
		
		note.setUpdatedAt(new Date());
		note.setIsMarked(0);
		note.setUser(user);
		note.setCreatedAt(new Date());
		noteRepository.save(note);		
	}

	@Override
	public NoteDTO updateNote(NoteDTO noteDTO) {
		Note note = noteRepository.findByNoteId(noteDTO.getNoteId());
		if(note != null) {
			note.setNoteContent(noteDTO.getNoteContent());
			note.setNoteTitle(noteDTO.getNoteTitle());
			note.setUpdatedAt(new Date());
			
			noteRepository.save(note);
			return modelMapper.map(note, NoteDTO.class);
		}
		return null;
	}

	@Override
	public boolean deleteNote(Integer noteId) {
		Note note = noteRepository.findByNoteId(noteId);
		if(note != null) {
			noteRepository.delete(note);
			return true;
		}
		return false;
	}

	@Override
	public Map<String, List<NoteDTO>> findNotesIsMarked(Integer userId) {
		List<Note> notes = noteRepository.findByUserIdAndIsMarkedOrderByCreatedAtDesc(userId);
		Map<String, List<NoteDTO>> notesByMarked = new LinkedHashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        for(Note note : notes) {
        	NoteDTO noteDTO = modelMapper.map(note, NoteDTO.class);
        	String dateKey = sdf.format(note.getCreatedAt());
        	notesByMarked.computeIfAbsent(dateKey, k -> new ArrayList<>()).add(noteDTO);
        }
        return notesByMarked;
	}

	@Override
	public NoteDTO updateMarkedNote(Integer noteId) {
		Note note = noteRepository.findByNoteId(noteId);
		if(note != null) {
			if(note.getIsMarked() == 1) note.setIsMarked(0);
			else note.setIsMarked(1);
			noteRepository.save(note);
			return modelMapper.map(note, NoteDTO.class);
		}
		return null;
	}

}
