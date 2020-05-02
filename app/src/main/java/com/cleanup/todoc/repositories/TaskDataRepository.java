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
    public LiveData<List<Task>> getAllTasks(){return this.taskDao.getAllTasks();}

    // --- CREATE ---
    public void createTask(Task task){taskDao.createTask(task);}

    // --- DELETE ---
    public void deleteTask(long taskId){taskDao.deleteTask(taskId);}
}
