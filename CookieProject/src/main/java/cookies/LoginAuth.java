package cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.db.DBService;

/**
 * Servlet implementation class LoginAuth
 */
@WebServlet("/lauth")
public class LoginAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAuth() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		try {
			Connection conn=DBService.getConnection();
			PreparedStatement pst=conn.prepareStatement("select * from login where userid=? and password=?");
			String uid=req.getParameter("username");
    		String pass=req.getParameter("password");
    		pst.setString(1, uid);
    		pst.setString(2, pass);
    		
    		ResultSet rs=pst.executeQuery();
    		
    		if (rs.next()) {
				
    			if (rs.getString("usertype").equals("admin")) {
					Cookie c1=new Cookie("userid",rs.getString("userid"));
					Cookie c2=new Cookie("password", rs.getString("password"));
					String msg="$Welcome rs.getString{userid}";
					
					c1.setMaxAge(60*60*24);
					c2.setMaxAge(60*60*24);
					resp.addCookie(c1);
					resp.addCookie(c2);
					
					
					RequestDispatcher rd=req.getRequestDispatcher("AdminCookie.jsp");
    				rd.forward(req, resp);
				}
    			else if((rs.getString("usertype").equals("student"))) {
					
					Cookie c3=new Cookie("Suserid",rs.getString("userid"));
					Cookie c4=new Cookie("spass", rs.getString("password"));
					
					resp.addCookie(c3);
					resp.addCookie(c4);
					RequestDispatcher rd=req.getRequestDispatcher("WellcomeStudent.jsp");
    				rd.forward(req, resp);
				}    			
			}
    		else {
    			out.println("Error");
    		}
		} catch (Exception e) {
			out.println(e.getMessage());
		}
		
	}

}
