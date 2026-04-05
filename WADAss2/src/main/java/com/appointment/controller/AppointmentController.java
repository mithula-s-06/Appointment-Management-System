package com.appointment.controller;

import com.appointment.model.Appointment;
import com.appointment.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "add_appointment";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Appointment appointment) {
        service.save(appointment);
        return "redirect:/view";
    }

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("list", service.getAll());
        return "view_appointments";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/view";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("appointment", service.getById(id));
        return "update_appointment";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {

        if (name == null || name.trim().isEmpty()) {
            return "redirect:/";
        }

        model.addAttribute("list", service.search(name));
        return "view_appointments";
    }
}