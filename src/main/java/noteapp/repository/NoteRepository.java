package noteapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import noteapp.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Integer>, CustomizedNoteRepository{
	@Query(value = "SELECT * FROM note n WHERE n.user_id = :userId ORDER BY n.created_at DESC", nativeQuery = true)
	List<Note> findByUserIdOrderByCreatedAtDesc(Integer userId);
	
	@Query(value = "SELECT * FROM note n WHERE n.user_id = :userId AND is_marked = 1 ORDER BY n.created_at DESC", nativeQuery = true)
	List<Note> findByUserIdAndIsMarkedOrderByCreatedAtDesc(Integer userId);
	
	Note findByNoteId(Integer noteId);
}
