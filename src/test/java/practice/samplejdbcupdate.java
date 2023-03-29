package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class samplejdbcupdate {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		// register the driver/database
		try {		
		Driver drivref=new Driver();
		DriverManager.registerDriver(drivref);
		//get the connection to database
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3", "root", "farsana123");
		//issue create statement
		Statement state = con.createStatement();
		//Execute query
		String query="insert into candidateinfo values('rannu',21,'kerala,('rakhi',23,'delhi');";
		
		int result = state.executeUpdate(query);
		if(result>=1)
		{
			System.out.println("row added");
		}
		ResultSet resulset = state.executeQuery("select * from candidateinfo");
		while(resulset.next())
		{
			System.out.println(resulset.getString(1)+"  "+resulset.getInt(2)+ "  "+resulset.getString(3));
		}}
		finally {
		//close database
		con.close();
		System.out.println("db closed");
		
		}
	}

}
