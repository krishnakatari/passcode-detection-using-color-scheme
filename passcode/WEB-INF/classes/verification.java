import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class verification extends HttpServlet
{   String col;
	String randomstring;
	String username;
	String enterpwd;
	String originalpwd;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
PrintWriter out=response.getWriter( );
response.setContentType("text/html");

		//DBLogic
		try
		{
			  Cookie ck[]=request.getCookies();  
    col=ck[0].getValue();
	randomstring=ck[1].getValue();
  username=
		request.getParameter("USERNAME");
	  enterpwd=request.getParameter("PASSWORD");

         Class.forName
			 ("oracle.jdbc.driver.OracleDriver");
		 
		 Connection con = DriverManager.getConnection
			 ("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");

		 Statement st=con.createStatement();
             if(st.execute("SELECT password FROM users where username='"+username+"'"));
		  {
	        ResultSet rs=st.getResultSet( );
			originalpwd =rs.getString(1);
		  }
		}//try
catch(SQLException sqle)
	{out.print(sqle);}//catch1

catch(ClassNotFoundException cnfe)
  { out.print(cnfe);}//catch2
catch(Exception e)
		{out.print(e);}
	
out.print("<body bgcolor=green text=white>");
out.print("<h1 align=center> Sb Servlet FROM Sa"+ col+"</h1>");
out.print("<h1 align=center> Sb Servlet FROM Sa"+ randomstring+"</h1>");
out.print("<h1 align=center> Sb Servlet FROM Sa"+ enterpwd +"</h1>");
out.print("<h1 align=center> Sb Servlet FROM Sa"+ originalpwd +"</h1>");

out.print("</body>");
out.close();
	}
}