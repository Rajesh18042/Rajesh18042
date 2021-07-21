package Project;

import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.*;
import javax.servlet.http.*;
import com.oreilly.servlet.MultipartRequest;

public class Backend extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		String unumber=req.getParameter("unumber");
		String email=req.getParameter("email");
		String mnumber=req.getParameter("mobile");
		String dob=req.getParameter("dob");
		String gender=req.getParameter("gender");
		String sslc=req.getParameter("ssc");
		String hsc=req.getParameter("hsc");
		String etype=req.getParameter("etype");
		String cname=req.getParameter("college");
		String qualification=req.getParameter("qualification");
		String tarea=req.getParameter("tarea");
		//MultipartRequest m=new MultipartRequest(req,"E:\\");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","rajesh");  
			PreparedStatement ps=con.prepareStatement("insert into project values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,fname);
			ps.setString(2,lname);
			ps.setString(3,password);
			ps.setString(4,address);
			ps.setString(5,unumber);
			ps.setString(6,email);
			ps.setString(7,mnumber);
			ps.setString(8,dob);
			ps.setString(9,gender);
			ps.setString(10,sslc);
			ps.setString(11,hsc);
			ps.setString(12,etype);
			ps.setString(13,cname);
			ps.setString(14,qualification);
			ps.setString(15,tarea);
			int i=ps.executeUpdate();
			if(i>0)
				out.print("your are successfully registered...");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

