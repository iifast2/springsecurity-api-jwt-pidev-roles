package com.pidevteam.repository;


import com.pidevteam.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // For Test
    List<Task> findByDescription(String description);
}
