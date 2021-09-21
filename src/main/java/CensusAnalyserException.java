public class CensusAnalyserException extends RuntimeException {
    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    enum ExceptionType {
        CENSUS_FILE_PROBLEM, UNABLE_TO_PARSE, NO_CENSUS_DATA, CSV_FILE_INTERNAL_ISSUES
    }
}
