package currencycalc;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * This is the main class where the program starts, also implements 
 * an ActionListener to allow the the events of handling buttons to
 * be managed.
 * @author ross
 */
public class CurrencyCalc implements ActionListener{
    // Atributes for the current object
    JFrame container;
    Container content;
    CardLayout layout;
    Menu menu;
    // class cannot be called converter as it is reserved
    CurrencyConverter converter;
    Calculator calculator;
    
    private 
    
    // constructor fot this class
    CurrencyCalc() {
        // Create the window that wil hold the program
        container = new JFrame("Currency converter");
        
        // kill the java vm if the app is closed
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // card layout requires an opject of just content to focus on
        // so the frame content must be placed in its own object
        content = container.getContentPane();
    
        // Create the card layout
        layout = new CardLayout();
        
        // Apply layout to the content
        content.setLayout(layout);
        
        // build the pages inside the arraylist
        menu = new Menu();
        converter = new CurrencyConverter();
        calculator = new Calculator();
        
        // add each page to the content and give them names so they can be accessed by the card layout
        content.add(menu, "menu");
        content.add(converter, "converter");
        content.add(calculator, "calculator");

        // Change the size of the window to the smallest panel
        container.pack();
        
        // Show the window
        container.setVisible(true);
    }
    
    // This is where the program starts
    public static void main(String[] args) {
        // build the gui
        CurrencyCalc app = new CurrencyCalc();
        
        // add action listeners for each button
        app.menu.calcButton.addActionListener(app);
        app.menu.converterButton.addActionListener(app);
        app.converter.backButton.addActionListener(app);
        app.calculator.backButton.addActionListener(app);
    }

     /**
     * void actionPerformed
     * This method will Override the actionPerformed method that is part of
     * the ActionListener interface and will be called whenever an action
     * element that has had the current object (startFrame) added to it.
     *
     * This method should never be called in code that is written in Java files.
     * It will be automatically called by the classes that use GUI elements
     * and have action listeners.
     *
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        // get the text inside the button
        switch (ae.getActionCommand()) {
            case("Currency converter"): {
                // show the currency converter
                layout.show(content, "converter");
                break;
            }
            
            case("Calculator"): {
                // show the calculator
                layout.show(content, "calculator");
                break;
            }
            
            case("Back to menu"): {
                // show the menu
                layout.show(content, "menu");
                break;
            }
            
            // Throw an execption if the event isn't found - helps with debuging
            default: throw new UnsupportedOperationException("No action for " + ae.getActionCommand());
        }
        
    }
    
}
