package com.example.daaa;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @ElementCollection
    private List<String> subjects = new ArrayList<>();

    @ElementCollection
    private Set<String> hobbies = new HashSet<>();

    @ElementCollection
    @MapKeyColumn(name = "subject")
    @Column(name = "marks")
    @CollectionTable(name = "student_marks", joinColumns = @JoinColumn(name = "student_id"))
    private Map<String, Integer> subjectMarks = new HashMap<>();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public List<String> getSubjects() { return subjects; }
    public void setSubjects(List<String> subjects) { this.subjects = subjects; }

    public Set<String> getHobbies() { return hobbies; }
    public void setHobbies(Set<String> hobbies) { this.hobbies = hobbies; }

    public Map<String, Integer> getSubjectMarks() { return subjectMarks; }
    public void setSubjectMarks(Map<String, Integer> subjectMarks) { this.subjectMarks = subjectMarks; }
}

