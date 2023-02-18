package myApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData{
	public static void inst(User ob)
	{
		String url="jdbc:mysql://localhost:3306/userinfo";
		String username="root";
		String psrd="";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c= DriverManager.getConnection(url,username,psrd);
			PreparedStatement s=c.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			s.setInt(1,ob.ID);
			s.setString(2, ob.name);
			s.setString(3, ob.USN);
			s.setString(4, ob.DOB);
			s.setString(5, ob.Email);
			s.setString(6, ob.MobileNumber);
			s.setString(7, ob.Gender);
			s.setString(8, ob.FatherName);
			s.setString(9, ob.MotherName);
			s.setString(10, ob.Address);
			s.setString(11, ob.Nationality);
			s.setString(12, ob.State);
			s.setString(13, ob.District);
			for(int i=0;i<2;i++)
			{
				s.setString(i+14, ob.tenth[i]);
			}
			for(int i=0;i<2;i++)
			{
				s.setInt(i+16, ob.tenMark[i]);
			}
			for(int i=0;i<2;i++)
			{
				s.setString(i+18, ob.twelth[i]);
			}
			for(int i=0;i<2;i++)
			{
				s.setInt(i+20, ob.twelveMark[i]);
			}
			
			s.setString(22, ob.AdmissionPath);
			s.setString(23, ob.AdmissionNumber);
			s.setInt(24, ob.Rank);
			s.setString(25, ob.Branch);
			s.executeUpdate();
			s.close();
			c.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
