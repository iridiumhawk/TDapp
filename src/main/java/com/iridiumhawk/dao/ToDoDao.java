package com.iridiumhawk.dao;

import com.iridiumhawk.entity.ToDo;

import java.util.List;

/**
 * Created by hawk on 09.05.2016.
 */

public interface ToDoDao {

    ToDo findById(Integer id);

    List findAllNotes();

    void saveNote(ToDo note);

    void deleteNote(Integer id);

    List findByNote(String search);

    List findByDate(String search);

}