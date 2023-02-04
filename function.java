package SDP;

import java.sql.*;
public class function
{
    public void delete(String name)
    {//cancel order
        String url="jdbc:mysql://localhost:3306/sdp"; //database name
        String user="root";
        String pwd="";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");//driver software
            Connection con = DriverManager.getConnection(url,user,pwd);
            Statement st = con.createStatement();
            String sql = "select * from cusorder where name=('"+name+"')";
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
            sql = "select * from stock where name=('"+name+"')";
            rs = st.executeQuery(sql);
            while(rs.next())
            {
                a = rs.getString(1);
                // price = rs.getInt(2);
                quantity = rs.getInt(3);
                System.out.println(a);
                // System.out.println(price);
            }
            String sqldelete="delete from cusorder where name=('"+name+"')";
            st.executeUpdate(sqldelete);
            System.out.println("record deleted successfully");
            String sqlupdate="update stock set quantity = ('"+(quantity + req)+"') where name=('"+name+"')";
            st.executeUpdate(sqlupdate);
            System.out.println("record updated successfully");
            con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public void delete2(String name)
    {
        String url="jdbc:mysql://localhost:3306/sdp"; //database name
        String user="root";
        String pwd="";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");//driver software
            Connection con = DriverManager.getConnection(url,user,pwd);
            Statement st = con.createStatement();
            String sql = "select * from cusorder where name=('"+name+"')";
            ResultSet rs = st.executeQuery(sql);
            String a = null;
            while(rs.next())
            {
                a = rs.getString(1);
                System.out.println(a);
            }
            String sqldelete="delete from cusorder where name=('"+name+"')";
            st.executeUpdate(sqldelete);
            System.out.println("record deleted successfully");
            con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
