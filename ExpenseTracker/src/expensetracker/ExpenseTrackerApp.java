package expensetracker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

public class ExpenseTrackerApp extends JFrame {
    private JTextField txtAmount, txtDescription;
    private JComboBox<String> cmbCategory;
    private JDateChooser dateChooser;
    private JTable table;
    private DefaultTableModel tableModel;
    private JLabel lblTotalExpense;
    
    public ExpenseTrackerApp() {
        setTitle("Daily Expense Tracker");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(240, 242, 245));
        
        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(41, 128, 185));
        headerPanel.setPreferredSize(new Dimension(1000, 80));
        JLabel headerLabel = new JLabel("💰 Daily Expense Tracker");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 28));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);
        
        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(240, 242, 245));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Input Panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 8, 8, 8);
        
        // Date
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblDate = new JLabel("Date:");
        lblDate.setFont(new Font("Arial", Font.BOLD, 14));
        inputPanel.add(lblDate, gbc);
        
        gbc.gridx = 1; gbc.gridy = 0; gbc.gridwidth = 2;
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setDate(new java.util.Date());
        dateChooser.setPreferredSize(new Dimension(250, 35));
        dateChooser.setFont(new Font("Arial", Font.PLAIN, 13));
        inputPanel.add(dateChooser, gbc);
        
        // Category
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        JLabel lblCategory = new JLabel("Category:");
        lblCategory.setFont(new Font("Arial", Font.BOLD, 14));
        inputPanel.add(lblCategory, gbc);
        
        gbc.gridx = 1; gbc.gridy = 1; gbc.gridwidth = 2;
        String[] categories = {"Food", "Transportation", "Shopping", "Bills", "Entertainment", 
                               "Health", "Education", "Other"};
        cmbCategory = new JComboBox<>(categories);
        cmbCategory.setPreferredSize(new Dimension(250, 35));
        cmbCategory.setFont(new Font("Arial", Font.PLAIN, 13));
        inputPanel.add(cmbCategory, gbc);
        
        // Amount
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1;
        JLabel lblAmount = new JLabel("Amount (₹):");
        lblAmount.setFont(new Font("Arial", Font.BOLD, 14));
        inputPanel.add(lblAmount, gbc);
        
        gbc.gridx = 1; gbc.gridy = 2; gbc.gridwidth = 2;
        txtAmount = new JTextField();
        txtAmount.setPreferredSize(new Dimension(250, 35));
        txtAmount.setFont(new Font("Arial", Font.PLAIN, 13));
        inputPanel.add(txtAmount, gbc);
        
        // Description
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1;
        JLabel lblDescription = new JLabel("Description:");
        lblDescription.setFont(new Font("Arial", Font.BOLD, 14));
        inputPanel.add(lblDescription, gbc);
        
        gbc.gridx = 1; gbc.gridy = 3; gbc.gridwidth = 2;
        txtDescription = new JTextField();
        txtDescription.setPreferredSize(new Dimension(250, 35));
        txtDescription.setFont(new Font("Arial", Font.PLAIN, 13));
        inputPanel.add(txtDescription, gbc);
        
        // Buttons Panel
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 3;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(Color.WHITE);
        
        JButton btnAdd = createStyledButton("Add Expense", new Color(46, 204, 113));
        JButton btnDelete = createStyledButton("Delete Selected", new Color(231, 76, 60));
        JButton btnClear = createStyledButton("Clear Fields", new Color(149, 165, 166));
        JButton btnRefresh = createStyledButton("Refresh", new Color(52, 152, 219));
        
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnRefresh);
        inputPanel.add(buttonPanel, gbc);
        
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        
        // Table Panel
        JPanel tablePanel = new JPanel(new BorderLayout(10, 10));
        tablePanel.setBackground(new Color(240, 242, 245));
        
        // Summary Panel
        JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        summaryPanel.setBackground(new Color(52, 73, 94));
        summaryPanel.setPreferredSize(new Dimension(1000, 50));
        lblTotalExpense = new JLabel("Total Expenses: ₹0.00");
        lblTotalExpense.setFont(new Font("Arial", Font.BOLD, 18));
        lblTotalExpense.setForeground(Color.WHITE);
        summaryPanel.add(lblTotalExpense);
        tablePanel.add(summaryPanel, BorderLayout.NORTH);
        
        // Table
        String[] columns = {"ID", "Date", "Category", "Amount (₹)", "Description"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(52, 73, 94));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setSelectionBackground(new Color(52, 152, 219));
        table.setSelectionForeground(Color.WHITE);
        table.setGridColor(new Color(189, 195, 199));
        
        // Center align amount column
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);
        
        // Button Actions
        btnAdd.addActionListener(e -> addExpense());
        btnDelete.addActionListener(e -> deleteExpense());
        btnClear.addActionListener(e -> clearFields());
        btnRefresh.addActionListener(e -> viewAllExpenses());
        
        viewAllExpenses();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 13));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(140, 35));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
            }
        });
        
        return button;
    }
    
    private void addExpense() {
        try {
            if (dateChooser.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Please select a date!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String amount = txtAmount.getText().trim();
            if (amount.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Amount is required!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            double amountValue = Double.parseDouble(amount);
            if (amountValue <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be greater than 0!", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(dateChooser.getDate());
            String category = (String) cmbCategory.getSelectedItem();
            String description = txtDescription.getText().trim();
            
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO expenses (date, category, amount, description) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, date);
            pst.setString(2, category);
            pst.setDouble(3, amountValue);
            pst.setString(4, description);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Expense added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
            viewAllExpenses();
            
            pst.close();
            conn.close();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount!", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void viewAllExpenses() {
        tableModel.setRowCount(0);
        double total = 0.0;
        
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM expenses ORDER BY date DESC");
            
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("date"),
                    rs.getString("category"),
                    String.format("%.2f", rs.getDouble("amount")),
                    rs.getString("description")
                };
                tableModel.addRow(row);
                total += rs.getDouble("amount");
            }
            
            lblTotalExpense.setText(String.format("Total Expenses: ₹%.2f", total));
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void deleteExpense() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an expense to delete!", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this expense?", 
            "Confirm Deletion", 
            JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                
                Connection conn = DatabaseConnection.getConnection();
                String sql = "DELETE FROM expenses WHERE id = ?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Expense deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                viewAllExpenses();
                
                pst.close();
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void clearFields() {
        dateChooser.setDate(new java.util.Date());
        cmbCategory.setSelectedIndex(0);
        txtAmount.setText("");
        txtDescription.setText("");
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new ExpenseTrackerApp());
    }
}