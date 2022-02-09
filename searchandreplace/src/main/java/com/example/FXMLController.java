package com.example;
/*
Put header here


 */

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class FXMLController implements Initializable {
    @FXML
    Button replaceAll,openFile, saveAs;
    @FXML
    TextArea textArea;
    @FXML
    TextField search, replace;
    FileChooser fileChooser;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));


    }

    @FXML
    public void openFileAction(ActionEvent actionEvent){

            File inFile = fileChooser.showOpenDialog(null);
            Scanner reader;
            StringBuilder stringBuilder;
            try {
                reader = new Scanner(inFile);
                stringBuilder = new StringBuilder();
                while (reader.hasNext()){
                   stringBuilder.append(reader.nextLine() + "\n");
                }
                textArea.setText(stringBuilder.toString());
            }catch (FileNotFoundException ex){
                System.out.println(ex.getMessage());
            }


    }

    @FXML
    public void saveAsAction(ActionEvent actionEvent){

            File outFile = fileChooser.showSaveDialog(null);
            FileWriter write;
            try {
                write = new FileWriter(outFile,true);
                write.write(textArea.getText() + "\n");
                write.close();
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }

    }
    @FXML
    public void replaceAllAction(ActionEvent actionEvent){
        String replaceWords = textArea.getText().replace(search.getText(),replace.getText());
        textArea.setText(replaceWords);
    }
}
