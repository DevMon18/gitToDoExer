package classes;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
    
    // Function to remove task by index
    public void deleteTask(int index) {
        tasks.remove(index);
    }

    // Method to remove all tasks  
    public void clearTaskList() {
        tasks.clear();
    }
// Method to view all tasks
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
// Method to mark a task as completed by its ID
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