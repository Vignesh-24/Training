<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
<link href="https://use.fontawesome.com/releases/v5.0.7/css/all.css" rel="stylesheet">
</head>
<style>
a.custom-card,
a.custom-card:hover {
  color: inherit;
}
body{
background-color:#E6F2FF;
}
a{
text-decoration:none;}
.card {
box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
button{
background: none;
	color: inherit;
	border: none;
	padding: 0;
	font: inherit;
	cursor: pointer;
	outline: inherit;
}
</style>
<body>
<div class="container">
<p class="display-4 text-center">Welcome Management !!</p> <br><br>
<div class="text-right"><a href="/logout"><button class="btn btn-dark">logout</button></a></div> <br>
  <div class="row">
    <div class="col-sm-6">
    
        <div class="card mb-4" style="height:8rem;">
            <div class="card-body">
            <h3 class="card-title text-center">Get Invoice By Invoice no</h3>
                        <form action="invoicebyinvno" method="post">
            <div style="display:flex; flex-direction: row; justify-content: center; align-items: center">

    <input type="number" class="form-control w-50 mr-4" placeholder="Enter Invoice Number" name="invno"/>
    <button type="submit"><span><i class="fas fa-arrow-right fa-2x text-dark"></i></span></button>

	</div>
    </form>
    </div>
    </div>
    </div>
    <div class="col-sm-6">
    
    <div class="card mb-4" style="height:8rem;">
    <div class="card-body">
    <h3 class="card-title text-center">Get Item Stock by Item Number</h3>
    <form action="itemstockybyitemno" method="post">
    <div style="display:flex; flex-direction: row; justify-content: center; align-items: center">
    <input type="number" class="form-control w-50 mr-4" placeholder="Enter Item Number" name="itemno" required/>
    <button type="submit"><span><i class="fas fa-arrow-right fa-2x text-dark"></i></span></button>

	</div>
    </form>
    </div>
    </div>
    </div>
    <div class="col-sm-6">
	<div class="card mb-4" style="height:8rem;">
            <div class="card-body">
            <h3 class="card-title text-center">Get Invoice By Customer Number</h3>
                        <form action="invoicebycustno" method="post">
            <div style="display:flex; flex-direction: row; justify-content: center; align-items: center">

    <input type="number" class="form-control w-50 mr-4" placeholder="Enter Customer Number" name="custno" required/>
    <button type="submit"><span><i class="fas fa-arrow-right fa-2x text-dark"></i></span></button>

	</div>
    </form>
    </div>
    </div>
</div>
     <div class="col-sm-6">
    
        <div class="card mb-4" style="height:8rem;">
            <div class="card-body">
            <h3 class="card-title text-center">Get Invoice By Invoice Date</h3>
                        <form action="invoicebyinvdate" method="post">
            <div style="display:flex; flex-direction: row; justify-content: center; align-items: center">

		    <input type="date" class="form-control w-50 mr-4" placeholder="Enter Start Date" name="startdate" required />
		    <input type="date" class="form-control w-50 mr-4" placeholder="Enter End Date" name="enddate" required/>
		    <button type="submit"><span><i class="fas fa-arrow-right fa-2x text-dark"></i></span></button>
		
			</div>
		    </form>
    </div>
    </div>
    </div>
</div>
<div class="row">
  <div class="col-sm-12">
    <a href="manage/stockreport" class="custom-card" style="text-decoration:none">
        <div class="card mb-4" style="height:8rem;">
            <div class="card-body">
                <h3 class="card-title text-center mt-3">Stock Report</h3>
            </div>
        </div>
        </a>
    </div>
</div>
  </div>

</body>
</html>