/* Marek Lubecki
 * CS320-SNHU
 * Module 4 Milestone 2
 */
public class Task {
    // Task class with fields for task ID, name, and description
    private final String taskId; // Final because the task ID shouldnt be updated
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {
        // Validation for Task ID (Required, max 10 chars, not null)
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID"); // Throw an exception if the task ID is invalid
        }
        // Validation for Name (Required, max 20 chars, not null)
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name"); // Throw an exception if the name is invalid
        }
        // Validation for Description (Required, max 50 chars, not null)
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description"); // Throw an exception if the description is invalid
        }

        this.taskId = taskId; // Set the task ID (final, so it cannot be changed later)
        this.name = name; // Set the name
        this.description = description; // Set the description
    }

    // Getters for all fields
    public String getTaskId() { return taskId; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    // Setters (No ID setter since it shouldnt be updated)
    public void setName(String name) { // Validate and set the name
        if (name == null || name.length() > 20) throw new IllegalArgumentException("Invalid name");
        this.name = name;
    }

    public void setDescription(String description) { // Validate and set the description
        if (description == null || description.length() > 50) throw new IllegalArgumentException("Invalid description");
        this.description = description;
    }
}