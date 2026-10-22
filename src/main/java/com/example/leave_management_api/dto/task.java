package com.example.leave_management_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
public class task {

    private String id;
    private String type;
    private String task_title;
    private String task_desc;
    
}
