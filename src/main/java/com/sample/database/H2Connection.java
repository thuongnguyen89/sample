package com.sample.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class H2Connection {

	private static final String SA = "sa";

	public static void main(String[] args) throws SQLException, NamingException {
        	connectDirectlyByEmbeddedFile();
	}

	private static void connectDirectlyByEmbeddedFile() throws SQLException {
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", SA);
	    connectionProps.put("password", "");
	    
		Connection conn = DriverManager.
		    getConnection("jdbc:h2:~/sampleDB", SA, "");
		// add application code here
		conn.close();
	}

	private static void connectByDataSource() throws NamingException, SQLException {
		Context ctx = new InitialContext();
		 DataSource ds = (DataSource) ctx.lookup("jdbc/dsH2Test");
		 Connection conn = ds.getConnection();
            // add application code here
            conn.close();
	}
	

}
