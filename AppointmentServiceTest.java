/* Marek Lubecki
 * CS320-SNHU
 * Module 5 Milestone
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

public class AppointmentServiceTest {
    
    private AppointmentService service;

    // Helper method to consistently generate a valid date in the future
    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1); // Add 1 month to current date
        return calendar.getTime();
    }

    // Initialize a new AppointmentService before each test to ensure a clean state
    @BeforeEach
    void setUp() {
        service = new AppointmentService();
    }

    @Test
    void testAddAppointmentSuccess() { // Test adding an appointment successfully
        Appointment appointment = new Appointment("12345", getFutureDate(), "Test description.");
        service.addAppointment(appointment);
        
        // Verify the appointment was actually added
        assertNotNull(service.getAppointment("12345"));
        assertEquals("Test description.", service.getAppointment("12345").getAppointmentDescription());
    }

    @Test
    void testAddAppointmentDuplicateId() { // Test adding an appointment with a duplicate ID
        Appointment appointment1 = new Appointment("12345", getFutureDate(), "Test description 1.");
        Appointment appointment2 = new Appointment("12345", getFutureDate(), "Test description 2.");
        
        service.addAppointment(appointment1);
        
        // Trying to add another appointment with the same ID should throw an error
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment2);
        });
    }

    @Test
    void testDeleteAppointmentSuccess() { // Test deleting an appointment successfully
        Appointment appointment = new Appointment("12345", getFutureDate(), "Test description.");
        service.addAppointment(appointment);
        
        // Delete it
        service.deleteAppointment("12345");
        
        // Verify it was deleted
        assertNull(service.getAppointment("12345"));
    }

    @Test
    void testDeleteAppointmentNotFound() { // Test deleting an appointment that doesn't exist
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("99999");
        });
    }

    @Test
    void testUpdateAppointmentSuccess() { // Test updating an appointment successfully
        Appointment appointment = new Appointment("12345", getFutureDate(), "Test description.");
        service.addAppointment(appointment);
        
        // Generate a slightly different future date to test the update
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 2); 
        Date newDate = calendar.getTime();
        
        // Update the fields
        service.updateAppointment("12345", newDate, "New description.");
        
        // Verify the fields changed
        Appointment updatedAppointment = service.getAppointment("12345");
        assertEquals("New description.", updatedAppointment.getAppointmentDescription());
        assertEquals(newDate, updatedAppointment.getAppointmentDate());
    }

    @Test
    void testUpdateAppointmentNotFound() { // Test updating an appointment that doesn't exist
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAppointment("99999", getFutureDate(), "New description.");
        });
    }
}