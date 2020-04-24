package com.cleanup.todoc.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.cleanup.todoc.model.Project;

/**
 * Created by Adrian SENEGAS 24/04/2020.
 */
@Dao
public interface ProjectDao {
    @Query("SELECT*FROM Project WHERE id=:projectId")
    LiveData<Project> getProject(long projectId);
}
