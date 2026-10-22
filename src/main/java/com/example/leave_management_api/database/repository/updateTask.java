package com.example.leave_management_api.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

import com.example.leave_management_api.database.entity.task;

@Repository
public interface updateTask extends JpaRepository<task, String> {

    @Modifying
    @Transactional
    @Query (value = "UPDATE task SET type = :type, task_title = :task_title, task_desc = :task_desc WHERE id = :id", nativeQuery = true)
    void update(
        @Param("id") String id,
        @Param("type") String type,
        @Param("task_title") String task_title,
        @Param("task_desc") String task_desc
    );
}
