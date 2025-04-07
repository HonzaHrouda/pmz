package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ClipboardView {

    @FXML
    private TextArea input;

    @FXML


    void copyText(MouseEvent event){



        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();

        if (clipboard.hasString()) {
            String text = input.getText();
            System.out.println("Textový obsah schránky:\n" + text);
        } else {
            System.out.println("Schránka neobsahuje žádný text.");
        }
        content.putString(input.getText());
        clipboard.setContent(content);


    }

}
