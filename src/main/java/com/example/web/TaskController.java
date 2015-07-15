package com.example.web;

import com.example.domain.Task;
import com.example.persistence.TaskMapper;
import com.example.web.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public Task saveTask(@RequestBody Task task) {
        if (task.getComplete() == null) {
            task.setComplete(false);
        }
        taskMapper.addTask(task);
        return task;
    }

    @RequestMapping(value = "/task/{taskId}", method = RequestMethod.GET)
    public Task getTask(@PathVariable Long taskId) {
        Task task = taskMapper.findTask(taskId);
        if (task != null) {
            return task;
        } else {
            throw new NotFoundException();
        }
    }


    @RequestMapping(value = "/task/{taskId}", method = RequestMethod.PUT)
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        int changed = taskMapper.updateTask(task);
        if (changed == 0) {
            throw new NotFoundException();
        }
        return task;
    }

}
