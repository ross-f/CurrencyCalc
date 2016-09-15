package currencycalc;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 * This class will create a currency converter that can be used 
 * to convert different types of currency with data from yahoo
 * finance.
 * @author ross
 */
public class CurrencyConverter extends javax.swing.JPanel {
    ArrayList<Currency> currencies;
    String[] currencyStrings;

    /**
     * Creates new form CurrencyConverter
     */
    public CurrencyConverter() {
        // Craete a list of currencies so they we can itterate through them
        currencies = new ArrayList<>(); 
        currencies.add(Currency.GBP);
        currencies.add(Currency.EUR);
        currencies.add(Currency.AUD);
        currencies.add(Currency.BTC);
        currencies.add(Currency.CAD);
        currencies.add(Currency.INR);
        currencies.add(Currency.SGD);
        currencies.add(Currency.USD);
        
        // Create an array of the strings of currencies so we can use them in the dropdown box model
        currencyStrings = new String[currencies.size()];
        
        // copy the names of the currencies to the array
        for (int i = 0; i < currencies.size(); i++){
            currencyStrings[i] = currencies.get(i).toString();
        }
        
        // create the inital components
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        firstCurrency = new javax.swing.JComboBox<>();
        secondCurrency = new javax.swing.JComboBox<>();
        firstCurrencyAmount = new javax.swing.JTextField();
        seccondCurrencyAmmount = new javax.swing.JLabel();
        claculateButton = new javax.swing.JButton();
        firstCurrencySymbol = new javax.swing.JLabel();
        secondCurrencySymbol = new javax.swing.JLabel();
        connectionStatus = new javax.swing.JLabel();

        backButton.setText("Back to menu");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Currency Converter");

        firstCurrency.setModel(new DefaultComboBoxModel<String>(currencyStrings));
        firstCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstCurrencyActionPerformed(evt);
            }
        });

        secondCurrency.setModel(new DefaultComboBoxModel<String>(currencyStrings));
        secondCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondCurrencyActionPerformed(evt);
            }
        });

        firstCurrencyAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstCurrencyAmountActionPerformed(evt);
            }
        });

        seccondCurrencyAmmount.setText("0");

        claculateButton.setText("Calculate");
        claculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claculateButtonActionPerformed(evt);
            }
        });

        firstCurrencySymbol.setText("£");

        secondCurrencySymbol.setText("£");

        connectionStatus.setForeground(new java.awt.Color(0, 204, 51));
        connectionStatus.setText("Internet connection required");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstCurrencySymbol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(firstCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(secondCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(firstCurrencyAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(secondCurrencySymbol)
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(connectionStatus)
                                .addGap(22, 22, 22))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(claculateButton)
                                .addGap(59, 59, 59)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seccondCurrencyAmmount, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secondCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstCurrencyAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstCurrencySymbol)
                    .addComponent(secondCurrencySymbol)
                    .addComponent(seccondCurrencyAmmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(claculateButton)
                .addGap(30, 30, 30)
                .addComponent(connectionStatus)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void firstCurrencyAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstCurrencyAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstCurrencyAmountActionPerformed

    // method called when the calculate button is pressed
    private void claculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claculateButtonActionPerformed
        connectionStatus.setText("Connecting to Yahoo Finance");
        
        // Use the name of the value in the drop down to get the full currency
        Currency firstCurrencyValue = currencies.get(firstCurrency.getSelectedIndex());
        Currency seccondCurrencyValue = currencies.get(secondCurrency.getSelectedIndex());
        
        // rate must be kept out of the scope of the try catch so it can be used later
        double rate;
        
        try {
            // wrap in try catch because get rate throws an expection when there is a connection issue
            rate = firstCurrencyValue.getRate(seccondCurrencyValue);
        } catch (RuntimeException e) {
            // message is thrown in the exception and then used here
            connectionStatus.setText(e.getMessage());
            // leave this method 
            return;
        }
        
        // get the text out of the model and parse it as a double
        // times it by the rate from yahoo finance
        // Round it to the nearsest 2nd decimal place
        // store the value as a double
        double seccondCurrencyAmmountDouble =
                Math.round(Double.parseDouble(firstCurrencyAmount.getText()) * rate);
       
        // set the result to what was worked out above.
        seccondCurrencyAmmount.setText(String.valueOf(seccondCurrencyAmmountDouble));
        
        // Set the text back to its original content
        connectionStatus.setText("Internet connection required");
    }//GEN-LAST:event_claculateButtonActionPerformed

    private void firstCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstCurrencyActionPerformed
        // when the first dropdown is changed - change the symbol
        firstCurrencySymbol.setText(currencies.get(firstCurrency.getSelectedIndex()).getSymbol());
    }//GEN-LAST:event_firstCurrencyActionPerformed

    private void secondCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondCurrencyActionPerformed
        // when the second dropdown is changed - change the symbol
        secondCurrencySymbol.setText(currencies.get(secondCurrency.getSelectedIndex()).getSymbol());
    }//GEN-LAST:event_secondCurrencyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton backButton;
    private javax.swing.JButton claculateButton;
    private javax.swing.JLabel connectionStatus;
    private javax.swing.JComboBox<String> firstCurrency;
    private javax.swing.JTextField firstCurrencyAmount;
    private javax.swing.JLabel firstCurrencySymbol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel seccondCurrencyAmmount;
    private javax.swing.JComboBox<String> secondCurrency;
    private javax.swing.JLabel secondCurrencySymbol;
    // End of variables declaration//GEN-END:variables
}
