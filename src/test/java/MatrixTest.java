import com.imilesp.tesmart8x8matrixcontroller.Matrix;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MatrixTest {
    private Matrix matrix;

    @Before
    public void setup() {
        matrix = new Matrix();
        matrix.connect("192.168.5.5", "5000");
    }

    @After
    public void terminate() {
        matrix.disconnect();
    }

    @Test
    public void testFindMatrix() {
        String address = matrix.findMatrix("192.168.5.0/27");
        assertNotNull(address);
    }

    @Test
    public void testMirrorMatrixIO() {
        matrix.mirrorMatrixIO();
        assertEquals("LINK:O1I1;O2I2;O3I3;O4I4;O5I5;O6I6;O7I7;O8I8;END", matrix.reqConfig());
    }

    @Test
    public void testMapInputToAllOutputs() {
        matrix.mapInputToAllOutputs("1");
        assertEquals("LINK:O1I1;O2I1;O3I1;O4I1;O5I1;O6I1;O7I1;O8I1;END", matrix.reqConfig());
    }

    @Test
    public void testMapInputToOutput() {
        matrix.mapInputToOutput("8", "1");
        matrix.mapInputToOutput("8", "2");
        matrix.mapInputToOutput("8", "3");
        matrix.mapInputToOutput("8", "4");
        matrix.mapInputToOutput("8", "5");
        matrix.mapInputToOutput("8", "6");
        matrix.mapInputToOutput("8", "7");
        matrix.mapInputToOutput("8", "8");
        assertEquals("LINK:O1I8;O2I8;O3I8;O4I8;O5I8;O6I8;O7I8;O8I8;END", matrix.reqConfig());
    }

    @Test
    public void testReqConfig() {
        assertNotNull(matrix.reqConfig());
    }

    @Test
    public void testSaveAndLoadPreset() {
        matrix.mapInputToAllOutputs("3");
        matrix.savePreset("8");
        matrix.mapInputToAllOutputs("2");
        matrix.loadPreset("8");
        assertEquals("LINK:O1I3;O2I3;O3I3;O4I3;O5I3;O6I3;O7I3;O8I3;END", matrix.reqConfig());
    } //bug here... maybe not reading all output from matrix?? affects doing stuff after... not an issue with reqConfig it seems...

    @Test
    public void testSaveAndLoadLabels() {
        for(int i = 0; i < 16; i++) {
            matrix.saveLabel("label " + (i + 1), i + 1);
        }
        assertEquals(new ArrayList<>(List.of(
                "label 1",
                "label 2",
                "label 3",
                "label 4",
                "label 5",
                "label 6",
                "label 7",
                "label 8",
                "label 9",
                "label 10",
                "label 11",
                "label 12",
                "label 13",
                "label 14",
                "label 15",
                "label 16"
        )), matrix.loadLabels());
    }

    @Test
    public void testResetLabels() {
        matrix.resetLabels();
        assertEquals(new ArrayList<>(List.of(
                "Output A",
                "Output B",
                "Output C",
                "Output D",
                "Output E",
                "Output F",
                "Output G",
                "Output H",
                "Input 1",
                "Input 2",
                "Input 3",
                "Input 4",
                "Input 5",
                "Input 6",
                "Input 7",
                "Input 8"
        )), matrix.loadLabels());
    }

    @Test
    public void testReqAddress() {
        assertEquals("192.168.005.005", matrix.reqAddress());
    }

    @Test
    public void testReqPort() {
        assertEquals("05000", matrix.reqPort());
    }

    @Test
    public void testReqGateway() {
        assertEquals("192.168.005.001", matrix.reqGateway());
    }

    @Test
    public void testReqMask() {
        assertEquals("255.255.255.000", matrix.reqMask());
    }

}
