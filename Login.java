package bankmanagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
  JButton signin, clear, signup;                            // globally defined
  JTextField cardTextField; JPasswordField pinTextField;                   // globally defined
  Login(){
    setTitle("AUTOMATED TELLER MACHINE");
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
    Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    label.setBounds(70, 10, 100, 100);
    add(label);

    JLabel text = new JLabel("Welcome to ATM");
    text.setFont(new Font("Osward", Font.BOLD,38));
    text.setBounds(200,40,400,40);
    add(text);

    JLabel cardno = new JLabel("Card NO:");
    cardno.setFont(new Font("Osward", Font.BOLD,30));
    cardno.setBounds(120,150,150,40);
    add(cardno);

    cardTextField = new JTextField();
    cardTextField.setBounds(300,150,230,30);
    cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
    add(cardTextField);

    JLabel pin= new JLabel("PIN:");
    pin.setFont(new Font("Osward", Font.BOLD,30));
    pin.setBounds(120,220,230,30);
    add(pin);

    pinTextField = new JPasswordField();
    pinTextField.setBounds(300,220,230,30);
    pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
    add(pinTextField);

    signin = new JButton("SIGN IN");
    signin.setBounds(300,300,100,30);
    signin.addActionListener(this);
    add(signin);

    clear = new JButton("CLEAR");
    clear.setBounds(430,300,100,30);
    clear.addActionListener(this);
    add(clear);

    signup = new JButton("SIGN UP");
    signup.setBounds(300,350,230,30);
    signup.addActionListener(this);
    add(signup);

    getContentPane().setBackground(Color.white);

    setSize(800,480);
    setVisible(true);
    setLocation(350,200);
  }

  
  public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == clear) {
      cardTextField.setText("");
      pinTextField.setText("");

    }else if(ae.getSource() == signin){
      Conn conn = new Conn();
      String Cardno = cardTextField.getText();
      String pinno = pinTextField.getText();
      String query = "select * from login where cardno = '"+Cardno+"' and pin = '"+pinno+"'";
      try {
       ResultSet rs = conn.s.executeQuery(query);
       if(rs.next()){
        setVisible(false);
        new Transaction(pinno).setVisible(true);
       }else{
        JOptionPane.showMessageDialog(null, "Incorret Details");
       }
          
      } catch (Exception e) {
        System.out.println(e);
      }

    }else if(ae.getSource() == signup){
      setVisible(false);
      new Signupone().setVisible(true);

    }

  }
public static void main(String[] args){
  new Login();
}

}