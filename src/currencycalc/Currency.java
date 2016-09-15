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
 * This enum holds all of the possible currencies 
 * it also holds the getRate method that calls the yahoo api
 * @author ross
 */
public enum Currency {
    // construct all of the posible currencies
    GBP("Great british pound", "£"), 
    BTC("Bitcoin", "Ƀ"),
    EUR("Euro", "€"),
    USD("US Dollar", "$"),
    INR("Indian Rupee", "₹"), 
    AUD("Australian dollar", "a$"), 
    CAD("Canadian dollar", "c$"), 
    SGD("Singapore dollar", "s$");
    
    private final String description, symbol;

    // enum constructor can onle be called inside enum
    Currency(String description, String symbol) {
        this.description = description;
        this.symbol = symbol;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Getter for symbol
    public String getSymbol() {
        return symbol;
    }
    
    /**
     * getRate
     * @param against - the currency to get the rate against
     * @return double - the rate
     * @throws RuntimeException - any network issues or missing rates 
     */
    public double getRate(Currency against) throws RuntimeException {
        // url of yahoo finance api - requesting back a format of JSON
        String baseURL =  "https://query.yahooapis.com/v1/public/yql?format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=&q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20";
        // create string of the two currecies ready for the request
        // NOTE: - when you have two objects that you want to convert to a string and concatinate
        // --- then you only need to toString one of them and the other is auto casted as a string
        String compare = this.toString() + against;
        // wrap it in brackets and string it ready for the api
        String compareSufix = "(\"" + compare + "\")";
        
        // set the response as null so its outside the scope of the try catch
        String response = null;
        
        try {
            // build the url and connection
            URL url = new URL(baseURL + compareSufix);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // the api is a GET so we need to set the type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            
            // if connection fails throw an exception
            if(connection.getResponseCode() != 200) {
                throw new RuntimeException("Cannot connect to Yahoo Finance: " + connection.getResponseMessage());
            }
            
            // put url stream into buffer
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            // collect the buffer into the response string 
            response = buffer.lines().collect(Collectors.joining());
        } catch (MalformedURLException e) {
            // will only error if the URL is incorrect
            System.err.println("Internal URL error: " + baseURL + compareSufix);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        
        // parse the JSON object and get the rate
        JSONObject JSONResponse = new JSONObject(response);
        String rateString = JSONResponse
                .getJSONObject("query")
                .getJSONObject("results")
                .getJSONObject("rate")
                .getString("Rate");
                       
        // parse the rate as a double
        Double rateDouble = Double.parseDouble(rateString);
        
        // if the rate is empty throw and exception 
        if (rateDouble == 0) throw new RuntimeException("No rate avalible for " + compare);
        
        // return the rate
        return rateDouble;
    }
}
