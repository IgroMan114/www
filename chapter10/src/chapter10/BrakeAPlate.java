/*

Program: BreakAPlate.java          Last Date of this Revision: March 9, 2026

Purpose: The BreakAPlate application displays three unbroken plates at the start. Clicking Play plays the game, displays broken plates, and displays the prize won.
If all three plates are broken, a tiger plush first prize is awarded. If less than three plates are broken, a sticker consolation prize is awarded.
At the end of a game the Play button changes to Play Again. Clicking Play Again displays a set of unbroken plates and the button changes back to Play allowing the user to play repeatedly.
The application ends when the user closes the window.

Author: Ihor Nedobor, 
School: CHHS
Course: Computer Programming 30
 

*/

package chapter10;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.transform.Templates;
import javax.swing.SwingConstants;
import java.awt.Font;

public class BrakeAPlate implements ActionListener{

    // ImageIcons used in the game: initial plates and possible results/prizes.
    ImageIcon plate = new ImageIcon("../chapter10/src/plates.gif");
    ImageIcon allbroke = new ImageIcon("../chapter10/src/plates_all_broken.gif");
    ImageIcon twobroke = new ImageIcon("../chapter10/src/plates_two_broken.gif");
    ImageIcon placehold = new ImageIcon("../chapter10/src/placeholder.gif");
    ImageIcon sticker = new ImageIcon("../chapter10/src/sticker.gif");
    ImageIcon tiger = new ImageIcon("../chapter10/src/tiger_plush.gif");

    // Main window frame for the application.
    JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // Run GUI creation on the Event Dispatch Thread for thread safety.
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Create the window and make it visible.
                    BrakeAPlate window = new BrakeAPlate();
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
    public BrakeAPlate() {
        // Set up all GUI components.
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        // Create the main frame and basic properties.
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);              // Position and size.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);           // Use absolute positioning.

        // Label to display the plates image at the top.
        JLabel plates = new JLabel(plate);
        plates.setBounds(10, 11, 414, 104);
        frame.getContentPane().add(plates);

        // Label to display the prize image or placeholder in the bottom area.
        JLabel prizes = new JLabel(" ");
        prizes.setHorizontalAlignment(SwingConstants.CENTER);
        prizes.setBounds(50, 151, 325, 110);
        frame.getContentPane().add(prizes);

        // Button the user clicks to play or play again.
        JButton play = new JButton("Play");
        play.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        play.setBackground(Color.CYAN);
        play.setBounds(44, 115, 346, 36);
        // Anonymous ActionListener to handle button clicks.
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                // Get the current action command string (Play / Play Again).
                String eventName = e.getActionCommand();
                // Generate random number 1 or 2 to decide the outcome.
                int random = (int) (2 * (Math.random()) + 1);
                // If user clicked when button shows "Play".
                if(eventName.equals("Play")) 
                {
                    // If random result is 2, all plates break and user wins tiger plush.
                    if(random == 2) 
                    {
                        plates.setIcon(allbroke);
                        prizes.setIcon(tiger);
                    }
                    // If random result is 1, only two plates break and user wins sticker.
                    else if(random == 1) 
                    {
                        plates.setIcon(twobroke);
                        prizes.setIcon(sticker);
                    }

                    // After one play, change button text and command to "Play Again".
                    play.setText("Play Again");
                    play.setActionCommand("Play Again");
                }
                // If user clicks when button shows "Play Again", reset to original state.
                else if(eventName == "Play Again") 
                {
                    // Reset plates and prize images.
                    plates.setIcon(plate);
                    prizes.setIcon(placehold);
                    // Change button back to "Play" for a new round.
                    play.setText("Play");
                    play.setActionCommand("Play");

                }
            }
        });
        frame.getContentPane().add(play);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Required by ActionListener interface;
    }
}
