import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class StateCensusAnalyser implements StateAnalyserIf {

    @Override
    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
        ArrayList<CSVStateCensus> csvList = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
                    .withType(CSVStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            for (CSVStateCensus csvStateCensus : (Iterable<CSVStateCensus>) csvToBean) {
                csvList.add(csvStateCensus);
            }
            return csvList.size();
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);

        } catch (NullPointerException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
        }

    }

    @Override
    public int loadStateCodeData(String csvFilePath) throws CensusAnalyserException {
        ArrayList<CSVStateCode> csvList = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CsvToBean<CSVStateCode> csvToBean = new CsvToBeanBuilder<CSVStateCode>(reader)
                    .withType(CSVStateCode.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            for (CSVStateCode csvStateCode : (Iterable<CSVStateCode>) csvToBean) {
                csvList.add(csvStateCode);
            }
            return csvList.size();
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);

        } catch (NullPointerException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.NO_CENSUS_DATA);
        } catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
        }

    }
}
