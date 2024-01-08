package task;

import java.util.*;  
import java.sql.*;  
  
public class EmpDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eidiko?user=root&password=12345");  
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }  
        return con;  
    }  
    public static int save(Emp e){  
        int status = 0;  
        try{  
            Connection con=EmpDao.getConnection();  
           // con.setAutoCommit(true);

            PreparedStatement ps=con.prepareStatement("insert into addemp values(?,?,?,?)");  
            ps.setInt(1,e.getId());  
            ps.setString(2,e.getName());  
            ps.setString(3,e.getDesignation());  
            ps.setInt(4,e.getSalary());  
            status=ps.executeUpdate();  
          //  con.commit();

            con.close();  
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }
          
       return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update addemp set Name=?,Designation=?,Salary=? where Id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getDesignation());  
            ps.setInt(3,e.getSalary());   
           ps.setInt(4,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from addemp where Id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from addemp where Id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
               e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setDesignation(rs.getString(3));  
                e.setSalary(rs.getInt(4)); 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from addemp");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
               e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setDesignation(rs.getString(3));  
                e.setSalary(rs.getInt(4)); 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  