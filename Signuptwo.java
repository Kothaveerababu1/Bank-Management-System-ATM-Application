package bankmanagement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Signuptwo extends JFrame implements ActionListener{
  JTextField aadhar, panNo;
  JButton next;
  JRadioButton syes,sno, eyes, eno;
  JComboBox religion,category, income, education, occupation;
  String formno;
  Signuptwo(String  formno){
    this.formno = formno;
    setLayout(null);
    setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

    JLabel additionaldetails= new JLabel("Page 2: Additional Details");
    additionaldetails.setFont(new Font("Raleway",Font.BOLD, 22));
    additionaldetails.setBounds(290,80,400,30);
    add(additionaldetails);

    JLabel name= new JLabel("Religion: ");
    name.setFont(new Font("Raleway",Font.BOLD, 20));
    name.setBounds(100,140,100,30);
    add(name);

    String[] religionval = {"Hindu","muslim","Christian","sikh"};
    religion = new JComboBox<>(religionval);
    religion.setBounds(300,140,400,30);
    religion.setBackground(Color.WHITE);
    add(religion);


    JLabel cat= new JLabel("Category: ");
    cat.setFont(new Font("Raleway",Font.BOLD, 20));
    cat.setBounds(100,190,200,30);
    add(cat);

    String[] categoryval = {"general","obc","sc","st"};
    category = new JComboBox<>(categoryval);
    category.setBounds(300,190,400,30);
    category.setBackground(Color.WHITE);
    add(category);


    JLabel inc= new JLabel("Income: ");
    inc.setFont(new Font("Raleway",Font.BOLD, 20));
    inc.setBounds(100,240,200,30);
    add(inc);

    String[] Incomeval = {"null","<150000","<250000","<500000","<upto 1000000"};
    income = new JComboBox<>(Incomeval);
    income.setBackground(Color.WHITE);
    income.setBounds(300,240,200,30);
    add(income);
  
    JLabel edu= new JLabel("Education Qualification ");
    edu.setFont(new Font("Raleway",Font.BOLD, 20));
    edu.setBounds(100,290,200,30);
    add(edu);

    String[] educationval = {"non gradute","under graduate","<post graduate","PHD","Others"};
    education = new JComboBox<>(educationval);
    education.setBackground(Color.WHITE);
    education.setBounds(300,315,200,30);
    add(education);


    JLabel occ= new JLabel("Occupation: ");
    occ.setFont(new Font("Raleway",Font.BOLD, 20));
    occ.setBounds(100,390,200,30);
    add(occ);

    String[] occval = {"Self employed","Business","Salaried","Student","Others"};
    occupation = new JComboBox<>(occval);
    occupation.setBackground(Color.WHITE);
    occupation.setBounds(300,390,200,30);
    add(occupation);

    JLabel pan= new JLabel("Pan No: ");
    pan.setFont(new Font("Raleway",Font.BOLD, 20));
    pan.setBounds(100,440,200,30);
    add(pan);

    panNo = new JTextField();
    panNo.setFont(new Font("Raleway", Font.BOLD, 14));
    panNo.setBounds(300,440,400,30);
    add(panNo);


    JLabel aadh= new JLabel("Adhaar No: ");
    aadh.setFont(new Font("Raleway",Font.BOLD, 20));
    aadh.setBounds(100,490,200,30);
    add(aadh);

    aadhar = new JTextField();
    aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
    aadhar.setBounds(300,490,400,30);
    add(aadhar);


    JLabel state= new JLabel("Senior Citizen: ");
    state.setFont(new Font("Raleway",Font.BOLD, 20));
    state.setBounds(100,540,200,30);
    add(state);
    
      // Adding Radio Buttons for Senior citizen selection
    syes = new JRadioButton("YES");
    syes.setBounds(300,540,100,30);
    syes.setBackground(Color.WHITE);
    add(syes); 
    sno = new JRadioButton("NO");
    sno.setBounds(450,540,100,30);
    sno.setBackground(Color.WHITE);
    add(sno); 

    ButtonGroup scityzengroup = new ButtonGroup();
    scityzengroup.add(syes);
    scityzengroup.add(sno);



    JLabel existac= new JLabel("Existing Account: ");
    existac.setFont(new Font("Raleway",Font.BOLD, 20));
    existac.setBounds(100,590,200,30);
    add(existac);

    eyes = new JRadioButton("YES");
    eyes.setBounds(300,590,100,30);
    eyes.setBackground(Color.WHITE);
    add(eyes); 
    eno = new JRadioButton("NO");
    eno.setBounds(450,590,100,30);
    eno.setBackground(Color.WHITE);
    add(eno);

    ButtonGroup eaccgroup = new ButtonGroup();
    eaccgroup.add(eyes);
    eaccgroup.add(eno);

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
    String Religion = (String) religion.getSelectedItem();
    String Category = (String) category.getSelectedItem();
    String Income = (String) income.getSelectedItem(); 
    String Education = (String) education.getSelectedItem();   
    String Occupation = (String) occupation.getSelectedItem(); 
    String Seniorcityzen = null;
    if(syes.isSelected()){
      Seniorcityzen = "yes";
    }else if (sno.isSelected()){
      Seniorcityzen = "NO";
    }

    String Existingacc = null;
    if(eyes.isSelected()){
      Existingacc = "yes";
    }else if (eno.isSelected()){
      Existingacc = "NO";
    }
    String Pan = (String) panNo.getText();
    String Aadhar = (String) aadhar.getText();

    try{
        Conn c = new Conn();
        String query = "insert into signuptwo values('"+formno+"','"+Religion+"','"+Category+"','"+Income+"','"+Education+"','"+Occupation+"','"+Pan+"','"+Aadhar+"','"+Seniorcityzen+"','"+Existingacc+"')";
        c.s.executeUpdate(query);

        //signupthree open   
        setVisible(false);
        new Signupthree(formno).setVisible(true);     
      }catch(Exception e){
      System.out.println(e);
    }


  }
  public static void main(String[] args) {
      new Signuptwo("");
  }
  
}
