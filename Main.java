package SDP;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
class window00 extends JFrame
{
    window00()
    {

        JFrame f=new JFrame("Supermarket Billing System By Pushkar Helge");
        JLabel l1 = new JLabel("Welcome to Supermarket!");
        l1.setFont(new Font("Verdana", Font.PLAIN,50));
        l1.setBounds(165, 10, 1000, 200);
        l1.setForeground(new Color(120,90,40));
        //l1.setBackground(new Color(100,20,70));


        JButton b1=new JButton("Administrator/Operator");
        b1.setBounds(50,550,330,50);
        b1.setFont(new Font("Arial", Font.PLAIN, 26));

        JButton b2=new JButton("Customer");
        b2.setBounds(445,550,200,50);
        b2.setFont(new Font("Arial", Font.PLAIN, 26));

        JButton b3=new JButton("Exit");
        b3.setFont(new Font("Arial", Font.PLAIN, 26));
        b3.setBounds(700,550,150,50);


        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window01();
                f.dispose();
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window20();
                f.dispose();
            }
        });
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f.dispose();
            }
        });



        ImageIcon img = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\visual-sell.png");
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(-280,-95,1500,900);

        JLabel l11 = new JLabel("-By Pushkar Helge \nRoll No:45");
        l11.setFont(new Font("Verdana", Font.PLAIN,30));
        l11.setBounds(655, 600, 1000, 200);
        l11.setForeground(new Color(120,90,40));

        f.add(l1);
        f.add(l11);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(background);
        f.setSize(1000,700);
        f.setLayout(null);

        //f.getContentPane().setBackground(Color.lightGray);
        f.getContentPane().setBackground(new Color(255, 244, 184));
        f.setVisible(true);

    }
}
class window01 extends JFrame
{
    window01()
    {
        JFrame w01 = new JFrame("LOG IN");

        JLabel l01 = new JLabel("Administrator Login");
        l01.setFont(new Font("Verdana", Font.PLAIN,30));
        l01.setBounds(250, 10, 1000, 100);

        JLabel l1=new JLabel("User Id :");
        l1.setFont(new Font("Arial", Font.PLAIN, 26));
        l1.setBounds(50,330, 200,30);
        JLabel l2=new JLabel("Password :");
        l2.setFont(new Font("Arial", Font.PLAIN, 26));
        l2.setBounds(50,400, 200,30);
        JLabel l3 = new JLabel("Enter The Valid Credentials");
        l3.setFont(new Font("Arial", Font.PLAIN, 26));
        JTextField t1=new JTextField(20);
        t1.setFont(new Font("Arial", Font.PLAIN, 26));
        t1.setBounds(250,330, 300,30);
        JTextField t2=new JTextField(20);
        t2.setFont(new Font("Arial", Font.PLAIN, 26));
        t2.setBounds(250,400, 300,30);
        JButton b1=new JButton("Log In");
        b1.setFont(new Font("Arial", Font.PLAIN, 26));
        b1.setBounds(250,500,120,45);
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String url="jdbc:mysql://localhost:3306/sdp"; //database name
                String user="root";
                String pwd="";
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");//driver software
                    Connection con = DriverManager.getConnection(url,user,pwd);
                    Statement st = con.createStatement();
                    String sql = "select * from admin where user=('"+t1.getText()+"') AND pass=('"+t2.getText()+"')";
                    ResultSet rs = st.executeQuery(sql);
                    String a = null;
                    String b = null;
                    while(rs.next())
                    {
                        a = rs.getString(1);
                        b = rs.getString(2);
                        System.out.println(a);
                        System.out.println(b);
                    }
                    if((a!=null && b!=null))
                    {
                        new window10();
                        w01.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Enter Valid Credentials","Error",JOptionPane.ERROR_MESSAGE);
                        l3.setBounds(250,550,500,30);
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                    l3.setBounds(250,550,500,30);
                }
            }
        });
        JButton b2=new JButton("Back");
        b2.setBounds(450,500,100,45);
        b2.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window00();
                w01.dispose();
            }
        });
        ImageIcon img = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\administrator1.png");
        img.setImage(img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(180,45,500,300);

        w01.add(l01);
        w01.add(l1);
        w01.add(l2);
        w01.add(l3);
        w01.add(t1);
        w01.add(t2);
        w01.add(b1);
        w01.add(b2);
        w01.add(background);
        w01.getContentPane().setBackground(new Color(255, 244, 184));
        w01.setSize(1000,700);
        w01.setLayout(null);
        w01.setVisible(true);
    }
}
class window10 extends JFrame
{
    window10()
    {
        JFrame W10=new JFrame("You Are Manager Now");
        JButton b1=new JButton("Add Item To Stock");
        b1.setBounds(50,330,270,50);
        JButton b2=new JButton("View Stock");
        b2.setBounds(380,330,200,50);
        JButton b3=new JButton("Delete Item From Stock");
        b3.setBounds(630,330,310,50);
        JButton b4=new JButton("Add Partner");
        b4.setBounds(50,500,270,50);
        JButton b5=new JButton("Delete Partner");
        b5.setBounds(380,500,200,50);
        JButton b6=new JButton("Return To Main Menu");
        b6.setBounds(630,500,310,50);
        b1.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.setFont(new Font("Arial", Font.PLAIN, 26));
        b3.setFont(new Font("Arial", Font.PLAIN, 26));
        b4.setFont(new Font("Arial", Font.PLAIN, 26));
        b5.setFont(new Font("Arial", Font.PLAIN, 26));
        b6.setFont(new Font("Arial", Font.PLAIN, 26));
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window11();
                W10.dispose();
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window12();
                W10.dispose();
            }
        });
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window13();
                W10.dispose();
            }
        });
        b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window14();
                W10.dispose();
            }
        });
        b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window15();
                W10.dispose();
            }
        });
        b6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window00();
                W10.dispose();
            }
        });
        ImageIcon img = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\administrator1.png");
        img.setImage(img.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(250,-10,500,300);

        W10.add(b1);
        W10.add(b2);
        W10.add(b3);
        W10.add(b4);
        W10.add(b5);
        W10.add(b6);

        W10.add(background);
        W10.getContentPane().setBackground(new Color(255, 244, 184));
        W10.setSize(1000,700);
        W10.setLayout(null);
        W10.setVisible(true);
    }
}
class window11 extends JFrame
{
    window11()
    {
        JFrame w11 = new JFrame("Add Item To Stock");
        JLabel l1=new JLabel("Name of the Item :");
        l1.setBounds(50,200, 300,30);
        JLabel l2=new JLabel("Price per Item :");
        l2.setBounds(50,250, 300,30);
        JLabel l3=new JLabel("Quantity To Be Added In Stock :");
        l3.setBounds(50,300, 400,30);
        JLabel l4=new JLabel("Batch Number :");
        l4.setBounds(50,350, 300,30);
        JLabel l5=new JLabel("Manufacture Date (yyyy-mm-dd):");
        l5.setBounds(50,400, 400,30);
        JLabel l6=new JLabel("Expiry Date (yyyy-mm-dd):");
        l6.setBounds(50,450, 400,30);
        JTextField t1=new JTextField(20);
        t1.setBounds(450,200, 300,30);
        JTextField t2=new JTextField(20);
        t2.setBounds(450,250, 300,30);
        JTextField t3=new JTextField(20);
        t3.setBounds(450,300, 300,30);
        JTextField t4=new JTextField(20);
        t4.setBounds(450,350, 300,30);
        JTextField t5=new JTextField(20);
        t5.setBounds(450,400, 300,30);
        JTextField t6=new JTextField(20);
        t6.setBounds(450,450, 300,30);
        JButton b1=new JButton("Add");
        b1.setBounds(400,540,130,40);
        JButton b2=new JButton("Cancel");
        b2.setBounds(850,600,120,40);
        b1.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.setFont(new Font("Arial", Font.PLAIN, 26));
        l1.setFont(new Font("Arial", Font.PLAIN, 26));
        l2.setFont(new Font("Arial", Font.PLAIN, 26));
        l3.setFont(new Font("Arial", Font.PLAIN, 26));
        l4.setFont(new Font("Arial", Font.PLAIN, 26));
        l5.setFont(new Font("Arial", Font.PLAIN, 26));
        l6.setFont(new Font("Arial", Font.PLAIN, 26));
        t1.setFont(new Font("Arial", Font.PLAIN, 26));
        t2.setFont(new Font("Arial", Font.PLAIN, 26));
        t3.setFont(new Font("Arial", Font.PLAIN, 26));
        t4.setFont(new Font("Arial", Font.PLAIN, 26));
        t5.setFont(new Font("Arial", Font.PLAIN, 26));
        t6.setFont(new Font("Arial", Font.PLAIN, 26));
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String url="jdbc:mysql://localhost:3306/sdp"; //database name
                String user="root";
                String pwd="";
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");//driver software
                    Connection con = DriverManager.getConnection(url,user,pwd);
                    Statement st = con.createStatement();
                    // stock is the table name
                    String sqlInsert="insert into stock values('"+t1.getText()+"','"+Integer.parseInt(t2.getText())+"', '"+Integer.parseInt(t3.getText())+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"')";
                    st.executeUpdate(sqlInsert);
                    System.out.println("record inserted successfully");
                    con.close();
                    JOptionPane.showMessageDialog(null, "Added Successfully","Done",JOptionPane.INFORMATION_MESSAGE);
                    new window10();
                    w11.dispose();
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window10();
                w11.dispose();
            }
        });
        ImageIcon img = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\visual-sell.png");
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(-260,-65,1500,900);

        ImageIcon img1 = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\stock.png");
        img1.setImage(img1.getImage().getScaledInstance(140,140,Image.SCALE_DEFAULT));
        JLabel background1= new JLabel("",img1,JLabel.CENTER);
        background1.setBounds(380,00,200,200);

        w11.add(l1);
        w11.add(l2);
        w11.add(l3);
        w11.add(l4);
        w11.add(l5);
        w11.add(l6);
        w11.add(t1);
        w11.add(t2);
        w11.add(t3);
        w11.add(t4);
        w11.add(t5);
        w11.add(t6);
        w11.add(b1);
        w11.add(b2);

