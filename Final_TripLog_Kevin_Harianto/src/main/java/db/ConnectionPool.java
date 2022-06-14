/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates-3
 * and open the template in the editor.
 */
 package db;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;

public class ConnectionPool {

  private static ConnectionPool pool = null;
  private static DataSource dataSource = null;

  public synchronized static ConnectionPool getInstance() {
    if (pool == null) {
      pool = new ConnectionPool();
    }
    return pool;
  }

  private ConnectionPool() {
    try {
      InitialContext ic = new InitialContext();
      dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/java3");
    } catch (NamingException e) {
      System.err.println(e);
    }
  }

  public Connection getConnection() {
    try {
      return dataSource.getConnection();
    } catch (SQLException sqle) {
      System.err.println(sqle);
      return null;
    }
  }

}
