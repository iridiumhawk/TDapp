package com.iridiumhawk.service;

import com.iridiumhawk.dao.ToDoDao;
import com.iridiumhawk.entity.ToDo;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hawk on 09.05.2016.
 */
@Service("ToDoService")
@Qualifier("main")
@Transactional
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoDao dao;

    public void saveNote(ToDo note) {
        dao.saveNote(note);
    }

    public void updateNote(ToDo note) {
        ToDo entity = dao.findById(note.getId());
        if (entity != null) {
            entity.setTitle(note.getTitle());
            entity.setBeginDate(note.getBeginDate());
            entity.setEndDate(note.getEndDate());
            entity.setNote(note.getNote());
            entity.setDone(note.getDone());

        }
    }

    public void deleteNoteById(Integer id) {
        dao.deleteNote(id);
    }

    public List<ToDo> findAllNotes() {
        return dao.findAllNotes();
    }

    public List<ToDo> findByNote(String search) {
        return dao.findByNote(search);
    }

    public List<ToDo> findByDate(String search) {
        return dao.findByDate(search);
    }

    public ToDo findById(Integer id) {
        return dao.findById(id);
    }


//    public boolean isNoteTitleUnique(Integer id, String title) {
//        return false;
//    }
/*

    public void generateNewNote() {

        List<String> listTODO = loadFileTODO();

        for (int i = 0; i < listTODO.size(); i++) {

            int randomLine = (int) Math.round(Math.random() * (listTODO.size()+1));

            if (randomLine < 0 || randomLine > listTODO.size() - 1) {
                continue;
            }

            String getLine = listTODO.get(randomLine);
            listTODO.set(randomLine, "");

            if (getLine.equals("")) {
                continue;
            }

            String title = getLine.split(" ")[0];

            Long beginDate = new Date().getTime() - Math.round(Math.random() * 94608000000L);
            Long endDate = new Date().getTime() + Math.round(Math.random() * 94608000000L);


            ToDo note = new ToDo();
            note.setTitle(title);
            note.setNote(getLine);
            note.setDone(new Date().getTime() % 11 == 0 ? true : false);
            note.setBeginDate(new LocalDate(beginDate));
            note.setEndDate(new LocalDate(endDate));
            saveNote(note);
        }
    }


    private List<String> loadFileTODO() {

        List<String> listTODO = new ArrayList<>();
        String line;
        String fileName = "c:/java/projects/MyTODOapp-v3/src/main/java/com/iridiumhawk/service/todo.txt";

        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));

            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                listTODO.add(line);
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            listTODO.add("Ничего не получилось загрузить");
        } catch (IOException e) {
            listTODO.add("Нечего больлше прочитать");
        }


        return listTODO;
    }
*/
}

