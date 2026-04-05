package com.appointment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Appointment {

    @Id
    private int appointmentid;

    private String clientname;
    private String service;
    private String date;
    private String time;

    public int getAppointmentid() { return appointmentid; }
    public void setAppointmentid(int appointmentid) { this.appointmentid = appointmentid; }

    public String getClientname() { return clientname; }
    public void setClientname(String clientname) { this.clientname = clientname; }

    public String getService() { return service; }
    public void setService(String service) { this.service = service; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
}