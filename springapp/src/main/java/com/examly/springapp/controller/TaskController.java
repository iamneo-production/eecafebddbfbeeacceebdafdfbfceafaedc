package com.examly.springapp.controller;

import java.util.List;

import com.examly.springapp.entity.Taskentity;
import com.examly.springapp.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class TaskController {
    @Autowired
    private TaskService service;
    
    @PostMapping("/saveTask")
    public Taskentity saveTask(@RequestBody Taskentity taskentity){
        return service.saveTask(taskentity);
        
    }


    @GetMapping("/changeStatus")
    public Taskentity updatetaskStatus(@RequestParam("id") String id){
        return service.updatetaskStatus(id);
    }

    @GetMapping("/deleteTask")
    public String deleteTask(@RequestParam("id") String id){
        return service.deleteTask(id);
    }
    @GetMapping("/alltasks")
    public List<Taskentity> getallTasks(){
        return service.getallTasks();
    }

    @GetMapping("/getTask")
    public Taskentity getTask(@RequestParam("id") String id){
        return service.gettaskbyid(id);
    }

}