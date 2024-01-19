package portfolio.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stocks")
@Getter
public class Stock {
    @Id
    private long stockId;
    private String stockName;
    String stockGroup;
    String stockType;


    private Double openingPrice;
    private Double highestPrice;
    private Double lowestPrice;
    private Double closingPrice;
    private Double lastPrice;
    private Double prevClosePrice;
    private long numberOfTrades;
    private long numberOfStocks;
    private long netTurnOver;


}
