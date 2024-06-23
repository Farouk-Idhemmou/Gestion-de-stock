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
@WebServlet(name = "allproducts", urlPatterns = {"/allproducts"})
public class allproducts extends HttpServlet {

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
            out.println("<title>Servlet allproducts</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet allproducts at " + request.getContextPath() + "</h1>");
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
out.println("th,");
out.println("td {");
out.println("border: 1px solid;");
out.println("padding: 10px;");
out.println("}");
out.println("button {");
out.println("border: none;");
out.println("cursor: pointer;");
out.println("}");
out.println("</style>");
out.println("<body>");
out.println("<h1 style=\"text-align: center\">Gestion de Stock : Liste of products</h1>");
out.println("");
out.println("<div");
out.println("style=\"");
out.println("display: flex;");
out.println("width: 100%;");
out.println("justify-content: space-around;");
out.println("align-items: center;");
out.println("\"");
out.println(">");
out.println("<form action=\"ajouterProduit\" method=\"GET\">");
out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 20px;");
out.println("background: #ffffff;");
out.println("color: black;");
out.println("border: 2px solid black;"); // Added black border
out.println("\"");
out.println(">");
out.println("Ajouter Porduit");
out.println("</button>");
out.println("</form>");
out.println("<form action=\"ajouterMarque.jsp\">");
/**out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 5px;");
out.println("background: rgb(205, 255, 176);");
out.println("color: black;");
out.println("\"");
out.println(">");
out.println("Ajouter Marque");
out.println("</button>");*/
out.println("</form>");
out.println("<form action=\"allStocks\">");
/**out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 5px;");
out.println("background: rgb(250, 225, 176);");
out.println("color: black;");
out.println("\"");
out.println(">");
out.println("liste Stockes");
out.println("</button>");*/
out.println("</form>");
out.println("<form action=\"allMarques\">");
/**out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 5px;");
out.println("background: rgb(250, 255, 176);");
out.println("color: black;");
out.println("\"");
out.println(">");
out.println("liste marques");*/
out.println("</button>");
out.println("</form>");
out.println("<form action=\"allproducts\" method=\"GET\">");
out.println("<select name=\"marque\" id=\"marque\" type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 20px;");
out.println("background: #ffffff;");
out.println("color: black;");
out.println("border: 2px solid black;"); // Added black border
out.println("\"");
out.println(">");
out.println("<option value=\"all\">All Marques</option>");
List<Marque> marques=marqueFacade.getAllMarques();

for(int i=0;i<marques.size();i++)
{
    out.println("<option value="+marques.get(i).getId()+">"+marques.get(i).getId()+"</option>");
}
out.println("</select>");
out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 20px;");
out.println("background: #ffffff;");
out.println("color: black;");
out.println("border: 2px solid black;"); // Added black border
out.println("\"");
out.println(">");
out.println("filtrer");
out.println("</button>");
out.println("</form>");
out.println("</div>");
out.println("<table style=\"width: 100%; padding: 20px\">");
out.println("<thead>");
out.println("<th>Id</th>");
out.println("<th>Marque</th>");
out.println("<th>Product name</th>");
out.println("<th>Prix</th>");
out.println("<th>Pois Kg</th>");
out.println("<th>Volume m3</th>");
out.println("<th>Action</th>");
out.println("</thead>");
out.println("<tbody>");
List<Produit> produits;
if (request.getParameter("marque")==null || request.getParameter("marque").equals("all"))
{
    produits=produitFacade.findAll();
}
else{
    String marque=request.getParameter("marque");
    
    Marque m=marqueFacade.getmarque(marque);
    
    produits=m.getproduits();
}
   


for(int i=0;i<produits.size();i++)
{
    Produit p=produits.get(i);
    out.println("<tr>");
out.println("<td>"+p.getId()+"</td>");
out.println("<td>"+p.getMaruqeProduit().getId()+"</td>");
out.println("<td>"+p.getDenomination()+"</td>");
out.println("<td>"+p.getPrix()+"</td>");
out.println("<td>"+p.getPoids()+"</td>");
out.println("<td>"+p.getVolume()+"</td>");
out.println("<td");
out.println("style=\"");
out.println("display: flex;");
out.println("align-items: center;");
out.println("justify-content: space-around;");
out.println("\"");
out.println(">");
out.println("<form action=\"updateProduit\" method=\"POST\">");
out.println("<input type=\"text\" name=\"id\" value="+p.getId()+" hidden />");
out.println("<button");
out.println("type=\"submit\"");
out.println("style=\"");
out.println("padding: 10px;");
out.println("border-radius: 20px;");
out.println("background: #ffffff;");
out.println("border: 2px solid #000000;"); 
out.println("color: black;");
out.println("\"");
out.println(">");
out.println("update");
out.println("</button>");
out.println("</form>");
out.println("<form action=\"supprimerProduit\" method=\"POST\">");
out.println("<input type=\"text\" name=\"id\" value="+p.getId()+" hidden />");
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
out.println("supprimer");
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
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet gerer</title>");            
            out.println("</head>");
            out.println("<body>");
            String origin=request.getParameter("origine");
              
            String nom=request.getParameter("nom");
            boolean a=marqueFacade.Creer(nom, origin);
            if (a)
            {
                 out.println("<h1>successfylly</h1>");
            }
           
            out.println("</body>");
            out.println("</html>");
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
