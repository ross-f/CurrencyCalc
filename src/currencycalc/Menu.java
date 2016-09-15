package currencycalc;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * This class creates the a menu panel with 3 buttons
 * @author ross
 */
public class Menu extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    public Menu() {
        // Create the initial GUI created by beans
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        converterButton = new javax.swing.JButton();
        calcButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();

        converterButton.setText("Currency converter");

        calcButton.setText("Calculator");

        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(converterButton)
                        .addGap(45, 45, 45)
                        .addComponent(calcButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(helpButton)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(converterButton)
                    .addComponent(calcButton))
                .addGap(43, 43, 43)
                .addComponent(helpButton)
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Method called when the help button is pressed, shows a dialog 
    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        // dialog is created as final as it is never changed
        final JDialog dialog =  new JDialog();
        
        // Make dialog on top of app
        dialog.setAlwaysOnTop(true);
        // Content to show
        JOptionPane.showMessageDialog(dialog, "This is a currency converter and calculator app. \n"
                + "Click one of the options on the menu to be \n"
                + "taken to the relvant page. \n\n"
                + ""
                + "The currency converter page allows you to choose \n"
                + "two currencies from a drop down and then enter \n"
                + "an ammount to convert. Clicking the convert button \n"
                + "get the current rates from Yahoo finance and do the math! \n\n"
                + ""
                + "The calculator page will give you a basic calculator \n"
                + "where you can enter numbers then add, subtract, multiply or divide \n "
                + "them by more numbers that you enter. It can also do more complex \n"
                + "procedures like workout squareroots or percentages.");
    }//GEN-LAST:event_helpButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton calcButton;
    public javax.swing.JButton converterButton;
    private javax.swing.JButton helpButton;
    // End of variables declaration//GEN-END:variables
}
