<%@page import="dbServices.DB"%>
<%@page import="java.sql.*"%>
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
        	    				<li class=""><a href="Message.jsp">Message</a></li>
         	   				<li class="start selected"><a href="Receive.jsp">Receive</a></li>
          	 				<li class="end"><a href="Logout.jsp">Logout</a></li>
				
        				</ul>
			</div>
		</nav>
		

		<section id="body" class="width clear">
                    <center>
                        <br><br>
                        <%
                        String name=(String)session.getAttribute("name");
                        String id=(String)session.getAttribute("iid");
                        
                        %>
			
           
                       <table align="center" style="text-align: center;width: 900px; border-radius: 7px; margin-left: -80px;" border="1">
                                   <tr style="color: crimson;font-size: x-large;"><td colspan="8" align="center">Received Secret Message</td></tr>
                                   <tr style="color: blue;font-size: 20px;font-weight: bold;">
                                       
                                       
                                       <td>Sender Name</td>
                                       
                                      
                                       
                                       <td>QR Image</td>
                                       
                                   </tr>
                                   
                                   
                                   <%
                                        int i=0;
                                        Connection con=new DB().fun();
                                        PreparedStatement query1=con.prepareStatement("SELECT * FROM msg where rname='"+name+"' ");
                                        ResultSet rs=query1.executeQuery();
                                        while(rs.next())
                                        {
                                            i++;
                                            //String id=rs.getString("id");
                                            String userid=rs.getString("uid");
                                            String username=rs.getString("name");
                                            String txt=rs.getString("txt");
                                            String enc=rs.getString("enc");
                                            String skey=rs.getString("skey");
                                            String iname=rs.getString("iname");
                                           
                                            %>
                                            <tr style="color: darkgreen;font-size: 20px;font-weight: bold;">
                                                
                                               
                                                <td><%=username%></td>
                                                
                                           
                                                <td><img src="images/<%=iname%>.png"></td>
                                                <!--<td><a href="Generate.jsp?id=<%=userid%>&&name=<%=username%>&&mail=<%=txt%>&&link=<%="http://localhost:22295/SOURCE_CODE/Qrgen.jsp?id="+userid%>">Generate key & QR code</a></td>-->
                                            </tr>
                                            <%
                                        }
                                        if(i==0)
                                        {
                                            %>
                                            <tr style="color: darkgreen;font-size: 20px;font-weight: bold;"><td colspan="3" align="center">----No User is there----</td></tr>
                                            <%
                                        }
                                    %>
                                   
                               </table>
                               <h1 align="center"><a href="Merge?name=<%=name%>">Merge</a></h1>
           
       
                       
                       
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
