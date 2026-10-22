package com.example.leave_management_api.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Data
public class task {

    @Id 
    @Column(name = "id")
    private String id;

    @Column(name = "type")
    private String type;

    @Column(name = "task_title")
    private String task_title;

    @Column(name = "task_desc")
    private String task_desc;

    @Column(name = "create_Date")
    private LocalDateTime create_Date;
}
