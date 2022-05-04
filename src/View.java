import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private final JFrame frame = new JFrame();
    private final JLabel title = new JLabel("Tic-Tac-Toe");
    private JLabel turn = new JLabel();
    private final JButton hostButton = new JButton("Host Game");
    private final JButton joinButton = new JButton("Join Game");
    private JPanel panel = new JPanel();
    private final JButton[] buttons = new JButton[9];
    private final JLabel[] labels = new JLabel[9];

    public View(){
        for (int i = 0; i < 9; i++){
            buttons[i] = new JButton();
        }

        title.setFont(new Font("Serif", Font.BOLD, 25));

        Dimension size = joinButton.getPreferredSize();
        joinButton.setBounds(450, 400, size.width, size.height);
        panel.setLayout(null);
        panel.add(joinButton);
        size = hostButton.getPreferredSize();
        hostButton.setBounds(250, 400, size.width, size.height);
        panel.add(hostButton);
        size = title.getPreferredSize();
        title.setBounds(335, 30, size.width +50, size.height);
        panel.add(title);

        frame.getContentPane().add(panel);

        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    public void disconnect(){
        frame.setVisible(false);
        frame.remove(panel);
        panel = new JPanel();

        panel.setLayout(null);
        panel.add(title);

        System.out.println("Setting up disconnect GUI!");

        turn = new JLabel("Other Player Disconnected!");
        turn.setFont(new Font("Serif", Font.BOLD, 50));
        Dimension size = turn.getPreferredSize();
        turn.setBounds(100, 300, size.width + 50, size.height);
        panel.add(turn);

        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    public void doubleHost(){
        frame.setVisible(false);
        frame.remove(panel);
        panel = new JPanel();

        panel.setLayout(null);
        panel.add(title);

        turn = new JLabel("Someone is already Hosting!");
        turn.setFont(new Font("Serif", Font.BOLD, 50));
        Dimension size = turn.getPreferredSize();
        turn.setBounds(100, 300, size.width + 50, size.height);
        panel.add(turn);

        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    public void waiting(){
        frame.setVisible(false);
        frame.remove(panel);
        panel = new JPanel();

        panel.setLayout(null);
        panel.add(title);

        turn = new JLabel("Waiting for other player...");
        turn.setFont(new Font("Serif", Font.BOLD, 50));
        Dimension size = turn.getPreferredSize();
        turn.setBounds(100, 300, size.width + 50, size.height);
        panel.add(turn);

        frame.getContentPane().add(panel);

        frame.setVisible(true);

    }

    public void updateGame(char[] squares, char currentPlayer, char gameStatus){
        frame.setVisible(false);
        frame.remove(panel);
        panel = new JPanel();
        if(gameStatus == 'n') {
            turn = new JLabel("It is your turn! (" + currentPlayer + ")");
            turn.setFont(new Font("Serif", Font.BOLD, 20));
            Dimension size = turn.getPreferredSize();
            turn.setBounds(335, 80, size.width, size.height);
        }
        else{
            if (gameStatus != 't') {
                turn = new JLabel("Player " + gameStatus + " Won!");
            }
            else {
                turn = new JLabel("The Game Ended In a Tie!");
            }
            turn.setFont(new Font("Serif", Font.BOLD, 30));
        }
        Dimension size = turn.getPreferredSize();
        turn.setBounds(332, 80, size.width, size.height);
        panel.add(turn);

        Border border = BorderFactory.createLineBorder(Color.black);

        int posx = 0, posy = 0, sizex = 144, sizey = 145;

        for(int i = 0; i < 9; i++){
            if(i == 0 || i == 3 || i == 6) posx = 170;
            if(i == 1 || i == 4 || i == 7) posx = 330;
            if(i == 2 || i == 5 || i == 8) posx = 490;
            if(i == 0 || i == 1 || i == 2) posy = 150;
            if(i == 3 || i == 4 || i == 5) posy = 310;
            if(i == 6 || i == 7 || i == 8) posy = 470;

            if (squares[i] == 'n' && gameStatus == 'n') {
                buttons[i].setBounds(posx, posy, sizex, sizey);
                panel.add(buttons[i]);
            }
            else{
                if(squares[i] != 'n')  labels[i] = new JLabel("   " + squares[i]);
                else labels[i] = new JLabel();
                labels[i].setFont(new Font("Serif", Font.BOLD, 75));
                labels[i].setBorder(border);
                labels[i].setBounds(posx, posy, sizex, sizey);
                panel.add(labels[i]);
            }
        }

        panel.setLayout(null);
        panel.add(title);

        frame.getContentPane().add(panel);

        frame.setVisible(true);


    }

    public void setHostButtonActionListener(ActionListener aL){hostButton.addActionListener(aL);}
    public void setJoinButtonActionListener(ActionListener aL){joinButton.addActionListener(aL);}
    public void setOneButtonActionListener(ActionListener aL){buttons[0].addActionListener(aL);}
    public void setTwoButtonActionListener(ActionListener aL){buttons[1].addActionListener(aL);}
    public void setThreeButtonActionListener(ActionListener aL){buttons[2].addActionListener(aL);}
    public void setFourButtonActionListener(ActionListener aL){buttons[3].addActionListener(aL);}
    public void setFiveButtonActionListener(ActionListener aL){buttons[4].addActionListener(aL);}
    public void setSixButtonActionListener(ActionListener aL){buttons[5].addActionListener(aL);}
    public void setSevenButtonActionListener(ActionListener aL){buttons[6].addActionListener(aL);}
    public void setEightButtonActionListener(ActionListener aL){buttons[7].addActionListener(aL);}
    public void setNineButtonActionListener(ActionListener aL){buttons[8].addActionListener(aL);}

}


