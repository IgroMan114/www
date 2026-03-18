/*

Program: TicTacToe.java          Last Date of this Revision: March 9, 2026

Purpose: The TicTacToe application allows two players to play a computerized game of TicTacToe.

Author: Ihor Nedobor, 
School: CHHS
Course: Computer Programming 30
 

*/

package chapter10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class TicTacToe {

    // These strings represent the value (X, O, or blank) of each board cell b1–b9.
    public String b1 = " ",b2 = " ",b3 = " ",b4 = " ",b5 = " ",b6 = " ",b7 = " ",b8 = " ",b9 = " ";
    // turn = 0 means it's X's turn, turn = 1 means it's O's turn.
    private int turn = 0;
    // start indicates whether the game board is currently active/visible.
    private boolean start = false;
    // Main application window.
    private JFrame frame;

    // Buttons for starting/resetting the game and for each of the 9 grid squares.
    private JButton startbtn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    // Label to display the winner or whose turn it is.
    JLabel winner;

    // Method to check all possible winning combinations and return a message if X or O wins.
    public String checkWinner() 
    {

        // Rows, columns, and diagonals for player X.
        if(b1.equals("X") && b2.equals("X") && b3.equals("X")) return "The Winner Is X!";
        if(b4.equals("X") && b5.equals("X") && b6.equals("X")) return "The Winner Is X!";
        if(b7.equals("X") && b8.equals("X") && b9.equals("X")) return "The Winner Is X!";
        if(b1.equals("X") && b5.equals("X") && b9.equals("X")) return "The Winner Is X!";
        if(b7.equals("X") && b5.equals("X") && b3.equals("X")) return "The Winner Is X!";
        if(b1.equals("X") && b4.equals("X") && b7.equals("X")) return "The Winner Is X!";
        if(b2.equals("X") && b5.equals("X") && b8.equals("X")) return "The Winner Is X!";
        if(b3.equals("X") && b6.equals("X") && b9.equals("X")) return "The Winner Is X!";

        // Rows, columns, and diagonals for player O.
        if(b1.equals("O") && b2.equals("O") && b3.equals("O")) return "The Winner Is O!";
        if(b4.equals("O") && b5.equals("O") && b6.equals("O")) return "The Winner Is O!";
        if(b7.equals("O") && b8.equals("O") && b9.equals("O")) return "The Winner Is O!";
        if(b1.equals("O") && b5.equals("O") && b9.equals("O")) return "The Winner Is O!";
        if(b7.equals("O") && b5.equals("O") && b3.equals("O")) return "The Winner Is O!";
        if(b1.equals("O") && b4.equals("O") && b7.equals("O")) return "The Winner Is O!";
        if(b2.equals("O") && b5.equals("O") && b8.equals("O")) return "The Winner Is O!";
        if(b3.equals("O") && b6.equals("O") && b9.equals("O")) return "The Winner Is O!";

        // No winner yet.
        return " ";

    }

    // Disable all grid buttons and change the start button label when the game ends.
    private void disableButtons(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        startbtn.setText("Restart");
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // Ensure GUI creation happens on the Event Dispatch Thread.
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Create the game window and show it.
                    TicTacToe window = new TicTacToe();
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
    public TicTacToe() {
        // Build and initialize all GUI components.
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        // Create the main frame and configure appearance.
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 51, 51));
        frame.setBounds(100, 100, 440, 342);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Label to display game status (winner or current player's turn).
        winner = new JLabel("");
        winner.setFont(new Font("Snap ITC", Font.PLAIN, 14));
        winner.setForeground(Color.BLACK);
        winner.setHorizontalAlignment(SwingConstants.CENTER);
        winner.setBounds(10, 259, 403, 33);
        frame.getContentPane().add(winner);

        // Button for cell (1,1) in the grid.
        btn1 = new JButton(" ");
        btn1.setFont(new Font("Snap ITC", Font.PLAIN, 75));
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                // If it's X's turn and this cell is not already O, place X.
                if(turn == 0 && !btn1.getText().equals("O")) 
                {
                    btn1.setText("X");
                    winner.setText("Second player turn(O)");
                    b1 = "X";
                    // After the move, check if there is a winner.
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    // Switch turn to O.
                    turn += 1;
                }

                // If it's O's turn and this cell is not already X, place O.
                else if(turn == 1 && !btn1.getText().equals("X")) 
                {
                    btn1.setText("O");
                    winner.setText("First player turn(X)");
                    b1 = "O";
                    // After the move, check if there is a winner.
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    // Switch turn back to X.
                    turn -= 1;
                }

            }
        });
        btn1.setBounds(10, 11, 115, 60);
        frame.getContentPane().add(btn1);

        // Button for cell (1,2) in the grid.
        btn2 = new JButton("  ");
        btn2.setFont(new Font("Snap ITC", Font.PLAIN, 75));
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                if(turn == 0 && !btn2.getText().equals("O")) 
                {
                    btn2.setText("X");
                    winner.setText("Second player turn(O)");
                    b2 = "X";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn += 1;
                }

                else if(turn == 1 && !btn2.getText().equals("X")) 
                {
                    btn2.setText("O");
                    winner.setText("First player turn(X)");
                    b2 = "O";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn -= 1;
                }

            }
        });
        btn2.setBounds(153, 11, 115, 60);
        frame.getContentPane().add(btn2);

        // Button for cell (1,3) in the grid.
        btn3 = new JButton(" ");
        btn3.setFont(new Font("Snap ITC", Font.PLAIN, 75));
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                if(turn == 0 && !btn3.getText().equals("O")) 
                {
                    btn3.setText("X");
                    winner.setText("Second player turn(O)");
                    b3 = "X";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn += 1;
                }

                else if(turn == 1 && !btn3.getText().equals("X")) 
                {
                    btn3.setText("O");
                    winner.setText("First player turn(X)");
                    b3 = "O";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn -= 1;
                }

            }
        });
        btn3.setBounds(298, 11, 115, 60);
        frame.getContentPane().add(btn3);

        // Button for cell (2,3) in the grid.
        btn6 = new JButton(" ");
        btn6.setFont(new Font("Snap ITC", Font.PLAIN, 75));
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                if(turn == 0 && !btn6.getText().equals("O")) 
                {
                    btn6.setText("X");
                    winner.setText("Second player turn(O)");
                    b6 = "X";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn += 1;
                }

                else if(turn == 1 && !btn6.getText().equals("X")) 
                {
                    btn6.setText("O");
                    winner.setText("First player turn(X)");
                    b6 = "O";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn -= 1;
                }

            }
        });
        btn6.setBounds(298, 82, 115, 59);
        frame.getContentPane().add(btn6);

        // Button for cell (2,2) in the grid.
        btn5 = new JButton(" ");
        btn5.setFont(new Font("Snap ITC", Font.PLAIN, 75));
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                if(turn == 0 && !btn5.getText().equals("O")) 
                {
                    btn5.setText("X");
                    winner.setText("Second player turn(O)");
                    b5 = "X";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn += 1;
                }

                else if(turn == 1 && !btn5.getText().equals("X")) 
                {
                    btn5.setText("O");
                    winner.setText("First player turn(X)");
                    b5 = "O";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn -= 1;
                }

            }
        });
        btn5.setBounds(153, 82, 115, 59);
        frame.getContentPane().add(btn5);

        // Button for cell (3,1) in the grid.
        btn7 = new JButton(" ");
        btn7.setFont(new Font("Snap ITC", Font.PLAIN, 75));
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {

                if(turn == 0 && !btn7.getText().equals("O")) 
                {
                    btn7.setText("X");
                    winner.setText("Second player turn(O)");
                    b7 = "X";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn += 1;
                }

                else if(turn == 1 && !btn7.getText().equals("X")) 
                {
                    btn7.setText("O");
                    winner.setText("First player turn(X)");
                    b7 = "O";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn -= 1;
                }

            }
        });
        btn7.setBounds(10, 152, 115, 62);
        frame.getContentPane().add(btn7);

        // Button for cell (3,2) in the grid.
        btn8 = new JButton(" ");
        btn8.setFont(new Font("Snap ITC", Font.PLAIN, 75));
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {

                if(turn == 0 && !btn8.getText().equals("O")) 
                {
                    btn8.setText("X");
                    winner.setText("Second player turn(O)");
                    b8 = "X";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn += 1;
                }

                else if(turn == 1 && !btn8.getText().equals("X")) 
                {
                    btn8.setText("O");
                    winner.setText("First player turn(X)");
                    b8 = "O";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn -= 1;
                }

            }
        });
        btn8.setBounds(153, 152, 115, 62);
        frame.getContentPane().add(btn8);

        // Button for cell (3,3) in the grid.
        btn9 = new JButton(" ");
        btn9.setFont(new Font("Snap ITC", Font.PLAIN, 75));
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                if(turn == 0 && !btn9.getText().equals("O")) 
                {
                    btn9.setText("X");
                    winner.setText("Second player turn(O)");
                    b9 = "X";
                    // Note: Same winner check, just written slightly differently.
                    if(!(checkWinner()).equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn += 1;
                }

                else if(turn == 1 && !btn9.getText().equals("X")) 
                {
                    btn9.setText("O");
                    winner.setText("First player turn(X)");
                    b9 = "O";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn -= 1;
                }

            }
        });
        btn9.setBounds(298, 152, 115, 62);
        frame.getContentPane().add(btn9);

        // Button for cell (2,1) in the grid.
        btn4 = new JButton(" ");
        btn4.setFont(new Font("Snap ITC", Font.PLAIN, 75));
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                if(turn == 0 && !btn4.getText().equals("O")) 
                {
                    btn4.setText("X");
                    winner.setText("Second player turn(O)");
                    b4 = "X";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn += 1;
                }

                else if(turn == 1 && !btn4.getText().equals("X")) 
                {
                    btn4.setText("O");
                    winner.setText("First player turn(X)");
                    b4 = "O";
                    if(!checkWinner().equals(" ")) 
                    {
                        disableButtons();
                        winner.setText(checkWinner());
                    }
                    turn -= 1;
                }

            }
        });

        btn4.setBounds(10, 82, 115, 59);
        frame.getContentPane().add(btn4);


        // Start/Restart/Reset button that controls the visibility and state of the board.
        startbtn = new JButton("Start");
        startbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When pressed, make all grid buttons visible (for Start or Restart).
                btn1.setVisible(true);
                btn2.setVisible(true);
                btn3.setVisible(true);
                btn4.setVisible(true);
                btn5.setVisible(true);
                btn6.setVisible(true);
                btn7.setVisible(true);
                btn8.setVisible(true);
                btn9.setVisible(true);
                winner.setText("First player turn(X)");
                // Determine which command was triggered: Start, Restart, or Reset.
                String Start = e.getActionCommand();
                // Restart: re-enable and clear the board, but keep it visible.
                if(Start.equals("Restart")) 
                {
                    turn = 0;
                    b1=b2=b3=b4=b5=b6=b7=b8=b9 = " ";
                    btn1.setText(" ");
                    btn2.setText(" ");
                    btn3.setText(" ");
                    btn4.setText(" ");
                    btn5.setText(" ");
                    btn6.setText(" ");
                    btn7.setText(" ");
                    btn8.setText(" ");
                    btn9.setText(" ");
                    btn1.setEnabled(true);
                    btn2.setEnabled(true);
                    btn3.setEnabled(true);
                    btn4.setEnabled(true);
                    btn5.setEnabled(true);
                    btn6.setEnabled(true);
                    btn7.setEnabled(true);
                    btn8.setEnabled(true);
                    btn9.setEnabled(true);
                    // After restart, use "Reset" as the next label.
                    startbtn.setText("Reset");
                    winner.setText("First player turn(X)");
                }
                // Start: first time game is started, set flag and change label to Reset.
                else if(Start.equals("Start")) 
                {
                    start = true;
                    startbtn.setText("Reset");
                }
                // Reset: hide all grid buttons and clear the board state.
                else if(Start.equals("Reset")) 
                {
                    btn1.setVisible(false);
                    btn2.setVisible(false);
                    btn3.setVisible(false);
                    btn4.setVisible(false);
                    btn5.setVisible(false);
                    btn6.setVisible(false);
                    btn7.setVisible(false);
                    btn8.setVisible(false);
                    btn9.setVisible(false);
                    turn = 0;
                    b1=b2=b3=b4=b5=b6=b7=b8=b9 = " ";
                    btn1.setText(" ");
                    btn2.setText(" ");
                    btn3.setText(" ");
                    btn4.setText(" ");
                    btn5.setText(" ");
                    btn6.setText(" ");
                    btn7.setText(" ");
                    btn8.setText(" ");
                    btn9.setText(" ");
                    start = false;
                    // Go back to initial Start label.
                    startbtn.setText("Start");
                    winner.setText(" ");
                } 

            }
        });



        // At startup, if game is not started, hide all grid buttons.
        if(start == false) 
        {
            btn1.setVisible(false);
            btn2.setVisible(false);
            btn3.setVisible(false);
            btn4.setVisible(false);
            btn5.setVisible(false);
            btn6.setVisible(false);
            btn7.setVisible(false);
            btn8.setVisible(false);
            btn9.setVisible(false);
        }

        // Configure and place the start/reset button.
        startbtn.setBackground(new Color(255, 255, 255));
        startbtn.setFont(new Font("Snap ITC", Font.PLAIN, 16));
        startbtn.setBounds(153, 225, 115, 23);
        frame.getContentPane().add(startbtn);
    }
}
