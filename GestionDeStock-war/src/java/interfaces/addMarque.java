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
 * @author USER
 */
@WebServlet(name = "ajouterMarque", urlPatterns = {"/ajouterMarque"})
public class addMarque extends HttpServlet {
    @EJB
    private ProduitFacade produitFacade;
    @EJB
    private MarqueFacade marqueFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
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
            out.println("<h1 style=\"text-align: center\">Add Marque</h1>");
            out.println("");
            out.println("<form action=\"ajouterMarque\" method=\"POST\">");
            out.println("<label for=\"marque\">Marque</label>");
            out.println("<input type=\"text\" name=\"NomMarque\" placeholder=\"nom \"   style=\"width: 250px;\"/>");
            out.println("<label for=\"pays\">Pays</label>");
            out.println("<input type=\"text\" name=\"Pays\" placeholder=\"pays\" style=\"width: 250px;\"/>");
            out.println("<button type=\"submit\" style=\"background: #ffffff; color: black; padding: 10px 20px; border: 2px solid black; border-radius: 20px; cursor: pointer;\">Add</button>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ajouterProduit</title>");
            out.println("</head>");
            out.println("<body>");

            String nomMarque = request.getParameter("NomMarque");
            String paysMarque = request.getParameter("Pays");


            boolean b = marqueFacade.Creer(nomMarque, paysMarque);
            if (b) {
                out.println("<script>");
                out.println("window.location.href=\"http://localhost:8080/GestionDeStock-war/allMarques\"");
                out.println("</script>");
            } else {
                out.println("<script>");
                out.println("window.location.href=\"http://localhost:8080/GestionDeStock-war/ajouterMarque\"");
                out.println("</script>");
            }
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
