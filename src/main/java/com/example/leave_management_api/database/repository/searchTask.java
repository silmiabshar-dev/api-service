package com.example.leave_management_api.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.leave_management_api.database.entity.task;

@Repository
public interface searchTask extends JpaRepository<task, String> {

    @Query(value = "SELECT * FROM task WHERE "
                    + "id LIKE CONCAT('%', :keyword, '%') OR "
                    + "type LIKE CONCAT('%', :keyword, '%') OR "
                    + "task_title LIKE CONCAT('%', :keyword, '%') OR "
                    + "task_desc LIKE CONCAT('%', :keyword, '%')",
            nativeQuery = true)
    List<task> search(@Param("keyword") String keyword);

}