//        w11.add(background);
        w11.add(background1);
        w11.getContentPane().setBackground(new Color(255, 244, 184));
        w11.setSize(1000,700);
        w11.setLayout(null);
        w11.setVisible(true);
    }
}
class window12 extends JFrame
{
    window12()
    {
        JFrame w12 = new JFrame("Database Result");
        JTable table = new JTable();
        JButton b2=new JButton("Back");
        b2.setBounds(750,600,200,30);
        String[] columnNames = {"Name","Rate", "Quantity", "Batch no.", "Mfg", "Exp"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String url="jdbc:mysql://localhost:3306/sdp"; //database name
        String user="root";
        String pwd="";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");//driver software
            Connection con = DriverManager.getConnection(url,user,pwd);
            String sql = "select * from stock";
            Statement ps =  con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            int i = 0;
            while(rs.next())
            {
                String name = rs.getString(1);
                int rate = rs.getInt(2);
                int quantity = rs.getInt(3);
                String batch =rs.getString(4);
                Date mfg =rs.getDate(5);
                Date exp =rs.getDate(6);
                model.addRow(new Object[]{name,rate,quantity,batch,mfg,exp});
                i++;
            }
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error",JOptionPane.ERROR_MESSAGE);
            }
            if(i ==1)
            {
                System.out.println(i+" Record Found");
            }
            else
            {
                System.out.println(i+" Records Found");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window10();
                w12.dispose();
            }
        });
        w12.add(b2);
        w12.add(scroll);
        w12.setVisible(true);
        w12.getContentPane().setBackground(Color.CYAN);
        w12.setSize(1000,700);
    }
}
class window13 extends JFrame
{
    window13()
    {
        JFrame w13 = new JFrame("Delete The Item From Stock");
        JLabel l1=new JLabel("Name of the Item :");
        l1.setBounds(530,275, 250,40);
        JLabel l2 = new JLabel("Item Not Found With The Associated Name!");
        JTextField t1=new JTextField(20);
        t1.setBounds(530,320, 300,40);
        JButton b1 = new JButton("Delete");
        b1.setBounds(530, 400, 150, 40);
        b1.setFont(new Font("Arial", Font.PLAIN, 26));
        l1.setFont(new Font("Arial", Font.PLAIN, 26));
        l2.setFont(new Font("Arial", Font.PLAIN, 26));
        t1.setFont(new Font("Arial", Font.PLAIN, 26));
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String url="jdbc:mysql://localhost:3306/sdp"; //database name
                String user="root";
                String pwd="";
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");//driver software
                    Connection con = DriverManager.getConnection(url,user,pwd);
                    Statement st = con.createStatement();
                    String sql = "select * from stock where name=('"+t1.getText()+"')";
                    ResultSet rs = st.executeQuery(sql);
                    String a = null;
                    while(rs.next())
                    {
                        a = rs.getString(1);
                        System.out.println(a);
                    }
                    // stock is the table name
                    if(a==null)
                    {
                        JOptionPane.showMessageDialog(null, "No Item Found With The Associated Name","Error",JOptionPane.ERROR_MESSAGE);
                        l2.setBounds(250, 550, 600,30);
                    }
                    else
                    {
                        String sqldelete="delete from stock where name=('"+t1.getText()+"')";
                        st.executeUpdate(sqldelete);
                        System.out.println("record deleted successfully");
                        JOptionPane.showMessageDialog(null, "Deleted Successfully","Done",JOptionPane.INFORMATION_MESSAGE);
                        new window10();
                        w13.dispose();
                    }
                    con.close();
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                    l2.setBounds(250, 550, 600,30);
                }

            }
        });
        JButton b2 = new JButton("Back");
        b2.setBounds(720, 400, 150, 40);
        b2.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window10();
                w13.dispose();
            }
        });
        ImageIcon img = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\visual-sell.png");
        img.setImage(img.getImage().getScaledInstance(465,320,Image.SCALE_DEFAULT));
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(-120,200,700,400);

        ImageIcon img1 = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\delete.png");
        img1.setImage(img1.getImage().getScaledInstance(165,130,Image.SCALE_DEFAULT));
        JLabel background1= new JLabel("",img1,JLabel.CENTER);
        background1.setBounds(380,30,200,200);

        w13.add(l1);
        w13.add(l2);
        w13.add(b1);
        w13.add(b2);
        w13.add(t1);

        w13.add(background);
        w13.add(background1);
        w13.getContentPane().setBackground(new Color(255, 244, 184));
        w13.setSize(1000,700);
        w13.setLayout(null);
        w13.setVisible(true);
    }
}
class window14 extends JFrame
{
    window14()
    {
        JFrame w14 = new JFrame("Add Partner");
        JLabel l1=new JLabel("New User Name :");
        l1.setBounds(520,250, 250,40);
        JLabel l2 = new JLabel("New Password :");
        l2.setBounds(520,350, 250,40);
        JTextField t1=new JTextField(20);
        t1.setBounds(520,285, 300,40);
        JTextField t2=new JTextField(20);
        t2.setBounds(520,385, 300,40);
        JButton b1 = new JButton("Create");
        b1.setBounds(520, 500, 150, 40);
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String url="jdbc:mysql://localhost:3306/sdp"; //database name
                String user="root";
                String pwd="";
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");//driver software
                    Connection con = DriverManager.getConnection(url,user,pwd);
                    Statement st = con.createStatement();
                    // admin is the table name
                    String sqlInsert="insert into admin values('"+t1.getText()+"','"+t2.getText()+"')";
                    st.executeUpdate(sqlInsert);
                    System.out.println("record inserted successfully");
                    con.close();
                    JOptionPane.showMessageDialog(null, "Added Successfully","Done",JOptionPane.INFORMATION_MESSAGE);
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
                new window10();
                w14.dispose();
            }
        });
        JButton b2 =new JButton("Back");
        b2.setBounds(700, 500, 150, 40);
        b1.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.setFont(new Font("Arial", Font.PLAIN, 26));
        t1.setFont(new Font("Arial", Font.PLAIN, 26));
        t2.setFont(new Font("Arial", Font.PLAIN, 26));
        l1.setFont(new Font("Arial", Font.PLAIN, 26));
        l2.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window10();
                w14.dispose();
            }
        });

        ImageIcon img = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\visual-sell.png");
        img.setImage(img.getImage().getScaledInstance(465,320,Image.SCALE_DEFAULT));
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(-120,200,700,400);

        ImageIcon img1 = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\addpartner.png");
        img1.setImage(img1.getImage().getScaledInstance(180,180,Image.SCALE_DEFAULT));
        JLabel background1= new JLabel("",img1,JLabel.CENTER);
        background1.setBounds(380,25,200,200);

        w14.add(l1);
        w14.add(l2);
        w14.add(t1);
        w14.add(t2);
        w14.add(b1);
        w14.add(b2);

        w14.add(background);
        w14.add(background1);
        w14.getContentPane().setBackground(new Color(255, 244, 184));
        w14.setSize(1000,700);
        w14.setLayout(null);
        w14.setVisible(true);
    }
}
class window15 extends JFrame
{
    window15()
    {
        JFrame w15 = new JFrame("Delete Partner");
        JLabel l1=new JLabel("User Name To Delete:");
        l1.setBounds(520,250,350,40);
        JLabel l2 = new JLabel("Password For Username:");
        JLabel l3 = new JLabel("Enter The Valid Credentials");
        l2.setBounds(520,350,350,40);
        JTextField t1=new JTextField(25);
        t1.setBounds(520,285,320,40);
        JTextField t2=new JTextField(25);
        t2.setBounds(520,385, 320,40);
        JButton b1 = new JButton("Delete");
        b1.setBounds(520, 500, 150, 40);
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String url="jdbc:mysql://localhost:3306/sdp"; //database name
                String user="root";
                String pwd="";
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");//driver software
                    Connection con = DriverManager.getConnection(url,user,pwd);
                    Statement st = con.createStatement();
                    String sql = "select * from admin where user=('"+t1.getText()+"') AND pass=('"+t2.getText()+"')";
                    ResultSet rs = st.executeQuery(sql);
                    String a = null;
                    while(rs.next())
                    {
                        a = rs.getString(1);
                        System.out.println(a);
                    }
                    if(a==null)
                    {
                        JOptionPane.showMessageDialog(null, "No Record Found","Error",JOptionPane.ERROR_MESSAGE);
                        l3.setBounds(350, 550, 550,30);
                    }
                    else
                    {
                        // admin is the table name
                        String sqldelete="delete from admin where user=('"+t1.getText()+"') AND pass=('"+t2.getText()+"')";
                        st.executeUpdate(sqldelete);
                        System.out.println("record deleted successfully");
                        JOptionPane.showMessageDialog(null, "Deleted Successfully","Done",JOptionPane.INFORMATION_MESSAGE);
                        new window10();
                        w15.dispose();
                    }
                    con.close();
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                    l3.setBounds(350, 550,550,30);
                }
            }
        });
        JButton b2 =new JButton("Back");
        b2.setBounds(700, 500, 150, 40);
        b1.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.setFont(new Font("Arial", Font.PLAIN, 26));
        t1.setFont(new Font("Arial", Font.PLAIN, 26));
        t2.setFont(new Font("Arial", Font.PLAIN, 26));
        l1.setFont(new Font("Arial", Font.PLAIN, 26));
        l2.setFont(new Font("Arial", Font.PLAIN, 26));
        l3.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window10();
                w15.dispose();
            }
        });
        ImageIcon img = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\visual-sell.png");
        img.setImage(img.getImage().getScaledInstance(465,320,Image.SCALE_DEFAULT));
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(-120,200,700,400);

        ImageIcon img1 = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\addpartner.png");
        img1.setImage(img1.getImage().getScaledInstance(180,180,Image.SCALE_DEFAULT));
        JLabel background1= new JLabel("",img1,JLabel.CENTER);
        background1.setBounds(380,25,200,200);

        w15.add(l1);
        w15.add(l2);
        w15.add(l3);
        w15.add(t1);
        w15.add(t2);
        w15.add(b1);
        w15.add(b2);

        w15.add(background);
        w15.add(background1);
        w15.getContentPane().setBackground(new Color(255, 244, 184));
        w15.setSize(1000,700);
        w15.setLayout(null);
        w15.setVisible(true);
    }
}
class window20 extends JFrame
{
    window20()
    {
        JFrame W20=new JFrame("Welcome To Shopping Market");
        JLabel l1 = new JLabel("Customer Dashboard");
        l1.setFont(new Font("Verdana", Font.PLAIN,50));
        l1.setBounds(300, 0, 1000, 200);

        JButton b1=new JButton("Add Item To Cart");
        b1.setBounds(580,210,270,45);
        JButton b2=new JButton("View Cart");
        b2.setBounds(910,210,200,45);
        JButton b3=new JButton("Delete Item From Cart");
        b3.setBounds(580,335,270,45);
        JButton b4=new JButton("Confirm Order");
        b4.setBounds(910,335,200,45);
        JButton b5=new JButton("Cancel Order");
        b5.setBounds(910,470,200,45);
        JButton b6=new JButton("Return To Main Menu");
        b6.setBounds(580,470,270,45);
        b1.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.setFont(new Font("Arial", Font.PLAIN, 26));
        b3.setFont(new Font("Arial", Font.PLAIN, 23));
        b4.setFont(new Font("Arial", Font.PLAIN, 26));
        b5.setFont(new Font("Arial", Font.PLAIN, 26));
        b6.setFont(new Font("Arial", Font.PLAIN, 23));
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window21();
                W20.dispose();
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window22();
                W20.dispose();
            }
        });
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window23();
                W20.dispose();
            }
        });
        b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window24();
                W20.dispose();
            }
        });
        b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window25();
                W20.dispose();
            }
        });
        b6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window00();
                W20.dispose();
            }
        });
        ImageIcon img = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\visual-sell.png");
        img.setImage(img.getImage().getScaledInstance(525,380,Image.SCALE_DEFAULT));
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(-75,200,700,400);
//        background.setBounds(-260,-65,1500,900);

        W20.add(l1);
        W20.add(b1);
        W20.add(b2);
        W20.add(b3);
        W20.add(b4);
        W20.add(b5);
        W20.add(b6);
        W20.add(background);
        W20.setSize(1200,700);
        W20.getContentPane().setBackground(new Color(255, 244, 184));
        W20.setLayout(null);
        W20.setVisible(true);
    }
}

