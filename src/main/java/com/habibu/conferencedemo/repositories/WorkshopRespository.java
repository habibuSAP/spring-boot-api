package com.habibu.conferencedemo.repositories;

import com.habibu.conferencedemo.models.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRespository extends JpaRepository<Workshop, Long> {
}
