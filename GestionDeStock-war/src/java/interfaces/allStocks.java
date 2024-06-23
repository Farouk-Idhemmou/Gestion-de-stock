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
import stock.Stock;
import stock.StockFacade;

/**
 *
 * @author ok
 */
@WebServlet(name = "allStocks", urlPatterns = {"/allStocks"})
public class allStocks extends HttpServlet {

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
            out.println("<title>Servlet allStocks</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet allStocks at " + request.getContextPath() + "</h1>");
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
out.println("button {");
out.println("border: none;");
out.println("cursor: pointer;");
out.println("}");
out.println("th,");
out.println("td {");
out.println("border: 1px solid;");
out.println("padding: 10px;");
out.println("}");
out.println("button {");
out.println("border: none;");
out.println("cursor: pointer;");
out.println("}");
out.println("body {");
out.println("flex-direction: column;");
out.println("display: flex;");
out.println("align-items: center;");
out.println("justify-content: center;");
out.println("}");
out.println("</style>");
out.println("<body>");
out.println("<h1 style=\"text-align: center\">Gestion de Stock : Liste of Stockes</h1>");
out.println("");
out.println("<div");
out.println("style=\"");
out.println("display: flex;");
out.println("width: 100%;");
out.println("justify-content: space-around;");
out.println("align-items: center;");
out.println("\"");
out.println(">");
out.println("<form action=\"gerer\">");
out.println("<input name=\"stock\" type=\"text\" placeholder=\"nom de stock a ajouter\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 20px;");
out.println("border: 2px solid #000000;");
out.println("color: black;");
out.println("\"");
out.println(">");
out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 20px;");
out.println("background: #ffffff;");
out.println("color: black;");
out.println("border: 2px solid #ff0000;"); // yellow border

out.println("\"");
out.println(">");
out.println("ajouter le stock");
out.println("</button>");
out.println("</form>");
out.println("<form action=\"allMarques\">");
/**out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 5px;");
out.println("background: rgb(205, 255, 176);");
out.println("color: black;");
out.println("\"");
out.println(">");
out.println("Liste Marques");
out.println("</button>");*/
out.println("</form>");
out.println("<form action=\"allproducts\">");
/**out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 5px;");
out.println("background: rgb(182, 137, 255);");
out.println("color: black;");
out.println("\"");
out.println(">");
out.println("liste des Produits");
out.println("</button>");*/
out.println("</form>");
out.println("</div>");
out.println("");
out.println("<table style=\"width: 60%; padding: 20px\">");
out.println("<thead>");
out.println("<th>Nom</th>");
out.println("<th>liste Produits</th>");
out.println("<th>Ajouter</th>");
out.println("</thead>");
out.println("<tbody>");

List<Stock> stockes=stockFacade.findAll();

for(int i=0;i<stockes.size();i++)
{
out.println("<tr>");
out.println("<td>"+stockes.get(i).getId()+"</td>");
out.println("<td style=\"text-align: center\">");
out.println("<form action=\"onestock\" method=\"GET\">");
out.println("<input type=\"text\" name=\"idstock\" value="+stockes.get(i).getId()+" hidden />");
out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 20px;");
out.println("background: #ffffff;");
out.println("color: rgb(0, 0, 0);");
out.println("border: 2px solid #000000;"); 
out.println("\"");
out.println(">");
out.println("Voir");
out.println("</button>");
out.println("</form>");
out.println("</td>");
out.println("<td style=\"text-align: center\">");
out.println("<form action=\"ajouterStock\" method=\"GET\">");
out.println("<input type=\"text\" name=\"idstock\" value="+stockes.get(i).getId()+" hidden />");
out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 20px;");
out.println("background: #ffffff;");
out.println("color: rgb(0, 0, 0);");
out.println("border: 2px solid #000000;"); 
out.println("\"");
out.println(">");
out.println("ajouter produit");
out.println("</button>");
out.println("</form>");
out.println("</td>");
out.println("</tr>");
}
out.println("</tbody>");
out.println("</table>");
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
