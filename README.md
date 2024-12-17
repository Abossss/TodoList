# 📋 **TodoList**

<div align="center">  

[简体中文](README_CN.md) / [繁体中文](README_TC.md) / English / [Deutsch](README_DE.md) / [日本語](README_JP.md)

</div>  

---

## 🌐 <span style="color: #2ecc71;">Project Overview</span> 💡

`TodoList` is a simple graphical to-do list management application built using Java Swing. It helps users conveniently add, view, manage, and mark tasks as completed. The application presents a task list through an intuitive interface, and supports local file storage of task data, allowing users to restore their previous task states upon restarting the application. 📅

---

## 🛠️ <span style="color: #9b59b6;">Project Structure</span> 📂

- **Root Directory**:
    - `.gitignore`: Specifies files or directories that should not be tracked by Git, preventing unnecessary files such as local configurations or compiled files from being committed to the repository. 🗑️
    - `tasks.txt`: A text file used to store to-do task data. The application loads task data from this file and updates it whenever tasks are modified (e.g., added, deleted, or status changed), ensuring persistence of task data across sessions. 📄
    - `TodoList.iml`: The IntelliJ IDEA project configuration file, storing settings related to project modules and dependencies to ensure proper IDE integration. 🖥️

- **`.idea` Directory**:  
  Contains IntelliJ IDEA-specific configuration files, such as `misc.xml`, `modules.xml`, `vcs.xml`, and `workspace.xml`, which manage personalized settings for project modules, version control integration, and workspace configurations. 🛠️

- **`out` Directory**:  
  Stores compiled output files, such as `.class` files. The `production` subdirectory contains a `TodoList` folder mirroring the project’s package structure, which includes the compiled bytecode files and associated resources (like icons). 🔧

- **`src` Directory**:  
  The source code directory, containing all Java class files that implement the project’s core functionality. The following key Java classes are included:
    - **`TaskInputPanel.java`**:
        - **Interface Components**: Contains a text input field (`taskInputField`) for users to enter task names, with customized font, size, and styles; also includes an "Add Task" button (`addButton`) to submit tasks. 📝
        - **Interaction Logic**: After entering a task name in the input field, users can click the "Add Task" button or press the Enter key to trigger the `addTask` method. ⏩
    - **`TaskListPanel.java`**:
        - **Member Variables and Initialization**: Maintains a `JList<String>` (`taskList`) to display tasks, a `DefaultListModel<String>` (`listModel`) as the data model for the list, a `List<Task>` for storing actual task objects, and a `File` (`taskFile`) pointing to the `tasks.txt` file. 📋
        - **Inner Class `Task`**: Defines the `Task` class to represent a task with properties like task name (`name`), completion status (`completed`), and priority (`priority`). 🎯
        - **Task Operations**:
            - `addTask`: Adds a new task from the `TaskInputPanel` to the `tasks` list and `listModel`. ➕
            - `removeSelectedTask`: Removes a selected task from the `tasks` list and `listModel`. 🗑️
            - `toggleTaskCompletion`: Toggles the completion status of a task. ✅
    - **`ToDoListApp.java`**:
        - **Interface Construction and Layout**: The constructor sets up the window, including setting the title to "To-Do List", specifying the window size, and centering it on the screen. 🏗️
        - **Entry Point**: The `main` method creates an instance of the `ToDoListApp` class to launch the application. 🚀

---

## 🛠️ <span style="color: #95a5a6;">How to Use</span>

1. **Launch the Application**: Run the `main` method in the `ToDoListApp` class. 🖱️
2. **Add a Task**: Type the task name in the input field at the top of the interface, then click the "Add Task" button or press Enter. ✍️
3. **View Tasks**: See all the tasks you've added in the task list. 👀
4. **Mark a Task as Completed**: Click on a task in the list or select it and press Enter to toggle its completion status. ✅
5. **Delete a Task**: Select the task you want to delete from the list, then click the "Delete Selected Task" button at the bottom of the interface. ❌

---

## ⚠️ <span style="color: #f1c40f;">Important Notes</span>

1. **Data Storage**:
    - This project relies on the `tasks.txt` file to store task data. Do not delete or modify the file format, as it may cause issues with loading or saving task data, affecting the application’s functionality. 💾

2. **Error Handling**:
    - The current error handling for file read/write operations mainly uses popup messages to inform users when an operation fails. In more complex scenarios, further improvements in error handling (such as detailed error logging) may be needed. 📉

---

We hope this `README` helps you! You can customize or expand the content based on your project’s actual usage scenario to make it easier for other users to understand and use the `TodoList` project. 😊

