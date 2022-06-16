package com.habibu.conferencedemo.controllers;


import com.habibu.conferencedemo.models.Attendee;
import com.habibu.conferencedemo.repositories.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {

    @Autowired
    private AttendeeRepository attendeeRepository;

    @GetMapping
    public List<Attendee> list(){
        return attendeeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Attendee get(@PathVariable Long id){
        return attendeeRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Attendee create(@RequestBody final Attendee attendee){
        return attendeeRepository.saveAndFlush(attendee);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        attendeeRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Attendee update(@PathVariable Long id){
        Attendee existingAttendee = attendeeRepository.getOne(id);
        return attendeeRepository.saveAndFlush(existingAttendee);
    }
}
