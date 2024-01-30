import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Signuptwo extends JFrame implements ActionListener {
    long random;
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion, category, occupation , education,income;
    String formno;
    Signuptwo(String formno) {
    this.formno=formno;
        setLayout(null);// by default its is centre align so make it null.
        setTitle("SignUp Form");


        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        additionalDetails.setBounds(250, 80, 400, 30);
        add(additionalDetails);


        JLabel Religion = new JLabel("Religion :");
        Religion.setFont(new Font("Railway", Font.BOLD, 20));
        Religion.setBounds(100, 140, 150, 30);
        add(Religion);

        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion  = new JComboBox(valReligion);
        religion .setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion );


        JLabel Category = new JLabel("Category :");
        Category.setFont(new Font("Railway", Font.BOLD, 20));
        Category.setBounds(100, 190, 200, 30);
        add(Category);
        String valcategory[]={"General","OBC","SC","ST"};
        category= new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);


        JLabel Income = new JLabel("Income :");
        Income.setFont(new Font("Railway", Font.BOLD, 20));
        Income.setBounds(100, 240, 150, 30);
        add(Income);
        String incomemcategory[]={"NULL","< 1,50,000","< 2,50,000","<5,00,000","up to 10,00,000"};
        income= new JComboBox(incomemcategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);


        JLabel Educational = new JLabel("Educational ");
        Educational.setFont(new Font("Railway", Font.BOLD, 20));
        Educational.setBounds(100, 290, 200, 30);
        add(Educational);
        JLabel Qualification = new JLabel("Qualification :");
        Qualification.setFont(new Font("Railway", Font.BOLD, 20));
        Qualification.setBounds(100, 315, 200, 30);
        add(Qualification);
        String educationValues[]={"Matriculation","Graduation","Post-Graduation","PHD","Other"};
        education= new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);


        JLabel Occupation = new JLabel("Occupation :");
        Occupation.setFont(new Font("Railway", Font.BOLD, 20));
        Occupation.setBounds(100, 390, 250, 30);
        add(Occupation);
        String occupationValues[]={"Employee","Self-Employee","Business","Student","Retired","Other"};
        occupation= new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);


        JLabel PanNumber = new JLabel("Pan Number:");
        PanNumber.setFont(new Font("Railway", Font.BOLD, 20));
        PanNumber.setBounds(100, 440, 200, 30);
        add(PanNumber);
        pan = new JTextField();
        pan.setBounds(300, 440, 400, 30);
        pan.setFont(new Font("Railway", Font.BOLD, 14));
        add(pan);


        JLabel AadharNumber = new JLabel("Aadhar Number:");
        AadharNumber.setFont(new Font("Railway", Font.BOLD, 20));
        AadharNumber.setBounds(100, 490, 200, 30);
        add(AadharNumber);
        aadhar = new JTextField();
        aadhar.setBounds(300, 490, 400, 30);
        aadhar.setFont(new Font("Railway", Font.BOLD, 14));
        add(aadhar);


        JLabel SeniorCitizen = new JLabel("Senior Citizen:");
        SeniorCitizen.setFont(new Font("Railway", Font.BOLD, 20));
        SeniorCitizen.setBounds(100, 540, 150, 30);
        add(SeniorCitizen);
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);
        ButtonGroup SeniorCitizengroup = new ButtonGroup();// this is done so that only one button is selected at a time
        SeniorCitizengroup.add(syes);
        SeniorCitizengroup.add(sno);


        JLabel ExistingAccount = new JLabel("Existing Account:");
        ExistingAccount.setFont(new Font("Railway", Font.BOLD, 20));
        ExistingAccount.setBounds(100, 590, 250, 30);
        add(ExistingAccount);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.white);
        add(eno);
        ButtonGroup ExistingAccountgroup = new ButtonGroup();// this is done so that only one button is selected at a time
        ExistingAccountgroup.add(eyes);
        ExistingAccountgroup.add(eno);




        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.setBounds(600, 660, 100, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(300, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;// random is long and to convert it into the string we must add ""+(i.e double
        // quotes and concatinate it the long.)
        String sreligion = (String) religion.getSelectedItem();// getselecteditem() we will get the value  from Jcombobox( value nikalne k lea)
        String scategory = (String)category.getSelectedItem();
        String sincome= (String) income.getSelectedItem();
        String seducation= (String)education.getSelectedItem();
        String soccupation= (String) occupation.getSelectedItem();

        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String exixtingaccount = null;
        if (eyes.isSelected()) {
            exixtingaccount = "Yes";
        } else if (eno.isSelected()) {
            exixtingaccount = "No";
        }
        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
            conn c = new conn();
            String query = "insert into signuptwo values ('" + formno + "' , '" + sreligion + "', '" + scategory + "', '"
                        + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + exixtingaccount
                        + "','" + seniorcitizen + "')";
            c.s.executeUpdate(query);
            setVisible(false);
            new Signupthree(formno).setVisible(true);// signupthree class ka object
            } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new Signuptwo("");
    }
}
