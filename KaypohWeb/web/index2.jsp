<%-- 
    Document   : index2.jsp
    Created on : Apr 24, 2015, 4:17:16 AM
    Author     : Bimo Aryo Tyasono
--%>

<%@page import="java.util.List"%>
<%@page import="kaypoh.Kaypoh"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css'>
		<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <title>Accordion with CSS3</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Accordion with CSS3" />
        <meta name="keywords" content="accordion, css3, sibling selector, radio buttons, input, pseudo class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style1.css" />
		<script type="text/javascript" src="js/modernizr.custom.29473.js"></script>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <% 
        String [] CategoryField=request.getParameterValues("kategori");
        String [] args= new String[10];
        //api
        args[0]=request.getParameter("mode") ;//"tw";
        args[1]="bm";
        args[2]=request.getParameter("topic");//"Beauty";
        //tags
        args[3]=request.getParameter("keyword") ;//"#Salon";
        out.print(CategoryField.length+4);
        for(int i=4;i<(CategoryField.length+4);i++){
        args[i]=CategoryField[i-4];
        }
        //args[5]="bedak,kalung";
        //args[6]="job";
//        args[0]="tw";//request.getParameter("mode") ;
//        args[1]="kmp";
//        args[2]="Beauty";
//        //tags
//        args[3]="#Salon";//request.getParameter("keyword") ;
//        args[4]="sex";
//        args[5]="bedak,kalung";
//        args[6]="job";
//        args[7]="apapun";
        Kaypoh Kepo = new Kaypoh(args);
        List<List> allresult = Kepo.getResult();

       %>
        <div class="container">
		<header>
                <div class="maskot"><img src="images/Kaypoh-MaskotSmall.png"/></div>
			<h1>Search <span>RESULT</span></h1>
				
		</header>
			<section class="ac-container">
                            <% List<String> NamaKategori= Kepo.topicCategories.get(3); 
                            
                                %>
                                <div>
                                    <% List<String> resultU= allresult.get(NamaKategori.size());
                                        List<String> userU=Kepo.username.get(NamaKategori.size());%>
					<input id="ac-<%=NamaKategori.size()%>" name="accordion-1" type="radio" checked />
					<label for="ac-<%=NamaKategori.size()%>">KATEGORI UNKNOWN <span> (<%=resultU.size()%>) </span></label>
					<article class="ac-small">
                                            
                                            
                                            <%for(int a=0;a<resultU.size();a++) {%> 
                                            <br>
                                            <div class="picture">
                                                <img alt="" src="image/Maskot-Act-Beauty.png"
                                                     style="height: 85px; " id="image"/>
                                            </div>
                                            
                                            <div class="Twit">
                                                <p><h2>@<%=userU.get(a)%></h2></p>
                                                <p><%=resultU.get(a)%></p>
                                                <%if(!Kepo.getLocation(resultU.get(a), 2).equals("")){%>
                                                    <form id="myform" action="gmap.jsp">
                                                        <input type='hidden' name='query' value=<%=Kepo.getLocation(resultU.get(a), 2)%>>
                                                     <button type="submit" class="btn btn-default">Location</button>
                                                <%}%>
                                            </div>
                                            <%}%>
						
					</article>
				</div>
                                
                                        <% for(int i=0;i<NamaKategori.size();i++) {
                                            List<String> User=Kepo.username.get(i);%>
				<div>
					<input id="ac-<%=i%>" name="accordion-1" type="radio" checked />
                                        <%String name= NamaKategori.get(i);
                                        
                                        List<String> result= allresult.get(i);%>
                                        <label for="ac-<%=i%>">KATEGORI <%=name%> <span> (<%=result.size()%>) </span></label>
					<article class="ac-small">
                                            
                                            <% for(int a=0;a<result.size();a++) {
                                            String username=User.get(a);%> 
                                            <br>
                                            <div class="picture">
                                                <img alt="" src="image/Maskot-Act-Beauty.png"
                                                     style="height: 85px; " id="image"/>
                                            </div>
                                            
                                            <div class="Twit">
                                                
                                                <h2>@<%=username%></h2>
                                                <p><%=result.get(a)%></p>
                                                <%if(!Kepo.getLocation(result.get(a), 2).equals("")){%>
                                                    <form id="myform" action="gmap.jsp">
                                                        <input type='hidden' name='query' value=<%=Kepo.getLocation(result.get(a), 2)%>>
                                                     <button type="submit" class="btn btn-default">Location</button>
                                                <%}%>
                                                
                                                
                                            </div>
                                            <%}%>
						
					</article>
				</div>
                            <%}%>
                            
				
			</section>
            <a href="home.jsp"><div class="btn">Back to Home</div></a>
        </div>
        
    <script src="bootstrap/js/bootstrap.min.js" />
    </body>
</html>