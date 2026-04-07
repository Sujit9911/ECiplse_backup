package dbmsminiproject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentManagementApp extends JFrame {
    private JTextField txtName, txtEmail, txtPhone, txtCourse;
    private JTable table;
    private DefaultTableModel tableModel;

    public StudentManagementApp() {
        setTitle("🎓 Student Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ---------- THEME COLORS ----------
        Color bgColor = new Color(245, 247, 250);
        Color accentColor = new Color(52, 152, 219);
        Color buttonHover = new Color(41, 128, 185);
        Color headerColor = new Color(236, 240, 241);

        // ---------- HEADER PANEL ----------
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(accentColor);
        JLabel title = new JLabel("Student Management System", JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setBorder(new EmptyBorder(10, 0, 10, 0));
        headerPanel.add(title, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // ---------- INPUT PANEL ----------
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 15, 15));
        inputPanel.setBackground(bgColor);
        inputPanel.setBorder(new EmptyBorder(20, 50, 20, 50));

        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 15);

        inputPanel.add(createLabel("Name:", labelFont));
        txtName = createTextField(fieldFont);
        inputPanel.add(txtName);

        inputPanel.add(createLabel("Email:", labelFont));
        txtEmail = createTextField(fieldFont);
        inputPanel.add(txtEmail);

        inputPanel.add(createLabel("Phone:", labelFont));
        txtPhone = createTextField(fieldFont);
        inputPanel.add(txtPhone);

        inputPanel.add(createLabel("Course:", labelFont));
        txtCourse = createTextField(fieldFont);
        inputPanel.add(txtCourse);

        // ---------- BUTTONS ----------
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(bgColor);

        JButton btnAdd = createStyledButton("Add Student", accentColor, buttonHover);
        JButton btnView = createStyledButton("View All", accentColor, buttonHover);
        JButton btnClear = createStyledButton("Clear", accentColor, buttonHover);

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnView);
        buttonPanel.add(btnClear);

        inputPanel.add(new JLabel()); // Empty cell
        inputPanel.add(buttonPanel);

        add(inputPanel, BorderLayout.WEST);

        // ---------- TABLE ----------
        String[] columns = {"ID", "Name", "Email", "Phone", "Course"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setRowHeight(25);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        table.getTableHeader().setBackground(headerColor);
        table.getTableHeader().setReorderingAllowed(false);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setSelectionBackground(new Color(174, 214, 241));
        table.setSelectionForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Student Records"));
        add(scrollPane, BorderLayout.CENTER);

        // ---------- BUTTON ACTIONS ----------
        btnAdd.addActionListener(e -> addStudent());
        btnView.addActionListener(e -> viewAllStudents());
        btnClear.addActionListener(e -> clearFields());

        viewAllStudents();
        setVisible(true);
    }

    // ---------- HELPER METHODS ----------
    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private JTextField createTextField(Font font) {
        JTextField field = new JTextField();
        field.setFont(font);
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        return field;
    }

    private JButton createStyledButton(String text, Color color, Color hoverColor) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
            }
        });

        return button;
    }

    private void addStudent() {
        String name = txtName.getText().trim();
        String email = txtEmail.getText().trim();
        String phone = txtPhone.getText().trim();
        String course = txtCourse.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name is required!");
            return;
        }

        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO students (name, email, phone, course) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, phone);
            pst.setString(4, course);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "✅ Student added successfully!");
            clearFields();
            viewAllStudents();

            pst.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void viewAllStudents() {
        tableModel.setRowCount(0);

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                Object[] row = {
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("course")
                };
                tableModel.addRow(row);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void clearFields() {
        txtName.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtCourse.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentManagementApp::new);
    }
}
