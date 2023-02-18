package myApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchData extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		String url="jdbc:mysql://localhost:3306/userinfo";
		String username="root";
		String psrd="";
		String semester=req.getParameter("result-sem");
		String usn=req.getParameter("result-usn");
		PrintWriter pw;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(url, username, psrd);
			Statement s=c.createStatement();
			ResultSet r=s.executeQuery("select * from userinfo");
			while(r.next())
			{
				if(usn.equals(r.getString(3)))
				{
					pw = res.getWriter();
					pw.println("Match Found. "+semester+" "+usn);
					pw.println(r.getString(2));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
