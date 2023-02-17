package com.navid.recipieapp.repository;

import com.navid.recipieapp.domain.Note;
import org.springframework.data.repository.CrudRepository;

/**
 * @author n.zare 2/6/2023 $
 */
public interface NotesRepository extends CrudRepository<Note, Long> {
}