class window21 extends JFrame
{
    window21()
    {
        JFrame w21 = new JFrame("Add Item To Cart");
        JLabel l1=new JLabel("Name Of Item :");
        l1.setBounds(50,275, 250,40);
        JLabel l2 = new JLabel("Quantity Required :");
        JLabel l3 = new JLabel("Sorry! Item Is Not Available");
        JLabel l4 = new JLabel("Sorry! Less Item Is Available");
        l2.setBounds(50,375, 250,40);
        JTextField t1=new JTextField(20);
        t1.setBounds(300,275, 300,40);
        JTextField t2=new JTextField(20);
        t2.setBounds(300,375, 300,40);
        JButton b1 = new JButton("Add");
        b1.setBounds(300, 500, 300, 40);
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String url="jdbc:mysql://localhost:3306/sdp"; //database name
                String user="root";
                String pwd="";
                int price = 0;
                int quantity = 0;
                String a = null;
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");//driver software
                    Connection con = DriverManager.getConnection(url,user,pwd);
                    Statement st = con.createStatement();
                    String sql = "select * from stock where name=('"+t1.getText()+"')";
                    ResultSet rs = st.executeQuery(sql);
                    while(rs.next())
                    {
                        a = rs.getString(1);
                        price = rs.getInt(2);
                        quantity = rs.getInt(3);
                        System.out.println(a);
                        System.out.println(price);
                    }
                    if(a==null)
                    {
                        JOptionPane.showMessageDialog(null, "Sorry Item Is Not Available","Error",JOptionPane.ERROR_MESSAGE);
                        l3.setBounds(300, 550, 450, 30);
                        l4.setBounds(0,0,0,0);
                    }
                    // order is the table name
                    if(quantity >= Integer.parseInt(t2.getText()))
                    {
                        String sqlInsert="insert into cusorder values('"+t1.getText()+"','"+Integer.parseInt(t2.getText())+"', '"+(price*Integer.parseInt(t2.getText()))+"')";
                        st.executeUpdate(sqlInsert);
                        System.out.println("record inserted successfully");
                        String sqlupdate="update stock set quantity = ('"+(quantity - Integer.parseInt(t2.getText()))+"') where name=('"+t1.getText()+"')";
                        st.executeUpdate(sqlupdate);
                        System.out.println("record updated successfully");
                        JOptionPane.showMessageDialog(null, "Added Successfully","Done",JOptionPane.INFORMATION_MESSAGE);
                        new window20();
                        w21.dispose();
                    }
                    else if(a!=null)
                    {
                        l4.setBounds(300,550,450,30);
                        l3.setBounds(0,0,0,0);
                    }
                    con.close();
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
        });
        JButton b2 =new JButton("Back");
        b2.setBounds(300, 600, 300, 30);
        b1.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.setFont(new Font("Arial", Font.PLAIN, 26));
        t1.setFont(new Font("Arial", Font.PLAIN, 26));
        t2.setFont(new Font("Arial", Font.PLAIN, 26));
        l1.setFont(new Font("Arial", Font.PLAIN, 26));
        l2.setFont(new Font("Arial", Font.PLAIN, 26));
        l3.setFont(new Font("Arial", Font.PLAIN, 26));
        l4.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window20();
                w21.dispose();
            }
        });

        JButton b3=new JButton("View Available Stock");
        b3.setBounds(700,330,250,45);

        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window121();
                w21.dispose();
            }
        });
        b3.setFont(new Font("Arial", Font.PLAIN, 20));

        ImageIcon img = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\visual-sell.png");
        img.setImage(img.getImage().getScaledInstance(465,320,Image.SCALE_DEFAULT));
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(-120,200,700,400);

        ImageIcon img1 = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\cart.png");
        img1.setImage(img1.getImage().getScaledInstance(174,170,Image.SCALE_DEFAULT));
        JLabel background1= new JLabel("",img1,JLabel.CENTER);
        background1.setBounds(380,20,200,200);

        w21.add(l1);
        w21.add(l2);
        w21.add(l3);
        w21.add(l4);
        w21.add(t1);
        w21.add(t2);
        w21.add(b1);
        w21.add(b2);
        w21.add(b3);

