import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CensusAnalyserTest {
    @Test
    public void givenStateCensusCSVFile_WhenCorrect_ReturnsCorrectRecords() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData("./src/main/resources/State.csv");
            assertEquals(4, numOfRecords);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenWrongDelimiter_ShouldThrowException() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData("./src/main/resources/State_WrongDelimiter.csv");
        } catch (CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES,e.type);
        }
    }

}
