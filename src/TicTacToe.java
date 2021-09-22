import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener {
    
    Random random = new Random();
    JFrame frame = new JFrame("Tic Tac Toe");
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean playerX_turn;
    char playerMark = 'X';
    
    public TicTacToe(){
        
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700,700);
    frame.getContentPane().setBackground(new Color(50,50,50));
    frame.setLayout(new BorderLayout());
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    
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
    
    title_panel.add(textField);
    frame.add(title_panel,BorderLayout.NORTH);
    frame.add(button_panel);
    
    firstTurn();
    createButtons();
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource() == buttons[i]){
                if(playerX_turn && playerMark == 'X'){
                    if(buttons[i].getText() == "-"){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        playerX_turn = false;
                        playerMark = 'O';
                        textField.setText("O turn");   
                    }
                }
                else{
                     if(buttons[i].getText() == "-"){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        playerX_turn = true;
                        playerMark = 'X';
                        textField.setText("X turn");      
                }
            }
                displayWinner();
        }
     }
   }
    
    public void createButtons(){
    for(int i=0;i<9;i++){
        buttons[i] = new JButton();
        button_panel.add(buttons[i]);
        buttons[i].setText("-");
        buttons[i].setBackground(new Color(220,220,255));
        buttons[i].setForeground(new Color(220,220,255));
        buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
        buttons[i].setFocusable(false);
        buttons[i].addActionListener(this);
        }
    }
    
    public void displayWinner(){
        if(checkWinner() == true){
            
            if(playerMark == 'X') playerMark = 'O';
            else playerMark = 'X';
            
            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(pane, "Game Over  ("+playerMark+ 
                    ")  Won. Play Again?","Game Over.",JOptionPane.YES_NO_OPTION);
            
            if(dialogResult == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Good luck!");
                resetTheGame();
            }
            else {
                System.exit(0);
            }
        }
        else if(checkDraw()){ 
            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(pane, "Draw, Game Over.  Play Again?"
                    ,"Game Over.",JOptionPane.YES_NO_OPTION);
            
            if(dialogResult == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Good luck!");
                resetTheGame();
                }
            else{ 
                System.exit(0);
            } 
        }  
    }
    
    public void firstTurn(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        if(random.nextInt(2)==0){
            playerX_turn = true;
            textField.setText("X turn");
        } else{
            playerX_turn = false;
            textField.setText("O turn");
        }

    }
    
    public void resetTheGame(){
        for(int i=0; i<9; i++){
            buttons[i].setText("-");
            buttons[i].setBackground(new Color(220,220,255));
            buttons[i].setForeground(new Color(220,220,255));
            buttons[i].setText("-");
        }
        
    }
    
    public boolean checkDraw(){
        boolean full = true;
        for(int i=0; i<9; i++){
            if(buttons[i].getText().charAt(0) == '-'){
                  full = false;
            } 
        }
        return full;  
    }
    
    public boolean checkWinner(){  
        
        return checkRows() == true || checkColumns() == true || checkDiagonals() == true; 
    }
    
    public boolean checkRows(){
        int i = 0;
        for(int j=0; j<3; j++){
            if(buttons[i].getText().equals(buttons[i+1].getText()) && 
                    buttons[i].getText().equals(buttons[i+2].getText())
                    && buttons[i].getText().charAt(0) != '-'){
                
                
                 buttons[i].setBackground(Color.GREEN);
                 buttons[i+1].setBackground(Color.GREEN);
                 buttons[i+2].setBackground(Color.GREEN );
            
                 
                return true;
            }
            i = i+3;
        }
        return false;
    }
    
    public boolean checkColumns(){
       int i = 0;
        for(int j=0; j<3; j++){
            if(buttons[i].getText().equals(buttons[i+3].getText()) && 
                    buttons[i].getText().equals(buttons[i+6].getText())
                    && buttons[i].getText().charAt(0) != '-'){
                
                buttons[i].setBackground(Color.GREEN);
                 buttons[i+3].setBackground(Color.GREEN);
                 buttons[i+6].setBackground(Color.GREEN );
                 
                 return true;
                
            }
            i++;
        }
        return false;
    }
    
    public boolean checkDiagonals(){
            if(buttons[0].getText().equals(buttons[4].getText()) && 
                    buttons[0].getText().equals(buttons[8].getText())
                    && buttons[0].getText().charAt(0) != '-'){
                
                    buttons[0].setBackground(Color.GREEN);
                 buttons[4].setBackground(Color.GREEN);
                 buttons[8].setBackground(Color.GREEN );
                 
                return true;
            }
            else if(buttons[2].getText().equals(buttons[4].getText()) && 
                    buttons[2].getText().equals(buttons[6].getText())
                    && buttons[2].getText().charAt(0) != '-'){
                
                 buttons[2].setBackground(Color.GREEN);
                 buttons[4].setBackground(Color.GREEN);
                 buttons[6].setBackground(Color.GREEN );
                 
                return true;
            }
            else{
              return false;  
            }  
    }

}
    

