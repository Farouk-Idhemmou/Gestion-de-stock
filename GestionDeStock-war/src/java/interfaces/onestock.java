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
import stock.ElementDeStock;
import stock.Marque;
import stock.MarqueFacade;
import stock.Produit;
import stock.ProduitFacade;
import stock.Stock;
import stock.StockFacade;

/**
 *
 * @author ok
 */
@WebServlet(name = "onestock", urlPatterns = {"/onestock"})
public class onestock extends HttpServlet {

    @EJB
    private MarqueFacade marqueFacade;

    @EJB
    private ProduitFacade produitFacade;

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
            out.println("<title>Servlet onestock</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet onestock at " + request.getContextPath() + "</h1>");
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
out.println("</style>");
out.println("<body>");
if (request.getParameter("idstock")!=null)
{
    String nom=request.getParameter("idstock");
out.println("<h1 style=\"text-align: center\">Gestion de Stock :"+nom+"</h1>");
}
out.println("");
out.println("<div");
out.println("style=\"");
out.println("display: flex;");
out.println("width: 100%;");
out.println("justify-content: space-around;");
out.println("align-items: center;");
out.println("\"");
out.println(">");
out.println("<form action=\"allproducts\">");
out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 20px;");
out.println("background: #ffffff;");
out.println("color: black;");
out.println("border: 2px solid #000000;"); 
out.println("\"");
out.println(">");
out.println("Liste Produits");
out.println("</button>");
out.println("</form>");
out.println("<form action=\"listeMarque\">");
/**out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 5px;");
out.println("background: rgb(182, 137, 255);");
out.println("color: black;");
out.println("\"");
out.println(">");
out.println("liste des marques");
out.println("</button>");*/
out.println("</form>");
out.println("<form action=\"onestock\">");
out.println("<select");
out.println("name=\"idstock\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 20px;");
out.println("background: #ffffff;");
out.println("color: black;");
out.println("border: 2px solid #000000;"); 
out.println("\"");
out.println(">");
List<Stock> stockes=stockFacade.findAll();

for(int i=0;i<stockes.size();i++)
{
out.println("<option>"+stockes.get(i).getId()+"</option>");
}
out.println("</select>");
out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 20px;");
out.println("background: #ffffff;");
out.println("color: black;");
out.println("border: 2px solid #000000;"); 
out.println("\"");
out.println(">");
out.println("Filter");
out.println("</button>");
out.println("</form>");
out.println("</div>");
out.println("");
out.println("<table style=\"width: 100%; padding: 20px\">");
out.println("<thead>");
out.println("<th>Id</th>");
out.println("<th>Marque</th>");
out.println("<th>Nom</th>");
out.println("<th>Prix</th>");
out.println("<th>Pois Kg</th>");
out.println("<th>Volume m3</th>");
out.println("<th>Quantite</th>");
out.println("<th>action</th>");
out.println("</thead>");
out.println("<tbody>");
if (request.getParameter("idstock")!=null)
{
    String nom=request.getParameter("idstock");
    
    Stock currentStock=stockFacade.find(nom);
    
    List<ElementDeStock> list=currentStock.getListestock().getListeStock();
    
    for(int i=0;i<list.size();i++)
    {
        Produit p=produitFacade.getProduit(list.get(i).getReferenceProduit());
        out.println("<tr>");
        out.println("<td>"+p.getId()+"</td>");
out.println("<td>"+p.getMaruqeProduit().getId()+"</td>");
out.println("<td>"+p.getDenomination()+"</td>");
out.println("<td>"+p.getPrix()+"</td>");
out.println("<td>"+p.getPoids()+"</td>");
out.println("<td>"+p.getVolume()+"</td>");
out.println("<td>"+list.get(i).getQuantite()+"</td>");
out.println("<td");
out.println("style=\"");
out.println("display: flex;");
out.println("align-items: center;");
out.println("justify-content: space-around;");
out.println("\"");
out.println(">");
out.println("<form action=\"gerer\" id=\"updateProduit\" method=\"POST\">");
out.println("<input value=\""+nom+"\" name=\"stocku\" hidden/>");
out.println("<input value=\""+p.getId()+"\" name=\"refpupdate\" hidden/>");
out.println("<input id=\"quantite\" value=\"\" name=\"quantiteu\" hidden/>");
out.println("</form>");
out.println("<button");
out.println("onclick=\"q()\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 20px;");
out.println("background: #ffffff;");
out.println("color: black;");
out.println("border: 2px solid #000000;"); 
out.println("\"");
out.println(">");
out.println("update");
out.println("</button>");
out.println("</td>");
out.println("</tr>");
        
    }
    
    
}

out.println("</tbody>");
out.println("</table>");
out.println("</body>");
out.println("<script>");
out.println("function q() {");
out.println("var qu = prompt(\"novelle quantite : \");");
out.println("document.getElementById(\"quantite\").value = qu;");
out.println("const form = document.getElementById(\"updateProduit\");");
out.println("form.submit();");
out.println("");
out.println("}");
out.println("</script>");
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
