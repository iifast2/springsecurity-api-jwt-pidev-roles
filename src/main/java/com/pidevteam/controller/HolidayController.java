package com.pidevteam.controller;


import com.pidevteam.entity.Holiday;
import com.pidevteam.service.EmailService;
import com.pidevteam.service.HolidayService;
import com.pidevteam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class HolidayController {
    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @Autowired
    private UserService userService;
    @Autowired
    EmailService emailService;
    @Autowired
    ModelMapper modelMapper;
    @GetMapping(value = "/holidays")
    public List<Holiday> findAll() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_ADMIN")) ? holidayService.findAll(): userService.findOne(
                SecurityContextHolder.getContext().getAuthentication().getName())
                .getRequests()
                .stream().map(r ->(Holiday)r).collect(Collectors.toList());

    }

    @GetMapping(value = "/holidays/{id}")
    public Holiday getOne(@PathVariable(value = "id") Long id){
        return holidayService.findById(id);
    }

    @PostMapping(value="/holidays")
    public Holiday saveHoliday(@RequestBody Holiday holiday){
        holiday.setUser(userService.findOne(SecurityContextHolder.getContext().getAuthentication().getName()));
        return holidayService.save(holiday);
    }

    @DeleteMapping(value = "/holidays/{id}" )
    public void delete(@PathVariable(name = "id") Long id){
        holidayService.deleteById(id);
    }

    @PutMapping(value = "/holidays" )
    public Holiday update(@RequestBody Holiday holiday){
        return holidayService.update(holiday);
    }

    @PutMapping(value = "/holidays/validate" )
    public Holiday validate(@RequestBody Holiday holiday){
        holiday.setStatus(holiday.getStatus());
        if(holiday.getStatus() == -1) {
            new Thread(() -> {
                try {
                    emailService.sendMail(
                            holiday.getUser().getEmail(),
                            "You're holiday is accepted  ",
                        holiday.getStartDate());

                } catch (MessagingException ex) {
                    ex.printStackTrace();
                }
            }).start();
        }
        else if (holiday.getStatus() == 1 )
        {
            new Thread(() -> {
                try {
                    emailService.sendMail(
                            holiday.getUser().getEmail(),
                            "You're holiday is refused  ",
                        holiday.getRejectionReason() );

                } catch (MessagingException ex) {
                    ex.printStackTrace();
                }
            }).start();
        }
        return holidayService.update(holiday);
    }

    // For Test
    @GetMapping(value = "/holidays/enddate/{dt}")
    public Holiday findByEndDate(@PathVariable(value = "dt") String dt){
        return holidayService.findByEndDate(dt);
    }

}
