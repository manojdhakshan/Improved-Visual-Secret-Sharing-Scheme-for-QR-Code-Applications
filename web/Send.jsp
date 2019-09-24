<%@page import="dbServices.DB"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.PreparedStatement"%>
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
        					<li><a href="Userhome.jsp">Home</a></li>
        	    				<li class="start selected"><a href="Message.jsp">Message</a></li>
         	   				<li class=""><a href="Receive.jsp">Receive</a></li>
          	 				<li class="end"><a href="Logout.jsp">Logout</a></li>
				
        				</ul>
			</div>
		</nav>
		

		<section id="body" class="width clear">
                    <center>
                        <br><br>
                        <%
                        Connection con=new DB().fun();
                        String name=(String)session.getAttribute("name");
                        String id=(String)session.getAttribute("iid");
                        PreparedStatement ps=con.prepareStatement("select * from reg where not id='"+id+"' ");
                        ResultSet rs=ps.executeQuery();
                        %>
			
           
                        <h1>Choose the person to whom you want to send</h1><br>
           
        <form action="Send.jsp">
            Select:
            <select name="rname" style="height: 30px; width: 150px;">
                <%
                while(rs.next())
                {
                %>
                <option><%=rs.getString("name")%></option>
                <%}%>
            </select>
            
            &emsp;&emsp;<input type="submit" value="Send">
        </form>
                 <%
                 String rname=request.getParameter("rname");
                 
                 PreparedStatement ps1=con.prepareStatement("update msg set rname='"+rname+"' where uid='"+id+"' ");
                 ps1.executeUpdate();
                 
                 
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
