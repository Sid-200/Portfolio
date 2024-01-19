package portfolio.example.demo.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import portfolio.example.demo.entity.Stock;
import portfolio.example.demo.repository.StockRepository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;


@Service
public class StockServices {
    @Autowired
    private StockRepository stockRepository;

    public void readCsvFileAndUpload(MultipartFile file ) {
        try{
            CSVParser parser = CSVParser.parse(file.getInputStream(),
                                StandardCharsets.UTF_8, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            List<CSVRecord> rows = parser.getRecords();
            for (var row : rows){

                Stock stockUpdating= new Stock(
                        Long.parseLong(row.get("SC_CODE")),
                        row.get("SC_NAME"),
                        row.get("SC_GROUP"),
                        row.get("SC_TYPE"),
                        Double.parseDouble(row.get("OPEN")),
                        Double.parseDouble(row.get("HIGH")),
                        Double.parseDouble(row.get("LOW")),
                        Double.parseDouble(row.get("CLOSE")),
                        Double.parseDouble(row.get("LAST")),
                        Double.parseDouble(row.get("PREVCLOSE")),
                        Long.parseLong(row.get("NO_TRADES")),
                        Long.parseLong(row.get("NO_OF_SHRS")),
                        Long.parseLong(row.get("NET_TURNOV"))
                );
                stockRepository.save(stockUpdating);
            }
    }
        catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Optional<Stock> getStockDetailById(Long stockId) {
       if()
    }

}

