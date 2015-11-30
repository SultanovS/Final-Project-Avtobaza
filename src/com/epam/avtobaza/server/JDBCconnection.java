package com.epam.avtobaza.server;
/**
 * Класс осуществляющий непосредственное установления связи с БД и выполнение запросов к ней
 */
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class JDBCconnection {
	
		Connection connection = null;
	// Метод, извлекающий данные из табли БД
public String[][] GetConnect(String zapros) {
		
		ResultSet resultset = null;
		int str=0, col=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/avtobaza","root","1234");
			Statement statement = (Statement) connection.createStatement();
			resultset = statement.executeQuery(zapros);
			while (resultset.next()) { str++; }
			while (resultset.previous()) {}
			col = resultset.getMetaData().getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		String[][] table = new String[str][col];
		str=0;
		try {
			while (resultset.next()) {
				for (int i = 0; i < col; i++) {
					table[str][i]=resultset.getString(i+1);
				}
				str++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return table;
}
// Метод, обновляющий данные в таблице
public void GetConnectUpdate(String zapros) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/avtobaza","root","1234");
		Statement statement = (Statement) connection.createStatement();
		statement.executeUpdate(zapros);
		
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
	

}
