//package com.web_project.school.model;
//
//import jakarta.persistence.*;
//import java.util.List;
//import java.util.UUID;
//
//@Entity
//@Table(name = "events")
//public class EventModel {
//    @Id
//    @GeneratedValue
//    private UUID id;
//
//    private String eventName;
//
//    @ManyToMany
//    @JoinTable(
//            name = "event_students",
//            joinColumns = @JoinColumn(name = "event_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id")
//    )
//    private List<StudentModel> students;
//
//    public EventModel(UUID id, String eventName, List<StudentModel> students) {
//        this.id = id;
//        this.eventName = eventName;
//        this.students = students;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getEventName() {
//        return eventName;
//    }
//
//    public void setEventName(String eventName) {
//        this.eventName = eventName;
//    }
//
//    public List<StudentModel> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<StudentModel> students) {
//        this.students = students;
//    }
//}