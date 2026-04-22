/* Marek Lubecki
 * CS320-SNHU
 * Module 5 Milestone 3 
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

public class AppointmentTest {
    
    // Helper method to consistently generate a valid date in the future
    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1); // Add 1 month to current date
        return calendar.getTime();
    }

    // Helper method to consistently generate an invalid date in the past
    private Date getPastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1); // Subtract 1 month from current date
        return calendar.getTime();
    }

    @Test
    void testAppointmentCreationSuccess() { // Test successful appointment creation
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("1234567890", futureDate, "This is a test description.");
        
        assertEquals("1234567890", appointment.getAppointmentID());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("This is a test description.", appointment.getAppointmentDescription());
    }

    @Test
    void testAppointmentIdTooLong() { // Test for appointment ID longer than 10 characters
        Date futureDate = getFutureDate();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "This is a test description.");
        });
    }

    @Test
    void testAppointmentIdNull() { // Test for null appointment ID
        Date futureDate = getFutureDate();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "This is a test description.");
        });
    }

    @Test
    void testAppointmentDatePast() { // Test for appointment date in the past
        Date pastDate = getPastDate();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", pastDate, "This is a test description.");
        });
    }

    @Test
    void testAppointmentDateNull() { // Test for null appointment date
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", null, "This is a test description.");
        });
    }

    @Test
    void testAppointmentDescriptionTooLong() { // Test for description longer than 50 characters
        Date futureDate = getFutureDate();
        assertThrows(IllegalArgumentException.class, () -> {
            // This string is 85 characters long
            new Appointment("12345", futureDate, "This description is definitely way too long to be accepted because it exceeds fifty characters.");
        });
    }

    @Test
    void testAppointmentDescriptionNull() { // Test for null description
        Date futureDate = getFutureDate();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);
        });
    }
}