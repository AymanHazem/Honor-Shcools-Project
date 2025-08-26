package com.ayman.Honor.Schools.repository;

import com.ayman.Honor.Schools.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {

    List<Courses> findByOrderByNameDesc();
}