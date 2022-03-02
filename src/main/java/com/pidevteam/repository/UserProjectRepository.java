package com.pidevteam.repository;

import com.pidevteam.entity.UserProject;
import com.pidevteam.entity.UserProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProjectRepository extends JpaRepository<UserProject,UserProjectId> {

   /* @Modifying
    @Transactional
    @Query(value = "insert into user_project values(:ismanager,:uid, :pid)", nativeQuery = true)
    void saveUP(@Param("uid") Long uid, @Param("pid") Long pid, @Param("ismanager") boolean ismanager );
*/
    @Query(value = "select * from user_project where project_id = :id ;", nativeQuery = true)
    List<UserProject> findAllByProjectId( @Param("id") Long id);
}
