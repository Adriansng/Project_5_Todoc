package com.cleanup.todoc.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by Adrian SENEGAS 24/04/2020.
 */
public class TaskViewModel extends ViewModel {

    // REPOSITORIES
    private final TaskDataRepository taskDataSource;
    private final Executor executor;

    // DATA
    public TaskViewModel(TaskDataRepository taskDataSource, Executor executor) {
        this.taskDataSource = taskDataSource;
        this.executor = executor;
    }

    // --------------------
    // FOR TASK
    // --------------------


    public List<Task> getTasks(){
        return taskDataSource.getAllTasks();
    }

    public void insertAllTasks(List<Task> taskList){
        executor.execute(() ->{
            taskDataSource.insertAllTasks(taskList);
        });
    }

    public void createTask(Task task){
        executor.execute(() ->{
            taskDataSource.createTask(task);
        });
    }

    public void updateTask(Task task){
        executor.execute(() ->{
            taskDataSource.updateTask(task);
        });
    }

    public void deleteTask(long taskId){
        executor.execute(() ->{
            taskDataSource.deleteTask(taskId);
        });
    }


}
