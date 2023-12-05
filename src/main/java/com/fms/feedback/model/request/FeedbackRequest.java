package com.fms.feedback.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackRequest {
    private String phoneNumber;
    private String topic;
    private String comment;
    private float rating;
}
