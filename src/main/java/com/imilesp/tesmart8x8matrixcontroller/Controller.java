package com.imilesp.tesmart8x8matrixcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;

import java.util.ArrayList;

public class Controller {
    private Matrix matrix;
    private boolean connected; //maybe use to show successful connection??

    @FXML
    private TextInputControl subnet;
    @FXML
    private TextInputControl mask;
    @FXML
    private TextInputControl ipAddress;
    @FXML
    private TextArea o1;
    @FXML
    private TextArea o2;
    @FXML
    private TextArea o3;
    @FXML
    private TextArea o4;
    @FXML
    private TextArea o5;
    @FXML
    private TextArea o6;
    @FXML
    private TextArea o7;
    @FXML
    private TextArea o8;
    @FXML
    private TextArea i1;
    @FXML
    private TextArea i2;
    @FXML
    private TextArea i3;
    @FXML
    private TextArea i4;
    @FXML
    private TextArea i5;
    @FXML
    private TextArea i6;
    @FXML
    private TextArea i7;
    @FXML
    private TextArea i8;

    @FXML
    public void initialize() {
        matrix = new Matrix();
        connected = false;
        loadLabels();
        o1.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 1);
        });
        o2.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 2);
        });
        o3.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 3);
        });
        o4.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 4);
        });
        o5.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 5);
        });
        o6.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 6);
        });
        o7.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 7);
        });
        o8.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 8);
        });
        i1.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 9);
        });
        i2.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 10);
        });
        i3.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 11);
        });
        i4.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 12);
        });
        i5.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 13);
        });
        i6.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 14);
        });
        i7.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 15);
        });
        i8.textProperty().addListener((observable, oldValue, newValue) -> {
            saveLabel(newValue, 16);
        });
    }

    @FXML
    protected void connect() {
        if(matrix.connect(ipAddress.getText(), "5000")) {
            String config = matrix.reqConfig();
            syncUIToMatrixConfig(config);
        }
    }

    private void syncUIToMatrixConfig(String configString) {
        //figure this out... probably need to parse the string and set the grid accordingly
    }

    @FXML
    protected void disconnect() { matrix.disconnect(); }

    @FXML
    protected void findMatrix() {
        connected = matrix.findMatrix(subnet.getText() + mask.getText());
        if(connected) {
            String config = matrix.reqConfig();
            syncUIToMatrixConfig(config);
        } else {
            //show some error toast?
        }
    }

    @FXML
    protected void mirrorMatrixIO() { matrix.mirrorMatrixIO(); }

    @FXML
    protected void mapInputToAllOutputs(String input) { matrix.mapInputToAllOutputs(input); } //put in UI

    @FXML
    protected void mapInputToOutput(String input, String output) { matrix.mapInputToOutput(input, output); } //put in UI

    @FXML
    protected void loadPreset(String slot) {
        matrix.loadPreset(slot);
        String config = matrix.reqConfig();
        syncUIToMatrixConfig(config);
    } //put in UI

    private void loadLabels() {
        ArrayList<String> labels = matrix.loadLabels();
        o1.setText(labels.get(0));
        o2.setText(labels.get(1));
        o3.setText(labels.get(2));
        o4.setText(labels.get(3));
        o5.setText(labels.get(4));
        o6.setText(labels.get(5));
        o7.setText(labels.get(6));
        o8.setText(labels.get(7));
        i1.setText(labels.get(8));
        i2.setText(labels.get(9));
        i3.setText(labels.get(10));
        i4.setText(labels.get(11));
        i5.setText(labels.get(12));
        i6.setText(labels.get(13));
        i7.setText(labels.get(14));
        i8.setText(labels.get(15));
    }

    @FXML
    protected void savePreset(String slot) { matrix.savePreset(slot); } //put in UI

    private void saveLabel(String label, int pos) {
        matrix.saveLabel(label, pos);
    }

    @FXML
    protected void resetLabels() {
        matrix.resetLabels();
        loadLabels();
    }

    @FXML
    protected void muteBuzzer() { matrix.muteBuzzer(); }

    @FXML
    protected void unmuteBuzzer() { matrix.unmuteBuzzer(); }
}