//        w21.add(background);
        w21.add(background1);
        w21.getContentPane().setBackground(new Color(255, 244, 184));
        w21.setSize(1000,700);
        w21.setLayout(null);
        w21.setVisible(true);

    }
}
class window121 extends JFrame
{
    window121()
    {
        JFrame w121 = new JFrame("Database Result");
        JTable table = new JTable();
        JButton b2=new JButton("Back");
        b2.setBounds(750,600,200,30);
        String[] columnNames = {"Name","Rate", "Quantity", "Batch no.", "Mfg", "Exp"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String url="jdbc:mysql://localhost:3306/sdp"; //database name
        String user="root";
        String pwd="";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");//driver software
            Connection con = DriverManager.getConnection(url,user,pwd);
            String sql = "select * from stock";
            Statement ps =  con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            int i = 0;
            while(rs.next())
            {
                String name = rs.getString(1);
                int rate = rs.getInt(2);
                int quantity = rs.getInt(3);
                String batch =rs.getString(4);
                Date mfg =rs.getDate(5);
                Date exp =rs.getDate(6);
                model.addRow(new Object[]{name,rate,quantity,batch,mfg,exp});
                i++;
            }
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error",JOptionPane.ERROR_MESSAGE);
            }
            if(i ==1)
            {
                System.out.println(i+" Record Found");
            }
            else
            {
                System.out.println(i+" Records Found");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window21();
                w121.dispose();
            }
        });
        w121.add(b2);
        w121.add(scroll);
        w121.setVisible(true);
        w121.getContentPane().setBackground(Color.CYAN);
        w121.setSize(1000,700);
    }
}

