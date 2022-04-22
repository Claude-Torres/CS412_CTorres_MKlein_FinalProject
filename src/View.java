import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private JFrame frame = new JFrame();
    private JLabel title = new JLabel("Tic-Tac-Toe");
    private JLabel turn = new JLabel();
    private JButton hostButton = new JButton("Host Game");
    private JButton joinButton = new JButton("Join Game");
    private JPanel panel = new JPanel();
    private JButton oneButton = new JButton();
    private JButton twoButton = new JButton();
    private JButton threeButton = new JButton();
    private JButton fourButton = new JButton();
    private JButton fiveButton = new JButton();
    private JButton sixButton = new JButton();
    private JButton sevenButton = new JButton();
    private JButton eightButton = new JButton();
    private JButton nineButton = new JButton();
    private JLabel oneLabel = new JLabel();
    private JLabel twoLabel = new JLabel();
    private JLabel threeLabel = new JLabel();
    private JLabel fourLabel = new JLabel();
    private JLabel fiveLabel = new JLabel();
    private JLabel sixLabel = new JLabel();
    private JLabel sevenLabel = new JLabel();
    private JLabel eightLabel = new JLabel();
    private JLabel nineLabel = new JLabel();

    public View(){
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

    public void setHostButtonActionListener(ActionListener aL){hostButton.addActionListener(aL);}
    public void setJoinButtonActionListener(ActionListener aL){joinButton.addActionListener(aL);}
    public void setOneButtonActionListener(ActionListener aL){oneButton.addActionListener(aL);}
    public void setTwoButtonActionListener(ActionListener aL){twoButton.addActionListener(aL);}
    public void setThreeButtonActionListener(ActionListener aL){threeButton.addActionListener(aL);}
    public void setFourButtonActionListener(ActionListener aL){fourButton.addActionListener(aL);}
    public void setFiveButtonActionListener(ActionListener aL){fiveButton.addActionListener(aL);}
    public void setSixButtonActionListener(ActionListener aL){sixButton.addActionListener(aL);}
    public void setSevenButtonActionListener(ActionListener aL){sevenButton.addActionListener(aL);}
    public void setEightButtonActionListener(ActionListener aL){eightButton.addActionListener(aL);}
    public void setNineButtonActionListener(ActionListener aL){nineButton.addActionListener(aL);}

}



