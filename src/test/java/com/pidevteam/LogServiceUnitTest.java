package com.pidevteam;

import com.pidevteam.repository.LogRepository;
import com.pidevteam.service.LogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LogServiceUnitTest {

    @InjectMocks
    LogService logService;

    @Mock
    LogRepository logRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll() {
        assertNotNull(logService.findAll());
    }
}