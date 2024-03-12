package BookStore;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteBookDetails extends HttpServlet{
	Connection con=null;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int bookid= Integer.parseInt(req.getParameter("bookid"));

		PreparedStatement pstmt=null;
		
		String query="delete from book_data where bookid=?";

			try {
				pstmt=con.prepareStatement(query);
				pstmt.setInt(1,bookid);
				
				PrintWriter pw =resp.getWriter();
				pw.print("<h1>"+" ...");
				pw.print("<h1>"+"..");
				int count=pstmt.executeUpdate();
				
				if (count==1) {
					
					
					pw.print("<h1>"+count+" Recourd Deleted");
					
					
				}
				else if(count>1) {
					
					pw.print("<h1>"+count+" Recourds Deleted");
					
					
					
				}
				else  {
					
					pw.print("<h1>"+"No Recourd Deleted");
					
				}
				
				pw.print("<br>");
				pw.print("<a href='delete.html'>");
				pw.print("<button style='display: inline-block;\r\n"
						+ "  padding: 7px 15px;\r\n"
						+ "  font-size: 16px;\r\n"
						+ "  cursor: pointer;\r\n"
						+ "  text-align: center;\r\n"
						+ "  text-decoration: none;\r\n"
						+ "  outline: none;\r\n"
						+ "  color: #fff;\r\n"
						+ "  background-color: #04AA6D;\r\n"
						+ "  border: none;\r\n"
						+ "  border-radius: 15px;\r\n"
						+ "  box-shadow: 0 9px #999;'>Delete Again</button>");
				pw.print("</a>");
				
				pw.print("<a href='index.html'>");
				pw.print("<button style='display: inline-block;\r\n"
						+ "  padding: 7px 15px;\r\n"
						+ "  font-size: 16px;\r\n"
						+ "  cursor: pointer;\r\n"
						+ "  text-align: center;\r\n"
						+ "  text-decoration: none;\r\n"
						+ "  outline: none;\r\n"
						+ "  color: #fff;\r\n"
						+ "  background-color: #04AA6D;\r\n"
						+ "  border: none;\r\n"
						+ "  border-radius: 15px;\r\n"
						+ "  box-shadow: 0 9px #999;'>Home</button>");
				pw.print("</a>");
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}

}
