package com.fms.feedback.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document("feedback")
@Getter
@Setter
public class Feedback {
    @Id
    private String feedbackId;
    private String studentId;
    private Date feedbackDate;
    private String topicName;
    private String topicTeacher;
    private String comment;
    private float rating;
}
