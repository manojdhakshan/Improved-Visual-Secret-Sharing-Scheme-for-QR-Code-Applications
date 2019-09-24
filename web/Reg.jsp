<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>QR_Code</title>
<link rel="stylesheet" href="styles.css" type="text/css" />
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<!--
cleansed, a free CSS web template by ZyPOP (zypopwebtemplates.com/)

Download: http://zypopwebtemplates.com/

License: Creative Commons Attribution
//-->
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
</head>

<body>

		<header>
			<div class="width">
				<h1><a href="#">Visual Secret Sharing</a></h1>
			</div>
		</header>
		<nav>
			<div class="width">
					<ul>
        					<li class="start selected"><a href="index.jsp">Home</a></li>
        	    				<li class=""><a href="User.jsp">User</a></li>
         	   				
          	 				<li class="end"><a href="Logout.jsp">Logout</a></li>
				
        				</ul>
			</div>
		</nav>
		

		<section id="body" class="width clear">
                    <center>
            <h1>User Registration</h1><br>
           
        <form action="Reg">
           <table style="border-spacing: 17px; width: 48%;">
               <tr><td>Username</td><td><input type="text" name="uname"required="required" pattern="[a-z A-Z]{1,}" title="Please Enter Only Text"/></td></tr>
               <tr><td>Password</td><td><input type="text" name="pass" required="required" /></td></tr>
               <tr><td>Email-Id</td><td><input type="text" name="emailid" required="required" /></td></tr>
               <tr><td>Mobile No</td><td><input type="text" name="mobno" required="required" pattern="[0-9]{10}" title="Please Enter Only 10 Digit Number" /></td></tr>
               <tr><td>City</td><td><input type="text" name="city" required="required" /></td></tr>
               <tr><td align="center" colspan="2"><input type="submit" value="Register"/> </td></tr>
           </table>
        </form>
           
                        </center>       
                    <br><br><br><br><br><br><br><br><br><br><br>

	</section>
	
	<footer class="clear">
        <div class="footer-content width">
            
            
            <div class="clear"></div>
        </div>
        <div class="footer-bottom">
            <p>&copy; Qr_Code Project 2018. </p>
         </div>
    </footer>
</body>
</html>
