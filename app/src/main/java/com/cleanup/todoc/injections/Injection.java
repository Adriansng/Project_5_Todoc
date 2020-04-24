package com.cleanup.todoc.injections;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.cleanup.todoc.database.TodocBasedata;
import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Adrian SENEGAS 24/04/2020.
 */
public class Injection {
    public static TaskDataRepository provideTaskDataSource(Context context){
        TodocBasedata database= TodocBasedata.getInstance(context);
        return new TaskDataRepository(database.taskDao());
    }

    public static ProjectDataRepository provideProjectDataSource(Context context){
        TodocBasedata database= TodocBasedata.getInstance(context);
        return new ProjectDataRepository(database.projectDao());
    }

    public static Executor provideExecutor(){return Executors.newSingleThreadExecutor();}

    public static ViewModelFactory provideViewModelFactory(Context context){
        TaskDataRepository dataSourceTask= provideTaskDataSource(context);
        ProjectDataRepository dataSourceProject = provideProjectDataSource(context);
        Executor executor= provideExecutor();
        return new ViewModelFactory(dataSourceTask,dataSourceProject,executor);
    }
}
