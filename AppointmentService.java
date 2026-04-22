/* Marek Lubecki
 * CS320-SNHU
 * Module 5 Milestone 3
 */

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    // Using a HashMap to store appointments with appointmentID as the key
    private final Map<String, Appointment> appointments = new HashMap<>(); 

    public void addAppointment(Appointment appointment) { // Add a new appointment to the service
        if (appointment == null || appointments.containsKey(appointment.getAppointmentID())) { // Check for null or duplicate ID
            throw new IllegalArgumentException("Appointment invalid or ID already exists");
        }
        appointments.put(appointment.getAppointmentID(), appointment); // Add the appointment to the HashMap
    }

    public void deleteAppointment(String appointmentID) { // Delete an appointment from the service using the ID
        if (!appointments.containsKey(appointmentID)) { // Check if the appointment ID exists
            throw new IllegalArgumentException("Appointment ID not found");
        }
        appointments.remove(appointmentID); // Remove the appointment
    }

     
    public void updateAppointment(String appointmentID, Date appointmentDate, String appointmentDescription) { 
        Appointment appointment = appointments.get(appointmentID);
        if (appointment == null) { // Check if the appointment ID exists
            throw new IllegalArgumentException("Appointment ID not found");
        }
        
        // Update the appointment's information using the setter methods
        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentDescription(appointmentDescription);
    }
    
    
    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }
}