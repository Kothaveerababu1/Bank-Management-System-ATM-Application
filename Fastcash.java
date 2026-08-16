package bankmanagement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
public class Fastcash extends JFrame implements ActionListener{
     JButton onehun,fivehun,thousand,twothous,fivethous,tenthous,back;
     String pinno;

      Fastcash(String pinno) {
      this.pinno = pinno;
      setLayout(null);

      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(0,0,900,900);
      add(image);

      JLabel text = new JLabel("Select The Withdrawl Amount.");
      text.setBounds(210,300,700,35);
      text.setFont(new Font("Raleway",Font.BOLD,16));
      text.setForeground(Color.white);
      image.add(text);

      onehun = new JButton("RS 100");
      onehun.setBounds(170,415,150,30);
      onehun.addActionListener(this);
      image.add(onehun);

      fivehun = new JButton("RS 500");
      fivehun.setBounds(170,450,150,30);
      fivehun.addActionListener(this);
      image.add(fivehun);

      thousand = new JButton("RS 1000");
      thousand.setBounds(170,485,150,30);
      thousand.addActionListener(this);
      image.add(thousand);

      twothous = new JButton("RS 2000");
      twothous.setBounds(355,415,150,30);
      twothous.addActionListener(this);
      image.add(twothous);

      fivethous = new JButton("RS 5000");
      fivethous.setBounds(355,450,150,30);
      fivethous.addActionListener(this);
      image.add(fivethous);

      tenthous = new JButton("RS 10000");
      tenthous.setBounds(355,485,150,30);
      tenthous.addActionListener(this);
      image.add(tenthous);


      back = new JButton("BACK");
      back.setBounds(355,520,150,30);
      back.addActionListener(this);
      image.add(back);
      
      setSize(900,900);
      setLocation(300,0);
      setUndecorated(true);
      setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == back){
        setVisible(false);
        new Transaction(pinno).setVisible(true);
      }else{
        String amount = ((JButton) ae.getSource()).getText().substring(3);
          Conn c = new Conn();
        try{
          ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
          int balance = 0;
          while(rs.next()){
            if(rs.getString("type").equals("Deposit")){
              balance += Integer.parseInt(rs.getString("amount"));
            }else{
              balance -= Integer.parseInt(rs.getString("amount"));
            }
          }
          if(ae.getSource() != back && balance<Integer.parseInt(amount)){
            JOptionPane.showMessageDialog(null,"Insufficient Balance");
            return;
          }

          Date date = new Date();
          String query = "insert into bank values('"+pinno+"','"+date+"','Withdrawl','"+amount+"')";
          c.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Sucessfully");

          setVisible(false);
          new Transaction(pinno).setVisible(true);


        }catch(Exception e){
          System.out.println(e);
        }
      }

    }
  

  public static void main(String[] args) {
    new Fastcash("");
    
  }
  
}
