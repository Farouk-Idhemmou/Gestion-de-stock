/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import stock.MarqueFacade;
import stock.ProduitFacade;
import stock.StockFacade;


/**
 *
 * @author USER
 */
@WebServlet(name = "gerer", urlPatterns = {"/gerer"})
public class gerer extends HttpServlet {

    @EJB
    private StockFacade stockFacade;

    @EJB
    private ProduitFacade produitFacade;

    @EJB
    private MarqueFacade marqueFacade;

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
            out.println("<html>");
            out.println("<body>");
            if (request.getParameter("origine")!=null)
            {
            String origin=request.getParameter("origine");
              
            String nom=request.getParameter("nom");
            boolean a=marqueFacade.Creer(nom, origin);
            if (a)
            {
                 out.println("<script>");
                 out.println("window.location.href=\"http://localhost:8080/GestionDeStock-war/allMarques\"");
                 out.println("</script>");
            }}
            else if(request.getParameter("ref")!=null)
            {
       
               
                String ref=request.getParameter("ref");
              
              String marque=request.getParameter("marque");
              String deno=request.getParameter("Denomination");
        
              double prix=Double.parseDouble(request.getParameter("Prix"));
             double poids=Double.parseDouble(request.getParameter("Poids"));
             double volume=Double.parseDouble(request.getParameter("Volume"));
            
             
             produitFacade.update(ref, marque, deno, prix, poids, volume);
              out.println("<h1>zazaza</h1>");
              out.println("</body>");
             out.println("</html>");
             
             out.println("<script>");
                 out.println("window.location.href=\"http://localhost:8080/GestionDeStock-war/allproducts\"");
                 out.println("</script>");
            }
            else if (request.getParameter("stock")!=null)
            {
                String nom=request.getParameter("stock");
                stockFacade.creer(nom);
                out.println("<script>");
                 out.println("window.location.href=\"http://localhost:8080/GestionDeStock-war/allStocks\"");
                 out.println("</script>");
            }
            else if (request.getParameter("refpupdate")!=null)
            {
                String nom=request.getParameter("stocku");
                String produit=request.getParameter("refpupdate");
                int q=Integer.parseInt(request.getParameter("quantiteu"));
                
                stockFacade.changeElementStock(nom, produit, q);
                out.println("<script>");
                 out.println("window.location.href=\"http://localhost:8080/GestionDeStock-war/onestock?idstock="+nom+"\"");
                 out.println("</script>");
            }
            
     
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

}
