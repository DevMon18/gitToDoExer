# To-Do List Application - System Overview

## 📋 Application Description

The To-Do List Application is a Java-based console application designed to help users manage their daily tasks efficiently. This project serves as a practical learning tool for mastering Git version control while building a functional task management system.

---

## 🎯 Core Functionality

### Base Features
- **Task Creation** - Add new tasks with descriptions
- **Task Viewing** - Display all tasks in a formatted list
- **Task Management** - Mark tasks as complete or incomplete
- **User Interface** - Simple console-based menu system

### Enhanced Features (To Be Implemented)
- **Priority Levels** - Assign HIGH, MEDIUM, or LOW priority to tasks
- **Due Dates** - Set deadlines and track overdue items
- **Categories** - Organize tasks by type (Work, Personal, Shopping, etc.)
- **Task Editing** - Modify existing task details
- **Task Deletion** - Remove completed or unwanted tasks

---

## 🏗️ System Architecture

### Application Structure

```
ToDoListApp/
├── src/
│   ├── App.java       # Main application class
│   ├── Task.java           # Task entity class
│   ├── TaskManager.java    # Priority enum (HIGH, MEDIUM, LOW)
├── .gitignore              # Git ignore rules
└── README.md               # Project documentation
```

### Class Design

#### Task Class
Represents an individual task with the following attributes:
- `id` - Unique identifier
- `description` - Task description
- `completed` - Completion status
- `priority` - Task priority level
- `dueDate` - Optional deadline
- `category` - Task category/tag

#### ToDoList Class
Main application controller that handles:
- Task collection management
- User input processing
- Display formatting
- Menu navigation
- CRUD operations (Create, Read, Update, Delete)

---

## 🔄 Application Flow

```
Start Application
     ↓
Display Menu
     ↓
User Selects Option
     ↓
┌────────────────────────────────────┐
│ 1. Add Task                        │
│ 2. View All Tasks                  │
│ 3. Mark Task Complete              │
│ 4. Edit Task                       │
│ 5. Delete Task                     │
│ 6. View Tasks by Category          │
│ 7. View Overdue Tasks              │
│ 8. Exit                            │
└────────────────────────────────────┘
     ↓
Execute Selected Action
     ↓
Update Task List (if needed)
     ↓
Return to Menu
```

---

## 📊 Data Management

### In-Memory Storage
- Tasks stored in `ArrayList<Task>` during runtime
- No persistent storage in base version
- All data lost when application closes

## 🎓 Learning Objectives

This system is specifically designed to teach:

### Git Concepts
- Branch creation and management
- Feature-based development workflow
- Merge strategies and conflict resolution
- Stashing uncommitted changes
- Commit history visualization

### Java Development
- Object-oriented design principles
- Enum usage for constants
- Collection framework (ArrayList)
- Input validation and error handling
- Console I/O operations
---

## 🚀 Development Workflow

Each feature is developed following this pattern:

1. **Create Feature Branch** - Isolated development environment
2. **Implement Feature** - Add new functionality
3. **Test Locally** - Verify feature works correctly
4. **Commit Changes** - Save progress with meaningful messages
5. **Merge to Main** - Integrate feature into main codebase
6. **Resolve Conflicts** - Handle any merge conflicts
7. **Verify Integration** - Ensure all features work together

---
This is a console-based application - no GUI required
Focus is on Git learning through practical development
Application complexity intentionally kept moderate to emphasize version control
Each feature is designed to be independent for clear branching practice
Conflicts are intentionally created for learning purposes
