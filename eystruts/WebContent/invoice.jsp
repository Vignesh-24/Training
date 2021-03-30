<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
     <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap" rel="stylesheet">
    <title>Invoice</title>
</head>
<style>
    body{
        font-family: 'Josefin Sans', 'sans-serif';
    }
</style>
<body>

	<nav class="large-device navbar navbar-dark unique-color-dark justify-content-between pb-3">
        <span class="navbar-brand" href="#"> Hello ${ uname }, </span>
 
    </nav>

    <div class="container">

        <div class="header-content py-2">
        
        <div class="row">
        	<div class="col-lg-6">
        		<h3>Name: ${invoice.getCustomer().getCustomername()}</h3>
        	</div>
        	<div class="col-lg-6">
        		 <h3>Address: ${invoice.getCustomer().getCustomeraddress()}</h3>
        	</div>
        </div>
        
        <div class="row">
        	<div class="col-lg-6">
        		  <h3>Phone: ${invoice.getCustomer().getCustomerphone()}</h3>
        	</div>
     
        	<div class="col-lg-6">
        		  <h3>Email: ${invoice.getCustomer().getCustomeremail()}</h3>
        	</div>
        </div>
        	
        <div class="row">
        	<div class="col-lg-6">
        		   <h3>Invoice Date: ${invoice.getInvoice().getInvdate().toString()}</h3>
        	</div>
        </div>
            
           
           
          
        </div>
    
        <table class="table table-striped">
            <thead class="thead-dark">
              <tr>
                <th scope="col">Sl.no</th>
                <th scope="col">Item Description</th>
                <th scope="col">Unit</th>
                <th scope="col">Price</th>
                <th scope="col">Quantity</th>
                <th scope="col">Amount</th>
              </tr>
            </thead>
            <tbody>
                <c:set var = "items" value = "${invoice.getItemlist()}"/>
                 <c:set var = "total" value = "0"/>
                <c:forEach var="trans" items="${invoice.getItemtrans()}" varStatus="status">
                    <c:set var = "item" value = "${items.get(trans.getItemno())}"/>
                    <tr>
                        <th scope="row">${status.count}</th>
                        <td>${item.getItemdesc()}</td>
                        <td>${item.getItemqty()}</td>
                        <td>${item.getItemprice()}</td>
                        <td>${trans.getItemunit()}</td>
                        <td>${trans.getItemunit()*item.getItemprice()} </td>
                        <c:set var = "total" value = "${total+trans.getItemunit()*item.getItemprice()}"/>
                      </tr>
	            </c:forEach>
	            <tr>
	            	<td colspan="6"><h1>TOTAL AMOUNT - ${total}</h1></td>
	            </tr>

              
            </tbody>
          </table>
    
          <div class="row">
              <div class="col-lg-3 ">
                <form action="pdf.do" method="post">
                    <input type="hidden" name="invno" value="${invoice.getInvoice().getInvno() }">
                    <input type="hidden" name="formid" value="pdf">
                    <button type="submit" class="btn btn-md btn-success">Get PDF </button>
                </form>
              </div>
              <div class="col-lg-3 text-center">
                <form action="excel.do" method="post">
                    <input type="hidden" name="invno" value="${invoice.getInvoice().getInvno() }">
                    <input type="hidden" name="formid" value="excel">
                    <button type="submit" class="btn btn-md btn-success" >Get Excel </button>
                </form>
              </div>
                <div class="col-lg-3">
                <form action="excel.do" method="post">
                    <input type="hidden" name="invno" value="${invoice.getInvoice().getInvno() }">
                    <input type="hidden" name="formid" value="mail">
                    <button type="submit" class="btn btn-md btn-success" >Send Email</button>
                </form>
              </div>
              <div class="col-lg-3 text-right">
                <form action="excel.do" method="post">
                    <input type="hidden" name="invno" value="${invoice.getInvoice().getInvno() }">
                    <input type="hidden" name="formid" value="sms">
                    <button type="submit" class="btn btn-md btn-success" >Send SMS</button>
                </form>
              </div>
          </div>

    </div>

    
    
</body>
</html>