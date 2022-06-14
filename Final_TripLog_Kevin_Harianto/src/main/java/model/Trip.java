/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author kevin
 */

/*
1. Add the Trip.java class.

This class is a JavaBean for representing a Trip. Check out SQLscript.sql
to see how the triplog table is defined, and define data fields for this class
accordingly. Add constructors, getters and setters, and other fields and methods
when needed to the class.


*/
public class Trip{
    int tripid;
    String country;
    String description;
    
    
    public static final String[] COUNTRY 
            = new String[] {"Canada", "USA", "Germany", "Singapore", "Japan"};
    @Override
    public String toString() {
        return "Trip{" + "tripid=" + tripid + ", country=" + country + ", description=" + description + '}';
    }

    public Trip(int tripid, String country, String description) {
        this.tripid = tripid;
        this.country = country;
        this.description = description;
    }

    public Trip() {
    }

    public int getTripid() {
        return tripid;
    }

    public void setTripid(int tripid) {
        this.tripid = tripid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
