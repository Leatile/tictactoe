import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.*;

public class TicTacToe extends Application implements ActionListener{
    
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    
public TicTacToe(){
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800,800);
    frame.getContentPane().setBackground(new Color(50,50,50));
    frame.setLayout(new BorderLayout());
    frame.setVisible(true);
    
    textField.setBackground(new Color(25,25,25));
    textField.setForeground(new Color(25,255,0));
    textField.setFont(new Font("Ink Free",Font.BOLD,75));
    textField.setHorizontalAlignment(JLabel.CENTER);
    textField.setText("Tic Tac Toe");
    textField.setOpaque(true);
    
    title_panel.setLayout(new BorderLayout());
    title_panel.setBounds(0,0,800,100);
    
    button_panel.setLayout(new GridLayout(3,3));
    button_panel.setBackground(new Color(150,150,150));
    
    for(int i=0;i<9;i++){
        buttons[i] = new JButton();
        button_panel.add(buttons[i]);
        buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
        buttons[i].setFocusable(false);
        buttons[i].addActionListener(this);
    }
    
    title_panel.add(textField);
    frame.add(title_panel,BorderLayout.NORTH);
    frame.add(button_panel);
    
    firstTurn();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource() == buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                        check();
                    }
                }
                else{
                     if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        check();
                }
            }
        }
    }
  }
    
    public void firstTurn(){
        
        try{
            Thread.sleep(2000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        
        if(random.nextInt(2) == 0){
        player1_turn = true;
        textField.setText("X turn");
        
    } else{
            if(random.nextInt(2) == 0){
        player1_turn = false;
        textField.setText("O turn");
            }   
        }
    }
    
    public void check(){
        
        //Check for X
        
        if("X".equals(buttons[0].getText()) && buttons[0].getText().equals(buttons[1].getText()) && 
                buttons[0].getText().equals(buttons[2].getText())){
            xWins(0,1,2);
        }
        
        if("X".equals(buttons[3].getText()) && buttons[3].getText().equals(buttons[4].getText()) && 
                buttons[3].getText().equals(buttons[5].getText())){
            xWins(3,4,5);
        }
        
        if("X".equals(buttons[6].getText()) && buttons[6].getText().equals(buttons[7].getText()) && 
                buttons[6].getText().equals(buttons[8].getText())){
            xWins(6,7,8);
        }
        
        if("X".equals(buttons[0].getText()) && buttons[0].getText().equals(buttons[3].getText()) && 
                buttons[0].getText().equals(buttons[6].getText())){
            xWins(0,3,6);
        }
        
        if("X".equals(buttons[1].getText()) && buttons[1].getText().equals(buttons[4].getText()) && 
                buttons[1].getText().equals(buttons[7].getText())){
            xWins(1,4,7);
        }
        
        if("X".equals(buttons[2].getText()) && buttons[2].getText().equals(buttons[5].getText()) && 
                buttons[2].getText().equals(buttons[8].getText())){
            xWins(2,5,8);
        }
        
        if("X".equals(buttons[0].getText()) && buttons[0].getText().equals(buttons[4].getText()) && 
                buttons[0].getText().equals(buttons[8].getText())){
            xWins(0,4,8);
        }
        
        if("X".equals(buttons[2].getText()) && buttons[2].getText().equals(buttons[4].getText()) && 
                buttons[2].getText().equals(buttons[6].getText())){
            xWins(2,4,6);
        }
        
        //Check for O
        
        if("O".equals(buttons[0].getText()) && buttons[0].getText().equals(buttons[1].getText()) && 
                buttons[0].getText().equals(buttons[2].getText())){
            oWins(0,1,2);
        }
        
        if("O".equals(buttons[3].getText()) && buttons[3].getText().equals(buttons[4].getText()) && 
                buttons[3].getText().equals(buttons[5].getText())){
            oWins(3,4,5);
        }
        
        if("O".equals(buttons[6].getText()) && buttons[6].getText().equals(buttons[7].getText()) && 
                buttons[6].getText().equals(buttons[8].getText())){
            oWins(6,7,8);
        }
        
        if("O".equals(buttons[0].getText()) && buttons[0].getText().equals(buttons[3].getText()) && 
                buttons[0].getText().equals(buttons[6].getText())){
            oWins(0,3,6);
        }
        
        if("O".equals(buttons[1].getText()) && buttons[1].getText().equals(buttons[4].getText()) && 
                buttons[1].getText().equals(buttons[7].getText())){
            oWins(1,4,7);
        }
        
        if("O".equals(buttons[2].getText()) && buttons[2].getText().equals(buttons[5].getText()) && 
                buttons[2].getText().equals(buttons[8].getText())){
            oWins(2,5,8);
        }
        
        if("O".equals(buttons[0].getText()) && buttons[0].getText().equals(buttons[4].getText()) && 
                buttons[0].getText().equals(buttons[8].getText())){
            oWins(0,4,8);
        }
        
        if("O".equals(buttons[2].getText()) && buttons[2].getText().equals(buttons[4].getText()) && 
                buttons[2].getText().equals(buttons[6].getText())){
            oWins(2,4,6);
        }
        
    }
    
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X won");
        
        JOptionPane pane = new JOptionPane();
        int result = JOptionPane.showConfirmDialog(pane, "Game Over, X Won. Would you like to play again?."
        + JOptionPane.YES_NO_OPTION);
        
        if(result == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Good luck!");
            Main.main(null);
            
        }else{
            JOptionPane.showMessageDialog(null, "Thanks for playing");
            System.exit(0);
        }
        
    }
    
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("O won");
        
        JOptionPane pane = new JOptionPane();
        int result = JOptionPane.showConfirmDialog(pane, "Game Over, O Won. Would you like to play again?."
        + JOptionPane.YES_NO_OPTION);
        
        if(result == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Good luck!");
            Main.main(null);
            
        }else{
            JOptionPane.showMessageDialog(null, "Thanks for playing");
            System.exit(0);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
