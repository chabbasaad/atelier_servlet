/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import DAO.Connexion;
import Metier.Biblio;
import Metier.Dictionnaire;
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

/**
 *
 * @author Huawei
 */
//@WebServlet(name = "ControleurDictionnaire", urlPatterns = {"/dictionnaires"})
public class ControleurDictionnaire extends HttpServlet {
    
     Biblio ges ;
    String action=null;
    PrintWriter out;
    String code;
    ArrayList<Dictionnaire> Dictionnaire;
    Dictionnaire edit ;
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action=req.getParameter("action");
        out = resp.getWriter();
        Dictionnaire = ges.Select("dictionnaire");
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
        ges.delete(new Dictionnaire(ref));
       
          resp.sendRedirect("/atelier_Biblio/dictionnaires");
     

    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out.println("this is update");
        
        ges.update(new Dictionnaire(req.getParameter("code"),req.getParameter("langue"),req.getParameter("titre"),Integer.parseInt(req.getParameter("nbr_def_mots"))));
         resp.sendRedirect("/atelier_Biblio/dictionnaires");
       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out.println("this is postl"+req.getMethod());
       ges.insert(new Dictionnaire(req.getParameter("code"),req.getParameter("langue"),req.getParameter("titre"),Integer.parseInt(req.getParameter("nbr_def_mots"))));
              resp.sendRedirect("/atelier_Biblio/dictionnaires");
       
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    
      if(action==null){
          req.getRequestDispatcher("/Dictionnaire/DictionnaireAffichage.jsp").forward(req, resp);
      }else{
           
         switch(action){
            case "form":
                if(!req.getParameter("id").isEmpty()){ 
                    
                       
       code=req.getParameter("id");
       req.setAttribute("action", "update");
        req.setAttribute("type", "readonly");
        
        edit = (Dictionnaire) ges.find("dictionnaire",code);
       
        req.setAttribute("code", edit.getCode());
        req.setAttribute("langue", edit.getLangue());
        req.setAttribute("titre", edit.getTitre());
        req.setAttribute("nbr_def_mots", edit.getNbr_def_mots());
                                
                 
     req.getRequestDispatcher("/Dictionnaire/Form.jsp").forward(req, resp);
                }
                else{ 
         req.setAttribute("type", "");
         req.setAttribute("action", "insert");
                req.setAttribute("code", "");
        req.setAttribute("langue", "");
        req.setAttribute("titre", "");
        req.setAttribute("nbr_def_mots", "");
                req.getRequestDispatcher("/Dictionnaire/Form.jsp").forward(req, resp);} break;
            case "delete": doDelete(req,resp);break;
        } 
      }
       
        
    }

    @Override
    public void init() throws ServletException {
        ges = new Biblio();
       
        
        }



 

}
