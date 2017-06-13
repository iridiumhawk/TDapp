package com.iridiumhawk.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "todo", schema = "test")
public class TodoEntity {
    private int id;
    private String title;
    private String note;
    private Timestamp begindate;
    private Timestamp enddate;
    private Boolean done;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "begindate")
    public Timestamp getBegindate() {
        return begindate;
    }

    public void setBegindate(Timestamp begindate) {
        this.begindate = begindate;
    }

    @Basic
    @Column(name = "enddate")
    public Timestamp getEnddate() {
        return enddate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }

    @Basic
    @Column(name = "done")
    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoEntity that = (TodoEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (begindate != null ? !begindate.equals(that.begindate) : that.begindate != null) return false;
        if (enddate != null ? !enddate.equals(that.enddate) : that.enddate != null) return false;
        if (done != null ? !done.equals(that.done) : that.done != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (begindate != null ? begindate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + (done != null ? done.hashCode() : 0);
        return result;
    }
}
