package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MessengerController {
    @FXML
    private TextField userMsg;
    @FXML
    private TextArea msgHistoryArea;

    public void clickSendButton(ActionEvent actionEvent) {
        final String msg = userMsg.getText();
        if (msg.isEmpty()){
            return;
        }

        String text = "User: " + msg;
        msgHistoryArea.appendText(text + "\n");
        userMsg.clear();
        userMsg.requestFocus();
    }

    public void clickClearHistory(ActionEvent actionEvent) {
        msgHistoryArea.clear();
    }

    public void clickExit(ActionEvent actionEvent) {
        System.exit(0);
    }
}