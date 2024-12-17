import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;

public class TaskListPanel extends JPanel {

    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private List<Task> tasks;
    private File taskFile;

    private int lastSelectedIndex = -1;
    public TaskListPanel() {
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskFile = new File("tasks.txt");  // 任务文件

        loadTasksFromFile();

        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setLayout(new BorderLayout());

        taskList.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        taskList.setBackground(new Color(255, 255, 255));
        taskList.setForeground(Color.BLACK);

        taskList.setVisibleRowCount(10);

        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int index = taskList.locationToIndex(e.getPoint());

                if (index >= 0 && index < tasks.size()) {
                    if (index == lastSelectedIndex) {
                        toggleTaskCompletion(index);
                    } else {
                        lastSelectedIndex = index;
                    }
                }
            }
        });

        taskList.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int index = taskList.getSelectedIndex();
                    if (index >= 0) {
                        toggleTaskCompletion(index);
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(taskList);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static class Task {
        String name;
        boolean completed;
        String priority;

        public Task(String name) {
            this.name = name;
            this.completed = false;
            this.priority = "低";
        }

        public String getName() {
            return name;
        }

        public void toggleCompleted() {
            completed = !completed;
        }

        public boolean isCompleted() {
            return completed;
        }

        public String getPriority() {
            return priority;
        }

        @Override
        public String toString() {
            if (completed) {
                return "<html><strike>" + name + "</strike> (已完成)</html>";
            } else {
                return name;
            }
        }
    }

    public void addTask(String task) {
        Task newTask = new Task(task);
        tasks.add(newTask);
        listModel.addElement(newTask.toString());
        saveTasksToFile();
    }

    public void removeSelectedTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            tasks.remove(selectedIndex);
            listModel.remove(selectedIndex);
            saveTasksToFile();

            if (tasks.size() > 0) {
                int newIndex = Math.min(selectedIndex, tasks.size() - 1);
                taskList.setSelectedIndex(newIndex);
                taskList.ensureIndexIsVisible(newIndex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "请选择要删除的任务！", "删除错误", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void toggleTaskCompletion(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.toggleCompleted();
            listModel.set(index, task.toString());

            saveTasksToFile();
        }
    }

    public void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFile))) {
            for (Task task : tasks) {
                writer.write(task.getName() + (task.isCompleted() ? " (已完成)" : ""));
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "保存任务失败！", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadTasksFromFile() {
        if (taskFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(taskFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // 将任务添加到任务列表
                    Task task = new Task(line.replace(" (已完成)", ""));
                    if (line.contains("(已完成)")) {
                        task.toggleCompleted();
                    }
                    tasks.add(task);
                    listModel.addElement(task.toString());
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "加载任务失败！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public JList<String> getTaskList() {
        return taskList;
    }
}