class window22 extends JFrame
{
    window22()
    {
        JFrame w22 = new JFrame("Database Result");
        JTable table = new JTable();
        JButton b2=new JButton("Back");
        b2.setBounds(750,600,200,30);
        String[] columnNames = {"Name","Quantity", "Amount"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String url="jdbc:mysql://localhost:3306/sdp"; //database name
        String user="root";
        String pwd="";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");//driver software
            Connection con = DriverManager.getConnection(url,user,pwd);
            String sql = "select * from cusorder";
            Statement ps =  con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            int total=0;
            int i = 0;
            while(rs.next())
            {
                String name = rs.getString(1);
                int req = rs.getInt(2);
                int amount = rs.getInt(3);
                total += amount;
                model.addRow(new Object[]{name,req,amount});
                i++;
            }
            model.addRow(new Object[]{"Total", null, total});
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error",JOptionPane.ERROR_MESSAGE);
            }
            if(i ==1)
            {
                System.out.println(i+" Record Found");
            }
            else
            {
                System.out.println(i+" Records Found");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window20();
                w22.dispose();
            }
        });
        w22.add(b2);
        w22.add(scroll);
        w22.setVisible(true);
        w22.getContentPane().setBackground(Color.CYAN);
        w22.setSize(1000,700);
    }
}
class window23 extends JFrame
{
    window23()
    {
        JFrame w23 = new JFrame("Delete The Item From Cart");
        JLabel l1=new JLabel("Name of the Item :");
        l1.setBounds(530,275, 250,40);
        JLabel l2 = new JLabel("Item Not Found With The Associated Name!");
        JTextField t1=new JTextField(20);
        t1.setBounds(530,320, 300,40);
        JButton b1 = new JButton("Delete");
        b1.setBounds(530, 400, 150, 40);
        b1.setFont(new Font("Arial", Font.PLAIN, 26));
        l1.setFont(new Font("Arial", Font.PLAIN, 26));
        l2.setFont(new Font("Arial", Font.PLAIN, 26));
        t1.setFont(new Font("Arial", Font.PLAIN, 26));
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String url="jdbc:mysql://localhost:3306/sdp"; //database name
                String user="root";
                String pwd="";
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");//driver software
                    Connection con = DriverManager.getConnection(url,user,pwd);
                    Statement st = con.createStatement();
                    String sql = "select * from cusorder where name=('"+t1.getText()+"')";
                    ResultSet rs = st.executeQuery(sql);
                    String a = null;
                    int req = 0;
                    // int price = 0;
                    int quantity = 0;
                    while(rs.next())
                    {
                        a = rs.getString(1);
                        req = rs.getInt(2);
                        System.out.println(a);
                    }
                    if(a==null)
                    {
                        JOptionPane.showMessageDialog(null, "Item with associated name is not In Cart","Error",JOptionPane.ERROR_MESSAGE);
                        l2.setBounds(200, 550, 600, 30);
                    }
                    else
                    {
                        sql = "select * from stock where name=('"+t1.getText()+"')";
                        rs = st.executeQuery(sql);
                        while(rs.next())
                        {
                            a = rs.getString(1);
                            // price = rs.getInt(2);
                            quantity = rs.getInt(3);
                            System.out.println(a);
                            // System.out.println(price);
                        }
                        String name = t1.getText();
                        String sqldelete="delete from cusorder where name=('"+name+"')";
                        st.executeUpdate(sqldelete);
                        System.out.println("record deleted successfully");
                        String sqlupdate="update stock set quantity = ('"+(quantity + req)+"') where name=('"+t1.getText()+"')";
                        st.executeUpdate(sqlupdate);
                        System.out.println("record updated successfully");
                        JOptionPane.showMessageDialog(null, "Deleted Successfully","Done",JOptionPane.INFORMATION_MESSAGE);
                        new window20();
                        w23.dispose();
                    }
                    con.close();
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                    l2.setBounds(200, 550, 600,30);
                }
            }
        });
        JButton b2 = new JButton("Back");
        b2.setBounds(720, 400, 150, 40);
        b2.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window20();
                w23.dispose();
            }
        });
        ImageIcon img = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\visual-sell.png");
        img.setImage(img.getImage().getScaledInstance(465,320,Image.SCALE_DEFAULT));
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(-120,200,700,400);

        ImageIcon img1 = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\delete.png");
        img1.setImage(img1.getImage().getScaledInstance(165,130,Image.SCALE_DEFAULT));
        JLabel background1= new JLabel("",img1,JLabel.CENTER);
        background1.setBounds(380,30,200,200);

        w23.add(l1);
        w23.add(l2);
        w23.add(b1);
        w23.add(b2);
        w23.add(t1);

        w23.add(background);
        w23.add(background1);
        w23.getContentPane().setBackground(new Color(255, 244, 184));
        w23.setSize(1000,700);
        w23.setLayout(null);
        w23.setVisible(true);
    }
}
class window24 extends JFrame
{
    window24()
    {
        JFrame w24 = new JFrame("Place Order");
        JLabel l1=new JLabel("Name of Customer :");
        l1.setBounds(50,300, 300,40);
        JLabel l2 = new JLabel("Customer Mobile No. :");
        JLabel l3 = new JLabel("Sorry! No Item In Cart");
        l2.setBounds(50,400, 300,40);
        JTextField t1=new JTextField(20);
        t1.setBounds(350,300, 300,40);
        JTextField t2=new JTextField(20);
        t2.setBounds(350,400, 300,40);
        JButton b1 = new JButton("Confirm");
        b1.setFont(new Font("Arial", Font.PLAIN, 26));
        b1.setBounds(350, 500, 150, 40);
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String url="jdbc:mysql://localhost:3306/sdp"; //database name
                String user="root";
                String pwd="";
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");//driver software
                    Connection con = DriverManager.getConnection(url,user,pwd);
                    String sql = "select * from cusorder";
                    Statement ps =  con.createStatement();
                    ResultSet rs = ps.executeQuery(sql);
                    int total=0;
                    while(rs.next())
                    {
                        int amount = rs.getInt(3);
                        total += amount;
                    }
                    Statement st = con.createStatement();
                    // stock is the table name
                    if(total>0)
                    {
                        String sqlInsert="insert into cusinfo values('"+t1.getText()+"','"+Long.parseLong(t2.getText())+"', '"+total+"')";
                        st.executeUpdate(sqlInsert);
                        System.out.println("record inserted successfully");
                        function f = new function();
                        sql = "select * from cusorder";
                        rs = st.executeQuery(sql);
                        String a = null;
                        while(rs.next())
                        {
                            a = rs.getString(1);
                            System.out.println(a);
                            f.delete2(a);
                        }
                        con.close();
                        JOptionPane.showMessageDialog(null, "Order Placed Successfully","Done",JOptionPane.INFORMATION_MESSAGE);
                        placeOrder p1 = new placeOrder();
                        p1.place(total);
                        w24.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "No Item In Cart","Error",JOptionPane.ERROR_MESSAGE);
                        l3.setBounds(350,550,500,30);
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
        });
        JButton b2 =new JButton("Back");
        b2.setBounds(550, 500, 150, 40);
        b1.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.setFont(new Font("Arial", Font.PLAIN, 26));
        t1.setFont(new Font("Arial", Font.PLAIN, 26));
        t2.setFont(new Font("Arial", Font.PLAIN, 26));
        l1.setFont(new Font("Arial", Font.PLAIN, 26));
        l2.setFont(new Font("Arial", Font.PLAIN, 26));
        l3.setFont(new Font("Arial", Font.PLAIN, 26));
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window20();
                w24.dispose();
            }
        });
        ImageIcon img = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\visual-sell.png");
        img.setImage(img.getImage().getScaledInstance(465,320,Image.SCALE_DEFAULT));
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(-120,200,700,400);

        ImageIcon img1 = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\placeorder.png");
        img1.setImage(img1.getImage().getScaledInstance(240,175,Image.SCALE_DEFAULT));
        JLabel background1= new JLabel("",img1,JLabel.CENTER);
        background1.setBounds(370,25,240,200);

        w24.add(l1);
        w24.add(l2);
        w24.add(l3);
        w24.add(b1);
        w24.add(b2);
        w24.add(t1);
        w24.add(t2);

