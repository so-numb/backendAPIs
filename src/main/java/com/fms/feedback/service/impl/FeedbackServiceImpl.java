package com.fms.feedback.service.impl;

import com.fms.feedback.model.Feedback;
import com.fms.feedback.model.LowRating;
import com.fms.feedback.model.Student;
import com.fms.feedback.model.Teacher;
import com.fms.feedback.model.request.FeedbackRequest;
import com.fms.feedback.model.request.GetTeacherRequest;
import com.fms.feedback.model.response.FeedbackResponse;
import com.fms.feedback.repository.FeedbackRepository;
import com.fms.feedback.repository.StudentRepository;
import com.fms.feedback.repository.TeacherRepository;
import com.fms.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Override
    public String registerTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
        return "Registered Successfully"+"\nYour user ID is "+teacher.getTeacherId();
    }

    @Override
    public String registerStudent(Student student) {
        studentRepository.save(student);
        return "Registered Successfully"+"\nYour user ID is "+student.getStudentId();
    }

    @Override
    public List<Teacher> viewAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Student> viewAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public FeedbackResponse createFeedback(FeedbackRequest feedbackRequest) {
        Student student = studentRepository.findByContact(feedbackRequest.getPhoneNumber());

        Feedback feedback = new Feedback();

        feedback.setStudentId((student.getStudentId()));
        feedback.setFeedbackDate(new Date());
        feedback.setTopicName(feedbackRequest.getTopic());

        for(Teacher var : teacherRepository.findAll()){
            if(var.getTopics().contains(feedbackRequest.getTopic())){
                feedback.setTopicTeacher(var.getName());
            }
        }

//        feedback.setTopicTeacher(teacherRepository.findByTopics(feedbackRequest.getTopic()).getName());
        feedback.setComment(feedbackRequest.getComment());
        feedback.setRating(feedbackRequest.getRating());

        feedback = feedbackRepository.save(feedback);

        FeedbackResponse feedbackResponse = new FeedbackResponse();

        feedbackResponse.setFeedbackId(feedback.getFeedbackId());
        feedbackResponse.setFeedbackStatus("Feedback submitted successfully!");
        feedbackResponse.setFeedbackDate(feedback.getFeedbackDate());
        return feedbackResponse;
    }

    @Override
    public String avgRating(String teacherName) {
        if(teacherRepository.findByName(teacherName) == null){
            return "Invalid teacher name!";
        }
        else{
            int count = feedbackRepository.findByTopicTeacher(teacherName).size();
            if(count == 0){
                return "0 rating available!";
            }
            float sum = 0;
            for(Feedback f : feedbackRepository.findByTopicTeacher(teacherName)){
                sum = sum + f.getRating();
            }
            float avg = sum/count;
            return "Average rating is " + avg;
        }
    }

    @Override
    public List<LowRating> lowRating(String studentName) {
        String studentId = studentRepository.findByName(studentName).getStudentId();
        List<Feedback> feedbackList = feedbackRepository.findByStudentId(studentId);
        List<LowRating> topicList = new ArrayList<>();
        for(Feedback feedback : feedbackList){
            if(feedback.getRating() < 4){
                LowRating lowRating = new LowRating();
                lowRating.setTopicName(feedback.getTopicName());
                lowRating.setComment(feedback.getComment());
                topicList.add(lowRating);
            }
        }
        return topicList;
    }

    @Override
    public String deleteFeedbackById(String feedbackID) {
        feedbackRepository.deleteById(feedbackID);
        return "Feedback deleted successfully!";
    }

    @Override
    public String deleteTeacher() {
        teacherRepository.deleteAll();
        return "Deleted";
    }

    @Override
    public String deleteStudent() {
        studentRepository.deleteAll();
        return "Deleted";
    }

    @Override
    public List<Feedback> viewAllFeedback() {
        return feedbackRepository.findAll();
    }


    @Override
    public List<Teacher> getTeacherByTopics(GetTeacherRequest getTeacherRequest) {
        return teacherRepository.findAllByTopicsIn(getTeacherRequest.getTopicList());
    }
}
