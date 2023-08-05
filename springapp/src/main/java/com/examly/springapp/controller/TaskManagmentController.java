package com.examly.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.pojo.Task;
import com.examly.springapp.repository.TaskRepository;

@RestController
public class TaskManagementController {

	@Autowired
	TaskRepository taskRepository;


    @PostMapping("/saveTask")
	public ResponseEntity<Task> createTasks(@RequestBody Task task) {
		taskRepository.save(task);
		return new ResponseEntity<Task>(task,HttpStatus.CREATED);
	}
 
    @GetMapping("/changeStatus")
	public String changeStatus(@RequestParam String taskId) {
		return "change status !  "+taskId;
	}

    @GetMapping("/deleteTask")
	public ResponseEntity<String> deleteTask(@RequestParam Long taskId) {
		taskRepository.deleteById(taskId);
		return new ResponseEntity<String>(taskId+" successfully deleted",HttpStatus.OK);
	}

    @GetMapping("/alltasks")
	public ResponseEntity<List<Task>> getAllTasks() {
		List<Task> tasks=(List<Task>)taskRepository.findAll();
		return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
	}
    
    @GetMapping("/getTask")
	public ResponseEntity<Task> getTask(@RequestParam Long taskId) {
		Optional<Task> task=taskRepository.findById(taskId);
		if(task.isPresent()){
			return new ResponseEntity<Task>(task.get(), HttpStatus.OK);
		} else{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
	}




}

