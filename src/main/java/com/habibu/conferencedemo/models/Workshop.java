package com.habibu.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "workshops")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workshop_id;
    private String workshop_name;
    private String description;
    private String requirements;
    private String room;
    private Integer capacity;

    @ManyToMany
    @JoinTable(name = "workshop_registrations",
            joinColumns = @JoinColumn(name = "workshop_id"),
            inverseJoinColumns = @JoinColumn(name = "attendee_ticket_id"))
    private List<Attendee> attendees;

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }

    public Long getWorkshop_id() {
        return workshop_id;
    }

    public void setWorkshop_id(Long workshop_id) {
        this.workshop_id = workshop_id;
    }

    public String getWorkshop_name() {
        return workshop_name;
    }

    public void setWorkshop_name(String workshop_name) {
        this.workshop_name = workshop_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
