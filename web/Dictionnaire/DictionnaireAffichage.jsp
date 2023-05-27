<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Metier.*"%>
<%@page import="Metier.Dictionnaire"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <!-- Add Bootstrap CSS -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <%!
    ArrayList<Dictionnaire> diction ;
    Biblio ges;
    
%>
    <body>
        <%
        ges=new Biblio();
        diction = ges.Select("dictionnaire");
        %>
        <center>
    <h1>La liste des Dictionnaires</h1>
     
<table   class="table table-bordered">
    <tr>
        <th>Code</th>
         <th>Langue</th>
        <th>Titre</th>
        <th>Nombre de Mots</th>
        <th colspan="3"><a href="dictionnaires?action=form&id=" class="btn btn-info">>>Ajouter</a></th>

    </tr>
    
<%
for(Dictionnaire i : diction){
%>
    <tr>
        <td><%= i.getCode()%></td>
        <td><%= i.getLangue()%></td>
        <td><%= i.getTitre()%></td>
        <td><%= i.getNbr_def_mots()%></td>
        <td><a href="dictionnaires?action=form&id=<%= i.getCode() %>" class="btn btn-primary">Editer</a></td>
        <td><a href="dictionnaires?action=delete&id=<%= i.getCode() %>" class="btn btn-danger"> Supp</a></td>


    </tr>
<% 
}
%>
</table>
<a href="./" class="btn btn-success">Retour</a>

</center>



    </body>
</html>




