<%-- 
    Document   : home
    Created on : Apr 22, 2015, 5:29:18 AM
    Author     : FiqieUlya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="all" href="bootstrap/css/bootstrap.css" />
         <link rel="stylesheet" type="text/css" href="css/home.css">
         <link rel="stylesheet" type="text/css" href="css/hover-min.css">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
       
        <title>Kaypoh - HOME</title>
    </head>
    <body>
        <div class="row">
 
            <div class="col-md-4">
                <form action="index.jsp" method="GET">
                    <input type="image" class="logo hvr-pulse" src="image/homefb.png" name="modeapp" class="btTxt submit" value="fb" />
                </form>
            </div>
            <div class="col-md-4 logou">
                <img src="images/HomeHome.png" />
            </div>
            <div class="col-md-4 col-md-offset-4">
                <form action="index.jsp" method="GET">
                    <input type="image" class="logo hvr-pulse" src="image/hometwit.png" name="modeapp" class="btTxt submit" value="tw"  />
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-md-offset-3"><!--img src="image/Maskot-Act-Sport.png"width="100%"></div-->
        </div>
        </div>
        <form action="index11.html">
            <input class="btn" type="button" value="About" style="position:absolute;bottom:30px;">
        </form>    
        <script src="bootstrap/js/bootstrap.min.js" />
    </body>
</html>
