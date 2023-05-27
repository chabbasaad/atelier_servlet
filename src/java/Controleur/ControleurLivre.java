package Controleur;

import DAO.Connexion;
import Metier.Biblio;
import Metier.Livre;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(name = "ControllerLiver", urlPatterns = {"/livres"})
public class ControleurLivre extends HttpServlet {

     Biblio ges ;
    String action=null;
    PrintWriter out;
    String code;
            int pages;
    String titre,autheur;
    ArrayList<Livre> Liv;
    Livre edit ;
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action=req.getParameter("action");
        out = resp.getWriter();
        Liv = ges.Select("livre");
        //out.println("Bonjour");
        if(req.getMethod().equals("GET")){
            
            doGet(req,resp);
        }else{
        switch(action){
            case "insert": doPost(req,resp);break;
            case "update": doPut(req,resp);break;
            
        }
        }
     }

     @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
     
        String ref = req.getParameter("id");
        ges.delete(new Livre(ref));
       
          resp.sendRedirect("/atelier_Biblio/livres");
  
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out.println("this is update");
        
        ges.update(new Livre(req.getParameter("code"),req.getParameter("titre"),req.getParameter("auteur"),Integer.parseInt(req.getParameter("nbr_pages"))));
         resp.sendRedirect("/atelier_Biblio/livres");
  }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out.println("this is postl"+req.getMethod());
       ges.insert(new Livre(req.getParameter("code"),req.getParameter("titre"),req.getParameter("auteur"),Integer.parseInt(req.getParameter("nbr_pages"))));
        resp.sendRedirect("/atelier_Biblio/livres");
       
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  
      if(action==null){
          req.getRequestDispatcher("/Livre/LivreAffichage.jsp").forward(req, resp);
      }else{
           
         switch(action){
            case "form":
                if(!req.getParameter("id").isEmpty()){ 
                    
                       
       code=req.getParameter("id");
       req.setAttribute("action", "update");
        req.setAttribute("type", "readonly");
        
        edit = (Livre) ges.find("livre",code);
        
        req.setAttribute("code", edit.getCode());
        req.setAttribute("titre", edit.getTitre());
        req.setAttribute("auteur", edit.getAuteur());
        req.setAttribute("nbr_pages", edit.getNbr_pages());
                                
                 
     req.getRequestDispatcher("/Livre/Form.jsp").forward(req, resp);
                }
                else{ 
         req.setAttribute("type", "");
         req.setAttribute("action", "insert");
                req.setAttribute("code", "");
        req.setAttribute("titre", "");
        req.setAttribute("auteur", "");
        req.setAttribute("nbr_pages", "");
                req.getRequestDispatcher("/Livre/Form.jsp").forward(req, resp);} break;
            case "delete": doDelete(req,resp);break;
//            case "normal": req.getRequestDispatcher("/Livres/LivresAffichage.jsp").forward(req, resp); break;
        } 
      }
       
        
    }

    @Override
    public void init() throws ServletException {
         Connexion.driver=getInitParameter("driver"); 
       Connexion.url=getInitParameter("url"); 
        Connexion.user=getInitParameter("user"); 
        Connexion.password=getInitParameter("password"); 
        ges = new Biblio();
      
        
        }
}