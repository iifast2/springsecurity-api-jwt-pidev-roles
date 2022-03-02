package com.pidevteam;

import com.pidevteam.controller.UserController;
import com.pidevteam.entity.User;
import com.pidevteam.entity.dto.UserDto;
import com.pidevteam.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

class UserControllerUnitTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserServiceImpl userService;

    User user;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setUsername("We Code");
        user.setPassword("123456");
        user.setBirthdate("1998-01-20");
        user.setSalary(1000);
        user.setCin("15009308");
        user.setEmail("karim@gmail.com");
        user.setLeaveBalance(0L);
        user.setFirstName("Karim");
        user.setLastName("Mannai");
        user.setFacebook("Facebook");
        user.setInstagram("Instagram");
        user.setLinkedin("LinkedIn");


        assertNotNull(user.getUsername());
        assertNotNull(user.getPassword());
        assertNotNull(user.getBirthdate());
        assertNotNull(user.getCin());
        assertNotNull(user.getEmail());
        assertNotNull(user.getFacebook());
        assertNotNull(user.getLastName());
        assertNotNull(user.getFacebook());
        assertNotNull(user.getInstagram());
        assertNotNull(user.getLinkedin());

        assert user.getUsername().length() >=3 : "Username Length Should Be At Least 3!";
        assert user.getPassword().length() >=6 : "Password Length Should Be At Least 3!";
    }


    @Test
    void listUser() {
        List<User> list = userController.listUser();
        assertNotNull(list);
    }

    @Test
    void getOne() {
        when(userService.findById(anyLong())).thenReturn(user);
        User us = userController.getOne(user.getId());
        assertNotNull(us);
        assertNotNull(us);

        asserts(us, user);

    }

    @Test
    void saveUser() {
        when (userService.findById(anyLong())).thenReturn(user);
        UserDto userDto = new UserDto();
        userDto.setBirthdate(user.getBirthdate());
        userDto.setPassword(user.getPassword());
        userDto.setSalary((int) user.getSalary());
        userDto.setUsername(user.getUsername());
        userService.save(userDto);

        assertNotNull(user.getId());


        User us = userController.getOne(user.getId());

        assertNotNull(us);

        asserts(us, user);
    }

    private void asserts(User us, User user) {
        assertNotNull(us);
        assertEquals(us.getPassword(), user.getPassword());
        assertEquals(us.getBirthdate(), user.getBirthdate());
        assertEquals(us.getSalary(), user.getSalary());
        assertEquals(us.getUsername(), user.getUsername());
        assertEquals(us.getRoles(), user.getRoles());
        assertEquals(us.getAddress(), user.getAddress());
        assertEquals(us.getCin(), user.getCin());
        assertEquals(us.getEmail(), user.getEmail());
        assertEquals(us.getLeaveBalance(), user.getLeaveBalance());
        assertEquals(us.getFacebook(), user.getFacebook());
        assertEquals(us.getInstagram(), user.getInstagram());
        assertEquals(us.getLinkedin(), user.getLinkedin());
        assertEquals(us.getFirstName(), user.getFirstName());
        assertEquals(us.getLastName(), user.getLastName());

        assert user.getUsername().length() >=3 : "Username Length Should Be At Least 3!";
        assert us.getPassword().length() >=6 : "Password Length Should Be At Least 3!";

    }


}
