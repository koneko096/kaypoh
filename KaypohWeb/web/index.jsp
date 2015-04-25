<%-- 
    Document   : index
    Created on : Apr 21, 2015, 8:27:34 PM
    Author     : FiqieUlya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="kaypoh.FacebookCrawler" %>
<%@page import="kaypoh.TwitterCrawler"%>
<%@page import="kaypoh.Kaypoh"%>
<%@page import="StringMatching.KnuthMorrisPratt"%>
<%@page import="static java.util.Arrays.asList"%>
<%@page import="java.util.List" %>
<%@page import="java.util.LinkedList" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" media="all" href="bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="style.css">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
    <script language="javascript">
        <% List<String> topics = asList("Health & Beauty", "Entertainment", "Sport", "Politics");
          List< List<String> > topicCategories = asList(
        asList("Obat", "Perawatan Tubuh", "Perawatan Wajah","Fashion"),
        asList("Musik", "Movies", "TV","Celebrity"),
        asList("Bola", "Raket", "Atlet"),
        asList("Daerah","Nasional","Internasional")
    );%>
        <% String a = request.getParameter("modeapp") ;
            out.write(a);
            int CO=0;
        %>
    function Beauty() 
    {
        document.getElementById("image").src = "image/Maskot-Act-Beauty.png";
        <%CO=0;%>
    }

    function Music() 
    {
        document.getElementById("image").src = "image/Maskot-Act-Music.png"; 
        <%CO=1;%>
    }
    function Sport() 
    {
        document.getElementById("image").src = "image/Maskot-Act-Sport.png"; 
        <%CO=2;%>
    }
    function Tech() 
    {
        document.getElementById("image").src = "image/Maskot-Act-Tech.png"; 
        <%CO=3;%>
    }
</script>
    </head>
    <body>
       
    
        
    <div class="TopicArt"> 
       <img alt="" src="image/Maskot-Act-Beauty.png" 
            style="height: 85px; width: 198px" id="image" />
        <p>
        <input id="Button1" type="button" value="Beauty" onclick="Beauty()" />&nbsp;&nbsp; 
        <input id="Button2" type="button" value="Music" onclick="Music()" />&nbsp;&nbsp;
        <input id="Button3" type="button" value="Sport" onclick="Sport()" />&nbsp;&nbsp;
        <input id="Button4" type="button" value="Tech" onclick="Tech()" />&nbsp;&nbsp;
        </p>
    </div>
        <div class = "searchform" >
            <form class="form-horizontal" action="index2.jsp" method="GET">
                <div class="form-group">
                    <label for="inputCategory" id="NamaKeyword" class="col-sm-2 control-label">Keyword <%=topics.get(CO)%></label>
                    <div class="col-sm-11">
                        <input type="hidden" name="topic" value="<%=topics.get(CO)%>"/>
                        <input type="text" name="keyword" class="form-control"  placeholder="#hiburan">
                    </div>
                </div>
                <%List<String> Kategori= topicCategories.get(CO); %>
                <% for(int i=0;i<Kategori.size();i++) {%>
                <div class="form-group">
                    
                    <label for="inputCategory" id="NamaKategori" class="col-sm-2 control-label">Kategori <%= Kategori.get(i)%></label>
                    <div class="col-sm-11">
                        <input type="text" name="kategori"class="form-control"  placeholder="Tv, Bedak, Mikasa">
                    </div>
                </div>
                <%}%>
                     <input type="hidden" name="mode" class="form-control" value="<%=a%>" >
                <br/>
                <div class="form-group">
                    <div class="col-sm-offset-7 col-sm-10">
                        <button type="submit" class="btn btn-default">Search</button>
                    </div>
                </div>
            </form>
    
        </div>

<!--footer>
</footer-->
<script src="bootstrap/js/bootstrap.min.js" />

    </body>
</html>
