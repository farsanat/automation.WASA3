package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class samplejdbcexecute {

	public static void main(String[] args) throws SQLException {
		// register the driver/database
		Driver drivref=new Driver();
DriverManager.registerDriver(drivref);
//get the coonnection to database
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3", "root", "farsana123");
//issue create statement
Statement state = con.createStatement();
//exicute querry
ResultSet result = state.executeQuery("select * from candidateinfo;");
while(result.next())
{
	System.out.println(result.getString(1)+"  "+result.getInt(2)+ "  "+result.getString(3));
}
//close the database
con.close();
System.out.println("db closed");


	}

}
