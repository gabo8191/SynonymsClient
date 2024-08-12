package co.edu.uptc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AddSynonymDialog extends JDialog {
    private JComboBox<String> listWords;
    private JLabel tittle;
    private JLabel tittleSynonym;
    private JTextArea synonyms;
    private JButton accept;

    public AddSynonymDialog(ActionListener listener) {
        initComponents(listener);
        this.setSize(250, 150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Select the word: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        add(titleLabel, gbc);

        listWords = new JComboBox<String>();
        listWords.addActionListener(listener);
        listWords.setActionCommand("LIST_WORDS");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        add(listWords, gbc);

        JLabel synonymLabel = new JLabel("Type a new synonym: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        add(synonymLabel, gbc);

        synonyms = new JTextArea();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JScrollPane(synonyms), gbc);

        accept = new JButton("Accept");
        accept.addActionListener(listener);
        accept.setActionCommand("ACCEPT_SYNONYM");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        add(accept, gbc);
    }

    public JComboBox<String> getListWords() {
        return listWords;
    }

    public void setListWords(JComboBox<String> listWords) {
        this.listWords = listWords;
    }

    public JLabel getTittle() {
        return tittle;
    }

    public void setTittle(JLabel tittle) {
        this.tittle = tittle;
    }

    public JLabel getTittleSynonym() {
        return tittleSynonym;
    }

    public void setTittleSynonym(JLabel tittleSynonym) {
        this.tittleSynonym = tittleSynonym;
    }

    public JTextArea getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(JTextArea synonyms) {
        this.synonyms = synonyms;
    }

    public JButton getAccept() {
        return accept;
    }

    public void setAccept(JButton accept) {
        this.accept = accept;
    }

}
