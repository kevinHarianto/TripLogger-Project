/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Trip;
import model.TripDAO;

/**
 *
 * @author kevin
 */
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String action = request.getServletPath();
        try {
            switch(action) {
                case "/display":
                    //loadTypes();
                    list(request, response);
                    break;
                case "/add":
                    add(request, response);
                    //list(request, response);
                    break;
                case "/search":
                    search(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            request.setAttribute("errorMsg", "Error: " + e);
            
        }
        getServletContext().getRequestDispatcher("/index.jsp")
        .forward(request, response);
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
  
    String min = request.getParameter("minID");
    String max = request.getParameter("maxID");
    int minNum = Integer.parseInt(min);
    int maxNum = Integer.parseInt(max);
    List<Trip> list = TripDAO.searchTrip(minNum, maxNum);
    
    
    request.setAttribute("list", list);
    request.setAttribute("listmsg", list != null && !list.isEmpty() ? 
        "Find " + list.size() + " trips. ID = " + minNum + "to"+ maxNum : "No user found.");
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    List<Trip> list = TripDAO.selectAll();
    request.setAttribute("list", list);
    request.setAttribute("listmsg", list != null && !list.isEmpty() ? 
        "Found " + list.size() + " trips in total" : "Search Data error");
    
    
        
    }

    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    try {
        String tripid = request.getParameter("tripid");
        String desc = request.getParameter("desc");
        String country = request.getParameter("country");
        int trip = Integer.parseInt(tripid);
        if (trip < 1 || trip > 100) {
                throw new IllegalArgumentException("wrong");
        }
        
        if (desc == null || desc.isEmpty()) {
                throw new IllegalArgumentException("wrong");
        }
        
       if (country == null || country.isEmpty()) {
                throw new IllegalArgumentException("wrong");
        }
       
       
//    public Trip(int tripid, String country, String description)
       Trip trips = new Trip(
            Integer.parseInt(tripid), country,
               desc
    );
       
        boolean done = TripDAO.insertTrip(trips);
    request.setAttribute("addmsg", done ?
          "new trip added to DB: " + trips.toString(): "Failed to insert triper: " + trips.toString());
   
    
    } catch (NumberFormatException e) {
            request.setAttribute("errorMsg", "Invalid trip data");
            
        } catch (IllegalArgumentException ex) {
            request.setAttribute("errorMsg", "Invalid trip data");
            
        }
    
    
   
    
    
    }

}
