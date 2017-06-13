package com.iridiumhawk.service;

import com.iridiumhawk.entity.ToDo;

import java.util.List;

/**
 * Created by hawk on 09.05.2016.
 */
public interface ToDoService {
    /**
     * Return one note object
     * @param id of note for get
     * @return one note by id
     */
    ToDo findById(Integer id);

    /**
     * Save one note to db
     * @param note
     */
    void saveNote(ToDo note);

    void updateNote(ToDo note);

    void deleteNoteById(Integer id);

    List<ToDo> findAllNotes();

    List<ToDo> findByNote(String search);

    List<ToDo> findByDate(String search);

//    boolean isNoteTitleUnique(Integer id, String title);

//    void generateNewNote();

}