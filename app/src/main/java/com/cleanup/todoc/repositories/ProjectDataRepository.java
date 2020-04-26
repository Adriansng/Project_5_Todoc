package com.cleanup.todoc.repositories;


import com.cleanup.todoc.database.ProjectDao;
import com.cleanup.todoc.model.Project;

/**
 * Created by Adrian SENEGAS 24/04/2020.
 */
public class ProjectDataRepository {
    private final ProjectDao projectDao;

    public ProjectDataRepository(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    // --- GET PROJECT ---
    public Project getProject(long projectId) {
        return this.projectDao.getProject(projectId);
    }
}
