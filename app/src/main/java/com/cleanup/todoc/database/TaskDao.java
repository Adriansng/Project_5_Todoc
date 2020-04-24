package com.cleanup.todoc.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleanup.todoc.model.Task;

import java.util.List;

/**
 * Created by Adrian SENEGAS 24/04/2020.
 */
@Dao
public interface TaskDao {

    @Query("SELECT*FROM Task")
    LiveData<List<Task>> getAllTask();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTask(List<Task> taskList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createTask(Task task);

    @Update
    int updateTask(Task task);

    @Query("DELETE FROM Task WHERE id = :taskId")
    void deleteTask(long taskId);
}
