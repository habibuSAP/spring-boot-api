package com.habibu.conferencedemo.controllers;

import com.habibu.conferencedemo.models.Workshop;
import com.habibu.conferencedemo.repositories.WorkshopRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workshops")
public class WorkshopController {

    @Autowired
    private WorkshopRespository workshopRespository;

    @GetMapping
    public List<Workshop> list(){
        return workshopRespository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Workshop get(@PathVariable Long id){
        return workshopRespository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Workshop create(@RequestBody final Workshop workshop){
        return workshopRespository.saveAndFlush(workshop);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Workshop update(@PathVariable Long id){
        Workshop existingWorkshop = workshopRespository.getOne(id);
        return workshopRespository.saveAndFlush(existingWorkshop);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        workshopRespository.deleteById(id);
    }



}
