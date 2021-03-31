<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap" rel="stylesheet">
    <title>Grocery</title>
</head>
<style>
    body{
        font-family: 'Josefin Sans', 'sans-serif';
    }
</style>
<body>

    <nav class="large-device navbar navbar-dark unique-color-dark justify-content-between pb-3">
        <span class="navbar-brand" href="#"> Welcome   ${ uname }</span>
         <form class="form-inline my-1" action="logout.do" method="post">
            <input type="hidden" name="formid" value="logout" >
            <button type="submit" class="btn btn-md btn-red btn-sm my-0" >Logout</button>>
        </form>
    </nav>


    <div class="container">

        <form action="shop.do" method="post">
        <input type="hidden" name="formid" value="shopping">
	    <input type="hidden" name="next" value="Fruits">
        <c:forEach var="item" items="${items}">

            <div class="row py-5">
                <div class="col-lg-6">
                    <img src="${item.getImg()}" height="100%" width="70%">
                </div>
                <div class="col-lg-6">
                    <h1>${item.getItemdesc() }</h1>
                    <h4>Unit : ${item.getItemqty()}</h4>
                    <h4>Price : ${item.getItemprice()}</h4>
                    <p class="h5 pt-2">Select Quantity</p>
                    <select name="${item.getItemno()}" class="form-control text-dark">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                    <div class="pt-5">
                        <input type="checkbox" name="selecteditems" class="btn-check" value="${item.getItemno()}" id="btn-check" autocomplete="off" />
                        <label class="btn btn-success" for="btn-check">Select</label>
                    </div>
                    
                </div>
                
            </div>

            <hr class="hr-dark py-2">

        </c:forEach>
        <div class="text-right">
            <button type="submit" class="btn btn-md btn-primary">Next</button>
        </div>
        
        </form>
        
    </div>

    
    
</body>
</html>






