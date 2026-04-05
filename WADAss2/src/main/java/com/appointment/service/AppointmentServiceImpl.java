package com.appointment.service;

import com.appointment.model.Appointment;
import com.appointment.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repo;

    public AppointmentServiceImpl(AppointmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Appointment save(Appointment appointment) {

        if (appointment.getAppointmentid() == 0) {

            List<Appointment> list = repo.findAll();
            int nextId = 1;

            if (!list.isEmpty()) {
                nextId = list.get(list.size() - 1).getAppointmentid() + 1;
            }

            appointment.setAppointmentid(nextId);
        }

        return repo.save(appointment);
    }

    @Override
    public List<Appointment> getAll() {
        return repo.findAll();
    }

    @Override
    public Appointment getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {

        if (!repo.existsById(id)) return;

        repo.deleteById(id);
        List<Appointment> list = repo.findAll();
        int i = 1;
        for (Appointment a : list) {
            a.setAppointmentid(i++);
        }
        repo.saveAll(list);
    }

    @Override
    public List<Appointment> search(String name) {
        return repo.findByClientnameContainingIgnoreCase(name);
    }
}