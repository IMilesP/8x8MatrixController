package com.imilesp.tesmart8x8matrixcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;

import java.util.ArrayList;

public class Controller {
    private Matrix matrix;
    private boolean connected;

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
    protected void initialize() {
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
        connected = matrix.connect(ipAddress.getText(), "5000");
        if(connected) {
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
        }
    }

    @FXML
    protected void mirrorMatrixIO() { matrix.mirrorMatrixIO(); }

    @FXML
    protected void mapInputOneToAllOutputs() {
        mapInputToAllOutputs("1");
    }
    @FXML
    protected void mapInputTwoToAllOutputs() {
        mapInputToAllOutputs("2");
    }
    @FXML
    protected void mapInputThreeToAllOutputs() {
        mapInputToAllOutputs("3");
    }
    @FXML
    protected void mapInputFourToAllOutputs() {
        mapInputToAllOutputs("4");
    }
    @FXML
    protected void mapInputFiveToAllOutputs() {
        mapInputToAllOutputs("5");
    }
    @FXML
    protected void mapInputSixToAllOutputs() {
        mapInputToAllOutputs("6");
    }
    @FXML
    protected void mapInputSevenToAllOutputs() {
        mapInputToAllOutputs("7");
    }
    @FXML
    protected void mapInputEightToAllOutputs() {
        mapInputToAllOutputs("8");
    }
    private void mapInputToAllOutputs(String input) { matrix.mapInputToAllOutputs(input); }

    @FXML
    protected void mapInputOneToOutputA() {
        mapInputToOutput("1", "1");
    }
    @FXML
    protected void mapInputTwoToOutputA() {
        mapInputToOutput("2", "1");
    }
    @FXML
    protected void mapInputThreeToOutputA() {
        mapInputToOutput("3", "1");
    }
    @FXML
    protected void mapInputFourToOutputA() {
        mapInputToOutput("4", "1");
    }
    @FXML
    protected void mapInputFiveToOutputA() {
        mapInputToOutput("5", "1");
    }
    @FXML
    protected void mapInputSixToOutputA() {
        mapInputToOutput("6", "1");
    }
    @FXML
    protected void mapInputSevenToOutputA() {
        mapInputToOutput("7", "1");
    }
    @FXML
    protected void mapInputEightToOutputA() {
        mapInputToOutput("8", "1");
    }
    @FXML
    protected void mapInputOneToOutputB() {
        mapInputToOutput("1", "2");
    }
    @FXML
    protected void mapInputTwoToOutputB() {
        mapInputToOutput("2", "2");
    }
    @FXML
    protected void mapInputThreeToOutputB() {
        mapInputToOutput("3", "2");
    }
    @FXML
    protected void mapInputFourToOutputB() {
        mapInputToOutput("4", "2");
    }
    @FXML
    protected void mapInputFiveToOutputB() {
        mapInputToOutput("5", "2");
    }
    @FXML
    protected void mapInputSixToOutputB() {
        mapInputToOutput("6", "2");
    }
    @FXML
    protected void mapInputSevenToOutputB() {
        mapInputToOutput("7", "2");
    }
    @FXML
    protected void mapInputEightToOutputB() {
        mapInputToOutput("8", "2");
    }
    @FXML
    protected void mapInputOneToOutputC() {
        mapInputToOutput("1", "3");
    }
    @FXML
    protected void mapInputTwoToOutputC() {
        mapInputToOutput("2", "3");
    }
    @FXML
    protected void mapInputThreeToOutputC() {
        mapInputToOutput("3", "3");
    }
    @FXML
    protected void mapInputFourToOutputC() {
        mapInputToOutput("4", "3");
    }
    @FXML
    protected void mapInputFiveToOutputC() {
        mapInputToOutput("5", "3");
    }
    @FXML
    protected void mapInputSixToOutputC() {
        mapInputToOutput("6", "3");
    }
    @FXML
    protected void mapInputSevenToOutputC() {
        mapInputToOutput("7", "3");
    }
    @FXML
    protected void mapInputEightToOutputC() {
        mapInputToOutput("8", "3");
    }
    @FXML
    protected void mapInputOneToOutputD() {
        mapInputToOutput("1", "4");
    }
    @FXML
    protected void mapInputTwoToOutputD() {
        mapInputToOutput("2", "4");
    }
    @FXML
    protected void mapInputThreeToOutputD() {
        mapInputToOutput("3", "4");
    }
    @FXML
    protected void mapInputFourToOutputD() {
        mapInputToOutput("4", "4");
    }
    @FXML
    protected void mapInputFiveToOutputD() {
        mapInputToOutput("5", "4");
    }
    @FXML
    protected void mapInputSixToOutputD() {
        mapInputToOutput("6", "4");
    }
    @FXML
    protected void mapInputSevenToOutputD() {
        mapInputToOutput("7", "4");
    }
    @FXML
    protected void mapInputEightToOutputD() {
        mapInputToOutput("8", "4");
    }
    @FXML
    protected void mapInputOneToOutputE() {
        mapInputToOutput("1", "5");
    }
    @FXML
    protected void mapInputTwoToOutputE() {
        mapInputToOutput("2", "5");
    }
    @FXML
    protected void mapInputThreeToOutputE() {
        mapInputToOutput("3", "5");
    }
    @FXML
    protected void mapInputFourToOutputE() {
        mapInputToOutput("4", "5");
    }
    @FXML
    protected void mapInputFiveToOutputE() {
        mapInputToOutput("5", "5");
    }
    @FXML
    protected void mapInputSixToOutputE() {
        mapInputToOutput("6", "5");
    }
    @FXML
    protected void mapInputSevenToOutputE() {
        mapInputToOutput("7", "5");
    }
    @FXML
    protected void mapInputEightToOutputE() {
        mapInputToOutput("8", "5");
    }
    @FXML
    protected void mapInputOneToOutputF() {
        mapInputToOutput("1", "6");
    }
    @FXML
    protected void mapInputTwoToOutputF() {
        mapInputToOutput("2", "6");
    }
    @FXML
    protected void mapInputThreeToOutputF() {
        mapInputToOutput("3", "6");
    }
    @FXML
    protected void mapInputFourToOutputF() {
        mapInputToOutput("4", "6");
    }
    @FXML
    protected void mapInputFiveToOutputF() {
        mapInputToOutput("5", "6");
    }
    @FXML
    protected void mapInputSixToOutputF() {
        mapInputToOutput("6", "6");
    }
    @FXML
    protected void mapInputSevenToOutputF() {
        mapInputToOutput("7", "6");
    }
    @FXML
    protected void mapInputEightToOutputF() {
        mapInputToOutput("8", "6");
    }
    @FXML
    protected void mapInputOneToOutputG() {
        mapInputToOutput("1", "7");
    }
    @FXML
    protected void mapInputTwoToOutputG() {
        mapInputToOutput("2", "7");
    }
    @FXML
    protected void mapInputThreeToOutputG() {
        mapInputToOutput("3", "7");
    }
    @FXML
    protected void mapInputFourToOutputG() {
        mapInputToOutput("4", "7");
    }
    @FXML
    protected void mapInputFiveToOutputG() {
        mapInputToOutput("5", "7");
    }
    @FXML
    protected void mapInputSixToOutputG() {
        mapInputToOutput("6", "7");
    }
    @FXML
    protected void mapInputSevenToOutputG() {
        mapInputToOutput("7", "7");
    }
    @FXML
    protected void mapInputEightToOutputG() {
        mapInputToOutput("8", "7");
    }
    @FXML
    protected void mapInputOneToOutputH() {
        mapInputToOutput("1", "8");
    }
    @FXML
    protected void mapInputTwoToOutputH() {
        mapInputToOutput("2", "8");
    }
    @FXML
    protected void mapInputThreeToOutputH() {
        mapInputToOutput("3", "8");
    }
    @FXML
    protected void mapInputFourToOutputH() {
        mapInputToOutput("4", "8");
    }
    @FXML
    protected void mapInputFiveToOutputH() {
        mapInputToOutput("5", "8");
    }
    @FXML
    protected void mapInputSixToOutputH() {
        mapInputToOutput("6", "8");
    }
    @FXML
    protected void mapInputSevenToOutputH() {
        mapInputToOutput("7", "8");
    }
    @FXML
    protected void mapInputEightToOutputH() {
        mapInputToOutput("8", "8");
    }
    private void mapInputToOutput(String input, String output) { matrix.mapInputToOutput(input, output); }

