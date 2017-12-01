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
	      		"    `Credit` varchar(250),\n" + 
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
  
  public static boolean InitDB(String fName, String lName, String Group) {
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
	      String sql = "INSERT INTO `Players`(`Last_Name`, `First_Name`, `Group`) VALUES ('"+lName+"','"+fName+"','"+Group+"');";
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
  
  public static String CheckUser(String fName, String lName, String Group) {
	   Connection conn = null;
	   Statement stmt = null;
	      String status=null;



	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	     // System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      //STEP 4: Execute a query
	      //System.out.println("Creating database...");
	      stmt = conn.createStatement();
	      String sql_use =  "USE `DBProg32758`;";
	      stmt.executeUpdate(sql_use);
	      String sql = "SELECT * FROM `Players` WHERE `Last_Name`='"+lName+"' AND `First_Name`='"+fName+"' AND `Group`='"+Group+"';";
	      ResultSet rs = stmt.executeQuery(sql);
	      while(rs.next()){
	      String checklname=rs.getString(1);
	      String checkfname=rs.getString(2);
	      String checkgroup=rs.getString(3);
	      System.out.println(checklname+checkfname+checkgroup);
	      if(checklname.equals(lName) && checkfname.equals(fName) && checkgroup.equals(Group)){
	          status="True";
	      }
	      else{
	          status="False";
	      }
	      System.out.println(status);
	      return status;
	      
	      }
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
		      System.out.println("error"+se2);

	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
		      System.out.println("error"+se);

	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	return status;
	
	}//end main
  public static String CreateUser(String fName, String lName, String Group, String car,String credit,String score,String username,String password) {
	   Connection conn = null;
	   Statement stmt = null;
	      String status=null;



	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	     // System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      //STEP 4: Execute a query
	      //System.out.println("Creating database...");
	      stmt = conn.createStatement();
	      String sql_use =  "USE `DBProg32758`;";
	      stmt.executeQuery(sql_use);
	      String sql = "UPDATE `Players` SET `Login`='"+username+"',`Password`='"+password+"',`Prefered_Car_Name`='"+car+"',`Credit`='"+credit+"',`Score`='"+score+"' WHERE `Last_Name`='"+lName+"' AND `First_Name`='"+fName+"' AND `Group`='"+Group+"';";
	      stmt.executeUpdate(sql);
	      User_Second_b.main(null);
	      return status;
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
		      System.out.println("error"+se2);

	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
		      System.out.println("error"+se);

	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	return status;
	
	}//end main
  public static String LoginUser(String username, String password) {
	   Connection conn = null;
	   Statement stmt = null;
	      String status=null;



	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	     // System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      //STEP 4: Execute a query
	      //System.out.println("Creating database...");
	      stmt = conn.createStatement();
	      String sql_use =  "USE `DBProg32758`;";
	      stmt.executeUpdate(sql_use);
	      String sql = "SELECT `Login`,`Password` FROM `Players` WHERE `Login`='"+username+"' AND `Password`='"+password+"';";
	      ResultSet rs = stmt.executeQuery(sql);
	      while(rs.next()){
	      String checkuname=rs.getString(1);
	      String checkpass=rs.getString(2);

	      System.out.println(checkuname+checkpass);
	      if(checkuname.equals(username) && checkpass.equals(password)){
	          status="True";
	      }
	      else{
	          status="False";
	      }
	      System.out.println(status);
	      return status;
	      
	      }
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
		      System.out.println("error"+se2);

	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
		      System.out.println("error"+se);

	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	return status;
	
	}//end main
}//end JDBCExample