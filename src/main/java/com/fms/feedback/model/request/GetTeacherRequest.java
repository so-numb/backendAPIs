package com.fms.feedback.model.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
@Setter
public class GetTeacherRequest {
    private List<String> topicList;
}
