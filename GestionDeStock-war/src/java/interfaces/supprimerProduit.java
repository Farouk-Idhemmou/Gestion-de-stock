/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import stock.Marque;
import stock.MarqueFacade;
import stock.Produit;
import stock.ProduitFacade;

/**
 *
 * @author USER
 */
@WebServlet(name = "supprimerProduit", urlPatterns = {"/supprimerProduit"})
public class supprimerProduit extends HttpServlet {

    @EJB
    private MarqueFacade marqueFacade;

    @EJB
    private ProduitFacade produitFacade;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet supprimerProduit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet supprimerProduit at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        if (request.getParameter("id")!=null)
        {
        String id=request.getParameter("id");
        Produit p=produitFacade.getProduit(id);
        Marque m=p.getMaruqeProduit();
        
        marqueFacade.delete(p,m);
        marqueFacade.update(m);
        produitFacade.remove(p);
        try  {
            PrintWriter out = response.getWriter();
            out.println("<script>");
                 out.println("window.location.href=\"http://localhost:8080/GestionDeStock-war/allproducts\"");
                 out.println("</script>");
            /* TODO output your page here. You may use following sample code. */
            
        }
        catch(Exception e)
        {}
        }
        else if (request.getParameter("marque")!=null)
        {
           Marque marque=marqueFacade.getmarque(request.getParameter("marque"));
           
           marqueFacade.empty(marque);
           
           marqueFacade.update(marque);
           
           marqueFacade.remove(marque);
           
           PrintWriter out = response.getWriter();
            out.println("<script>");
                 out.println("window.location.href=\"http://localhost:8080/GestionDeStock-war/allMarques\"");
                 out.println("</script>");
           
           
                   
        }
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

}
