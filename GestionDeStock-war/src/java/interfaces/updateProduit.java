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
 * @author ok
 */
@WebServlet(name = "updateProduit", urlPatterns = {"/updateProduit"})
public class updateProduit extends HttpServlet {

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
            out.println("<title>Servlet updateProduit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateProduit at " + request.getContextPath() + "</h1>");
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
       try  {
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
out.println("<html lang=\"en\">");
out.println("<head>");
out.println("<meta charset=\"UTF-8\" />");
out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
out.println("<title>Document</title>");
out.println("<style>");
            out.println("body { background: #FFF5E1; }"); // Set background color to off-white with a hint of orange
            out.println("th, td { border: 1px solid; padding: 10px; }");
            out.println("button { border: none; cursor: pointer; }");
            out.println("</style>");
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
out.println("background: #FFF5E1;");
out.println("color: white;");
out.println("padding: 10px 20px;");
out.println("border-radius: 5px;");
out.println("}");
out.println("</style>");
out.println("<body>");
out.println("<h1 style=\"text-align: center\">Update Product</h1>");
out.println("");
out.println("<form action=\"gerer\" method=\"POST\">");
String id=request.getParameter("id");

Produit p=produitFacade.getProduit(id);
out.println("<input type=\"text\" name=\"ref\" placeholder=\"reference\" value=\""+p.getId()+"\" style=\"width: 250px;\" readonly/>");
out.println("<label for=\"marque\">Update Marque</label>");
out.println("<select name=\"marque\" id=\"marque\" value=\"" +p.getMaruqeProduit().getId()+"\" style=\"width: 250px;\" >");
List<Marque> marques=marqueFacade.getAllMarques();

for(int i=0;i<marques.size();i++)
{ 
    out.println("<option value="+marques.get(i).getId()+">"+marques.get(i).getId()+"</option>");
}
out.println("</select>");
out.println("<input type=\"text\" name=\"Denomination\" placeholder=\"nouvelle nom\" value=\""+p.getDenomination()+"\"  style=\"width: 250px;\" />");
out.println("<input type=\"text\" name=\"Prix\" placeholder=\"prix\" value=\""+p.getPrix()+"\" style=\"width: 250px;\" />");
out.println("<input type=\"text\" name=\"Poids\" placeholder=\"poids\" value=\""+p.getPoids()+"\"  style=\"width: 250px;\"/>");
out.println("<input type=\"text\" name=\"Volume\" placeholder=\"volume\" value=\""+p.getPoids()+"\"  style=\"width: 250px;\"/>");
out.println("<button type=\"submit\" style=\"background: #ffffff; color: black; padding: 10px 20px; border: 2px solid black; border-radius: 20px; cursor: pointer;\">Update</button>");
out.println("</form>");
out.println("</body>");
out.println("</html>");

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
 