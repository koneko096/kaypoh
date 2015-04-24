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
        
        String [] args= new String[10];
        //api
        args[0]="tw";//request.getParameter("mode") ;
        args[1]="kmp";
        args[2]="Beauty";
        //tags
        args[3]="#Salon";//request.getParameter("keyword") ;
        args[4]="asus,charger";
        args[5]="bedak, kalung";
        args[6]="sauna";
        Kaypoh Kepo = new Kaypoh(args);
        List<List> allresult = Kepo.getResult();
       %>
        <div class="container">
		<header>
                <div class="maskot"><img src="images/Kaypoh-MaskotSmall.png"/></div>
			<h1>Search <span>RESULT</span></h1>
				
		</header>
			<section class="ac-container">
                            <% List<String> NamaKategori= Kepo.topicCategories.get(0); 
                                for(int i=0;i<NamaKategori.size();i++) {%>
				<div>
					<input id="ac-<%=i%>" name="accordion-1" type="radio" checked />
					<label for="ac-<%=i%>">KATEGORI <%=NamaKategori.get(i)%></label>
					<article class="ac-small">
                                            
                                            <% 
                                            for(int a=0;a<allresult.size();a++) {%> 
                                            <br>
                                            <!--div class="picture">
                                                <img alt="" src="image/Maskot-Act-Beauty.png"
                                                     style="height: 85px; " id="image"/>
                                            </div-->
                                            <div class="Twit">
                                                <h2>@BimoAryo</h2>
                                                <p><%=allresult.get(a)%></p>
                                                
                                            </div>
                                            <%}%>
						
					</article>
				</div>
                            <%}%>
				<!--div>
					<input id="ac-2" name="accordion-1" type="radio" />
					<label for="ac-2">KATEGORI 2</label>
					<article class="ac-medium">
						<p>Like you, I used to think the world was this great place where everybody lived by the same standards I did, then some kid with a nail showed me I was living in his world, a world where chaos rules not order, a world where righteousness is not rewarded. That's Cesar's world, and if you're not willing to play by his rules, then you're gonna have to pay the price. </p>
					</article>
				</div>
                
                
                
				<div>
					<input id="ac-3" name="accordion-1" type="radio" />
					<label for="ac-3">KATEGORI 3</label>
					<article class="ac-large">
						<p>You think water moves fast? You should see ice. It moves like it has a mind. Like it knows it killed the world once and got a taste for murder. After the avalanche, it took us a week to climb out. Now, I don't know exactly when we turned on each other, but I know that seven of us survived the slide... and only five made it out. Now we took an oath, that I'm breaking now. We said we'd say it was the snow that killed the other two, but it wasn't. Nature is lethal but it doesn't hold a candle to man. </p>
					</article>
				</div>
				<div>
					<input id="ac-4" name="accordion-1" type="radio" />
					<label for="ac-4">KATEGORI 4</label>
					<article class="ac-large">
						<p>You see? It's curious. Ted did figure it out - time travel. And when we get back, we gonna tell everyone. How it's possible, how it's done, what the dangers are. But then why fifty years in the future when the spacecraft encounters a black hole does the computer call it an 'unknown entry event'? Why don't they know? If they don't know, that means we never told anyone. And if we never told anyone it means we never made it back. Hence we die down here. Just as a matter of deductive logic. </p>
                        <p>Today, Brackets only supports Live Preview for HTML and CSS. However, in the current version, changes to
            JavaScript files are automatically reloaded when you save. We are currently working on Live Preview
            support for JavaScript. Live previews are also only possible with Google Chrome, but we hope
            to bring this functionality to all major browsers in the future.</p>
                        <p>Today, Brackets only supports Live Preview for HTML and CSS. However, in the current version, changes to
            JavaScript files are automatically reloaded when you save. We are currently working on Live Preview
            support for JavaScript. Live previews are also only possible with Google Chrome, but we hope
            to bring this functionality to all major browsers in the future.</p>
                        <p>Today, Brackets only supports Live Preview for HTML and CSS. However, in the current version, changes to
            JavaScript files are automatically reloaded when you save. We are currently working on Live Preview
            support for JavaScript. Live previews are also only possible with Google Chrome, but we hope
            to bring this functionality to all major browsers in the future.</p>
					</article>
				</div-->
			</section>
            <a href="home.jsp"><div class="btn">Back to Home</div></a>
        </div>
        
    <script src="bootstrap/js/bootstrap.min.js" />
    </body>
</html>