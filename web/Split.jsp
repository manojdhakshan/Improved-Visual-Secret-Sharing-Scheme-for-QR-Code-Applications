<%@page import="algorithm.GFG"%>
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
        					<li class="start selected"><a href="Userhome.jsp">Home</a></li>
        	    				<li class=""><a href="Message.jsp">Message</a></li>
         	   				<li class=""><a href="Receive.jsp">Receive</a></li>
          	 				<li class="end"><a href="Logout.jsp">Logout</a></li>
				
        				</ul>
			</div>
		</nav>
		

		<section id="body" class="width clear">
                    <center>
                        <br><br>
                        <%
                        String name=(String)session.getAttribute("name");
                        %>
			
           
                        <h1>Splitted Text</h1><br>
                        <%
                        String txt=request.getParameter("text");
                        int lstem=txt.length()/5;
                        System.out.println(lstem);
                        String p[]={txt.substring(0,lstem),txt.substring(lstem)};
                        System.out.println("part 1"+p[0]);
                        System.out.println("Part 2"+p[1]);
                        
                        
                        
                        
                        %>
           
        
                       
                       
                    </center>         
                    <br><br><br><br><br><br><br><br><br><br><br><br>

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
