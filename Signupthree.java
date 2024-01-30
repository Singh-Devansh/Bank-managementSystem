import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Signupthree  extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
    Signupthree(String formno){
        this.formno= formno;
        setLayout(null);
        setTitle("Signup Form");


        JLabel l1= new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Railway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);


        JLabel type= new JLabel("Account Type :");
        type.setFont(new Font("Railway",Font.BOLD,22));
        type.setBounds(100,100,250,30);
        add(type);

        r1= new JRadioButton("Saving Account");
        r1.setFont(new Font("Railway",Font.BOLD,14));
        r1.setBounds(100,150,250,20);
        r1.setBackground(Color.white);
        add(r1);

        r2= new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Railway",Font.BOLD,14));
        r2.setBounds(350,150,250,20);
        r2.setBackground(Color.white);
        add(r2);

        r3= new JRadioButton("Current Account");
        r3.setFont(new Font("Railway",Font.BOLD,14));
        r3.setBounds(100,200,250,20);
        r3.setBackground(Color.white);
        add(r3);

        r4= new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Railway",Font.BOLD,14));
        r4.setBounds(350,200,250,20);
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);


        JLabel card= new JLabel("Card Number :");
        card.setFont(new Font("Railway",Font.BOLD,22));
        card.setBounds(100,280,250,30);
        add(card);
        JLabel number= new JLabel("XXXX-XXXX-XXX-0164");
        number.setFont(new Font("Railway",Font.BOLD,22));
        number.setBounds(330,280,350,30);
        add(number);

        JLabel carddetails= new JLabel("Your 16 Digit Card Number");
        carddetails.setFont(new Font("Railway",Font.BOLD,12));
        carddetails.setBounds(100,310,350,20);
        add(carddetails);

        JLabel pin= new JLabel("PIN :");
        pin.setFont(new Font("Railway",Font.BOLD,22));
        pin.setBounds(100,340,250,30);
        add(pin);
        JLabel Number= new JLabel("XXXX");
        Number.setFont(new Font("Railway",Font.BOLD,22));
        Number.setBounds(330,340,350,30);
        add(Number);
        JLabel pindetails= new JLabel("Your 4 Digit Pin Number");
        pindetails.setFont(new Font("Railway",Font.BOLD,12));
        pindetails.setBounds(100,370,350,20);
        add(pindetails);

        JLabel services = new JLabel("Services Required:");
        services.setBounds(100,440,250,30);
        services.setFont(new Font("Railway",Font.BOLD,22));
        add(services);
        c1= new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Railway",Font.BOLD,14));
        c1.setBounds(100,490,200,30);
        add(c1);
        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Railway",Font.BOLD,14));
        c2.setBounds(300,490,200,30);
        add(c2);
        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Railway",Font.BOLD,14));
        c3.setBounds(100,540,200,30);
        add(c3);
        c4= new JCheckBox("Credit Card");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Railway",Font.BOLD,14));
        c4.setBounds(300,540,200,30);
        add(c4);
        c5= new JCheckBox("SMS Services");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Railway",Font.BOLD,14));
        c5.setBounds(100,590,200,30);
        add(c5);
        c6= new JCheckBox("Cheque Book");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Railway",Font.BOLD,14));
        c6.setBounds(300,590,200,30);
        add(c6);

        c7= new JCheckBox("i hereby declare that above entered details by me is correct.");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Railway",Font.BOLD,12));
        c7.setBounds(100,670,500,30);
        add(c7);

        submit= new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(620,720,200,30);
        submit.addActionListener(this);
        add(submit);

        cancel= new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(100,720,200,30);
        cancel.addActionListener(this);
        add(cancel);



        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType= null;
            if(r1.isSelected()){
                accountType= "Saving Account";
            } else if (r2.isSelected()) {
                accountType="Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType="Current Account";
            } else if (r4.isSelected()) {
                accountType="Recurring Deposit Account";
            }

            Random random= new Random();
            String cardnumber= "" +Math.abs((random.nextLong() % 90000000L) + 8855936000000000L);// random 16 digit number
            String pinnumber = "" +Math.abs((random.nextLong() % 9000L)+ 1000L);// random 4 digit number.

            String facility= null;
            if(c1.isSelected()){
                facility= facility + "ATM Card";// multiple input agr lena hoto aise lenge.
            } else if (c2.isSelected()) {
                facility= facility + "Internet Banking";
            }else if (c3.isSelected()){
                facility=facility + "Mobile Banking";
            } else if (c4.isSelected()) {
                facility=facility + "Credit Card";
            }else if (c5.isSelected()){
                facility= facility + "SMS Services";
            } else if (c6.isSelected()) {
                facility=facility + "Cheque";
            }
            try {
                if(c7.equals("")){
                    JOptionPane.showMessageDialog(null,"please accept the validity.");
                }else {
                    conn c = new conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "card number: " + cardnumber+"\n pin:" + pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            }catch (Exception e){
                System.out.println(e);
            }


        }
        else if(ae.getSource()==cancel){
                setVisible(false);
                new Login().setVisible(true);
        }
    }

    public static void main(String args[]){
        new Signupthree("");

    }
}