    @FXML
    protected void loadPresetOne() {
        loadPreset("1");
    }
    @FXML
    protected void loadPresetTwo() {
        loadPreset("2");
    }
    @FXML
    protected void loadPresetThree() {
        loadPreset("3");
    }
    @FXML
    protected void loadPresetFour() {
        loadPreset("4");
    }
    @FXML
    protected void loadPresetFive() {
        loadPreset("5");
    }
    @FXML
    protected void loadPresetSix() {
        loadPreset("6");
    }
    @FXML
    protected void loadPresetSeven() {
        loadPreset("7");
    }
    @FXML
    protected void loadPresetEight() {
        loadPreset("8");
    }
    private void loadPreset(String slot) {
        matrix.loadPreset(slot);
        String config = matrix.reqConfig();
        syncUIToMatrixConfig(config);
    }

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
    protected void savePresetOne() {
        savePreset("1");
    }
    @FXML
    protected void savePresetTwo() {
        savePreset("2");
    }
    @FXML
    protected void savePresetThree() {
        savePreset("3");
    }
    @FXML
    protected void savePresetFour() {
        savePreset("4");
    }
    @FXML
    protected void savePresetFive() {
        savePreset("5");
    }
    @FXML
    protected void savePresetSix() {
        savePreset("6");
    }
    @FXML
    protected void savePresetSeven() {
        savePreset("7");
    }
    @FXML
    protected void savePresetEight() {
        savePreset("8");
    }
    private void savePreset(String slot) { matrix.savePreset(slot); }

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