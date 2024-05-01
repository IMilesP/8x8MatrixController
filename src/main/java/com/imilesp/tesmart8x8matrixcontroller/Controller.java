package com.imilesp.tesmart8x8matrixcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private Button a1;
    @FXML
    private Button a2;
    @FXML
    private Button a3;
    @FXML
    private Button a4;
    @FXML
    private Button a5;
    @FXML
    private Button a6;
    @FXML
    private Button a7;
    @FXML
    private Button a8;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button c1;
    @FXML
    private Button c2;
    @FXML
    private Button c3;
    @FXML
    private Button c4;
    @FXML
    private Button c5;
    @FXML
    private Button c6;
    @FXML
    private Button c7;
    @FXML
    private Button c8;
    @FXML
    private Button d1;
    @FXML
    private Button d2;
    @FXML
    private Button d3;
    @FXML
    private Button d4;
    @FXML
    private Button d5;
    @FXML
    private Button d6;
    @FXML
    private Button d7;
    @FXML
    private Button d8;
    @FXML
    private Button e1;
    @FXML
    private Button e2;
    @FXML
    private Button e3;
    @FXML
    private Button e4;
    @FXML
    private Button e5;
    @FXML
    private Button e6;
    @FXML
    private Button e7;
    @FXML
    private Button e8;
    @FXML
    private Button f1;
    @FXML
    private Button f2;
    @FXML
    private Button f3;
    @FXML
    private Button f4;
    @FXML
    private Button f5;
    @FXML
    private Button f6;
    @FXML
    private Button f7;
    @FXML
    private Button f8;
    @FXML
    private Button g1;
    @FXML
    private Button g2;
    @FXML
    private Button g3;
    @FXML
    private Button g4;
    @FXML
    private Button g5;
    @FXML
    private Button g6;
    @FXML
    private Button g7;
    @FXML
    private Button g8;
    @FXML
    private Button h1;
    @FXML
    private Button h2;
    @FXML
    private Button h3;
    @FXML
    private Button h4;
    @FXML
    private Button h5;
    @FXML
    private Button h6;
    @FXML
    private Button h7;
    @FXML
    private Button h8;
    private Button[][] grid;
    private Button[] currentlyOn;

    @FXML
    protected void initialize() {
        matrix = new Matrix();
        connected = false;
        grid = new Button[8][8];
        currentlyOn = new Button[8];
        grid[0][0] = a1;
        grid[1][0] = a2;
        grid[2][0] = a3;
        grid[3][0] = a4;
        grid[4][0] = a5;
        grid[5][0] = a6;
        grid[6][0] = a7;
        grid[7][0] = a8;
        grid[0][1] = b1;
        grid[1][1] = b2;
        grid[2][1] = b3;
        grid[3][1] = b4;
        grid[4][1] = b5;
        grid[5][1] = b6;
        grid[6][1] = b7;
        grid[7][1] = b8;
        grid[0][2] = c1;
        grid[1][2] = c2;
        grid[2][2] = c3;
        grid[3][2] = c4;
        grid[4][2] = c5;
        grid[5][2] = c6;
        grid[6][2] = c7;
        grid[7][2] = c8;
        grid[0][3] = d1;
        grid[1][3] = d2;
        grid[2][3] = d3;
        grid[3][3] = d4;
        grid[4][3] = d5;
        grid[5][3] = d6;
        grid[6][3] = d7;
        grid[7][3] = d8;
        grid[0][4] = e1;
        grid[1][4] = e2;
        grid[2][4] = e3;
        grid[3][4] = e4;
        grid[4][4] = e5;
        grid[5][4] = e6;
        grid[6][4] = e7;
        grid[7][4] = e8;
        grid[0][5] = f1;
        grid[1][5] = f2;
        grid[2][5] = f3;
        grid[3][5] = f4;
        grid[4][5] = f5;
        grid[5][5] = f6;
        grid[6][5] = f7;
        grid[7][5] = f8;
        grid[0][6] = g1;
        grid[1][6] = g2;
        grid[2][6] = g3;
        grid[3][6] = g4;
        grid[4][6] = g5;
        grid[5][6] = g6;
        grid[6][6] = g7;
        grid[7][6] = g8;
        grid[0][7] = h1;
        grid[1][7] = h2;
        grid[2][7] = h3;
        grid[3][7] = h4;
        grid[4][7] = h5;
        grid[5][7] = h6;
        grid[6][7] = h7;
        grid[7][7] = h8;
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
            syncUIToMatrixConfig();
        }
    }

    private void syncUIToMatrixConfig() {
        String config = matrix.reqConfig();
        int[] configCol = new int[8];
        int[] configRow = new int[8];
        configRow[0] = config.charAt(6) - '0';
        configCol[0] = config.charAt(8) - '0';
        configRow[1] = config.charAt(11) - '0';
        configCol[1] = config.charAt(13) - '0';
        configRow[2] = config.charAt(16) - '0';
        configCol[2] = config.charAt(18) - '0';
        configRow[3] = config.charAt(21) - '0';
        configCol[3] = config.charAt(23) - '0';
        configRow[4] = config.charAt(26) - '0';
        configCol[4] = config.charAt(28) - '0';
        configRow[5] = config.charAt(31) - '0';
        configCol[5] = config.charAt(33) - '0';
        configRow[6] = config.charAt(36) - '0';
        configCol[6] = config.charAt(38) - '0';
        configRow[7] = config.charAt(41) - '0';
        configCol[7] = config.charAt(43) - '0';
        for(int i = 0; i < 8; i++) {
            buttonSelected(grid[configCol[i] - 1][configRow[i] - 1]);
            currentlyOn[i] = grid[configCol[i] - 1][configRow[i] - 1];
        }
    }

    private void buttonSelected(Button selected) {
        selected.setStyle("-fx-background-color: slateblue;");
    }
    private void buttonUnselected(Button unselected) {
        unselected.setStyle(
                "-fx-font-family: \"Consolas\";\n" +
                "-fx-base: #3f474f;\n" +
                "-fx-accent: #e7eff7;\n" +
                "-fx-default-button: #7f878f;\n" +
                "-fx-focus-color: #efefef;\n" +
                "-fx-faint-focus-color: #efefef22;\n" +
                "-fx-focused-text-base-color : ladder(\n" +
                "   -fx-selection-bar,\n" +
                "   -fx-light-text-color 45%,\n" +
                "   -fx-dark-text-color 46%,\n" +
                "   -fx-dark-text-color 59%,\n" +
                "   -fx-mid-text-color 60%\n" +
                ");\n" +
                "-fx-focused-mark-color : -fx-focused-text-base-color;");
    }

    @FXML
    protected void disconnect() { matrix.disconnect(); }

    @FXML
    protected void findMatrix() {
        connected = matrix.findMatrix(subnet.getText() + mask.getText());
        if(connected) {
            syncUIToMatrixConfig();
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
    private void mapInputToAllOutputs(String input) {
        if(matrix.mapInputToAllOutputs(input)) {
            for(int i = 0; i < 8; i++) {
                buttonUnselected(currentlyOn[i]);
                buttonSelected(grid[Integer.parseInt(input) - 1][i]);
                currentlyOn[i] = grid[Integer.parseInt(input) - 1][i];
            }
        }
    }

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
    private void mapInputToOutput(String input, String output) {
        if(matrix.mapInputToOutput(input, output)) {
            buttonUnselected(currentlyOn[Integer.parseInt(output) - 1]);
            buttonSelected(grid[Integer.parseInt(input) - 1][Integer.parseInt(output) - 1]);
            currentlyOn[Integer.parseInt(output) - 1] = grid[Integer.parseInt(input) - 1][Integer.parseInt(output) - 1];
        }
    }

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
        syncUIToMatrixConfig();
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