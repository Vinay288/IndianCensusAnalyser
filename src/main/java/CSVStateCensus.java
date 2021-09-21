import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
    @CsvBindByName(column = "slno", required = true)
    public String slno;

    @CsvBindByName(column = "stateName", required = true)
    public String stateName;

    @CsvBindByName(column = "population", required = true)
    public String population;

    @Override
    public String toString() {
        return "CSVStateCensus{" +
                "slno='" + slno + '\'' +
                ", stateName='" + stateName + '\'' +
                ", stateNumber='" + population + '\'' +
                '}';
    }
}
