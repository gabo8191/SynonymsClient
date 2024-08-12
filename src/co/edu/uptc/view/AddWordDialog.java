package co.edu.uptc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Insets;

public class AddWordDialog extends JDialog {

    private JButton accept;
    private JLabel tittle;
    private JTextArea word;

    public AddWordDialog(ActionListener listener) {
        initComponents(listener);
        this.setSize(250, 120);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        tittle = new JLabel("New word: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(tittle, gbc);

        word = new JTextArea();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        add(new JScrollPane(word), gbc);

        accept = new JButton("Accept");
        accept.addActionListener(listener);
        accept.setActionCommand("ACCEPT_WORD");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        add(accept, gbc);
    }

    public JButton getAccept() {
        return accept;
    }

    public void setAccept(JButton accept) {
        this.accept = accept;
    }

    public JLabel getTittle() {
        return tittle;
    }

    public void setTittle(JLabel tittle) {
        this.tittle = tittle;
    }

    public JTextArea getWord() {
        return word;
    }

    public void setWord(JTextArea word) {
        this.word = word;
    }

}
