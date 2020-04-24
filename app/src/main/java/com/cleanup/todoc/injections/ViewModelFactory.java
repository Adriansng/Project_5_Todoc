package com.cleanup.todoc.injections;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.cleanup.todoc.repositories.TaskDataRepository;
import com.cleanup.todoc.ui.TaskViewModel;

import java.util.concurrent.Executor;

/**
 * Created by Adrian SENEGAS 24/04/2020.
 */
public class ViewModelFactory implements ViewModelProvider.Factory {
    private final TaskDataRepository taskDataSources;
    private final Executor executor;

    public ViewModelFactory( TaskDataRepository taskDataSources,Executor executor) {
        this.taskDataSources = taskDataSources;
        this.executor = executor;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(TaskViewModel.class)){
            return (T) new TaskViewModel(taskDataSources,executor);
        }
        throw  new IllegalArgumentException("Unknown ViewModel class");
    }
}
