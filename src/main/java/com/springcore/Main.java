package com.springcore;

import com.springcore.dao.TodoDao;
import com.springcore.entity.Todo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        TodoDao todoDao = context.getBean("todoDao", TodoDao.class);


//        Insert todo
//        Todo todo = new Todo("fourth task");
//        Integer id = todoDao.insert(todo);
//        System.out.println(id);

//        get all todos
        List<Todo> todos = todoDao.getAllTodo();
        for (Todo todo: todos) {
            System.out.println(todo);
        }

//        get todo by id
//        Todo todo = todoDao.getTodoById(1);
//        if (todo == null) {
//            System.out.println("Todo is not found");
//        } else {
//            System.out.println(todo);
        
//        }

//        update todo
//        Todo updateTodo = todoDao.updateTodo(1, "updated first title");
//        if (updateTodo == null) {
//            System.out.println("Todo is not found");
//        } else {
//            System.out.println(updateTodo);
//        }

//        Delete todo
//        Boolean deleteTodo = todoDao.deleteTodo(1);
//        if (deleteTodo == false) {
//            System.out.println("Todo is not found");
//        } else {
//            System.out.println("Todo deleted");
//        }
    }

}
