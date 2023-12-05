package com.fms.feedback.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FeedbackResponse {
    private String feedbackId;
    private Date feedbackDate;
    private String feedbackStatus;
}
