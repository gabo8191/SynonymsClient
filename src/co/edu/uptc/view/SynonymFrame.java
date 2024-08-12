package co.edu.uptc.view;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class SynonymFrame extends JFrame {
    private WordPanel wordPanel;
    private SynonymPanel synonymPanel;
    private AddPanel addPanel;
    private AddSynonymDialog addSynonym;
    private AddWordDialog addWord;

    public SynonymFrame(ActionListener listener) {
        super("Synonyms Dictionary");
        this.setSize(500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents(listener);
        this.setVisible(true);
    }

    public void initComponents(ActionListener actionListener) {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        wordPanel = new WordPanel(actionListener);
        container.add(wordPanel);

        synonymPanel = new SynonymPanel(actionListener);
        container.add(synonymPanel);

        addPanel = new AddPanel(actionListener);

        container.add(addPanel);

        this.setContentPane(container);
    }

    public void showAddWordDialog(ActionListener listener) {
        addWord = new AddWordDialog(listener);
        addWord.setVisible(true);
    }

    public void showAddSynonymDialog(ActionListener listener) {
        addSynonym = new AddSynonymDialog(listener);
        addSynonym.setVisible(true);
    }

    public String getWord() {
        return wordPanel.getTextInput().getText().toLowerCase();
    }

    public String getWordDialog() {
        return addWord.getWord().getText().toLowerCase();
    }

    public void setSynonym(String synonym) {
        synonymPanel.setResult(synonym);
    }

    public void setSynonymList(String[] synonymList, int count) {
        synonymPanel.setSynonymList(synonymList, count);
    }

    public void setSynonymNumber(int size) {
        synonymPanel.setSynonymNumber(size);
    }

    public void closeAddWordDialog() {
        addWord.dispose();
    }

    public void closeAddSynonymDialog() {
        addSynonym.dispose();
    }

    public void setListWords(String words) {
        addSynonym.getListWords().addItem(words);
    }

    public String getSelectedWord() {
        return addSynonym.getListWords().getSelectedItem().toString();
    }

    public String getSynonymDialog() {
        return addSynonym.getSynonyms().getText().toLowerCase();
    }

}
