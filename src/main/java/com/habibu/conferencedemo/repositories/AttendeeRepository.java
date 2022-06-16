package com.habibu.conferencedemo.repositories;

import com.habibu.conferencedemo.models.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}
