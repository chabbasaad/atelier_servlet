<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Metier.*"%>
<%@page import="Metier.Livre"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of </title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <%!
    ArrayList<Livre> diction ;
    Biblio ges;
    
%>
    <body>
   
        <%
        ges=new Biblio();
        diction = ges.Select("livre");
        %>
        <center>
    <h1>La liste des livre</h1>
     
<table  class="table table-bordered">
    <tr>
        <th>Code</th>
        <th>Titre</th>
        <th>Autheur</th>
        <th>Pages</th>
        <th colspan="3"><a href="livres?action=form&id=" class="btn btn-info">>>Ajouter</a></th>

    </tr>
    
<%
for(Livre i : diction){
%>
    <tr>
        <td><%= i.getCode()%></td>
        <td><%= i.getTitre()%></td>
        <td><%= i.getAuteur()%></td>
        <td><%= i.getNbr_pages()%></td>
        <td><a href="livres?action=form&id=<%= i.getCode() %>" class="btn btn-primary">Editer</a></td>
        <td><a href="livres?action=delete&id=<%= i.getCode() %>" class="btn btn-danger"> Supp</a></td>


    </tr>
<% 
}
%>
</table>
<% if (request.getAttribute("code") != null) { %>
    <%@include file="message.html" %>
<% } %>
<a href="./" class="btn btn-success">Retour</a>

</center>
    </body>
    
   
</html>


