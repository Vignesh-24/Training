

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        <span class="navbar-brand" href="#"> Welcome to Shop APP Mr. ${uname}</span>
        <form class="form-inline my-1" action="logout.do" method="post">
            <input type="hidden" name="formid" value="logout" >
            <button type="submit" class="btn btn-md btn-red btn-sm my-0" >Logout</button>>
        </form>
    </nav>
    

    <div class="container py-5">
 		<div class="row">
 		<img src="https://st2.depositphotos.com/1309454/7392/v/950/depositphotos_73921481-stock-illustration-shopping-online-background.jpg"
 		height=50% width=100%>
 		</div>
        <div class="card">
        	<form action="shopping.do" method="post">
			<input type="hidden" name="formid" value="shopping">
			<input type="hidden" name="next" value="Jewel">	
		
		
            <div class="py-3 text-center">
                <button type="submit" class="btn btn-primary">Shopping</button>
            </div>
            </form>
           
            </div>
          </div>
        </form>
    </div>

    
    
</body>
</html>
