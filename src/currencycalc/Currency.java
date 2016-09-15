/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencycalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;
import org.json.JSONObject;

/**
 *
 * @author ross
 */
public enum Currency {
    GBP("Great british pound", "£"), 
    BTC("Bitcoin", "Ƀ"),
    EUR("Euro", "€"),
    USD("US Dollar", "$"),
    INR("Indian Rupee", "₹"), 
    AUD("Australian dollar", "a$"), 
    CAD("Canadian dollar", "c$"), 
    SGD("Singapore dollar", "s$");
    
    private final String description, symbol;

    Currency(String description, String symbol) {
        this.description = description;
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public String getSymbol() {
        return symbol;
    }
    
    public double getRate(Currency against) throws RuntimeException {
        String baseURL =  "https://query.yahooapis.com/v1/public/yql?format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=&q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20";
        String compare = this.toString() + against;
        String compareSufix = "(\"" + compare + "\")";
        
        String response = null;
        
        try {
            URL url = new URL(baseURL + compareSufix);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            
            if(connection.getResponseCode() != 200) {
                throw new RuntimeException("Cannot connect to Yahoo Finance");
            }
            
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            response = buffer.lines().collect(Collectors.joining());
        } catch (MalformedURLException e) {
            System.err.println("Internal URL error: " + baseURL + compareSufix);
        } catch (IOException e) {
            System.err.println("Internal connecton error");
        }
        
        JSONObject JSONResponse = new JSONObject(response);
        String rateString = JSONResponse
                .getJSONObject("query")
                .getJSONObject("results")
                .getJSONObject("rate")
                .getString("Rate");
                       
        Double rateDouble = Double.parseDouble(rateString);
        
        if (rateDouble == 0 ) throw new RuntimeException("No rate avalible for " + compare);
        
        return rateDouble;
    }
}
