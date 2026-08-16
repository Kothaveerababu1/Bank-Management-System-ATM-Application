package bankmanagement;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class Signupone extends JFrame implements ActionListener{
  long random;
  JTextField nameTextField, fnameTextField,emailTextField, addressTextField, stateTextField, cityTextField,pincodeTextField;
  JButton next;
  JRadioButton male,fmale,married,unmarried,others;
  JDateChooser dobchooser;
  Signupone(){
    setLayout(null);
    Random ran = new Random();
    random = Math.abs((ran.nextLong() & 9000L) + 1000L);

    JLabel formno = new JLabel("APPLICATION FORM NO." + random);
    formno.setFont(new Font("Raleway",Font.BOLD, 38));
    formno.setBounds(140,20,600,40);
    add(formno);

    JLabel personaldetails= new JLabel("Page 1: Personal Details");
    personaldetails.setFont(new Font("Raleway",Font.BOLD, 22));
    personaldetails.setBounds(290,80,400,30);
    add(personaldetails);

    JLabel name= new JLabel("Name: ");
    name.setFont(new Font("Raleway",Font.BOLD, 20));
    name.setBounds(100,140,80,30);
    add(name);

    nameTextField = new JTextField();
    nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
    nameTextField.setBounds(300,140,400,30);
    add(nameTextField);


    JLabel fname= new JLabel("Father's Name: ");
    fname.setFont(new Font("Raleway",Font.BOLD, 20));
    fname.setBounds(100,190,200,30);
    add(fname);

    fnameTextField = new JTextField();
    fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
    fnameTextField.setBounds(300,190,400,30);
    add(fnameTextField);


    JLabel dob= new JLabel("Date Of Birth: ");
    dob.setFont(new Font("Raleway",Font.BOLD, 20));
    dob.setBounds(100,240,200,30);
    add(dob);

    dobchooser = new JDateChooser();
    dobchooser.setBounds(300,240,200,30);
    add(dobchooser);

    

    JLabel gender= new JLabel("Gender: ");
    gender.setFont(new Font("Raleway",Font.BOLD, 20));
    gender.setBounds(100,290,200,30);
    add(gender);

    //adding Radio Buttons for the Gender selection
    male = new JRadioButton("Male");
    male.setBounds(300,290,60,30);
    male.setBackground(Color.WHITE);
    add(male); 
    fmale = new JRadioButton("Female");
    fmale.setBounds(450,290,80,30);
    fmale.setBackground(Color.WHITE);
    add(fmale);
    ButtonGroup gendergroup = new ButtonGroup();
    gendergroup.add(male);
    gendergroup.add(fmale);

    JLabel email= new JLabel("Email Address: ");
    email.setFont(new Font("Raleway",Font.BOLD, 20));
    email.setBounds(100,340,200,30);
    add(email);

    emailTextField = new JTextField();
    emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
    emailTextField.setBounds(300,340,400,30);
    add(emailTextField);


    JLabel marit= new JLabel("Marital Status: ");
    marit.setFont(new Font("Raleway",Font.BOLD, 20));
    marit.setBounds(100,390,200,30);
    add(marit);

      // Adding Radio Buttons for Marrtial Status selection
    married = new JRadioButton("Married");
    married.setBounds(300,390,100,30);
    married.setBackground(Color.WHITE);
    add(married); 
    unmarried = new JRadioButton("Unmarried");
    unmarried.setBounds(450,390,100,30);
    unmarried.setBackground(Color.WHITE);
    add(unmarried); 
    others = new JRadioButton("Others");
    others.setBounds(600,390,100,30);
    others.setBackground(Color.WHITE);
    add(others); 
    ButtonGroup maritgroup = new ButtonGroup();
    maritgroup.add(married);
    maritgroup.add(unmarried);
    maritgroup.add(others);



    JLabel address= new JLabel("Address: ");
    address.setFont(new Font("Raleway",Font.BOLD, 20));
    address.setBounds(100,440,200,30);
    add(address);

    addressTextField = new JTextField();
    addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
    addressTextField.setBounds(300,440,400,30);
    add(addressTextField);


    JLabel city= new JLabel("City: ");
    city.setFont(new Font("Raleway",Font.BOLD, 20));
    city.setBounds(100,490,200,30);
    add(city);

    cityTextField = new JTextField();
    cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
    cityTextField.setBounds(300,490,400,30);
    add(cityTextField);


    JLabel state= new JLabel("State: ");
    state.setFont(new Font("Raleway",Font.BOLD, 20));
    state.setBounds(100,540,200,30);
    add(state);

    stateTextField = new JTextField();
    stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
    stateTextField.setBounds(300,540,400,30);
    add(stateTextField);


    JLabel pincode= new JLabel("PinCode: ");
    pincode.setFont(new Font("Raleway",Font.BOLD, 20));
    pincode.setBounds(100,590,200,30);
    add(pincode);

    pincodeTextField = new JTextField();
    pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
    pincodeTextField.setBounds(300,590,400,30);
    add(pincodeTextField);

    
    next = new JButton("Next");
    next.setBackground(Color.BLACK);
    next.setForeground(Color.WHITE);
    next.setFont(new Font("Raleway",Font.BOLD,14));
    next.setBounds(620,660,80,30);
    next.addActionListener(this);
    add(next);

    //Creating a Frame
    getContentPane().setBackground(Color.WHITE);
    setSize(850,800);
    setLocation(350,10);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent ac){
    String formno = ""+ random;
    String fname = fnameTextField.getText();
    String dob =((JTextField) dobchooser.getDateEditor().getUiComponent()).getText();
    String gender = null;
    String name = nameTextField.getText();
    if(male.isSelected()){
      gender = "Male";
    }else if(fmale.isSelected()){
      gender = "Female";
    }
    String email = emailTextField.getText();
    String marital = null;
    if(married.isSelected()){
      marital = "Married";
    }else if(unmarried.isSelected()){
      marital = "Unmarried";
    }else if(others.isSelected()){
      marital = "Other";
    }

    String address = addressTextField.getText();
    String state = stateTextField.getText();
    String city = cityTextField.getText();
    String pincode = pincodeTextField.getText();

    try{
      if(name.isEmpty()){
        JOptionPane.showMessageDialog(null,"Name is required");
      }else{
        Conn c = new Conn();
        String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
        c.s.executeUpdate(query);

        setVisible(false);
        new Signuptwo(formno).setVisible(true);

      }

    }catch(Exception e){
      System.out.println(e);
    }


  }
  public static void main(String[] args) {
      new Signupone();
  }
  
}
