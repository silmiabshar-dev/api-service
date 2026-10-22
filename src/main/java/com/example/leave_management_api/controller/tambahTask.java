package com.example.leave_management_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.leave_management_api.service.task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;

@Controller 
@Slf4j 
@RequestMapping("/task")
public class tambahTask {
    
    private final task taskService;

    @Autowired
    public tambahTask(task taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tambahTask")
        public ResponseEntity<?> addTask(@RequestParam String id, @RequestParam String type, @RequestParam String task_title, @RequestParam String task_desc) {
            try {
                taskService.addTask(id, type, task_title, task_desc);
                return ResponseEntity.ok("Task added successfully");
            } catch (Exception e) {
                log.error("Error adding task: {}", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding task");
            }
        }

    @GetMapping("/SearchTask")
    public ResponseEntity<?> searchTask(@RequestParam String id) {
            try {
                var task = taskService.findById(id);
                if (task.isPresent()) {
                    return ResponseEntity.ok(task.get());
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
                }
            } catch (Exception e) {
                log.error("Error searching task: {}", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error searching task");
            }
        }

    @GetMapping("/UpdateTask")
    public ResponseEntity<?> updateTask(@RequestParam String id, @RequestParam String type, @RequestParam String task_title, @RequestParam String task_desc) {
            try {
                var task = taskService.update(id, type, task_title, task_desc);
                if (task.isPresent()) {
                    return ResponseEntity.ok(task.get());
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
                }
            } catch (Exception e) {
                log.error("Error updating task: {}", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating task");
            }
        }
}

