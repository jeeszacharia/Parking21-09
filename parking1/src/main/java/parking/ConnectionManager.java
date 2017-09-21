package parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ConnectionManager objConnectionManager =null;
	private final String USERID="root";
	private final String PASSWORD="root";
	private final String DBURL="jdbc:mysql://localhost:3306/parking";
	
	private Connection conn=null;
	
	private ConnectionManager(){
				
	}
	
	public static ConnectionManager getInstance(){
		
		
		if(objConnectionManager==null){
			
			objConnectionManager= new ConnectionManager();
		}
		
		return objConnectionManager;
	}
	
	private boolean openConnection() {
		
        try{			
        	
        	
                
		conn= DriverManager.getConnection(DBURL, USERID, PASSWORD);
        }catch(SQLException e){
        	
        	e.printStackTrace();
        	
        }
		return true;
	
		
	}
	
public Connection getConnection() {
	if(conn==null){
	
	if(openConnection()){
						
		System.out.println("Connection Opened");
		
		return conn;
		
    	}else return null;		
    }
		
	return conn;
		
}

public void closeConnection(){
	
	System.out.println("Closing Connection");
	
	try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	conn=null;
}
	
	
}

