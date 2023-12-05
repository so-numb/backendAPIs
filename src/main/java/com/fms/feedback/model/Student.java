package com.fms.feedback.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Student")
@Getter
@Setter
public class Student {
    @Id
    private String studentId;
    private String name;
    private String contact;
    private String address;
    private String course;
    private String batch;
}
