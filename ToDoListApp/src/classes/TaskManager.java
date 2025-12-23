package classes;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            printBox("No tasks available.");
        } else {
            printTasksTable();
        }
    }

    private void printTasksTable() {
        System.out.println("\n" + "═".repeat(120));
        System.out.println("║" + centerText("YOUR TASKS", 118) + "║");
        System.out.println("═".repeat(120));
        
        // Header
        System.out.printf("║ %-4s │ %-8s │ %-35s │ %-12s │ %-10s │ %-15s ║%n", 
            "ID", "Status", "Description", "Deadline", "Priority", "Overdue");
        System.out.println("║" + "─".repeat(118) + "║");
        
        // Task rows
        for (Task task : tasks) {
            String status = task.isCompleted() ? "✓ Done" : "○ Pending";
            String description = truncate(task.getDescription(), 35);
            String deadline = task.getDeadline() != null ? task.getDeadline().toString() : "No deadline";
            String priority = getPriorityWithSymbol(task.getPriority());
            String overdue = isOverdue(task) ? "⚠ YES" : "No";
            
            System.out.printf("║ %-4d │ %-8s │ %-35s │ %-12s │ %-10s │ %-15s ║%n",
                task.getId(), status, description, deadline, priority, overdue);
        }
        
        System.out.println("═".repeat(120));
        System.out.println("║ Total Tasks: " + tasks.size() + 
                         " │ Completed: " + getCompletedCount() + 
                         " │ Pending: " + getPendingCount() + 
                         " │ Overdue: " + getOverdueCount() + 
                         " ".repeat(Math.max(0, 67 - String.valueOf(tasks.size()).length() - 
                                            String.valueOf(getCompletedCount()).length() - 
                                            String.valueOf(getPendingCount()).length() - 
                                            String.valueOf(getOverdueCount()).length())) + "║");
        System.out.println("═".repeat(120) + "\n");
    }

    private String getPriorityWithSymbol(String priority) {
        if (priority == null) return "N/A";
        String upperPriority = priority.toUpperCase();
        switch (upperPriority) {
            case "HIGH":
                return "🔴 HIGH";
            case "MEDIUM":
                return "🟡 MEDIUM";
            case "LOW":
                return "🟢 LOW";
            default:
                return priority;
        }
    }

    private boolean isOverdue(Task task) {
        if (task.getDeadline() == null || task.isCompleted()) {
            return false;
        }
        return task.getDeadline().isBefore(LocalDate.now());
    }

    private int getCompletedCount() {
        return (int) tasks.stream().filter(Task::isCompleted).count();
    }

    private int getPendingCount() {
        return (int) tasks.stream().filter(t -> !t.isCompleted()).count();
    }

    private int getOverdueCount() {
        return (int) tasks.stream().filter(this::isOverdue).count();
    }

    private String truncate(String text, int maxLength) {
        if (text == null) return "";
        return text.length() > maxLength ? text.substring(0, maxLength - 3) + "..." : text;
    }

    private String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text + " ".repeat(Math.max(0, width - text.length() - padding));
    }

    public void printBox(String message) {
        int width = Math.max(message.length() + 4, 40);
        System.out.println("\n┌" + "─".repeat(width) + "┐");
        System.out.println("│ " + message + " ".repeat(width - message.length() - 1) + "│");
        System.out.println("└" + "─".repeat(width) + "┘\n");
    }

    public void printSuccessBox(String message) {
        int width = Math.max(message.length() + 6, 40);
        System.out.println("\n╔" + "═".repeat(width) + "╗");
        System.out.println("║ ✓ " + message + " ".repeat(width - message.length() - 3) + "║");
        System.out.println("╚" + "═".repeat(width) + "╝\n");
    }

    public void printErrorBox(String message) {
        int width = Math.max(message.length() + 6, 40);
        System.out.println("\n╔" + "═".repeat(width) + "╗");
        System.out.println("║ ✗ " + message + " ".repeat(width - message.length() - 3) + "║");
        System.out.println("╚" + "═".repeat(width) + "╝\n");
    }

    public boolean markTaskAsCompleted(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.markAsCompleted();
                return true;
            }
        }
        return false;
    }
}