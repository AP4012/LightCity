package org.example;

import org.example.models.User;

import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Menu extends JFrame {
    private static Game game = new Game();
    private Font customFont;
    int width = this.getWidth();
    int height = this.getHeight();

    public Menu() {
        // Load custom font
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:\\Users\\WinSell\\Desktop\\LightCity\\PressStart2P-Regular.ttf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            customFont = new Font("Arial", Font.PLAIN, 12);
        }


        setTitle("Welcome to LightCity");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ImagePanel mainMenuPanel = new ImagePanel("C:\\Users\\WinSell\\Desktop\\LightCity\\fotor-ai-2023062811929.jpg");
        mainMenuPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        add(mainMenuPanel, BorderLayout.CENTER);

        JButton continueGameButton = new JButton("Continue Game");
        JButton startGameButton = new JButton("Start Game");
        JButton joinServerButton = new JButton("Join Server");
        JButton exitButton = new JButton("Exit");

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainMenuPanel.add(continueGameButton, gbc);

        gbc.gridy = 1;
        mainMenuPanel.add(startGameButton, gbc);

        gbc.gridy = 2;
        mainMenuPanel.add(joinServerButton, gbc);

        gbc.gridy = 3;
        mainMenuPanel.add(exitButton, gbc);

        applyCustomFont(continueGameButton);
        applyCustomFont(startGameButton);
        applyCustomFont(joinServerButton);
        applyCustomFont(exitButton);

        addSoundOnHoverListener(continueGameButton);
        addSoundOnHoverListener(startGameButton);
        addSoundOnHoverListener(joinServerButton);
        addSoundOnHoverListener(exitButton);

        continueGameButton.addActionListener(e -> {
            User user = loginMenu();
            if (user != null) {
                game.continueGame(user);
            }
        });

        startGameButton.addActionListener(e -> {
            User user = signupMenu();
            if (user != null) {
                game.startGame(user);
            }
        });

        joinServerButton.addActionListener(e -> joinServer());

        exitButton.addActionListener(e -> System.exit(0));


    }

    private void applyCustomFont(JButton button) {
        button.setFont(customFont.deriveFont(14f));
    }

    private void addMouseListener(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setFont(customFont.deriveFont(Font.BOLD, 14f));
                playSound("path/to/your/sound.wav"); // Add this line
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setFont(customFont.deriveFont(Font.PLAIN, 14f));
            }
        });
    }

    private void playSound(String soundFile) {
        try {
            File audioFile = new File(soundFile);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void addSoundOnHoverListener(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setFont(customFont.deriveFont(Font.BOLD, 14f));
                playSound("C:\\Users\\WinSell\\Desktop\\LightCity\\notification_sound.wav");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setFont(customFont.deriveFont(Font.PLAIN, 14f));
            }
        });
    }

    public static User loginMenu() {
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");
        User tempUser = new User(username, password);
        if (true) {
            return tempUser;
        } else {
            int option = JOptionPane.showOptionDialog(null, "Invalid credentials. What would you like to do?",
                    "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    new Object[]{}, null);
            switch (option) {
                case 0:
                    return loginMenu();
                case 1:
                    return signupMenu();
                default:
                    System.exit(0);
            }
        }
        return null;
    }

    public static User signupMenu() {
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");
        User signUpUser = new User(username, password);
        if (true) {
            return signUpUser;
        } else {
            int option = JOptionPane.showOptionDialog(null, "Registration failed. What would you like to do?",
                    "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    new Object[]{}, null);
            switch (option) {
                case 0:
                    return loginMenu();
                default:
                    System.exit(0);
            }
        }
        return null;
    }

    private void joinServer() {
        String ip = JOptionPane.showInputDialog("Enter Server IP Address:");
        int port = Integer.parseInt(JOptionPane.showInputDialog("Enter Server Port:"));
        game.joinServer(ip, port);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Menu menu = new Menu();
            menu.setVisible(true);
        });
    }

}

class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(String imagePath) {
        backgroundImage = new ImageIcon(imagePath).getImage();
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = this.getWidth();
        int height = this.getHeight();
        g.drawImage(backgroundImage, 0, 0, width, height, this);
    }
}