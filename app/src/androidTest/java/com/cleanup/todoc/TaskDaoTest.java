package com.cleanup.todoc;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.cleanup.todoc.database.TodocBasedata;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Adrian SENEGAS 26/04/2020.
 */
@RunWith(AndroidJUnit4.class)
public class TaskDaoTest {

    // FOR DATA
    private TodocBasedata database;

    // FOR SET FOR TEST
    private Task NEW_TASK_1 = new Task(1L,"Ajouter un header au site",1587253634);
    private Task NEW_TASK_2 = new Task(2L," Modifier la couleur des textes ",1620082400 );
    private Task NEW_TASK_3 = new Task(3L,"Appeler le client",1622760800);

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule= new InstantTaskExecutorRule();

    @Before
    public void initDb(){
        this.database= Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),TodocBasedata.class)
                .allowMainThreadQueries()
                .build();
    }

    @After
    public void closeDb(){
        database.close();
    }

    @Test
    public void getTasksWhenNoItemInserted(){
        // TEST
        List<Task> tasks= this.database.taskDao().getAllTasks();
        assertTrue(tasks.isEmpty());
    }

    @Test
    public  void insertAndGetTasks() {
        // BEFORE : Adding demo tasks
        this.database.taskDao().createTask(NEW_TASK_1);
        this.database.taskDao().createTask(NEW_TASK_2);
        this.database.taskDao().createTask(NEW_TASK_3);
        // TEST
        List<Task> tasks= this.database.taskDao().getAllTasks();
        assertEquals(3, tasks.size());
    }

    @Test
    public void insertAndDeleteTask() {
        // BEFORE : Adding demo task. Next, get the task added & delete it
        this.database.taskDao().createTask(NEW_TASK_1);
        Task taskAdded = this.database.taskDao().getAllTasks().get(0);
        this.database.taskDao().deleteTask(taskAdded.getId());
        // TEST
        List<Task> tasks= this.database.taskDao().getAllTasks();
        assertTrue(tasks.isEmpty());
    }
}
