package com.iridiumhawk.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by hawk on 09.05.2016.
 */


@Entity
@Table(name="todo")
 public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=1, max=100)
    @Column(name = "TITLE", nullable = false)
    private String title;

    @Size(min=1, max=1000)
    @Column(name = "NOTE", nullable = false)
    private String note;

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "BEGINDATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate beginDate;

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "ENDDATE", nullable = true)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate endDate;


    @NotNull
    @Column(name = "DONE", nullable = false)
    private Boolean done;

    //приоритет добавить?

/*    @Column(name = "PRIORITET")
    private Integer prioritet;*/

//    кодировка ISO-8859-1

    @Required
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ToDo))
            return false;
        ToDo other = (ToDo) obj;
        if (id != other.id)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "ToDo: [id=" + id + ", title=" + title + ", note=" + note + ", beginDate="
                + beginDate +  ", endDate="
                + endDate +", ended=" + done  + "]";
    }

}