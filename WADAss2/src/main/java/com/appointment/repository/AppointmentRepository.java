package com.appointment.repository;

import com.appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByClientnameContainingIgnoreCase(String name);
}