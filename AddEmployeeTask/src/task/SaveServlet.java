package task;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;  
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("Id");
        int Id=Integer.parseInt(id);
        String name = request.getParameter("name");
        String designation = request.getParameter("designation");
        String salary = request.getParameter("salary");
        Emp e = new Emp();
       e.setId(Id);
        e.setName(name);;
        e.setDesignation(designation);
        e.setSalary(Integer.parseInt(salary));

        int num = EmpDao.save(e);
        if (num>0) {
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("home.jsp").include(request, response);
        } else {
            out.println("<p>Sorry! Unable to save record. "+num+"</p>");
        }

        out.close();
    }
} 