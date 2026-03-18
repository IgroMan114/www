/*

Program: LocalBank.java          Last Date of this Revision: March 9, 2026

Purpose: The LocalBank application allows accounts to be opened, modified, and closed.
Each account has a unique account number, which is required for all transactions. Transactions include deposits and withdrawals.
An account balance can also be checked. The LocalBank interface should provide a menu of options. Depending on the option selected, additional input may be needed.
When a transaction is performed, updated account information should be displayed.

Author: Ihor Nedobor, 
School: CHHS
Course: Computer Programming 30
  

*/
package chapter10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocalBank {

    // Bank object that will handle all account operations (add, delete, deposit, etc.)
    
	Bank bank = new Bank();

    // Main window and all Swing components used in the GUI
    
    private JFrame frame;
    private JTextField account;
    private JTextField amount;
    private JTextField firstN;
    private JTextField lastN;
    private JTextField balance;
    JComboBox action;
    JTextArea accountinfo, error;
    JLabel actionlbl, accountlbl, amountlbl, firstNlbl, lastNlbl, balancelbl, infolbl;
    JButton process;
    public String fname = " ", lname = " ";
    public double bal = -1.0;

    /**
    * Launch the application.
    */
    public static void main(String[] args) {
    	
        // Ensures that GUI creation runs on the Event Dispatch Thread (EDT)
    	
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Create the window and show it
                    LocalBank window = new LocalBank();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
    * Create the application.
    */
    public LocalBank() {
        // Initialize and lay out all components
        initialize();
    }

    /**
    * Disable all text fields (used when no specific action is selected).
    */
    public void disableTextFields()
    {
        account.setEnabled(false);
        amount.setEnabled(false);
        firstN.setEnabled(false);
        lastN.setEnabled(false);
        balance.setEnabled(false);
    }

    /**
    * Clear the content of all text fields.
    */
    public void cleanTextFields()
    {
        account.setText("");
        amount.setText("");
        firstN.setText("");
        lastN.setText("");
        balance.setText("");
    }

    /**
    * Initialize the contents of the frame.
    */
    private void initialize() {
        // Create main frame
        frame = new JFrame();
        frame.setBounds(100, 100, 630, 590);     // Set window size and position
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with background color and null layout (absolute positioning)
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(188, 204, 181));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        // Label prompting user to select an action
        
        actionlbl = new JLabel("Select an action:");
        actionlbl.setForeground(new Color(0, 0, 0));
        actionlbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        actionlbl.setBounds(42, 28, 271, 23);
        panel.add(actionlbl);

        // Text field for account number
        
        account = new JTextField();
        account.setBounds(42, 157, 530, 31);
        panel.add(account);
        account.setColumns(10);

        // Text field for deposit/withdrawal amount
        
        amount = new JTextField();
        amount.setColumns(10);
        amount.setBounds(42, 224, 530, 31);
        panel.add(amount);

        // Text field for first name (used when adding an account)
        
        firstN = new JTextField();
        firstN.setColumns(10);
        firstN.setBounds(42, 288, 530, 31);
        panel.add(firstN);

        // Text field for last name (used when adding an account)
        
        lastN = new JTextField();
        lastN.setColumns(10);
        lastN.setBounds(42, 352, 530, 31);
        panel.add(lastN);

        // Text field for initial/beginning balance
        
        balance = new JTextField();
        balance.setColumns(10);
        balance.setBounds(42, 418, 530, 31);
        panel.add(balance);

        // Label for account number
        
        accountlbl = new JLabel("Account number:");
        accountlbl.setForeground(new Color(0, 0, 0));
        accountlbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        accountlbl.setBounds(42, 135, 113, 23);
        panel.add(accountlbl);

        // Label for amount field
        
        amountlbl = new JLabel("Amount of deposit/withdrawal:");
        amountlbl.setForeground(new Color(0, 0, 0));
        amountlbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        amountlbl.setBounds(42, 199, 178, 23);
        panel.add(amountlbl);

        // Label for first name
        
        firstNlbl = new JLabel("First Name:");
        firstNlbl.setForeground(new Color(0, 0, 0));
        firstNlbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        firstNlbl.setBounds(42, 263, 113, 23);
        panel.add(firstNlbl);

        // Label for last name
        
        lastNlbl = new JLabel("Last Name:");
        lastNlbl.setForeground(new Color(0, 0, 0));
        lastNlbl.setBackground(new Color(245, 245, 245));
        lastNlbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        lastNlbl.setBounds(42, 330, 113, 23);
        panel.add(lastNlbl);

        // Label for beginning balance
        
        balancelbl = new JLabel("Beginning balance:");
        balancelbl.setForeground(new Color(0, 0, 0));
        balancelbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        balancelbl.setBounds(42, 394, 113, 23);
        panel.add(balancelbl);

        // Instruction label, will be updated when certain fields must be filled
        
        infolbl = new JLabel("Complete the information in RED.");
        infolbl.setForeground(new Color(0, 0, 0));
        infolbl.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        infolbl.setBounds(42, 95, 530, 23);
        panel.add(infolbl);

        // Text area to show account info, result messages, or errors
        
        accountinfo = new JTextArea();
        accountinfo.setFont(new Font("Monospaced", Font.PLAIN, 11));
        accountinfo.setBackground(new Color(188, 204, 181));
        accountinfo.setBounds(42, 460, 189, 80);
        panel.add(accountinfo);

        // Combo box to select which action to perform on the bank
        
        action = new JComboBox();
        action.setModel(new DefaultComboBoxModel(new String[] {"", "Add Account", "Delete Account", "Deposit", "Withdrawal", "Check Balance"}));
        
        // ItemListener to react when the selected action changes
        
        action.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e)
            {
            	
                // When "Add Account" is chosen, enable name and balance fields
            	
                if(action.getSelectedItem().equals("Add Account"))
                {
                    firstN.setEnabled(true);
                    lastN.setEnabled(true);
                    balance.setEnabled(true);
                    
                    // Turn corresponding labels red to indicate required fields
                    
                    firstNlbl.setForeground(new Color(208,47 ,47));
                    lastNlbl.setForeground(new Color(208,47 ,47));
                    balancelbl.setForeground(new Color(208,47 ,47));
                    
                    // Disable the combo box so the user finishes this action first
                    
                    action.setEnabled(false);
                }
                
                // When "Delete Account" is chosen, only account field is required
                
                else if(action.getSelectedItem().equals("Delete Account"))
                {
                    account.setEnabled(true);
                    accountlbl.setForeground(new Color(208,47 ,47));
                    action.setEnabled(false);
                }
                
                // When "Deposit" is chosen, account and amount fields are required
                
                else if(action.getSelectedItem().equals("Deposit"))
                {
                    account.setEnabled(true);
                    amount.setEnabled(true);
                    accountlbl.setForeground(new Color(208,47 ,47));
                    amountlbl.setForeground(new Color(208,47 ,47));
                    action.setEnabled(false);
                }
                
                // When "Withdrawal" is chosen, account and amount fields are required
                
                else if(action.getSelectedItem().equals("Withdrawal"))
                {
                    account.setEnabled(true);
                    amount.setEnabled(true);
                    accountlbl.setForeground(new Color(208,47 ,47));
                    amountlbl.setForeground(new Color(208,47 ,47));
                    action.setEnabled(false);
                }
                
                // When "Check Balance" is chosen, only account field is required
                
                else if(action.getSelectedItem().equals("Check Balance"))
                {
                    account.setEnabled(true);
                    accountlbl.setForeground(new Color(208,47 ,47));
                    action.setEnabled(false);
                }
            }
        });
        action.setBounds(42, 53, 530, 31);
        panel.add(action);

        // Button to process whichever transaction is currently selected
        
        process = new JButton("Process transaction");
        process.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                // Read and trim all input values from the text fields
            	
                String fNameInput = firstN.getText().trim();
                String lNameInput = lastN.getText().trim();
                String balInput = balance.getText().trim();
                String accountInput = account.getText().trim();
                String amountInput = amount.getText().trim();

                // Validate required fields for adding an account
                
                if((fNameInput.isEmpty() || lNameInput.isEmpty() || balInput.isEmpty()) && action.getSelectedItem().equals("Add Account"))
                {
                    accountinfo.setText("Please fill in First Name, \nLast Name, and Balance.");
                    return;
                }
                try {
                	
                    // If the user selected "Add Account", create a new account
                	
                    if(action.getSelectedItem().equals("Add Account"))
                    {
                        // Convert balance string to double (may throw NumberFormatException)
                    	
                        double balValue = Double.parseDouble(balInput);

                        // Create the account using your bank object and get its ID
                        
                        String id = bank.addAccount(fNameInput, lNameInput, balValue);

                        // Show success message with the new account ID
                        
                        accountinfo.setText("Success! \nAccount ID: " + id +
                        "\nKeep this ID safe.");

                        // Reset label colors back to black
                        
                        firstNlbl.setForeground(Color.BLACK);
                        lastNlbl.setForeground(Color.BLACK);
                        balancelbl.setForeground(Color.BLACK);
                        
                        // Clear fields and reset combo box
                        
                        cleanTextFields();
                        action.setEnabled(true);
                        action.setSelectedItem("");
                        
                        // Disable all text fields again
                        
                        disableTextFields();
                        
                    }
                } catch (NumberFormatException ex) {
                	
                    // Error for invalid balance input
                	
                    accountinfo.setText("Error: Balance must be \na valid number.");
                }

                // Validate required field for deleting an account
                
                if(accountInput.isEmpty() && action.getSelectedItem().equals("Delete Account")) {
                    accountinfo.setText("Please fill in Account ID.");
                    return;
                }
                
                // If account input exists and delete is selected, perform deletion
                
                else if(accountInput.isEmpty() == false && action.getSelectedItem().equals("Delete Account"))
                {
                	
                    // Call bank to delete account and display the returned message
                	
                    accountinfo.setText("" + bank.deleteAccount(accountInput));
                    accountlbl.setForeground(Color.BLACK);
                    cleanTextFields();
                    action.setEnabled(true);
                    action.setSelectedItem("");
                    disableTextFields();
                }

                // Validate required fields for deposit or withdrawal
                
                if((accountInput.isEmpty() || amountInput.isEmpty()) && (action.getSelectedItem().equals("Deposit") || action.getSelectedItem().equals("Withdrawal")))
                {
                    accountinfo.setText("Please fill in Account ID \nand amount of deposit/withdrawal.");
                    return;
                }
                try
                {
                    // Process deposit
                	
                    if(action.getSelectedItem().equals("Deposit"))
                    {
                        // Convert amount to double
                    	
                        double amountvalue = Double.parseDouble(amountInput);
                        
                        // Perform transaction with type 1 for deposit
                        
                        String amnt = bank.transaction(1, accountInput, amountvalue);
                        accountinfo.setText(amnt);
                        amountlbl.setForeground(Color.BLACK);
                        accountlbl.setForeground(Color.BLACK);
                        cleanTextFields();
                        action.setEnabled(true);
                        action.setSelectedItem("");
                        disableTextFields();
                    }
                    // Process withdrawal
                    
                    else if(action.getSelectedItem().equals("Withdrawal"))
                    {
                        // Convert amount to double
                    	
                        double amountvalue = Double.parseDouble(amountInput);
                        
                        // Perform transaction with type 2 for withdrawal
                        
                        String amnt = bank.transaction(2, accountInput, amountvalue);
                        accountinfo.setText(amnt);
                        accountinfo.setText(amnt);
                        amountlbl.setForeground(Color.BLACK);
                        accountlbl.setForeground(Color.BLACK);
                        cleanTextFields();
                        action.setEnabled(true);
                        action.setSelectedItem("");
                        disableTextFields();
                    }
                } catch (NumberFormatException ex) {
                	
                    // Error for invalid amount input
                	
                    accountinfo.setText("Error: amount must be \na valid number.");
                }

                // Validation for checking balance: account ID is required
                
                if(accountInput.isEmpty() && (action.getSelectedItem().equals("Check Balance")))
                {
                    accountinfo.setText("Please fill in Account ID.");
                    return;
                }
                
                // If account is provided, retrieve and show the balance
                
                else if(accountInput.isEmpty() == false && (action.getSelectedItem().equals("Check Balance")))
                {
                    String info = bank.checkBalance(accountInput);
                    accountinfo.setText(info);
                    accountlbl.setForeground(Color.BLACK);
                    cleanTextFields();
                    action.setEnabled(true);
                    action.setSelectedItem("");
                    disableTextFields();
                }
            }
        });

        // Position the "Process transaction" button
        
        process.setBounds(230, 473, 145, 67);
        panel.add(process);

        // "Back" button to reset the UI state and go back to the action selection
        
        JButton back = new JButton("back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                // Re-enable the action combo box and clear selection
            	
                action.setEnabled(true);
                action.setSelectedItem("");
                
                // Reset all labels to black
                
                firstNlbl.setForeground(Color.BLACK);
                lastNlbl.setForeground(Color.BLACK);
                balancelbl.setForeground(Color.BLACK);
                infolbl.setForeground(Color.BLACK);
                amountlbl.setForeground(Color.BLACK);
                accountlbl.setForeground(Color.BLACK);
                
                // Clear informational text and fields
                
                accountinfo.setText(" ");
                cleanTextFields();
                
                // Disable all text fields
                
                disableTextFields();
                
                // Show a prompt again
                
                accountinfo.setText("Choose an action");
            }
        });
        
        // When no action is selected at startup, text fields should be disabled
        
        if(action.getSelectedItem().equals(""))
        {
            disableTextFields();
        }
        back.setBackground(new Color(128, 128, 128));
        back.setBounds(535, 11, 69, 23);
        panel.add(back);

    }
}
