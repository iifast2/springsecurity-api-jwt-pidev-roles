package com.pidevteam;

import com.pidevteam.controller.UserProjectController;
import com.pidevteam.entity.Project;
import com.pidevteam.entity.User;
import com.pidevteam.entity.UserProject;
import com.pidevteam.entity.UserProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserProjectControllerIntegrationTest {

    String url = "http://localhost:8091";
    String authAdmin= "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEZWdsYSIsInNjb3BlcyI6IlJPTEVfQURNSU4iLCJpYXQiOjE1NzU4NDAxMTAsImV4cCI6MTU3NTkyNjUxMH0.WkOZzCdIahFXZJPU-tqwcdLzS65a-Szzh83JcgOY5Ow";
    String authNoadmin= "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3aWVtIiwic2NvcGVzIjoiUk9MRV9BRE1JTiIsImlhdCI6MTU3NTg0MDA3NywiZXhwIjoxNTc1OTI2NDc3fQ.gtI6g8V95oHhWwCgg7GBYUHq3l_jsOQQS3ZeUqNgqXQ";


    @Mock
    UserProjectController userProjectController;

    HttpHeaders headersAdmin = new HttpHeaders();
    HttpHeaders headersNoAdmin = new HttpHeaders();
    HttpHeaders headersNoAuth = new HttpHeaders();

    TestRestTemplate restTemplate = new TestRestTemplate();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        headersAdmin.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headersAdmin.add("Authorization", "Bearer " + authAdmin);

        headersNoAdmin.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headersNoAdmin.add("Authorization", "Bearer " + authNoadmin);
    }


    @Test
    void saveProject() {

        // For Admin Test
        UserProject userProjectAdmin = new UserProject();
        UserProjectId userProjectIdAdmin = new UserProjectId();

        ResponseEntity<User> userAdmin = restTemplate.exchange(
                url + "/users/3", HttpMethod.GET, new HttpEntity<User>(null, headersAdmin), User.class);


        HttpEntity<Project> projectAdmin = restTemplate.exchange(
                url+"/projects/20", HttpMethod.GET, new HttpEntity<Project>(null, headersAdmin), Project.class);

        userProjectIdAdmin.setUser(userAdmin.getBody());
        userProjectIdAdmin.setProject(projectAdmin.getBody());

        userProjectAdmin.setPrimaryKey(userProjectIdAdmin);
        userProjectAdmin.setManager(true);





        HttpEntity<UserProject> entityAdmin = new HttpEntity<UserProject>(userProjectAdmin, headersAdmin);
        ResponseEntity<String> resAdmin = restTemplate.postForEntity(url+"/userprojects", entityAdmin, String.class);
        assertNotNull(resAdmin.getBody());





        // For No Admin Test
        UserProject userProjectNoAdmin = new UserProject();
        UserProjectId userProjectIdNoAdmin = new UserProjectId();

        ResponseEntity<User> userNoAdmin = restTemplate.exchange(
                url + "/users/2", HttpMethod.GET, new HttpEntity<User>(null, headersNoAdmin), User.class);


        HttpEntity<Project> projectNoAdmin = restTemplate.exchange(
                url+"/projects/21", HttpMethod.GET, new HttpEntity<Project>(null, headersNoAdmin), Project.class);

        userProjectIdNoAdmin.setUser(userNoAdmin.getBody());
        userProjectIdNoAdmin.setProject(projectNoAdmin.getBody());

        userProjectNoAdmin.setPrimaryKey(userProjectIdNoAdmin);
        userProjectNoAdmin.setManager(false);





        HttpEntity<UserProject> entityNoAdmin = new HttpEntity<UserProject>(userProjectNoAdmin, headersNoAdmin);
        ResponseEntity<String> resNoAdmin = restTemplate.postForEntity(url+"/userprojects", entityNoAdmin, String.class);
        assertNotNull(resNoAdmin.getBody());

        // For No Auth Test

        HttpEntity<Project> projectNoAuth = restTemplate.exchange(
                url+"/projects/15", HttpMethod.GET, new HttpEntity<Project>(null, headersNoAdmin), Project.class);

        userProjectIdNoAdmin.setProject(projectNoAuth.getBody());

        HttpEntity<UserProject> entityNoAuth = new HttpEntity<UserProject>(userProjectAdmin, headersNoAuth);

        ResponseEntity<String> resNoAuth = restTemplate.postForEntity(url+"/userprojects", entityNoAdmin, String.class);

        assertNotNull(resNoAdmin.getBody());
    }
}