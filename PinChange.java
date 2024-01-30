import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber= pinnumber;
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel("Change your Pin.");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pintext= new JLabel("New Pin.");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,20);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Railway",Font.BOLD,25));
        pin.setBounds(360,320,150,25);
        image.add(pin);

        JLabel repintext= new JLabel(" Re-Enter New Pin.");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,20);
        image.add(repintext);

        repin= new JPasswordField();
        repin.setFont(new Font("Railway",Font.BOLD,25));
        repin.setBounds(360,360,150,25);
        image.add(repin);

        change= new JButton("CHANGE");
        change.setBounds(360,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back= new JButton("BACK");
        back.setBounds(360,520,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "please re-enter the new pin.");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter the new pin .");
                    return;
                }

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin doesn't match.");
                    return;
                }


                conn c= new conn();
                String query1= "update bank set pin= '"+rpin+"' where pin='"+pinnumber+"'";
                String query2= "update login set pin= '"+rpin+"' where pin='"+pinnumber+"'";
                String query3= "update signupthree set pin= '"+rpin+"' where pin='"+pinnumber+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin changed successfully.");
                setVisible(false);
                new Transaction(rpin).setVisible(true);
            }
                catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }


    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
