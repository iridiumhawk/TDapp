package com.iridiumhawk.dao;

import com.iridiumhawk.entity.ToDo;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hawk on 09.05.2016.
 */

@Repository("ToDoDao")
@Qualifier("main")
public class ToDoDaoImpl extends AbstractDao<Integer, ToDo> implements ToDoDao {

    public ToDo findById(Integer id) {
        return getByKey(id);
    }

    public void saveNote(ToDo note) {
        persist(note);
    }

    public void deleteNote(Integer id) {
        Query query = getSession().createSQLQuery("delete from todo where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public List<ToDo> sortBy() {
/*        Query query = getSession().createSQLQuery("delete from todo where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();*/

        return new ArrayList<>();
    }

    //    @SuppressWarnings("unchecked")
    public List findAllNotes() {
        Criteria criteria = createEntityCriteria();
        return criteria.list();
    }

    public List findByNote(String search) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.like("note", "%" + search + "%"));

        criteria.addOrder(Order.asc("note"));
        return criteria.list();
    }

    public List findByDate(String search) {
      /*Locale locale = java.util.Locale.US;*/

        LocalDate dateLocal = LocalDate.parse(search);


        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("beginDate", dateLocal));
//        criteria.add(Restrictions.eq("endDate",dateLocal));

        return criteria.list();
    }
}

