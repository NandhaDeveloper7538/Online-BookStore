package BookStore;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.cj.xdevapi.Statement;

@SuppressWarnings("serial")
@WebServlet("/displaybooks")
public class DisplayBooks extends HttpServlet {
	Connection con=null;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root", "mysql@753888");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		java.sql.Statement stmt=null;
		ResultSet rs=null;
		PrintWriter pw=resp.getWriter();
		String query="select * from book_data";
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			pw.print("<table border='2' align='center' style='background-color:#E2F9F5'>");
			pw.print("<tr style='background-color:#5DB8A9'>");
			pw.print("<th>BOOK ID</th>");
			pw.print("<th>BOOKNAME</th>");
			pw.print("<th>BOOKPRICE</th>");
			pw.print("<th>BOOKAUTHOR</th>");
			pw.print("</tr>");
			while(rs.next()) {
				pw.print("<tr>");
				pw.print("<td>"+rs.getString(1)+"</td>");
				pw.print("<td>"+rs.getString(2)+"</td>");
				pw.print("<td>"+rs.getDouble(3)+"</td>");
				pw.print("<td>"+rs.getString(4)+"</td>");
				pw.print("<tr>");
			}
			pw.print("</table>");
			pw.print("<br/>");
			pw.print("<br/>");
			
			pw.print("<center>");
			pw.print("<a href='index.html' style='margin-right:10px'>");
			pw.print("<button style='display: inline-block;\r\n"
					+ "  padding: 6px 15px;\r\n"
					+ "  font-size: 16px;\r\n"
					+ "  cursor: pointer;\r\n"
					+ "  text-align: center;\r\n"
					+ "  text-decoration: none;\r\n"
					+ "  outline: none;\r\n"
					+ "  color: #fff;\r\n"
					+ "  background-color: #04AA6D;\r\n"
					+ "  border: none;\r\n"
					+ "  border-radius: 15px;\r\n"
					+ "  box-shadow: 0 9px #999;'>Home page</button>");
			pw.print("</a>");
			
			pw.print("<a href='login.html' style='margin-left:10px'>");
			pw.print("<button class='btn btn-danger' style='display: inline-block;\r\n"
					+ "  padding: 6px 15px;\r\n"
					+ "  font-size: 16px;\r\n"
					+ "  cursor: pointer;\r\n"
					+ "  text-align: center;\r\n"
					+ "  text-decoration: none;\r\n"
					+ "  outline: none;\r\n"
					+ "  color: #fff;\r\n"
					+ "  background-color: #04AA6D;\r\n"
					+ "  border: none;\r\n"
					+ "  border-radius: 15px;\r\n"
					+ "  box-shadow: 0 9px #999;'>log out</button>");
			pw.print("</a>");
			
			pw.print("</center>");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
