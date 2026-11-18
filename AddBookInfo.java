import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookInfo extends JFrame implements ActionListener {
    private JLabel lblTitle, lblAuthor, lblBooks;
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea txtAreaBooks;

    public AddBookInfo() {
        setTitle("Add Book Info");
        setSize(450, 280);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Top Panel for Inputs
        JPanel pnlInput = new JPanel(new GridLayout(2, 2, 5, 5));
        lblTitle = new JLabel("Book Title:");
        lblAuthor = new JLabel("Author:");
        txtTitle = new JTextField();
        txtAuthor = new JTextField();
        pnlInput.add(lblTitle);
        pnlInput.add(txtTitle);
        pnlInput.add(lblAuthor);
        pnlInput.add(txtAuthor);

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
        lblBooks = new JLabel("Books:");
        txtAreaBooks = new JTextArea(5, 30);
        txtAreaBooks.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaBooks);
        pnlSouth.add(lblBooks, BorderLayout.NORTH);
        pnlSouth.add(scrollPane, BorderLayout.CENTER);

        add(pnlNorth, BorderLayout.NORTH);
        add(pnlSouth, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            String title = txtTitle.getText().trim();
            String author = txtAuthor.getText().trim();
            if (!title.isEmpty() && !author.isEmpty()) {
                MainMenu.bookList.add(new Book(title, author));
                txtTitle.setText("");
                txtAuthor.setText("");
            }
        } else if (e.getSource() == btnList) {
            txtAreaBooks.setText("");
            for (Book b : MainMenu.bookList) {
                txtAreaBooks.append("Book title : " + b.getTitle() + " (Author : " + b.getAuthor() + ")\n");
            }
        }
    }
}