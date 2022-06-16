package com.habibu.conferencedemo.controllers;

import com.habibu.conferencedemo.models.Tag;
import com.habibu.conferencedemo.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public List<Tag> list(){
        return tagRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Tag get(@PathVariable Long id) {
        return tagRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tag create(@RequestBody final Tag tag ) {
        return tagRepository.saveAndFlush(tag);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public  void delete(@PathVariable Long id){
         tagRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Tag update(@PathVariable Long id){
        Tag existingTag = tagRepository.getOne(id);
        return tagRepository.saveAndFlush(existingTag);
    }
}
