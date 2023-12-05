package com.fms.feedback.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Teacher")
@Getter
@Setter
public class Teacher {
    @Id
    private String teacherId;
    private String name;
    private String contact;
    private String address;
    private List<String> topics;
//    private float avgRating;
//    private List<Feedback> feedbacks;
}
