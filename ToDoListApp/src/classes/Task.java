package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Task {
    private static int idCounter = 1;
    private int id;
    private String description;
    private LocalDate deadline;  /** Changed to LocalDate for better date handling */
    private boolean isCompleted;
    private String priority; // New attribute for task priority
    

    public Task(String description, String deadline, String priority) {
        this.id = idCounter++;
        this.description = description;
        setDeadline(deadline);  /** Changed to LocalDate for better date handling */
        this.priority = priority; // Set priority
        this.isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getPriority() {
        return priority; // Getter for priority
    }


    public void markAsCompleted() {
        this.isCompleted = true;
        System.out.println("Task ID " + id + " marked as completed."); // Log completion
    }

    /** Method to set the deadline with validation */
    public void setDeadline(String deadline) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.deadline = LocalDate.parse(deadline, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use 'yyyy-MM-dd'.");
            this.deadline = null; // or set to a default date if necessary
        }
    }


    @Override
    public String toString() {
        return "Task ID: " + id +
               ", Description: " + description +
               ", Deadline: " + deadline +
               ", Completed: " + (isCompleted ? "Yes" : "No") + // Modified to accommodate LocalDate
               ", Priority: " + priority; // Include priority in toString;
    }
}