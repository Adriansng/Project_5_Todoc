package com.cleanup.todoc.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

/**
 * Created by Adrian SENEGAS 24/04/2020.
 */
@Database(entities = {Task.class, Project.class}, version = 1, exportSchema = false)
public abstract class TodocBasedata extends RoomDatabase {

    // --- SINGLETON --
    private static volatile TodocBasedata INSTANCE;

    // --- DAO ---
    public abstract TaskDao taskDao();
    public abstract ProjectDao projectDao();

    // --- INSTANCE ---
    public static TodocBasedata getInstance(Context context){
        if(INSTANCE == null) {
            synchronized (TodocBasedata.class) {
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TodocBasedata.class,"TodocDatabse.db").allowMainThreadQueries()
                            .build();

                }
            }
        }
        return INSTANCE;
    }

}
