/* Marek Lubecki
 * CS320-SNHU
 * Module 5 Milestone 3
 */

import java.util.Date;

public class Appointment {
    // Appointment class with fields for ID, date, and description
    private final String appointmentID; // Final because the appointment ID shouldn't be updated
    private Date appointmentDate;
    private String appointmentDescription;
	
    public Appointment(String appointmentID, Date appointmentDate, String appointmentDescription) {
        // Validation for Appointment ID (Required, max 10 chars, not null)
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        // Validation for Appointment Date (Required, cannot be in the past, not null)
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        // Validation for Description (Required, max 50 chars, not null)
        if (appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.appointmentID = appointmentID; // Set the appointment ID
        this.appointmentDate = appointmentDate; // Set the date
        this.appointmentDescription = appointmentDescription; // Set the description
    }

    // Getters for all fields
    public String getAppointmentID() { return appointmentID; }
    public Date getAppointmentDate() { return appointmentDate; }
    public String getAppointmentDescription() { return appointmentDescription; }

    // Setters 
    public void setAppointmentDate(Date appointmentDate) { // Validate and set the date
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentDescription(String appointmentDescription) { // Validate and set the description
        if (appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.appointmentDescription = appointmentDescription;
    }
}
