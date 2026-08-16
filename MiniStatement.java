package bankmanagement;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;

public class MiniStatement extends JFrame {
  String pinno;

      MiniStatement(String pinno){
        this.pinno = pinno;


        setTitle("Mini Statement");

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel tbalance = new JLabel();
        tbalance.setBounds(20,500,400,20);
        add(tbalance);

        JLabel card = new JLabel("Indian Bank");
        card.setBounds(20,80,300,20);
        add(card);

        try {
          Conn conn = new Conn();
          ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinno+"'");
          while(rs.next()){
            card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+ "XXXXXXXX" +rs.getString("cardnumber").substring(12));
          }
            
        } catch (Exception e) {
          System.out.println(e);
        }

        try {
          Conn conn = new Conn();
          int bal =0;
          ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinno+"'");
          while(rs.next()){
            mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+ "<br><br><html>");

             if(rs.getString("type").equals("Deposit")){
              bal += Integer.parseInt(rs.getString("amount"));
            }else{
              bal -= Integer.parseInt(rs.getString("amount"));
            }
            
          }
          tbalance.setText("Your Current account balance is Rs "+ bal);
            
        } catch (Exception e) {
          System.out.println(e);
        }

        


        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);


  }

  public static void main(String[] args) {
      new MiniStatement("");
  }
  
}
