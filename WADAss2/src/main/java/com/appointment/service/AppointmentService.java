package com.appointment.service;

import com.appointment.model.Appointment;
import java.util.List;

public interface AppointmentService {

    Appointment save(Appointment appointment);

    List<Appointment> getAll();

    Appointment getById(int id);

    void delete(int id);

    List<Appointment> search(String name);
}
