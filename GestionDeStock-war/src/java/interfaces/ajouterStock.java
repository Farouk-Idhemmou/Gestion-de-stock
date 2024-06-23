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
import stock.StockFacade;

/**
 *
 * @author ok
 */
@WebServlet(name = "ajouterStock", urlPatterns = {"/ajouterStock"})
public class ajouterStock extends HttpServlet {

    @EJB
    private StockFacade stockFacade;

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
            out.println("<title>Servlet ajouterStock</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ajouterStock at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
out.println("<html lang=\"en\">");
out.println("<head>");
out.println("<meta charset=\"UTF-8\" />");
out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
out.println("<title>Document</title>");
out.println("</head>");
out.println("<style>");
out.println("body {");
out.println("display: flex;");
out.println("justify-content: center;");
out.println("align-items: center;");
out.println("width: 100%;");
out.println("height: 100vh;");
out.println("flex-direction: column;");
out.println("overflow: hidden;");
out.println("background: #FFF5E1;");
out.println("}");
out.println("form {");
out.println("width: 50%;");
out.println("height: 80vh;");
out.println("display: flex;");
out.println("flex-direction: column;");
out.println("align-items: center;");
out.println("}");
out.println("input,");
out.println("select {");
out.println("width: 80%;");
out.println("padding: 10px;");
out.println("height: 8%;");
out.println("margin: 5px;");
out.println("border-radius: 5px;");
out.println("}");
out.println("button {");
out.println("background: #000000;");
out.println("color: white;");
out.println("padding: 10px 20px;");
out.println("border-radius: 5px;");
out.println("}");
out.println("</style>");
out.println("<body>");
out.println("<h1 style=\"text-align: center\">add Product into Stock</h1>");
out.println("");
out.println("<form action=\"ajouterStock\" method=\"POST\">");
String stock=request.getParameter("idstock");
out.println("<input type=\"text\" name=\"nom\" placeholder=\"nom du stock\" value=\""+stock+"\" style=\"width: 250px;\" />");
out.println("<input type=\"text\" name=\"refProduit\" placeholder=\"reference du Produit\" style=\"width: 250px;\" />");
out.println("<input type=\"text\" name=\"quantite\" placeholder=\"Quantite\" style=\"width: 250px;\" />");
out.println("");
out.println("<button type=\"submit\" style=\"background: #ffffff; color: black; padding: 10px 20px; border: 2px solid black; border-radius: 20px; cursor: pointer;\">Ajouter</button>");
out.println("</form>");
out.println("</body>");
out.println("</html>");

        }
        catch(Exception e)
        {}
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
        String nom=request.getParameter("nom");
        String refProduit=request.getParameter("refProduit");
        String quantite=request.getParameter("quantite");
        
        int q=Integer.parseInt(quantite);
        
        stockFacade.addToStock(nom, refProduit, q);
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();
        out.println("<script>");
        out.println("window.location.href=\"http://localhost:8080/GestionDeStock-war/allStocks\"");
        out.println("</script>");
        }
        catch(Exception e)
        {}
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
