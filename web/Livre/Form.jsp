<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liver form </title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>
        <center>
               <div class="card">
                   <div class="card-body">
                    
    <fieldset>
    <form action="livres?action=<%=request.getAttribute("action")%>" method="post">
        
    <table>
        
        <div class="form-group row">
      <label for="Code" class="col-sm-2 col-form-label">Code :</label>
      <div class="col-sm-7">
            <input class="form-control"   placeholder="Enter code" type="text" name="code" value="<%=request.getAttribute("code")%>" <%=request.getAttribute("type")%>>
      </div>
     </div>
      
    <div class="form-group row">
      <label for="titre" class="col-sm-2 col-form-label">titre :</label>
      <div class="col-sm-7">
     <input class="form-control"    placeholder="Enter titre" type="text" name="titre" value="<%=request.getAttribute("titre")%>">
      </div>
     </div>
      
         <div class="form-group row">
      <label for="titre" class="col-sm-2 col-form-label">auteur :</label>
      <div class="col-sm-7">
     <input class="form-control"    placeholder="Enter auteur" type="text" name="auteur" value="<%=request.getAttribute("auteur")%>">
      </div>
     </div>
       
      
       <div class="form-group row">
      <label for="titre" class="col-sm-2 col-form-label">nbr_pages :</label>
      <div class="col-sm-7">
     <input class="form-control"    placeholder="Enter nbr_pages" type="text" name="nbr_pages" value="<%=request.getAttribute("nbr_pages")%>">
      </div>
     </div>
     
      
        <td><input type="submit" name="submit" value="Envoyer" class="btn btn-success"></td>
        <td><input type="reset" name="rest" value="Annuler" class="btn btn-danger"></td>
    </tr>
    </table>
<a href="livres" class="btn btn-info">Retour</a>
</form> 
</fieldset>
       </div>
                   </div>
</center>
    </body>
</html>
