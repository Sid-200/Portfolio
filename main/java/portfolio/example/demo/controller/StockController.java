package portfolio.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import portfolio.example.demo.entity.Stock;
import portfolio.example.demo.helper.Response;
import portfolio.example.demo.service.StockServices;

import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockServices stockServices;
    @PostMapping("/upload")
    ResponseEntity<String>fileUpload(@RequestBody MultipartFile file ){
        if(file.isEmpty()){
            return ResponseEntity.badRequest().body("please upload file");
        }
        else{
            stockServices.readCsvFileAndUpload(file);
            return ResponseEntity.ok("File uploaded and processed successfully");
        }
    }
    @GetMapping("/details/{stockId}")
    ResponseEntity<Response<Stock>>stockDetails(@PathVariable("stockId") Long stockId){
        Optional<Stock> optionalStock =stockServices.getStockDetailById(stockId);
        if(optionalStock.isEmpty()) {
            return Response.failed("Stock not found " , null);
        }
        return Response.success("Stock details retrieved successfully" , optionalStock.get());
}



}
