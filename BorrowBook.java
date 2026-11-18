import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowBook extends JFrame implements ActionListener {
    private JLabel lblStudent, lblBook, lblBorrowInfo, lblResult;
    private JComboBox<Student> cmbStudent;
    private JComboBox<Book> cmbBook;
    private JButton btnBorrow;

    public BorrowBook() {
        setTitle("Borrow Book");
        setSize(550, 260);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Top Panel for Combo Boxes
        JPanel pnlInput = new JPanel(new GridLayout(2, 2, 10, 10));
        lblStudent = new JLabel("Student Name & Matric:");
        lblBook = new JLabel("Book Title & Author:");

        cmbStudent = new JComboBox<>();
        cmbBook = new JComboBox<>();

        // Populate dropdowns from shared lists
        for (Student s : MainMenu.studentList) {
            cmbStudent.addItem(s);
        }
        for (Book b : MainMenu.bookList) {
            cmbBook.addItem(b);
        }

        pnlInput.add(lblStudent);
        pnlInput.add(cmbStudent);
        pnlInput.add(lblBook);
        pnlInput.add(cmbBook);

        // Center Panel for Borrow Button
        JPanel pnlButton = new JPanel(new FlowLayout());
        btnBorrow = new JButton("Borrow");
        btnBorrow.addActionListener(this);
        pnlButton.add(btnBorrow);

        // South Panel for Borrow Information
        JPanel pnlOutput = new JPanel(new GridLayout(2, 1, 5, 5));
        lblBorrowInfo = new JLabel("Borrow Information :");
        lblResult = new JLabel(" ");
        pnlOutput.add(lblBorrowInfo);
        pnlOutput.add(lblResult);

        add(pnlInput, BorderLayout.NORTH);
        add(pnlButton, BorderLayout.CENTER);
        add(pnlOutput, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBorrow) {
            Student selectedStudent = (Student) cmbStudent.getSelectedItem();
            Book selectedBook = (Book) cmbBook.getSelectedItem();

            if (selectedStudent != null && selectedBook != null) {
                String message = selectedBook.borrowBy(selectedStudent);
                lblResult.setText(message);
            }
        }
    }
}