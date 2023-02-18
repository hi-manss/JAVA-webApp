package myApp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/html/input")
public class GetData extends HttpServlet{
		static User a=new User();
		static int id;
		public static void obj(int id) {
			a.ID=id;
		}
		public void doPost(HttpServletRequest req,HttpServletResponse res) {
			PrintWriter out;
			a.name=req.getParameter("full-name");
			a.USN=req.getParameter("usn");
			a.DOB=req.getParameter("dob");
			a.Email=req.getParameter("email");
			a.MobileNumber=req.getParameter("mob-number");
			a.Gender=req.getParameter("gender");
			a.FatherName=req.getParameter("father-name");
			a.MotherName=req.getParameter("mother-name");
			a.Address=req.getParameter("address");
			a.Nationality=req.getParameter("nationality");
			a.State=req.getParameter("state");
			a.District=req.getParameter("district");
			a.tenth[0]=req.getParameter("10-board");
			a.tenth[1]=req.getParameter("10-regis");
			a.tenMark[0]=Integer.parseInt(req.getParameter("10-max"));
			a.tenMark[1]=Integer.parseInt(req.getParameter("10-obtained"));
			a.twelth[0]=req.getParameter("12-board");
			a.twelth[1]=req.getParameter("12-regis");
			a.twelveMark[0]=Integer.parseInt(req.getParameter("12-max"));
			a.twelveMark[1]=Integer.parseInt(req.getParameter("12-obtained"));
			a.AdmissionPath=req.getParameter("admission");
			a.AdmissionNumber=req.getParameter("admission-number");
			a.Rank=Integer.parseInt(req.getParameter("ce-rank"));
			a.Branch=req.getParameter("branch");
			InsertData.inst(a);
			try {
				out = res.getWriter();
				out.println("<h1>Your Response has been recorded!</h1>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
