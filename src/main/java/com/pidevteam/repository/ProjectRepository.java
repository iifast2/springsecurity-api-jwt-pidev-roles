package com.pidevteam.repository;

import com.pidevteam.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository  extends JpaRepository<Project, Long> {
    // For Test
    List<Project> findByName(String name);

}
