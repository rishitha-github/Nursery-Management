package Ndao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nmod.Cmod;
import com.nmod.Nmod;

public class Ndao {
	static String result=null;
	static String url="jdbc:mysql://localhost:3306/nursery";
	static String usname="root";
	static String passw="admin";
	static int count;
	static Connection con=null;
	static PreparedStatement ps;
	public static String veri(String uname1,String pass)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,usname,passw);
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from admin");
			while(rs.next())
			{
				String uname=rs.getString("uname");
				String password=rs.getString("password");
				if(uname.equals(uname1) && password.equals(pass))
				{
					return "success";
				
				}
								}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return "failure";

		
		
		
	}
	public static int insert(int number,int price)
	{
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,usname,passw);
		PreparedStatement ps= con.prepareStatement("insert into brinjal(number,price) values(?,?)");
		ps.setInt(1, number);
		ps.setInt(2, price);
		
	count=	ps.executeUpdate();
		ps.close();
		con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	public static ArrayList<Nmod> display()
	{
		ArrayList<Nmod> al=new ArrayList<Nmod>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,usname,passw);
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from brinjal");
			while(rs.next())
			{
			int stockid=rs.getInt("stockid");
			int number=rs.getInt("number");
		Nmod n= new Nmod(stockid, number);
			al.add(n);
				
								}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return al;
	}
	public static void delete(int stockid) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,usname,passw);
		PreparedStatement ps= con.prepareStatement("delete from brinjal where stockid = ?");
		ps.setInt(1,stockid);
		
		
	    ps.executeUpdate();
		ps.close();
		con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
    public static int cinsert(String cname,Long cnum,int camount) {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,usname,passw);
		PreparedStatement ps= con.prepareStatement("insert into customer(cname,cnumber,amount) values(?,?,?)");
		ps.setString(1, cname);
		ps.setLong(2, cnum);
		ps.setInt(3, camount);
		
	count=	ps.executeUpdate();
		ps.close();
		con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
    }
    
    public static ArrayList<Cmod> cdisplay()
	{
		ArrayList<Cmod> all=new ArrayList<Cmod>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,usname,passw);
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from customer");
			while(rs.next())
			{
			int id=rs.getInt("id");
			String cname=rs.getString("cname");
			Long cnumber = rs.getLong("cnumber");
			int amt=rs.getInt("amount");
		Cmod c = new Cmod(id, cname, cnumber, amt);
			all.add(c);
				
								}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return all;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
