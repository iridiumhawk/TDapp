package com.iridiumhawk.controller;

import com.iridiumhawk.entity.ToDo;
import com.iridiumhawk.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by hawk on 08.05.2016.
 */
@Controller
@RequestMapping("/")
public class MyController {

    int countPerPage = 20;

    @Autowired
    ToDoService service;

//    @Autowired
//    MessageSource messageSource;


    public List returnListOfPages() {
        List<Integer> listPages = new ArrayList<>();
        int sizeNotesList = service.findAllNotes().size();
        int countPages;

        if (sizeNotesList % countPerPage == 0) {
            countPages = sizeNotesList / countPerPage;
        } else countPages = sizeNotesList / countPerPage + 1;

        for (int i = 1; i <= countPages; i++) {
            listPages.add(i);
        }
        return listPages;
    }

    /**
     * @return
     */
    public List<ToDo> listNoteForOnePage() {
        return listNoteForOnePage(1);
    }

    /**
     * @param page
     * @return
     */
    public List<ToDo> listNoteForOnePage(Integer page) {

        int sizeNotesList = service.findAllNotes().size();

        int minIndex = (page - 1) * countPerPage;
        int maxIndex = sizeNotesList > minIndex + countPerPage ? minIndex + countPerPage : sizeNotesList;

        List<ToDo> notes = service.findAllNotes().subList(minIndex, maxIndex);

        return notes;
    }

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listNotes(ModelMap model) {

        List<ToDo> notes = listNoteForOnePage(1);
        model.addAttribute("pages", returnListOfPages());
        model.addAttribute("notes", notes);

        return "allnotes";
    }

    @RequestMapping(value = {"/page-{page}"}, method = RequestMethod.GET)
    public String pagesNotes(@PathVariable Integer page, ModelMap model) {

        returnPageByNumber(page, model);

        return "allnotes";

    }

    private void returnPageByNumber(@PathVariable Integer page, ModelMap model) {
        List<ToDo> notes = listNoteForOnePage(page);
        model.addAttribute("pages", returnListOfPages());
        model.addAttribute("currentpage", page);
        model.addAttribute("notes", notes);
    }

    @RequestMapping(value = {"/sortbycategory"}, method = RequestMethod.GET)
    public String pagesSortByCategory(@PathVariable Integer page, ModelMap model) {

        returnPageByNumber(page, model);

        return "allnotes";

    }

    @RequestMapping(value = {"/sortbynote"}, method = RequestMethod.GET)
    public String pagesSortByNote(@PathVariable Integer page, ModelMap model) {

        returnPageByNumber(page, model);

        return "allnotes";

    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newNote(ModelMap model) {
        ToDo note = new ToDo();
        model.addAttribute("createnote", note);
        model.addAttribute("edit", false);
        return "newnote";
    }
/*
    @RequestMapping(value = {"/gen"}, method = RequestMethod.GET)
    public String genNote() {
        service.generateNewNote();

        return "redirect:/list";
    }*/

    //Поиск
    @RequestMapping(value = {"/find"}, method = RequestMethod.POST)
    public String findNote(@RequestParam("input") String input, ModelMap model) {

        List<ToDo> notes = new ArrayList<>();

        input = input.trim();

        int id = 0;
        boolean findById = false;
        boolean findByDate = false;
        boolean findByNote = false;

        //проверка на неверный запрос
        try {
            id = Integer.parseInt(input);
            findById = true;
        } catch (NumberFormatException e) {
            findById = false;
        }

        if (input.matches("\\d{4}-\\d{2}-\\d{2}")) {
            findByDate = true;
        }

        if (!findById && !findByDate) {
            findByNote = true;
        }

        if (findById) {
            ToDo result = service.findById(id);
            if (result != null) notes.add(result);
        }

        if (findByDate) {
            notes = service.findByDate(input);
        }


        if (findByNote) {
            notes = service.findByNote(input);
        }


        if (notes.isEmpty()) {

            model.addAttribute("success", "Поиск вернул пустой результат!");
            return "done";
        }


        model.addAttribute("notes", notes);

        return "allnotes";

    }

    @RequestMapping(value = {"/delete-{id}-note"}, method = RequestMethod.GET)
    public String deleteNote(@PathVariable Integer id) {
        service.deleteNoteById(id);
        return "redirect:/list";
    }

    @RequestMapping(value = {"/edit-{id}-note"}, method = RequestMethod.GET)
    public String editNote(@PathVariable Integer id, ModelMap model) {
        ToDo note = service.findById(id);
        model.addAttribute("createnote", note);
        model.addAttribute("edit", true);
        return "newnote";
    }


    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveNote(@Valid ToDo note, BindingResult result, ModelMap model) {


        model.put("createnote", note);

        if (result.hasErrors()) {
            model.addAttribute("error", true);
            return "newnote";
        }

        service.saveNote(note);

        model.addAttribute("success", "Дело " + note.getTitle() + " сохранено успешно!");
        return "done";
    }

    @RequestMapping(value = {"/edit-{id}-note"}, method = RequestMethod.POST)
    public String updateNote(@Valid ToDo note, BindingResult result,
                             ModelMap model) {

        model.put("createnote", note);
        if (result.hasErrors()) {
            model.addAttribute("error", true);
            return "newnote";
        }

        service.updateNote(note);

        model.addAttribute("success", "Дело " + note.getTitle() + " изменено успешно!");
        return "done";
    }


}

