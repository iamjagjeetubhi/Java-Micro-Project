//STEP 1. Import required packages
import java.sql.*;

public class MySQLAccess{
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "a";
   
  public static boolean checkDB() {
   Connection conn = null;
   Statement stmt = null;
	ResultSet rs = null;

   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 4: Execute a query
      System.out.println("Checking database...");
      /*stmt = conn.createStatement();
      
      String sql = "CREATE DATABASE IF NOT EXISTS STUDENTS";
      stmt.executeUpdate(sql);
      System.out.println("Database created successfully...");*/
      
  		String dbName = "DBProg32758";

  		rs = conn.getMetaData().getCatalogs();

		while(rs.next()){
			String catalogs = rs.getString(1);
			
			if(dbName.equals(catalogs)){
				System.out.println("the database "+dbName+" exists");
				return true;
			}
			
			
      
		}
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Database doesn't exists!");
   return false;

}//end main
  
  public static boolean createDB() {
	   Connection conn = null;
	   Statement stmt = null;


	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating database...");
	      stmt = conn.createStatement();
	      
	      String sql = "CREATE DATABASE DBProg32758";
	      stmt.executeUpdate(sql);
	      System.out.println("Database created successfully...");
	      // Admin_First_b database created 
	      Admin_First_b dbcreated = new Admin_First_b();
	      dbcreated.main(null);
	      return true;
	      
	  	
	   }catch(SQLException se){
		      System.out.println("error"+se);

	      //Handle errors for JDBC
	   }catch(Exception e){
	      //Handle errors for Class.forName
		      System.out.println("error"+e);
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	return false;
	}//end main
  
  public static boolean createTB() {
	   Connection conn = null;
	   Statement stmt = null;


	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating database...");
	      stmt = conn.createStatement();
	      String sql_use =  "USE `DBProg32758`;";
	      stmt.executeUpdate(sql_use);
	      String sql = "CREATE TABLE Players(\n" + 
	      		"    `Last_Name` varchar(250),\n" + 
	      		"    `First_Name` varchar(250),\n" + 
	      		"    `Group` varchar(200),\n" + 
	      		"    `Login` varchar(250),\n" + 
	      		"    `Password` varchar(250),\n" + 
	      		"    `Prefered_Car_Name` varchar(250),\n" + 
	      		"    `Logo` varchar(250),\n" + 
	      		"    `Score` varchar(250));";
	      stmt.executeUpdate(sql);
	      System.out.println("Table created successfully...");
	      Admin_First_c frame = new Admin_First_c();
	      frame.main(null);
	      return true;
	      
	  	
	   }catch(SQLException se){
		      System.out.println("error"+se);

	      //Handle errors for JDBC
	   }catch(Exception e){
	      //Handle errors for Class.forName
		      System.out.println("error"+e);
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	return false;
	}//end main
  
  public static boolean InitDB(String fName, String lName) {
	   Connection conn = null;
	   Statement stmt = null;


	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating database...");
	      stmt = conn.createStatement();
	      String sql_use =  "USE `DBProg32758`;";
	      stmt.executeUpdate(sql_use);
	      String sql = "INSERT INTO `Players`(`Last_Name`, `First_Name`) VALUES ('"+lName+"','"+fName+"');";
	      stmt.executeUpdate(sql);
	      System.out.println("Value inserted successfully...");
	      return true;
	      
	  	
	   }catch(SQLException se){
		      System.out.println("error"+se);

	      //Handle errors for JDBC
	   }catch(Exception e){
	      //Handle errors for Class.forName
		      System.out.println("error"+e);
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	return false;
	}//end main
}//end JDBCExample