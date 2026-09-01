import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Screen extends JPanel implements ActionListener {
    private ArrayList<Pair<Student, Schedule>> students;
    private JTextArea display;
    private JTextField nameInput;
    private boolean showingNotFound;

    public Screen() {
        students = new ArrayList<>();
        createStudents();

        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(500, 350));
        setBackground(new Color(235, 240, 245));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Type a student name and press Enter");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        display = new JTextArea(getStudentNames());
        display.setEditable(false);
        display.setFont(new Font("Monospaced", Font.PLAIN, 18));
        display.setLineWrap(true);
        display.setWrapStyleWord(true);
        add(new JScrollPane(display), BorderLayout.CENTER);

        nameInput = new JTextField();
        nameInput.setFont(new Font("Arial", Font.PLAIN, 18));
        nameInput.addActionListener(this);
        
        nameInput.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                clearNotFoundMessage();
            }

            public void removeUpdate(DocumentEvent e) {
                clearNotFoundMessage();
            }

            public void changedUpdate(DocumentEvent e) {
                clearNotFoundMessage();
            }
        });
        add(nameInput, BorderLayout.SOUTH);
    }

    private void createStudents() {
        Student maya = new Student("Maya");
        Schedule mayaSchedule = new Schedule();
        mayaSchedule.addClass(1, "Geometry");
        mayaSchedule.addClass(2, "P.E.");
        mayaSchedule.addClass(3, "US History");
        students.add(new Pair<>(maya, mayaSchedule));

        Student jordan = new Student("Jordan");
        Schedule jordanSchedule = new Schedule();
        jordanSchedule.addClass(1, "English");
        jordanSchedule.addClass(2, "Biology");
        jordanSchedule.addClass(3, "Computer Science");
        students.add(new Pair<>(jordan, jordanSchedule));

        Student alex = new Student("Alex");
        Schedule alexSchedule = new Schedule();
        alexSchedule.addClass(1, "Spanish");
        alexSchedule.addClass(2, "Algebra");
        alexSchedule.addClass(3, "Art");
        students.add(new Pair<>(alex, alexSchedule));
    }

    private String getStudentNames() {
        String names = "Students:\n";

        for (Pair<Student, Schedule> pair : students) {
            names += pair.getKey() + "\n";
        }

        return names;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameInput.getText().trim();

        for (Pair<Student, Schedule> pair : students) {
            Student student = pair.getKey();
            Schedule schedule = pair.getValue();

            if (student.getName().equalsIgnoreCase(name)) {
                display.setText(student + "'s Schedule:\n" + schedule);
                showingNotFound = false;
                nameInput.setText("");
                return;
            }
        }

        display.setText("Student not found.\n\n" + getStudentNames());
        showingNotFound = true;
        nameInput.setText("");
    }

    private void clearNotFoundMessage() {
        if (showingNotFound && nameInput.getText().length() > 0) {
            display.setText(getStudentNames());
            showingNotFound = false;
        }
    }
}
