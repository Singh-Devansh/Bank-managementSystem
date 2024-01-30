
import java.awt.*;
import java.awt.event.*;
import java.net.StandardSocketOptions;
import java.sql.*;

import javax.swing.*;// swing package is imported extended java package, swing is usd to make frame for desktop application

public class Login extends JFrame implements ActionListener {
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;// password will not be seen , it will come in dot... .

    Login() {
        setTitle("ATM");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("banklogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);// we can't place the icon directly of frame so we use jlable .
        lable.setBounds(70, 10, 100, 100);
        add(lable);
        // this is to add text to the frame
        JLabel text = new JLabel("Welcome to my ATM");
        text.setFont(new Font("Osward", Font.BOLD, 35));
        text.setBounds(200, 40, 400, 40);
        add(text);
        // this is to add other text to frame.
        JLabel cardnumber = new JLabel("Card Number:");
        cardnumber.setFont(new Font("Railway", Font.BOLD, 20));// this is style of text
        cardnumber.setBounds(120, 125, 150, 30);// this is text alignment in the frame .
        add(cardnumber);
        // this is to add input box infront of cardnumber.
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 125, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Railway", Font.BOLD, 20));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        // this is to add sign in button.

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);// this will tell us that button is being clicked
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);

        setSize(800, 500);// it decide the length and breadth of frame.
        setVisible(true);// by default the frame is not visible its value is false .
        setLocation(350, 200);// this is the location as by default the frame starts from origin i.e left-top.

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");// setText() will add the value (daalne k lea )
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            conn c= new conn();
            String cardnumber=cardTextField.getText();
            String pinnumber= pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";// it will fetch the data from login database.
            try{
               ResultSet rs = c.s.executeQuery(query); // we will store the fetched data in resultset.
               if(rs.next()){// it means that if rs has get somedata then close this page and open transaction page.
                   setVisible(false);
                   new Transaction(pinnumber).setVisible(true);
               }else {
                   JOptionPane.showMessageDialog(null,"incorrect card number or pin");
               }
            }
            catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signupone().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Login();

    }
}