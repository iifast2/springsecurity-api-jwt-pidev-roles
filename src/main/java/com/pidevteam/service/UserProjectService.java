package com.pidevteam.service;



import com.pidevteam.entity.UserProject;
import com.pidevteam.entity.UserProjectId;
import com.pidevteam.repository.UserProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProjectService {
    private final UserProjectRepository userProjectRepository;

    public UserProjectService(UserProjectRepository userProjectRepository) {
        this.userProjectRepository = userProjectRepository;
    }

    public List<UserProject> findAll() {
        return userProjectRepository.findAll();
    }

    public UserProject save(UserProject userProject) {
        return userProjectRepository.save(userProject);
    }

   public UserProject findById(UserProjectId id ) {
        return userProjectRepository.getOne(id);
    }
    public  void deleteById(UserProjectId id){userProjectRepository.deleteById(id);}
}
