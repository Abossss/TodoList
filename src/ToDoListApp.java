import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListApp extends JFrame {

    private TaskInputPanel taskInputPanel;
    private TaskListPanel taskListPanel;
    private JButton removeButton;

    public ToDoListApp() {

        setTitle("To-Do List");

        setSize(400, 600);

        this.setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("resources/icon.png")));

        JPanel mainPanel = new JPanel(new BorderLayout());

        taskListPanel = new TaskListPanel();
        taskInputPanel = new TaskInputPanel(taskListPanel);

        mainPanel.add(taskInputPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(taskListPanel.getTaskList());
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        removeButton = new JButton("删除选中任务");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskListPanel.removeSelectedTask();
            }
        });
        bottomPanel.add(removeButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoListApp();
    }
}
