package co.edu.uptc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WordPanel extends JPanel {

    private JLabel word;
    private JTextArea textInput;
    private JButton find;

    public WordPanel(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        word = new JLabel("Word: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(word, gbc);

        textInput = new JTextArea();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.ipadx = 10;
        add(textInput, gbc);

        find = new JButton("Find Synonyms");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0;
        add(find, gbc);

        find.addActionListener(listener);
        find.setActionCommand("FIND_SYNONYM");
    }

    public JLabel getWord() {
        return word;
    }

    public void setWord(JLabel word) {
        this.word = word;
    }

    public JTextArea getTextInput() {
        return textInput;
    }

    public void setText(JTextArea textInput) {
        this.textInput = textInput;
    }

    public JButton getFind() {
        return find;
    }

    public void setFind(JButton find) {
        this.find = find;
    }

}
