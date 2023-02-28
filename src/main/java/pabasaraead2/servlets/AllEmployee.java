package pabasaraead2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import pabasaraead2.entity.Employee;
import com.db.utils.DbConnection;

@WebServlet(urlPatterns = {"/register-new-employee" ,"/load-all-employees"})
public class AllEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AllEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("all employees get");
		try {
			Connection con = DbConnection.connectDB();
			String sqlQuery = "select * ,day(e_joinedDate) as day,month(e_joinedDate) as month ,year(e_joinedDate) as year  from employees";
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sqlQuery);
			ArrayList<Employee> employees = new ArrayList<>();
            while (result.next()) {
            	 Employee emp = new Employee();
            		emp.setId( result.getInt("id"));
            		emp.setNic( result.getString("e_nic"));
            		emp.setName( result.getString("e_name"));
            		emp.setDepartment( result.getString("e_department"));
            		emp.setDesignation( result.getString("e_designation"));
            		emp.setJoinedDate(result.getString("year")+"."+result.getString("month")+"."+result.getString("day"));
            		employees.add(emp);

            }
			req.setAttribute("userList",employees);

			RequestDispatcher disp = req.getRequestDispatcher("allEmployees.jsp");
			disp.forward(req, res);
		
		} catch (Exception e) {
			System.out.println("Something went wrong " + e);
			res.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			System.out.println("post request");
			String name = req.getParameter("name");
			String nic = req.getParameter("nic");
			String designation = req.getParameter("designation");
			String department = req.getParameter("department");
			if(nic.isEmpty() == true || name.isEmpty() == true || designation.isEmpty() == true || department.isEmpty() == true) {
				System.out.println("All fields must be Fill");
				res.sendRedirect("index.jsp");
			}else {			
			//DB operation
				try {
					Connection con = DbConnection.connectDB();
			
					String sqlQuery = "insert into employees(e_nic, e_name, e_department, e_designation) "
								+ "values('"+nic+"','"+name+"','"+department+"','"+designation+"')";
					Statement stmt = con.createStatement();
					stmt.executeUpdate(sqlQuery);
					doGet(req, res);
				} catch (Exception e) {
					System.out.println("Something went wrong " + e);
					res.sendRedirect("index.jsp");
				}
				
			}

	}




}
