import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaskInputPanel extends JPanel {

    private JTextField taskInputField;
    private JButton addButton;
    private TaskListPanel taskListPanel;

    public TaskInputPanel(TaskListPanel taskListPanel) {
        this.taskListPanel = taskListPanel;
        setLayout(new BorderLayout());

        taskInputField = new JTextField(20);
        taskInputField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        taskInputField.setPreferredSize(new Dimension(250, 30));
        taskInputField.setMargin(new Insets(5, 5, 5, 5));

        addButton = new JButton("添加任务");
        addButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        addButton.addActionListener(e -> addTask());

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.CENTER);

        taskInputField.addActionListener(e -> addTask());
    }

    private void addTask() {
        String taskName = taskInputField.getText().trim();
        if (!taskName.isEmpty()) {
            taskListPanel.addTask(taskName);
            taskInputField.setText("");
            taskInputField.requestFocusInWindow();
        } else {
            JOptionPane.showMessageDialog(this, "任务不能为空！", "输入错误", JOptionPane.WARNING_MESSAGE);
        }
    }
}
