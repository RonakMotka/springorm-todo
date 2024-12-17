package com.springcore.dao;

import com.springcore.entity.Todo;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public class TodoDao {

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public int insert(Todo todo) {
        System.out.println(todo);
        Integer id = (Integer) hibernateTemplate.save(todo);
        return  id;
    }

    public List<Todo> getAllTodo() {
        return hibernateTemplate.execute(session -> session.createQuery("from Todo where isDeleted = false", Todo.class).list());
    }

    public Todo getTodoById(int id) {
        try {
            String query = String.format("from Todo where id = %d and isDeleted = false", id);
            Todo dbtodo = hibernateTemplate.execute(session -> session.createQuery(query, Todo.class).getSingleResult());
            return dbtodo;
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public Todo updateTodo(int id, String title) {
        Todo dbTodo = getTodoById(id);
        if (dbTodo == null) {
            return null;
        }
        dbTodo.setTitle(title);
        dbTodo.setUpdatedAt(now());
        hibernateTemplate.update(dbTodo);
        return dbTodo;
    }

    @Transactional
    public boolean deleteTodo(int id){
        Todo dbTodo = getTodoById(id);
        if (dbTodo == null) {
            return false;
        }
        dbTodo.setDeleted(true);
        dbTodo.setUpdatedAt(now());
        hibernateTemplate.update(dbTodo);
        return true;
    }


}
