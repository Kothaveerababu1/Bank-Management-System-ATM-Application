package bankmanagement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pinchange extends JFrame implements ActionListener{
  JButton change,back;
  JPasswordField rpin ,pin;
  String pinno;

  public Pinchange(String pinno) {
    this.pinno = pinno;
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);

    JLabel text = new JLabel("CHANGE YOUR PIN");
    text.setForeground(Color.white);
    text.setFont(new Font("System",Font.BOLD,16));
    text.setBounds(250,280,500,20);
    image.add(text);

    JLabel pintext = new JLabel("NEW PIN:");
    pintext.setForeground(Color.white);
    pintext.setFont(new Font("System",Font.BOLD,16));
    pintext.setBounds(165,320,180,25);
    image.add(pintext);

    pin = new JPasswordField();
    pin.setForeground(Color.black);
    pin.setFont(new Font("Raleway",Font.BOLD,16));
    pin.setBounds(330,320,180,25);
    image.add(pin);


    JLabel repin = new JLabel("RE ENTER NEW PIN:");
    repin.setForeground(Color.white);
    repin.setFont(new Font("System",Font.BOLD,16));
    repin.setBounds(165,360,180,25);
    image.add(repin);

    rpin = new JPasswordField();
    rpin.setForeground(Color.BLACK);
    rpin.setFont(new Font("Raleway",Font.BOLD,16));
    rpin.setBounds(330,360,180,25);
    image.add(rpin);

    change = new JButton("CHANGE");
    change.setBounds(355,485,150,30);
    change.addActionListener(this);
    image.add(change);

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
    if(ae.getSource() == change){
        try{
          String npin = pin.getText();
          String reppin = rpin.getText();
          if(!npin.equals(reppin)){
            JOptionPane.showMessageDialog(null,"Entered pin doesnot match.");
            pin.setText("");
            rpin.setText("");
            return;
          }
          if(npin.equals("")){
           JOptionPane.showMessageDialog(null,"Please Enter new Pin.");
          }
          if(reppin.equals("")){
           JOptionPane.showMessageDialog(null,"Please Re-Enter new Pin.");
          }

          Conn conn = new Conn();
          String query1 = "update bank set pin = '"+reppin+"' where pin = '"+pinno+"'";
          String query2 = "update login set pin = '"+reppin+"' where pin = '"+pinno+"'";
          String query3 = "update signupthree set pin = '"+reppin+"' where pin = '"+pinno+"'";

          conn.s.executeUpdate(query1);
          conn.s.executeUpdate(query2);
          conn.s.executeUpdate(query3);

          JOptionPane.showMessageDialog(null,"Pin Changed Successfully.");
          setVisible(false);
          new Transaction(reppin).setVisible(true);

        }catch(Exception e){
          System.out.println(e);
        }
     }else{
      setVisible(false);
      new Transaction(pinno).setVisible(true);

    }

  }

  public static void main(String[] args){
    new Pinchange("").setVisible(true);
  }
  
}
