package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.google.gson.Gson;

import co.edu.uptc.net.Connection;
import co.edu.uptc.net.Request;
import co.edu.uptc.net.Response;
import co.edu.uptc.view.SynonymFrame;

public class Presenter implements ActionListener {

    private SynonymFrame view;
    private int index;
    private Connection connection;
    private Gson gson;

    public Presenter() {
        connection = new Connection();
        view = new SynonymFrame(this);
        index = 0;
        gson = new Gson();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        try {

            switch (command) {
                case "ADD_WORD":
                    handleAddWordAction();
                    break;
                case "ADD_SYNONYM":
                    handleAddSynonymAction();
                    break;
                case "FIND_SYNONYM":
                    handleFindSynonymAction();
                    break;
                case "NEXT":
                    handleNextAction();
                    break;
                case "PREVIOUS":
                    handlePreviousAction();
                    break;
                case "ACCEPT_WORD":
                    handleAcceptWordAction();
                    break;
                case "ACCEPT_SYNONYM":
                    handleAcceptSynonymAction();
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    private void handleAddWordAction() {
        view.showAddWordDialog(this);
    }

    private void handleAddSynonymAction() {
        view.showAddSynonymDialog(this);
        populateWordList();
    }

    private void populateWordList() {
        connection.send(gson.toJson(new Request("ADD_SYNONYM", "", "")));
        Response response = gson.fromJson(connection.receive(), Response.class);
        if (response != null && response.getResponse() != null) {
            String[] words = response.getResponse().split(",");
            for (String word : words) {
                view.setListWords(word);
            }
        } else {
            System.out.println("Error: No se recibió una respuesta válida del servidor");
        }
    }

    private void handleFindSynonymAction() {
        connection.send(gson.toJson(new Request("FIND_SYNONYM", view.getWord(), "")));
        Response response = gson.fromJson(connection.receive(), Response.class);
        String[] synonyms = response.getResponse().split(",");
        if (synonyms.length == 1 && synonyms[0].equals("")) {
            view.setSynonym("La palabra no existe");
        } else {
            view.setSynonymList(synonyms, 0);
            view.setSynonymNumber(synonyms.length);
        }

    }

    private void handleNextAction() {
        connection.send(gson.toJson(new Request("NEXT", view.getWord(), "")));
        String[] synonyms = gson.fromJson(connection.receive(), Response.class).getResponse().split(",");
        if (index < synonyms.length - 1) {
            index++;
            view.setSynonymList(synonyms, index);
        }
    }

    private void handlePreviousAction() {
        Request request = new Request("PREVIOUS", view.getWord(), "");
        connection.send(gson.toJson(request));
        Response response = gson.fromJson(connection.receive(), Response.class);
        String[] synonyms = response.getResponse().split(",");
        if (index > 0) {
            index--;
            view.setSynonymList(synonyms, index);
        }
    }

    private void handleAcceptWordAction() {
        if (!view.getWordDialog().isEmpty()) {
            Request request = new Request("ACCEPT_WORD", view.getWordDialog(), "");
            connection.send(gson.toJson(request));
            Response response = gson.fromJson(connection.receive(), Response.class);
            view.setSynonym(response.getResponse());
            view.closeAddWordDialog();
        } else {
            view.setSynonym("No se puede agregar una palabra vacía");
        }
    }

    private void handleAcceptSynonymAction() {
        if (!view.getSelectedWord().isEmpty() && !view.getSynonymDialog().isEmpty()) {
            connection
                    .send(gson.toJson(new Request("ACCEPT_SYNONYM", view.getSelectedWord(), view.getSynonymDialog())));
            view.setSynonym(gson.fromJson(connection.receive(), Response.class).getResponse());
            view.closeAddSynonymDialog();
        } else {
            view.setSynonym("No se puede agregar un sinónimo vacío");
        }
    }

    public static void main(String[] args) {
        new Presenter();
    }
}
