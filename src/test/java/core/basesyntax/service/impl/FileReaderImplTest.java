package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FileReaderImplTest {
    private static FileReader fileReader;

    @Before
    public void setUp() {
        fileReader = new FileReaderImpl();
    }

    @Test
    public void readFromFile_ValidPath_Ok() {
        String validPathToFile = "src/test/resources/Transactions.csv";
        List<String> expected = new ArrayList<>();
        expected.add("b,banana,20");
        expected.add("b,apple,100");
        expected.add("s,banana,100");
        expected.add("p,banana,13");
        expected.add("r,apple,10");
        expected.add("p,apple,20");
        expected.add("p,banana,5");
        expected.add("s,banana,50");
        List<String> actual = fileReader.readFromFile(validPathToFile);
        assertEquals(expected,actual);
    }

    @Test(expected = RuntimeException.class)
    public void readFromFile_NotValidPath_NotOk() {
        String notValidPathToFile = "src/test/resources/NotValidTransactions.csv";
        fileReader.readFromFile(notValidPathToFile);
    }

    @Test(expected = RuntimeException.class)
    public void readFromFile_NullPath_NotOk() {
        String notValidPathToFile = null;
        fileReader.readFromFile(notValidPathToFile);
    }
}