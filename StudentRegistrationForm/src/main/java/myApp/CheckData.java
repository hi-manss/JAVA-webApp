package myApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class CheckData extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
				boolean ans;
				PrintWriter pw=res.getWriter();
				res.setContentType("text/html");
				String name=req.getParameter("email");
				String pswrd=req.getParameter("pass");
				String url="jdbc:mysql://localhost:3306/userinfo";
				String username="root";
				String psrd="";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c= DriverManager.getConnection(url,username,psrd);
					Statement s=c.createStatement();
					ResultSet r=s.executeQuery("select * from users");
					ans=true;
					while(r.next())
					{
						if(name.equals(r.getString(2)) && pswrd.equals(r.getString(3)))
						{
							GetData.obj(r.getInt(1));
							/*RequestDispatcher disp=req.getRequestDispatcher("html/form.html");
							disp.forward(req, res);*/
							res.sendRedirect("html/form.html");
							ans=false;
							break;
						}
					}
					if(ans)
					{
						pw.println("<h1>Oops! Wrong Username/Password...</h1>");
					}
					c.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
}
