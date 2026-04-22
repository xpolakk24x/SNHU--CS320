/* Marek Lubecki
 * CS320-SNHU
 * Module 4 Milestone 2
 */
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    // Using a HashMap to store tasks with taskId as the key
    private final Map<String, Task> tasks = new HashMap<>(); 

    public void addTask(Task task) { // Add a new task to the service
        if (task == null || tasks.containsKey(task.getTaskId())) { // Check if the task is null or if the task ID already exists
            throw new IllegalArgumentException("Task invalid or ID already exists");
        }
        tasks.put(task.getTaskId(), task); // Add the task to the HashMap
    }

    public void deleteTask(String taskId) { // Delete a task from the service using the task ID
        if (!tasks.containsKey(taskId)) { // Check if the task ID exists in the HashMap
            throw new IllegalArgumentException("Task ID not found");
        }
        tasks.remove(taskId); // Remove the task from the HashMap
    }

    public void updateTask(String taskId, String name, String description) { // Update an existing task's information using the task ID
        Task task = tasks.get(taskId);
        if (task == null) { // Check if the task ID exists in the HashMap
            throw new IllegalArgumentException("Task ID not found");
        }
        
        // Update the task's information using the setter methods
        task.setName(name);
        task.setDescription(description);
    }
    
    // Method to retrieve a task by its ID
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}