//        w24.add(background);
        w24.add(background1);
        w24.getContentPane().setBackground(new Color(255, 244, 184));
        w24.setSize(1000,700);
        w24.setLayout(null);
        w24.setVisible(true);
    }
}
class window25 extends JFrame
{
    window25()
    {
        JFrame w25 = new JFrame("Cancel The Order");
        JLabel l1 = new JLabel("Confirm  ?");
        l1.setBounds(380,150,400,79);
        JLabel l2 = new JLabel("Cancel The Order");
        l2.setBounds(250,250,600,79);
        JButton b1 = new JButton("Yes");
        b1.setBounds(200,400, 300,30);
        JButton b2 = new JButton("No");
        b2.setBounds(550,400, 300, 30);
        b1.setFont(new Font("Arial", Font.PLAIN, 26));
        l1.setFont(new Font("Arial", Font.PLAIN, 72));
        l2.setFont(new Font("Arial", Font.PLAIN, 72));
        b2.setFont(new Font("Arial", Font.PLAIN, 26));
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                function f = new function();
                String url="jdbc:mysql://localhost:3306/sdp"; //database name
                String user="root";
                String pwd="";
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");//driver software
                    Connection con = DriverManager.getConnection(url,user,pwd);
                    Statement st = con.createStatement();
                    String sql = "select * from cusorder";
                    ResultSet rs = st.executeQuery(sql);
                    String a = null;
                    while(rs.next())
                    {
                        a = rs.getString(1);
                        System.out.println(a);
                        f.delete(a);
                    }
                    JOptionPane.showMessageDialog(null, "Order Cancelled Successfully","Done",JOptionPane.INFORMATION_MESSAGE);
                    new window00();
                    w25.dispose();
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
        });
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new window20();
                w25.dispose();
            }
        });
        ImageIcon img = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\visual-sell.png");
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(-260,-65,1500,900);

        w25.add(l1);
        w25.add(l2);
        w25.add(b1);
        w25.add(b2);
