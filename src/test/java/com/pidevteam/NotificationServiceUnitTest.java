package com.pidevteam;

import com.pidevteam.entity.Notification;
import com.pidevteam.entity.User;
import com.pidevteam.repository.NotificationRepository;
import com.pidevteam.service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class NotificationServiceUnitTest {
    Notification notification;


    @InjectMocks
    NotificationService notificationService;

    @Mock
    NotificationRepository notificationRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        notification = new Notification();
        notification.setBody("Test");
        notification.setTitle("Title");
        notification.setLink("link1");
        notification.setViewed(true);
    }

    @Test
    void findAll() {assertNotNull(notificationService.findAll());}

    @Test
    void save() {
        when (notificationRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(notification));
        notificationRepository.save(notification);
        assertNotNull(notification.getBody());
        assertNotNull(notification.getTitle());
        assertNotNull(notification.getLink());



        Notification not = notificationService.findById(notification.getId());


        assertEquals(not.getBody(), notification.getBody());
        assertEquals(not.getTitle(), notification.getTitle());
        assertEquals(not.getLink(), notification.getLink());

    }

    @Test
    void update() {
        String newTitle= "Update Test";
        notification.setTitle(newTitle);

        when (notificationRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(notification));
        Notification not = notificationService.findById(notification.getId());


        assertEquals(not.getBody(), notification.getBody());
        assertEquals(not.getLink(), notification.getLink());
        assertEquals(not.getTitle(), notification.getTitle());
    }

    @Test
    void findById() {
        when (notificationRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(notification));
        Notification not = notificationService.findById(notification.getId());

        assertEquals(not.getBody(), notification.getBody());
        assertEquals(not.getTitle(), notification.getTitle());
        assertEquals(not.getLink(), notification.getLink());

    }

    @Test
    void deleteById() {
        long notificationId=42;

        notificationService.deleteById(notificationId);

        verify(notificationRepository, times(1)).deleteById(eq(notificationId));
    }

    @Test
    void findAllByUser() {
        assertNotNull(notificationRepository.findAllByUser(new User()));
    }
}