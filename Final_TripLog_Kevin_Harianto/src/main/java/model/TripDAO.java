/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import db.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class TripDAO {
 
//(11,'Canada', 'Sheridan campus tours, 07.2020'),
    /*
    tripid int not null,
  country varchar(20) not null,
  description varchar(100) not null,
    */
    public static final String INSERT_TRIP
            = "insert into triplog values (?,?,?);";
    
  private static final String SQL_SELECT_ALL = "select * from triplog;";
    
  
  private static final String SQL_SEARCH_TRIP
      = "select * from triplog where tripid >= ? and tripid <= ? ;";
  
        public static boolean insertTrip(Trip trip) {
        boolean result = false;

        try (
                Connection connection = ConnectionPool.getInstance().getConnection();
                PreparedStatement ps = connection.prepareStatement(INSERT_TRIP);) {

            ps.setInt(1, trip.getTripid());
            ps.setString(2, trip.getCountry());
            ps.setString(3, trip.getDescription());
            result = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
      System.err.println(ex);
      Logger.getLogger(TripDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
        
          public static List<Trip> selectAll() {
    List<Trip> list = new ArrayList<>();
    try ( Connection connection = ConnectionPool.getInstance().getConnection();  
        PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(new Trip(
            rs.getInt("tripid"), rs.getString("country"),
                rs.getString("description")
        ));
      }
    } catch (SQLException ex) {
      System.err.println(ex);
      Logger.getLogger(TripDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
  }
          
          
           public static List<Trip> searchTrip(int min, int max) {
    List<Trip> list = new ArrayList<>();
    try ( Connection connection = ConnectionPool.getInstance().getConnection();  
        PreparedStatement ps = connection.prepareStatement(SQL_SEARCH_TRIP);) {
      ps.setInt(1, min);
      
      ps.setInt(2, max);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(new Trip(
            rs.getInt("tripid"), rs.getString("country"),
                rs.getString("description")
        ));
      }
    } catch (SQLException ex) {
      System.err.println(ex);
      Logger.getLogger(TripDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
  }
}