//        w25.add(background);
        w25.getContentPane().setBackground(new Color(255, 244, 184));
        w25.setSize(1000,700);
        w25.setLayout(null);
        w25.setVisible(true);
    }
}
class placeOrder extends JFrame
{
    public void place(int s)
    {
        JFrame w000 = new JFrame("Your Order Has Been Placed");
        JLabel l1 = new JLabel("Please PAY!  "+s + "  Rupees by Cash" );
        JLabel l2 = new JLabel(" Or Scan Below QR Code for UPI Payment");
//        JLabel l3 = new JLabel("");
        JLabel l4 = new JLabel("THANK YOU!! Visit Again");
        JButton b2 = new JButton("OKAY");
        l4.setFont(new Font("Arial", Font.PLAIN, 24));
        b2.setFont(new Font("Arial", Font.PLAIN, 26));
        l1.setFont(new Font("Arial", Font.PLAIN, 26));
        l2.setFont(new Font("Arial", Font.PLAIN, 26));
//        l3.setFont(new Font("Arial", Font.PLAIN, 26));
        l1.setBounds(220,20, 600, 30);
        l2.setBounds(200,60, 600, 30);
//        l3.setBounds(400,40, 300, 30);
        l4.setBounds(310,675, 400, 30);
        b2.setBounds(370,725, 120, 30);
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, "Thank You Visit Again","Done",JOptionPane.INFORMATION_MESSAGE);
                new window00();
                w000.dispose();
            }
        });
        ImageIcon img = new ImageIcon("C:\\Users\\Pushkar\\IdeaProjects\\OOP\\src\\SDP\\payment.jfif");
        img.setImage(img.getImage().getScaledInstance(450,555,Image.SCALE_DEFAULT));
        JLabel background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(225,100,500,555);

        w000.add(b2);
        w000.add(l1);
        w000.add(l2);
//        w000.add(l3);
        w000.add(l4);
        w000.add(background);
        w000.getContentPane().setBackground(new Color(255, 244, 184));
        w000.setSize(1000,800);
        w000.setLayout(null);
        w000.setVisible(true);
    }
}
public class Main
{
    public static void main(String[] args)
    {
        window00 w01 = new window00();
    }
}

