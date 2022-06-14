/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import model.Trip;

/**
 * Web application lifecycle listener.
 *
 * @author kevin
 */
public class NewServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
     sce.getServletContext().setAttribute("country", Trip.COUNTRY);
     
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    
        System.out.println("context destroyed" + sce);
    }
}
