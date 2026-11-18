import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentInfo extends JFrame implements ActionListener {
    private JLabel lblName, lblMatric, lblStudents;
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea txtAreaStudents;

    public AddStudentInfo() {
        setTitle("Add Student Info");
        setSize(450, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Top Panel for Inputs
        JPanel pnlInput = new JPanel(new GridLayout(2, 2, 5, 5));
        lblName = new JLabel("Name:");
        lblMatric = new JLabel("Matric:");
        txtName = new JTextField();
        txtMatric = new JTextField();
        pnlInput.add(lblName);
        pnlInput.add(txtName);
        pnlInput.add(lblMatric);
        pnlInput.add(txtMatric);

        // Center Panel for Buttons
        JPanel pnlButtons = new JPanel(new FlowLayout());
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        btnAdd.addActionListener(this);
        btnList.addActionListener(this);
        pnlButtons.add(btnAdd);
        pnlButtons.add(btnList);

        JPanel pnlNorth = new JPanel(new BorderLayout(5, 5));
        pnlNorth.add(pnlInput, BorderLayout.NORTH);
        pnlNorth.add(pnlButtons, BorderLayout.CENTER);

        // South Panel for Text Area
        JPanel pnlSouth = new JPanel(new BorderLayout(5, 5));
        lblStudents = new JLabel("Students:");
        txtAreaStudents = new JTextArea(5, 30);
        txtAreaStudents.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaStudents);
        pnlSouth.add(lblStudents, BorderLayout.NORTH);
        pnlSouth.add(scrollPane, BorderLayout.CENTER);

        add(pnlNorth, BorderLayout.NORTH);
        add(pnlSouth, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String name = txtName.getText().trim();
            String matric = txtMatric.getText().trim();
            if (!name.isEmpty() && !matric.isEmpty()) {
                MainMenu.studentList.add(new Student(name, matric));
                txtName.setText("");
                txtMatric.setText("");
            }
        } else if (e.getSource() == btnList) {
            txtAreaStudents.setText("");
            for (Student s : MainMenu.studentList) {
                txtAreaStudents.append("Name : " + s.toString() + "\n");
            }
        }
    }
}