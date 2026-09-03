import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Screen extends JPanel implements ActionListener {
    private MyArrayList<Song> playlist;
    private JTextArea display;
    private JTextField nameInput;
    private JTextField artistInput;
    private JTextField albumInput;
    private JTextField removeInput;
    private JButton addButton;
    private JButton removeButton;

    public Screen() {
        playlist = new MyArrayList<>();
        seedPlaylist();

        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(560, 520));
        setBackground(new Color(235, 240, 245));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Playlist Manager");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        display = new JTextArea();
        display.setEditable(false);
        display.setFont(new Font("Monospaced", Font.PLAIN, 15));
        refreshDisplay();
        add(new JScrollPane(display), BorderLayout.CENTER);

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        form.setBackground(new Color(235, 240, 245));

        form.add(new JLabel("Song Name:"));
        nameInput = new JTextField();
        form.add(nameInput);

        form.add(new JLabel("Artist:"));
        artistInput = new JTextField();
        form.add(artistInput);

        form.add(new JLabel("Album:"));
        albumInput = new JTextField();
        form.add(albumInput);

        form.add(new JLabel("Remove by name:"));
        removeInput = new JTextField();
        form.add(removeInput);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(235, 240, 245));

        addButton = new JButton("Add Song");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        removeButton = new JButton("Remove Song");
        removeButton.addActionListener(this);
        buttonPanel.add(removeButton);

        JPanel south = new JPanel(new BorderLayout(10, 10));
        south.setBackground(new Color(235, 240, 245));
        south.add(form, BorderLayout.CENTER);
        south.add(buttonPanel, BorderLayout.SOUTH);
        add(south, BorderLayout.SOUTH);
    }

    private void seedPlaylist() {
        playlist.add(new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera"));
        playlist.add(new Song("Blinding Lights", "The Weeknd", "After Hours"));
        playlist.add(new Song("Shape of You", "Ed Sheeran", "Divide"));
        playlist.add(new Song("Rolling in the Deep", "Adele", "21"));
    }

    private void refreshDisplay() {
        String text = "Playlist (" + playlist.size() + " songs):\n\n";

        for (int i = 0; i < playlist.size(); i++) {
            text += (i + 1) + ". " + playlist.get(i) + "\n";
        }

        display.setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameInput.getText().trim();
            String artist = artistInput.getText().trim();
            String album = albumInput.getText().trim();

            if (name.length() > 0 && artist.length() > 0 && album.length() > 0) {
                playlist.add(new Song(name, artist, album));
                nameInput.setText("");
                artistInput.setText("");
                albumInput.setText("");
            }
        } else if (e.getSource() == removeButton) {
            String name = removeInput.getText().trim();

            if (name.length() > 0) {
                Song toRemove = null;
                for (int i = 0; i < playlist.size(); i++) {
                    Song song = playlist.get(i);
                    if (song.getName().equalsIgnoreCase(name)) {
                        toRemove = song;
                        break;
                    }
                }

                if (toRemove != null) {
                    playlist.remove(toRemove);
                    removeInput.setText("");
                }
            }
        }

        refreshDisplay();
    }
}
