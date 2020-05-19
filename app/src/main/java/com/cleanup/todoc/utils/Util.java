package com.cleanup.todoc.utils;

import com.cleanup.todoc.model.Task;

import java.util.Collections;
import java.util.List;

import static com.cleanup.todoc.utils.SortMethod.ALPHABETICAL;
import static com.cleanup.todoc.utils.SortMethod.ALPHABETICAL_INVERTED;
import static com.cleanup.todoc.utils.SortMethod.OLD_FIRST;
import static com.cleanup.todoc.utils.SortMethod.RECENT_FIRST;

public class Util {

    public static List<Task> sortTasks(final List<Task> tasks, SortMethod sortMethod) {
        if (tasks.size() != 0) {
            switch (sortMethod) {
                case ALPHABETICAL:
                    Collections.sort(tasks, new Task.TaskAZComparator());
                    break;
                case ALPHABETICAL_INVERTED:
                    Collections.sort(tasks, new Task.TaskZAComparator());
                    break;
                case RECENT_FIRST:
                    Collections.sort(tasks, new Task.TaskRecentComparator());
                    break;
                case OLD_FIRST:
                    Collections.sort(tasks, new Task.TaskOldComparator());
                    break;
            }
        }
        return tasks;
    }
}
