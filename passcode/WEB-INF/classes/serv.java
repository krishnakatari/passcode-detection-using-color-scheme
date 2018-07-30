import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import java.util.Math.*;
public class serv extends HttpServlet
{
	StringBuffer  randomstring=new StringBuffer("");
	StringBuffer col=new StringBuffer("");	
	String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
     public String  color()
    {
                
                 switch((int)Math.floor(Math.random() * (7 - 1) ) + 1)
                  {
                        case 1:col.append("r");return("red");
                        case 2:col.append("g");return("green");
                        case 3:col.append("r");return("red");
                        case 4:col.append("b");return("blue");
                        case 5:col.append("o");return("orange");
                        case 6:col.append("y");return("yellow");
						default: col.append("r"); return("red");                 
				  }
     /////default return (no colr like blck)
	 //return "";
    }
                                                                      //printing characters in table
public char alphaNum()
{
         
		int rnum = (int)Math.floor(Math.random() * chars.length());
        char ch= chars.charAt(rnum);      ///////////we can use chaAt
   int flag=0;
		for(int k=0;k<randomstring.length();k++)
	{
			if(randomstring.charAt(k)==ch)
		{ flag=1; break;}
	}
                                        if(flag==0) 
                                        {
                                        randomstring.append(String.valueOf(ch));     
                                        return ch;
                                        }
                                        else
                                         {
                                            return alphaNum();
                                         }
}


	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        PrintWriter pw=res.getWriter(); 
		res.setContentType("Text/Html");
        
		//html
		pw.println
			("<body bgcolor=white text=black> <form action=\"verification.com\" method=\"post\">");
     pw.println("<h1 align=center> Login Form </h1> <hr><br><br>  <table align=center border=0>");
	    pw.println
			("<tr><td>Enter Username : </td> <td><input type=text name=USERNAME></td></tr>");

		pw.println("<tr><td>Enter Password : </td>");
		   pw.println("<td><input type=password name=PASSWORD></td></tr>");

	   pw.println
		   ("<tr><td></td>      <td align=right>  <input type=submit value=Login>	 </td></tr>");
	 pw.println("</table>  ");
        
		pw.println("<table align=center border=2 color=light blue>");
        for(int i=1;i<=6;i++)
        {
        pw.println("<tr>");
        for(int j=1;j<=6;j++)
        {
         
        //String c=req.getParameter("color");
         String c=color();
         char ch=alphaNum();
         if(c.equals("red"))
            pw.println("<td BGCOLOR=\"red\" align=\"center\">");
        if(c.equals("green"))
            pw.println("<td BGCOLOR=\"green\" align=\"center\">");
        if(c.equals("orange"))
            pw.println("<td BGCOLOR=\"orange\" align=\"center\">");

        if(c.equals("blue"))
            pw.println("<td BGCOLOR=\"blue\" align=\"center\">");
        if(c.equals("yellow"))
            pw.println("<td BGCOLOR=\"yellow\" align=\"center\">");
        if(c.equals("black"))
            pw.println("<td BGCOLOR=\"white\" align=\"center\">");
          pw.println(ch);
         pw.println("</td>");
        
         }//td
        pw.println("</tr>");
        }//tr
       pw.println(  "   </table>  ");
     
     //html,head close
               // pw.println("<center><h2>The selected color is:"+c+"</h2></center>");
        pw.println("</form>   </body> ");
		pw.close();

    Cookie ck1=new Cookie("color",col.toString());//creating cookie object  
	Cookie ck2=new Cookie("randomstring",randomstring.toString());//creating cookie object  
    res.addCookie(ck1);//adding cookie in the response  
	res.addCookie(ck2);
    
    }
                                                           //printing background colors
 
} //class