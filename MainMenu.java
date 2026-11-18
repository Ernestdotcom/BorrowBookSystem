import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenu extends JFrame implements ActionListener {
    private JLabel lblTitle;
    private JButton btnAddStudent, btnAddBook, btnBorrowBook;
    
    // Shared lists to store objects across all windows
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static ArrayList<Book> bookList = new ArrayList<>();

    public MainMenu() {
        setTitle("Main Menu");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 1, 10, 10));
        ((JComponent) pane).setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        lblTitle = new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));

        btnAddStudent = new JButton("Add Student Info");
        btnAddBook = new JButton("Add Book Info");
        btnBorrowBook = new JButton("Borrow Book");

        btnAddStudent.addActionListener(this);
        btnAddBook.addActionListener(this);
        btnBorrowBook.addActionListener(this);

        pane.add(lblTitle);
        pane.add(btnAddStudent);
        pane.add(btnAddBook);
        pane.add(btnBorrowBook);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddStudent) {
            new AddStudentInfo().setVisible(true);
        } else if (e.getSource() == btnAddBook) {
            new AddBookInfo().setVisible(true);
        } else if (e.getSource() == btnBorrowBook) {
            new BorrowBook().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MainMenu().setVisible(true);
    }
}