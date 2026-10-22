package com.example.leave_management_api.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

import com.example.leave_management_api.database.entity.task;

@Repository
public interface addTaskRepo extends JpaRepository<task, String> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO task (id, type, task_title, task_desc, create_Date) "
                    + "VALUES (:id, :type, :task_title, :task_desc, :create_Date)",
                    nativeQuery = true)
    void addTask(
            @Param("id") String id,
            @Param("type") String type,
            @Param("task_title") String task_title,
            @Param("task_desc") String task_desc,
            @Param("create_Date") LocalDateTime create_Date
        );

}
