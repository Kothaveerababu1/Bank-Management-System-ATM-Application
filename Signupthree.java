package bankmanagement;
import java.awt.*;                           //For font
import java.awt.event.*;
import java.util.*;                        //For Jlabels and Jframes
import javax.swing.*;                          //For Random number generation

public class Signupthree extends JFrame implements ActionListener {
  JRadioButton r1,r2,r3,r4;
  JCheckBox c1,c2,c3,c4,c5,c6,c7;
  JButton submit, cancel;
  String formno;

  Signupthree(String formno){
    this.formno = formno;
    setLayout(null);
    JLabel l1 = new JLabel("Page 3: Account Details");
    l1.setFont(new Font("Raleway",Font.BOLD,22));
    l1.setBounds(280,40,400,40);
    add(l1);

    JLabel type = new JLabel("Account Type");
    type.setFont(new Font("Raleway",Font.BOLD,22));
    type.setBounds(100,140,200,30);
    add(type);

    r1 = new JRadioButton("Savings Account");
    r1.setFont(new Font("Raleway",Font.BOLD,16));
    r1.setBackground(Color.white);
    r1.setBounds(100,180,180,20);
    add(r1);

    r2 = new JRadioButton("Fixed Deposit Account");
    r2.setFont(new Font("Raleway",Font.BOLD,16));
    r2.setBackground(Color.white);
    r2.setBounds(350,180,220,20);
    add(r2);

    r3 = new JRadioButton("Current Account");
    r3.setFont(new Font("Raleway",Font.BOLD,16));
    r3.setBackground(Color.white);
    r3.setBounds(100,220,180,20);
    add(r3);

    r4 = new JRadioButton("Recurring Deposit Account");
    r4.setFont(new Font("Raleway",Font.BOLD,16));
    r4.setBackground(Color.white);
    r4.setBounds(350,220,220,20);
    add(r4);

    ButtonGroup groupacc = new ButtonGroup();
    groupacc.add(r1);
    groupacc.add(r2);
    groupacc.add(r3);
    groupacc.add(r4);

    JLabel card = new JLabel("Card Number:");
    card.setFont(new Font("Raleway",Font.BOLD,22));
    card.setBounds(100,300,200,30);
    add(card);

    JLabel carddetail = new JLabel("This is your 16 digit card no");
    carddetail.setFont(new Font("Raleway",Font.BOLD,12));
    carddetail.setBounds(100,330,300,30);
    add(carddetail);

    JLabel number = new JLabel("XXXX-XXXX-XXXX-4148");
    number.setFont(new Font("Raleway",Font.BOLD,22));
    number.setBounds(330,300,220,30);
    add(number);


    JLabel pin = new JLabel("PIN:");
    pin.setFont(new Font("Raleway",Font.BOLD,22));
    pin.setBounds(100,370,220,30);
    add(pin);

    JLabel pindetail = new JLabel("This is your password");
    pindetail.setFont(new Font("Raleway",Font.BOLD,12));
    pindetail.setBounds(100,390,300,30);
    add(pindetail);


    JLabel pnum= new JLabel("XXXX");
    pnum.setFont(new Font("Raleway",Font.BOLD,22));
    pnum.setBounds(330,370,220,30);
    add(pnum);

    JLabel services = new JLabel("Services Required:");
    services.setFont(new Font("Raleway",Font.BOLD,22));
    services.setBounds(100,450,220,30);
    add(services);

    c1 = new JCheckBox("ATM Card");
    c1.setFont(new Font("Raleway",Font.BOLD,16));
    c1.setBackground(Color.white);
    c1.setBounds(100,500,200,30);
    add(c1);

    c2= new JCheckBox("Internet Banking");
    c2.setFont(new Font("Raleway",Font.BOLD,16));
    c2.setBackground(Color.white);
    c2.setBounds(350,500,200,30);
    add(c2);

    c3 = new JCheckBox("Mobile Banking");
    c3.setFont(new Font("Raleway",Font.BOLD,16));
    c3.setBackground(Color.white);
    c3.setBounds(100,550,200,30);
    add(c3);

    c4 = new JCheckBox("Email/SMS Alerts");
    c4.setFont(new Font("Raleway",Font.BOLD,16));
    c4.setBackground(Color.white);
    c4.setBounds(350,550,200,30);
    add(c4);

    c5 = new JCheckBox("Cheque Book");
    c5.setFont(new Font("Raleway",Font.BOLD,16));
    c5.setBackground(Color.white);
    c5.setBounds(100,600,200,30);
    add(c5);

    c6 = new JCheckBox("E-Statement");
    c6.setFont(new Font("Raleway",Font.BOLD,16));
    c6.setBackground(Color.white);
    c6.setBounds(350,600,200,30);
    add(c6);

    c7 = new JCheckBox("I Here by declare that above entered details are Correct to the best of my knowledge");
    c7.setFont(new Font("Raleway",Font.BOLD,12));
    c7.setBackground(Color.white);
    c7.setBounds(100,680,600,30);
    add(c7);

    submit = new JButton("Submit");
    submit.setBackground(Color.black);
    submit.setForeground(Color.white);
    submit.setFont(new Font("Raleway",Font.BOLD,14));
    submit.setBounds(220,720,100,30);
    submit.addActionListener(this);
    add(submit);

    cancel = new JButton("Cancel");
    cancel.setBackground(Color.black);
    cancel.setForeground(Color.white);
    cancel.setFont(new Font("Raleway",Font.BOLD,14));
    cancel.setBounds(420,720,100,30);
    cancel.addActionListener(this);
    add(cancel);

    getContentPane().setBackground(Color.white);                //setting the background color of the frame
    setSize(850,820);
    setLocation(350,0);
    setVisible(true);

  }

  public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == submit){
      String acctype = null;
      if(r1.isSelected()){
        acctype = "Savings Account";
      }else if(r2.isSelected()){
        acctype = "Fixed Deposit Account";
      }else if(r3.isSelected()){
        acctype = "Current Account";
      }else if(r4.isSelected()){
        acctype = "Recurring Account";
      }
      Random random = new Random();
      String Cardno = "" + Math.abs((random.nextLong() % 9000000L)+ 5040936000000000L);

      String pinno = "" + Math.abs((random.nextLong() % 9000L+ 1000L));

      String facility = "";
      if(c1.isSelected()){
        facility = facility + " ATM Card";
      }if(c2.isSelected()){
        facility = facility + " Internet Banking";
      }if(c3.isSelected()){
        facility = facility + " Moblie Banking";
      }if(c4.isSelected()){
        facility = facility + " Email & SMS Alerts";
      }if(c5.isSelected()){
        facility = facility + " Cheque Book";
      }if(c6.isSelected()){
        facility = facility + " E-Statement";
      }

      try{
        if(acctype == null){
          JOptionPane.showMessageDialog(null, "Account type is required");
        }else{
          Conn conn = new Conn();
          String query1 = "insert into signupthree values('"+formno+"','"+acctype+"','"+Cardno+"','"+pinno+"','"+facility+"')";
          conn.s.executeUpdate(query1);
          String query2 = "insert into login values('"+formno+"','"+Cardno+"','"+pinno+"')";
          conn.s.executeUpdate(query2);

          JOptionPane.showMessageDialog(null,"card number: "+ Cardno +"\nPin: "+ pinno);

          setVisible(false);
          new Deposit(pinno).setVisible(true);
        }

      }catch(Exception e){ 
        System.out.println(e);
      }
  


    }else if(ae.getSource() == cancel){
      setVisible(false);
      new Login().setVisible(true);

    }


  }

  public static void main(String[] args) {
    new Signupthree("");
  }
  
}
