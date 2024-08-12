package co.edu.uptc.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

public class AddPanel extends JPanel {
    private JButton addWord;
    private JButton addSynonym;

    public AddPanel(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        addWord = new JButton("Add Word");
        addWord.addActionListener(listener);
        addWord.setActionCommand("ADD_WORD");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(addWord, gbc);

        addSynonym = new JButton("Add Synonym");
        addSynonym.addActionListener(listener);
        addSynonym.setActionCommand("ADD_SYNONYM");
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(addSynonym, gbc);
    }

    public JButton getAddWord() {
        return addWord;
    }

    public void setAddWord(JButton addWord) {
        this.addWord = addWord;
    }

    public JButton getAddSynonym() {
        return addSynonym;
    }

    public void setAddSynonym(JButton addSynonym) {
        this.addSynonym = addSynonym;
    }

}
