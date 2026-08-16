package bankmanagement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{

  JButton withdraw,back;
  JTextField amount;
  String pinno;

  Withdrawl(String pinno){
    this.pinno = pinno;
    setLayout(null);
    

      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(0,0,900,900);
      add(image);

      JLabel text = new JLabel("Enter the amount to Withdraw");
      text.setForeground(Color.white);
      text.setFont(new Font("System",Font.BOLD,16));
      text.setBounds(170,300,400,16);
      image.add(text);
      
      amount = new JTextField();
      amount.setForeground(Color.black);
      amount.setFont(new Font("Raleway",Font.BOLD,20));
      amount.setBounds(170,350,320,20);
      image.add(amount);

      withdraw = new JButton("WITHDRAW");
      withdraw.setBounds(355,485,150,30);
      withdraw.addActionListener(this);
      image.add(withdraw);

      back = new JButton("BACK");
      back.setBounds(355,520,150,30);
      back.addActionListener(this);
      image.add(back);

      

    setSize(900,900);
    setLocation(300,0);
    setVisible(true);
    

  }

  public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == withdraw){
      String number = amount.getText();
      Date date = new Date();
      if(number.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter the amount");
      }else{
        try{
        Conn conn = new Conn();
        String query = "insert into bank values('"+pinno+"','"+date+"','Withdrawl','"+number+"')";
        conn.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Rs"+number+ " Withdraw successfully." );
        setVisible(false);
        new Transaction(pinno).setVisible(true);
        }catch(Exception e){
          System.out.println(e);
        }
      }

    }else if(ae.getSource() == back){
      setVisible(false);
      new Transaction(pinno).setVisible(true);

    }

  }
  public static void main(String[] args) {
    new Withdrawl("");
    
  }
  
}
