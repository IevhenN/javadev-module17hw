package home.hw.module17hw.repository;

import home.hw.module17hw.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {}
