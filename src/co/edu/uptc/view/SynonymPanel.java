package co.edu.uptc.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.Insets;

public class SynonymPanel extends JPanel {
    private JButton previous;
    private JButton next;
    private JTextArea result;
    private JLabel quantitySynonymsText;
    private JLabel quantitySynonymsNumber;

    public SynonymPanel(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        previous = new JButton("<<");
        previous.addActionListener(listener);
        previous.setActionCommand("PREVIOUS");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 40;
        gbc.ipady = 0;
        add(previous, gbc);

        result = new JTextArea();
        result.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipadx = 0;
        add(new JScrollPane(result), gbc);

        next = new JButton(">>");
        next.addActionListener(listener);
        next.setActionCommand("NEXT");
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.ipadx = 40;
        gbc.ipady = 0;
        gbc.weightx = 0;
        add(next, gbc);

        quantitySynonymsText = new JLabel("Synonyms Number: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(quantitySynonymsText, gbc);

        quantitySynonymsNumber = new JLabel("");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        add(quantitySynonymsNumber, gbc);

        setBorder(javax.swing.BorderFactory.createTitledBorder("Synonyms"));
    }

    public void setSynonyms(String synonyms, int index) {
        result.setText(synonyms);
        quantitySynonymsNumber.setText(String.valueOf(index));
    }

    public JButton getPrevious() {
        return previous;
    }

    public void setPrevious(JButton previous) {
        this.previous = previous;
    }

    public JButton getNext() {
        return next;
    }

    public void setNext(JButton next) {
        this.next = next;
    }

    public JTextArea getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result.setText(result);
    }

    public void setSynonymList(String[] synonymList, int index) {
        result.setEditable(true);
        result.setText(synonymList[index]);
        result.setEditable(false);
    }

    public void setSynonymNumber(int size) {
        quantitySynonymsNumber.setText(String.valueOf(size));
    }

    public JLabel getQuantitySynonymsText() {
        return quantitySynonymsText;
    }

    public void setQuantitySynonymsText(JLabel quantitySynonymsText) {
        this.quantitySynonymsText = quantitySynonymsText;
    }

    public JLabel getQuantitySynonymsNumber() {
        return quantitySynonymsNumber;
    }

    public void setQuantitySynonymsNumber(JLabel quantitySynonymsNumber) {
        this.quantitySynonymsNumber = quantitySynonymsNumber;
    }

}
