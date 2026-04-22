/* Marek Lubecki
 * CS320-SNHU
 * Module 4 Milestone
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    
    private TaskService service;

    // Initialize a new TaskService before each test to ensure a clean state
    @BeforeEach
    void setUp() {
        service = new TaskService();
    }

    @Test
    void testAddTaskSuccess() { // Test adding a task successfully
        Task task = new Task("12345", "Test Name", "Test description.");
        service.addTask(task);
        
        // Verify the task was actually added
        assertNotNull(service.getTask("12345"));
        assertEquals("Test Name", service.getTask("12345").getName());
    }

    @Test
    void testAddTaskDuplicateId() { // Test adding a task with a duplicate ID
        Task task1 = new Task("12345", "Test Name", "Test description.");
        Task task2 = new Task("12345", "Another Name", "Another description.");
        
        service.addTask(task1);
        
        // Trying to add another task with the same ID should throw an error
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }

    @Test
    void testDeleteTaskSuccess() { // Test deleting a task successfully
        Task task = new Task("12345", "Test Name", "Test description.");
        service.addTask(task);
        
        // Delete it
        service.deleteTask("12345");
        
        // Verify it was deleted
        assertNull(service.getTask("12345"));
    }

    @Test
    void testDeleteTaskNotFound() { // Test deleting a task that doesn't exist
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("99999");
        });
    }

    @Test
    void testUpdateTaskSuccess() { // Test updating a task successfully
        Task task = new Task("12345", "Test Name", "Test description.");
        service.addTask(task);
        
        // Update the fields
        service.updateTask("12345", "New Name", "New description.");
        
        // Verify the fields changed, but the ID stayed the same
        Task updatedTask = service.getTask("12345");
        assertEquals("New Name", updatedTask.getName());
        assertEquals("New description.", updatedTask.getDescription());
    }

    @Test
    void testUpdateTaskNotFound() { // Test updating a task that doesn't exist
        // Trying to update a task that doesn't exist should throw an error
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTask("99999", "New Name", "New description.");
        });
    }
}