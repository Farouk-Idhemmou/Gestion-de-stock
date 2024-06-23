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
import stock.ProduitFacade;

/**
 *
 * @author ok
 */
@WebServlet(name = "ajouterProduit", urlPatterns = {"/ajouterProduit"})
public class ajouterProduit extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ajouterProduit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ajouterProduit at " + request.getContextPath() + "</h1>");
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
out.println("background: black;");
out.println("color: white;");
out.println("padding: 10px 20px;");
out.println("border-radius: 5px;");
out.println("}");
out.println("</style>");
out.println("<body>");
out.println("<h1 style=\"text-align: center\">Add Product</h1>");
out.println("");
out.println("<form action=\"ajouterProduit\" method=\"POST\">");
out.println("<input type=\"text\" name=\"ref\" placeholder=\"reference\"  style=\"width: 250px;\"/>");
out.println("<label for=\"marque\"  style=\"font-size: 16px;\">Choisir la marque</label>");
out.println("<select name=\"marque\" id=\"marque\" style=\"width: 275px; border: 2px solid black; \" >");
List<Marque> marques=marqueFacade.getAllMarques();

for(int i=0;i<marques.size();i++)
{
    out.println("<option value="+marques.get(i).getId()+">"+marques.get(i).getId()+"</option>");
}
out.println("</select>");
out.println("<input type=\"text\" name=\"Denomination\" placeholder=\"nom de produit\" style=\"width: 250px;\" />");
out.println("<input type=\"text\" name=\"Prix\" placeholder=\"prix\" style=\"width: 250px;\" />");
out.println("<input type=\"text\" name=\"Poids\" placeholder=\"poids\" style=\"width: 250px;\" />");
out.println("<input type=\"text\" name=\"Volume\" placeholder=\"volume\" style=\"width: 250px;\" />");
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
         try  {
             PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ajouterProduit</title>");            
            out.println("</head>");
            out.println("<body>");

       
              String ref=request.getParameter("ref");
              
              String marque=request.getParameter("marque");
              String deno=request.getParameter("Denomination");
        
              double prix=Double.parseDouble(request.getParameter("Prix"));
             double poids=Double.parseDouble(request.getParameter("Poids"));
             double volume=Double.parseDouble(request.getParameter("Volume"));
             
             
             boolean b=produitFacade.creer(ref, marque, deno, prix, poids, volume);
             if(b)
             {
            out.println("<script>");
                 out.println("window.location.href=\"http://localhost:8080/GestionDeStock-war/allproducts\"");
                 out.println("</script>");
             }
             else
             {
              out.println("<script>");
                 out.println("window.location.href=\"http://localhost:8080/GestionDeStock-war/ajouterProduit\"");
                 out.println("</script>");
             }
             
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
