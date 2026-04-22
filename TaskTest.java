/* Marek Lubecki
 * CS320-SNHU
 * Module 4 Milestone
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    void testTaskCreationSuccess() { // Test successful task creation
        Task task = new Task("1234567890", "Test Name", "This is a test description.");
        assertEquals("1234567890", task.getTaskId());
        assertEquals("Test Name", task.getName());
        assertEquals("This is a test description.", task.getDescription());
    }

    @Test
    void testTaskIdTooLong() { // Test for task ID longer than 10 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Test Name", "This is a test description.");
        });
    }

    @Test
    void testTaskIdNull() { // Test for null task ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Test Name", "This is a test description.");
        });
    }

    @Test
    void testNameTooLong() { // Test for name longer than 20 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "ThisNameIsWayTooLong1", "This is a test description.");
        });
    }

    @Test
    void testNameNull() { // Test for null name
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "This is a test description.");
        });
    }

    @Test
    void testDescriptionTooLong() { // Test for description longer than 50 characters
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Test Name", "This description is definitely way too long to be accepted because it exceeds fifty characters.");
        });
    }

    @Test
    void testDescriptionNull() { // Test for null description
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Test Name", null);
        });
    }
}