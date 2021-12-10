package gameUI.dialogue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;

public class Dialog extends JFrame {

    private Font font;
    private final JButton leftButton;
    private final JButton rightButton;
    private final JPanel buttonPanel;
    private final JLabel textLabel;
    private final JPanel contentPanel;
    private Color buttonColor = new Color(49, 46, 46);
    private Color backgroundColor = new Color(56, 56, 56);
    private Color textColor = new Color(227, 227, 227);

    public Dialog(Component parent, String title, String text, int width, String iconPath,
                  String leftButtonText, String rightButtonText,
                  ActionListener leftListener, ActionListener rightListener, String fontPath) {

        loadFont(fontPath);

        setSize(width, 180);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle(title);
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);

        leftButton = new JButton(leftButtonText);
        rightButton = new JButton(rightButtonText);
        leftButton.setOpaque(true);
        rightButton.setOpaque(true);
        leftButton.setBorderPainted(false);
        rightButton.setBorderPainted(false);
        leftButton.addActionListener(leftListener);
        rightButton.addActionListener(rightListener);
        leftButton.addActionListener(actionEvent ->
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)));
        rightButton.addActionListener(actionEvent ->
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)));

        buttonPanel = new JPanel();
        GridLayout buttonsLayout = new GridLayout(1, 2);
        buttonsLayout.setHgap(10);
        buttonPanel.setLayout(buttonsLayout);
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(buttonPanel, BorderLayout.SOUTH);


        textLabel = new JLabel(text);

        Icon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(iconPath)));
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(icon);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(15, 15, 10, 5));
        FlowLayout contentLayout = new FlowLayout();
        contentLayout.setAlignment(FlowLayout.LEFT);
        contentLayout.setHgap(20);
        contentPanel.setLayout(contentLayout);
        contentPanel.add(imageLabel);
        contentPanel.add(textLabel);
        add(contentPanel, BorderLayout.CENTER);

        changeFonts();
        changeComponentColors();
        setVisible(true);
    }

    private void changeFonts() {
        leftButton.setFont(font);
        rightButton.setFont(font);
        textLabel.setFont(font);
    }

    private void changeComponentColors() {
        getContentPane().setBackground(backgroundColor);

        leftButton.setForeground(textColor);
        leftButton.setBackground(buttonColor);
        rightButton.setForeground(textColor);
        rightButton.setBackground(buttonColor);
        buttonPanel.setBackground(backgroundColor);
        textLabel.setForeground(textColor);
        contentPanel.setBackground(backgroundColor);
    }

    private void loadFont(String fontPath) {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT,
                    Objects.requireNonNull(getClass().getResourceAsStream(fontPath))).deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    public void setColors(Color buttonColor, Color backgroundColor, Color textColor) {
        this.backgroundColor = backgroundColor;
        this.buttonColor = buttonColor;
        this.textColor = textColor;

        changeComponentColors();
    }
}
