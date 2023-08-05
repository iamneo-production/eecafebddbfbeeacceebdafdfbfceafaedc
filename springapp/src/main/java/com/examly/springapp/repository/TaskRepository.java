package com.examly.springapp.repository;
import com.examly.springapp.pojo.Task;

import org.springframework.data.repository.CrudRepository;


public interface TaskRepository extends CrudRepository<Task, Long> {

}