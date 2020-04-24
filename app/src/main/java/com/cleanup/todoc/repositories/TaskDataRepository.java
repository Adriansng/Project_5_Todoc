package com.cleanup.todoc.repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.TaskDao;
import com.cleanup.todoc.model.Task;

import java.util.List;

/**
 * Created by Adrian SENEGAS 24/04/2020.
 */
public class TaskDataRepository {
    private final TaskDao taskDao;

    public TaskDataRepository(TaskDao taskDAO){this.taskDao = taskDAO;}

    // --- GET ---
    public List<Task> getAllTasks(){return this.taskDao.getAllTask();}

    public void insertAllTasks(List<Task> taskList){taskDao.insertAllTask(taskList);}

    // --- CREATE ---
    public void createTask(Task task){taskDao.createTask(task);};

    // --- UPDATE ---
    public void updateTask(Task task){taskDao.updateTask(task);}

    // --- DELETE ---
    public void deleteTask(long taskId){taskDao.deleteTask(taskId);}
}
