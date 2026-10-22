package com.example.leave_management_api.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leave_management_api.database.repository.addTaskRepo;
import com.example.leave_management_api.database.repository.updateTask;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service("taskService")
public class task {

    @Autowired
    private addTaskRepo addTask;

    @Autowired
    private updateTask updateTaskRepo;

    @Transactional
    public Optional<com.example.leave_management_api.database.entity.task> addTask(String id, String type, String task_title, String task_desc) {
        com.example.leave_management_api.database.entity.task newTask = new com.example.leave_management_api.database.entity.task();
        newTask.setId(id);
        newTask.setType(type);
        newTask.setTask_title(task_title);
        newTask.setTask_desc(task_desc);
        newTask.setCreate_Date(LocalDateTime.now());

        addTask.addTask(id, type, task_title, task_desc, newTask.getCreate_Date());

        return Optional.of(newTask);
    }

    public Optional<com.example.leave_management_api.database.entity.task> findById(String id) {
        return addTask.findById(id);
    }

    @Transactional
    public Optional<com.example.leave_management_api.database.entity.task> update(String id, String type, String task_title, String task_desc) {
        updateTaskRepo.update(id, type, task_title, task_desc);
        return addTask.findById(id);
    }

}
