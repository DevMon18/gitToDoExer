package classes;

import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    private static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printWelcomeBanner();
        
        while (true) {
            printMenu();
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addNewTask(scanner);
                        break;
                    case 2:
                        taskManager.viewTasks();
                        break;
                    case 3:
                        completeTask(scanner);
                        break;
                    case 4:
                        printExitBanner();
                        scanner.close();
                        return;
                    default:
                        taskManager.printErrorBox("Invalid option! Please choose 1-4.");
                }
            } catch (InputMismatchException e) {
                taskManager.printErrorBox("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void printWelcomeBanner() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                               ║");
        System.out.println("║           📋  WELCOME TO TO-DO LIST MANAGER  📋               ║");
        System.out.println("║                                                               ║");
        System.out.println("║              Organize Your Tasks Efficiently!                 ║");
        System.out.println("║                                                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
    }

    private static void printMenu() {
        System.out.println("\n┌───────────────────────────────────────────────────────────────┐");
        System.out.println("│                         MAIN MENU                             │");
        System.out.println("├───────────────────────────────────────────────────────────────┤");
        System.out.println("│  1. ➕ Add a new task                                         │");
        System.out.println("│  2. 📋 View all tasks                                         │");
        System.out.println("│  3. ✓  Mark a task as completed                               │");
        System.out.println("│  4. 🚪 Exit                                                    │");
        System.out.println("└───────────────────────────────────────────────────────────────┘");
        System.out.print("Choose an option [1-4]: ");
    }

    private static void printExitBanner() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                               ║");
        System.out.println("║                    👋 GOODBYE! 👋                             ║");
        System.out.println("║                                                               ║");
        System.out.println("║              Thank you for using To-Do List Manager!          ║");
        System.out.println("║                    See you next time!                         ║");
        System.out.println("║                                                               ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
    }

    private static void addNewTask(Scanner scanner) {
        System.out.println("\n┌───────────────────────────────────────────────────────────────┐");
        System.out.println("│                      ADD NEW TASK                             │");
        System.out.println("└───────────────────────────────────────────────────────────────┘");
        
        System.out.print("📝 Enter task description: ");
        String description = scanner.nextLine().trim();
        
        if (description.isEmpty()) {
            taskManager.printErrorBox("Task description cannot be empty!");
            return;
        }
        
        System.out.print("📅 Enter task deadline (YYYY-MM-DD): ");
        String deadline = scanner.nextLine().trim();

        System.out.print("⚡ Enter task priority (Low, Medium, High): ");
        String priority = scanner.nextLine().trim();
        
        if (priority.isEmpty()) {
            priority = "Medium"; // Default priority
        }

        Task task = new Task(description, deadline, priority);
        
        if (task.getDeadline() == null && !deadline.isEmpty()) {
            taskManager.printErrorBox("Task added but deadline format was invalid!");
        } else {
            taskManager.addTask(task);
            taskManager.printSuccessBox("Task added successfully! ID: " + task.getId());
        }
    }

    private static void completeTask(Scanner scanner) {
        System.out.println("\n┌───────────────────────────────────────────────────────────────┐");
        System.out.println("│                   MARK TASK AS COMPLETED                      │");
        System.out.println("└───────────────────────────────────────────────────────────────┘");
        
        System.out.print("🔢 Enter task ID to mark as completed: ");
        
        try {
            int taskId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (taskManager.markTaskAsCompleted(taskId)) {
                taskManager.printSuccessBox("Task #" + taskId + " marked as completed!");
            } else {
                taskManager.printErrorBox("Task #" + taskId + " not found!");
            }
        } catch (InputMismatchException e) {
            taskManager.printErrorBox("Invalid ID! Please enter a number.");
            scanner.nextLine(); // Clear invalid input
        }
    }
}