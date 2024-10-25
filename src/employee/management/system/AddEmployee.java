package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tname, tfname, taddress, tphone, taadhar, temail , tsalary, tdesignation;
    JLabel tempid;

    JDateChooser tdob;
    JComboBox Boxeducation;

    JButton  add,back;

    Random ran = new Random();
    int number = ran.nextInt(999999);

    AddEmployee(){

        getContentPane().setBackground(new Color(163,255,188));


        JLabel heading = new JLabel("Add Employee Detail");
        heading.setFont(new Font("railway", Font.BOLD, 25));
        heading.setForeground(Color.darkGray);
        heading.setBounds(320,30,500,50);
        add(heading);

        JLabel name = new JLabel("Name:");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);


        JLabel fename = new JLabel("Father'sName:");
        fename.setBounds(400,150,100,30);
        fename.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        add(fename);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        JLabel dob = new JLabel("Date of birth:");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        add( dob);

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);

        JLabel salary = new JLabel("salary:");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);

        JLabel address = new JLabel("Adress:");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel email = new JLabel("E-mail:");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);


        JLabel phone = new JLabel("Phone:");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);


        JLabel education = new JLabel("Higher edu..:");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        add(education);

        String items[] = {"BBA","B.Tech","LLB","BA","BSC","MCA", "MA","PHD","POLYTECHNIQE"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(600,300,150,30);
        add(Boxeducation);



        JLabel aadhar = new JLabel("Aadhar:");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600,350,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel empid = new JLabel("EmployeeID:");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        tempid.setForeground(Color.red);
        add(tempid);

        JLabel designation = new JLabel("Designation:");
        designation.setBounds(400,400,150,30);
        designation.setFont(new Font("SAN_SARIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(600,400,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        add = new JButton("Add");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);




        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem().toString();
            String designation =tdesignation.getText();
            String aadhar = taadhar.getText();
            String empid = tempid.getText();

            try{
                conn c= new conn();
                String query = "Insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();

            }
        }else {
            setVisible(false);
            new Main_class();

        }
    }

    public static void main(String[] args) {
    new AddEmployee();

    }
}
