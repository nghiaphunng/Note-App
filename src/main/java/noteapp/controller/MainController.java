package noteapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import noteapp.dto.NoteDTO;
import noteapp.dto.UserDTO;
import noteapp.service.NoteService;

@Controller
@RequestMapping("/home")
public class MainController {
	@Autowired 
	private NoteService noteService;
	
	@GetMapping(value= {"", "/"})
	public ModelAndView home(HttpServletRequest request, @RequestParam(value = "starred", required = false) Boolean starred) {
		ModelAndView modelAndView = new ModelAndView();
		
		//list note
		HttpSession session = request.getSession(false);
		if(session != null) {
			UserDTO user = (UserDTO) session.getAttribute("user");
			if(user != null) {
				if(Boolean.TRUE.equals(starred)) {
					Map<String, List<NoteDTO>> notesDefault = noteService.findNotesIsMarked(user.getUserId());
					modelAndView.addObject("notesDefault", notesDefault);
				}
				else {
					Map<String, List<NoteDTO>> notesDefault = noteService.findNotesDefault(user.getUserId());
					modelAndView.addObject("notesDefault", notesDefault);
				}				
				modelAndView.setViewName("index");
			}
			else {
				modelAndView.setViewName("redirect:/login");
			}
		}
		else {
			modelAndView.setViewName("redirect:/login");
		}
		return modelAndView;
	}
	
	@PostMapping(value= {"/new-note"})
	public ModelAndView addNote(@ModelAttribute NoteDTO noteDTO, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("redirect:/home");
			
		UserDTO user = (UserDTO) session.getAttribute("user");
		
//		test
//		NoteDTO note = new NoteDTO();
//		note.setNoteTitle("Chủ đề 22");
//		note.setNoteContent("Nội dung 22");
//		noteService.createNewNote(note, user.getUserId());	
		noteService.createNewNote(noteDTO, user.getUserId());	
		
		return modelAndView;
	}
	
	@PostMapping(value= {"/edit-note"})
	public ModelAndView editNote(@ModelAttribute NoteDTO noteDTO, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("redirect:/home");
		NoteDTO noteRes = noteService.updateNote(noteDTO);
		if(noteRes != null) {
			modelAndView.addObject("msgEditNote", "Chỉnh sửa bản ghi thành công");
		}
		else {
			modelAndView.addObject("msgEditNote", "Chỉnh sửa bản ghi thất bại");
		}
		return modelAndView;
	}
	
	@GetMapping(value = {"/marked-note/{id}"})
	public ModelAndView markedNote(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/home");
		NoteDTO noteRes = noteService.updateMarkedNote(id);
		if(noteRes != null) {
			modelAndView.addObject("msgUpdateMarkedNote", "Cập nhật thành công");
		}
		else {
			modelAndView.addObject("msgUpdateMarkedNote", "Cập nhật thất bại");
		}
		return modelAndView;
	}
	
	@PostMapping(value = {"/delete-note/{id}"})
	public ModelAndView deleteNote(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/home");
		boolean checkDeleteNote = noteService.deleteNote(id);
		if(checkDeleteNote) {
			modelAndView.addObject("msgDeleteNote", "Xóa bản ghi thành công");
		}
		else {
			modelAndView.addObject("msgDeleteNote", "Xóa bản ghi thất bại");
		}
		return modelAndView;
	}
}
