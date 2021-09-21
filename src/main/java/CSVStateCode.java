import com.opencsv.bean.CsvBindByName;
public class CSVStateCode {

        @CsvBindByName(column = "slno", required = true)
        public String slno;

        @CsvBindByName(column = "stateName", required = true)
        public String stateName;

        @CsvBindByName(column = "stateCode", required = true)
        public String stateCode;

        @Override
        public String toString() {
            return "CSVStateCensus{" +
                    "slno='" + slno + '\'' +
                    ", stateName='" + stateName + '\'' +
                    ", stateNumber='" + stateCode + '\'' +
                    '}';
        }
    }
