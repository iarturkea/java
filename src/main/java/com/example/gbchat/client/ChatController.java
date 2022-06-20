package com.example.gbchat.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

import java.io.IOException;
import java.util.Optional;

public class ChatController {
    public TextField loginField;
    public PasswordField passField;
    public VBox msgBox;
    public HBox loginBox;
    public TextArea msgLoginArea;
    public VBox loginPanel;

    @FXML
    private TextField userMsg;
    @FXML
    private TextArea msgHistoryArea;

    private final Client client;

    public ChatController() {
        this.client = new Client(this);
        while (true) {
            try {
                client.openConnection();
                break;
            } catch (IOException e) {
                showNotification();
            }
        }
    }

    private void showNotification() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Сервер недоступен.\n" + "Проверьте сервер",
                new ButtonType("Попробовать снова", ButtonBar.ButtonData.OK_DONE),
                new ButtonType("Выйти", ButtonBar.ButtonData.CANCEL_CLOSE)
        );
        alert.setTitle("Ошибка подключения");
       final Optional<ButtonType> answer = alert.showAndWait();
       final Boolean isExit = answer.map(select -> select.getButtonData().isCancelButton()).orElse(false);
       if(isExit){
           System.exit(0);
       }
    }


    public void clickSendButton(ActionEvent actionEvent) {
        final String msg = userMsg.getText();
        if (msg.isEmpty()){
            return;
        }
        client.sendMsg(msg);
        userMsg.clear();
        userMsg.requestFocus();
    }

    public void clickClearHistory(ActionEvent actionEvent) {
        msgHistoryArea.clear();
    }

    public void clickExit(ActionEvent actionEvent) {
        client.sendMsg("/end");
        client.closeConnection();
        System.exit(0);
    }

    public void addMsg(String msg) {
        msgHistoryArea.appendText(msg + "\n");
    }

    public void clickReconnect(ActionEvent actionEvent) throws IOException {
        client.openConnection();
    }

    public void setAuth(boolean success){
        loginPanel.setVisible(!success);
        msgBox.setVisible(success);
    }
    public void addLoginMsg(String msg){
        msgLoginArea.appendText(msg);
    }

    public void signInBtnClick() {
        client.sendMsg("/auth " + loginField.getText() + " " + passField.getText());
    }
}