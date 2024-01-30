import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class Signupone extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextfField, cityTextField, stateTextField,
            pinTextField, dobTextField;
    JButton next;
    JRadioButton male, female, others, married, unmarried;
    JDateChooser dateChooser;

    Signupone() {

        setLayout(null);// by defaukt its is centre allign so make it null.
        setTitle("SignUp Form");
        Random ran = new Random();// to get random number.
        random = (Math.abs(ran.nextLong() % 9000L + 1000L));// math.absolute will give the positive number.

        JLabel formno = new JLabel("APPLICATION FORM NO." + random);
        formno.setFont(new Font("Railway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        personalDetails.setBounds(250, 80, 400, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Railway", Font.BOLD, 20));
        name.setBounds(100, 140, 150, 30);
        add(name);
        nameTextField = new JTextField();
        nameTextField.setBounds(300, 140, 400, 30);
        nameTextField.setFont(new Font("Railway", Font.BOLD, 14));
        add(nameTextField);

        JLabel fathername = new JLabel("Father name :");
        fathername.setFont(new Font("Railway", Font.BOLD, 20));
        fathername.setBounds(100, 190, 200, 30);
        add(fathername);
        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 190, 400, 30);
        fnameTextField.setFont(new Font("Railway", Font.BOLD, 14));
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Railway", Font.BOLD, 20));
        dob.setBounds(100, 240, 150, 30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 200, 30);
        add(dateChooser);
        // dobTextField = new JTextField();
        // dobTextField.setBounds(300, 240, 400, 30);
        // dobTextField.setFont(new Font("Railway", Font.BOLD, 20));
        // add(dobTextField);

        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Railway", Font.BOLD, 20));
        gender.setBounds(100, 290, 100, 30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.white);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 100, 30);
        female.setBackground(Color.white);
        add(female);
        ButtonGroup gendergroup = new ButtonGroup();// this is done so that only one button is selected at a time
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email Address :");
        email.setFont(new Font("Railway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setBounds(300, 340, 400, 30);
        emailTextField.setFont(new Font("Railway", Font.BOLD, 14));
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status :");
        marital.setFont(new Font("Railway", Font.BOLD, 20));
        marital.setBounds(100, 390, 250, 30);
        add(marital);
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.white);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        others = new JRadioButton("Other");
        others.setBounds(600, 390, 100, 30);
        others.setBackground(Color.white);
        add(others);
        ButtonGroup maritalgroup = new ButtonGroup();// this is done so that only one button is selected at a time
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Railway", Font.BOLD, 20));
        address.setBounds(100, 440, 150, 30);
        add(address);
        addressTextfField = new JTextField();
        addressTextfField.setBounds(300, 440, 400, 30);
        addressTextfField.setFont(new Font("Railway", Font.BOLD, 14));
        add(addressTextfField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Railway", Font.BOLD, 20));
        city.setBounds(100, 490, 150, 30);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setBounds(300, 490, 400, 30);
        cityTextField.setFont(new Font("Railway", Font.BOLD, 14));
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Railway", Font.BOLD, 20));
        state.setBounds(100, 540, 150, 30);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setBounds(300, 540, 400, 30);
        stateTextField.setFont(new Font("Railway", Font.BOLD, 14));
        add(stateTextField);

        JLabel pincode = new JLabel("Pin-code:");
        pincode.setFont(new Font("Railway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 150, 30);
        add(pincode);
        pinTextField = new JTextField();
        pinTextField.setBounds(300, 590, 400, 30);
        pinTextField.setFont(new Font("Railway", Font.BOLD, 14));
        add(pinTextField);

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
        String name = nameTextField.getText();// getText() we will get the value ( value nikalne k lea)
        String fathername = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (others.isSelected()) {
            marital = "Other";
        }

        String address = addressTextfField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "name is required");
            } else {
                conn c = new conn();
                String query = "insert into signup values ('" + formno + "' , '" + name + "', '" + fathername + "', '"
                        + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city
                        + "','" + pin + "','" + state + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signuptwo(formno).setVisible(true);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new Signupone();
    }
}
