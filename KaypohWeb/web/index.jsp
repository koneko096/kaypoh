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
        <title>Search</title>
        <link rel="stylesheet" media="all" href="bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="style.css">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
    <script language="javascript">
        //inisialisasi List kategori
        <% List<String> topics = asList("Health & Beauty", "Entertainment", "Sport", "Tech");
          List< List<String> > topicCategories = asList(
        asList("Obat", "Perawatan Tubuh", "Perawatan Wajah","Fashion"),
        asList("Musik", "Movies", "TV","Celebrity"),
        asList("Bola", "Raket", "Atlet", "Turnamen"),
        asList("Internet","Gadget","Science", "Space")
    );%>
        <% String a = request.getParameter("modeapp") ;

            int CO=0;
        %>
        <%List<String> Kategori= topicCategories.get(CO); %>

    function Beauty() 
    {
        document.getElementById("image").src = "image/Maskot-Act-Beauty2.png";
         document.body.style.background = "#FF81FA url('image/bg-kaypoh.png') repeat 0% 0%";
         
        <%CO=0;%>
        document.getElementById("NamaKeyword").innerHTML = "Keyword <%= topics.get(CO)%>";
        document.getElementById("hiddentopic").value = "<%=topics.get(CO)%>";

        <% for(int i=0;i<Kategori.size();i++) {%>
                document.getElementById("<%= "NamaK" + i%>").innerHTML = "Kategori <%= Kategori.get(i)%>";
        <%}%> 
    }

    function Entertainment() 
    {
        document.getElementById("image").src = "image/Maskot-Act-Music2.png"; 
        document.body.style.background = "#50FF54 url('image/bg-kaypoh.png') repeat 0% 0%";
        <%CO=1;%>
        document.getElementById("NamaKeyword").innerHTML = "Keyword <%= topics.get(CO)%>";
        document.getElementById("hiddentopic").value = "<%=topics.get(CO)%>";
        <%Kategori= topicCategories.get(CO); %>
        <% for(int i=0;i<Kategori.size();i++) {%>
                document.getElementById("<%= "NamaK" + i%>").innerHTML = "Kategori <%= Kategori.get(i)%>";
        <%}%>       
    };
    function Sport() 
    {
        document.getElementById("image").src = "image/Maskot-Act-Sport2.png";
        document.body.style.background = "#6D9987 url('image/bg-kaypoh.png') repeat 0% 0%";
        <%CO=2;%>
        document.getElementById("NamaKeyword").innerHTML = "Keyword <%= topics.get(CO)%>";
        document.getElementById("hiddentopic").value = "<%=topics.get(CO)%>";
        <%Kategori= topicCategories.get(CO); %>
        <% for(int i=0;i<Kategori.size();i++) {%>
                document.getElementById("<%= "NamaK" + i%>").innerHTML = "Kategori <%= Kategori.get(i)%>";
        <%}%>     
    }
    function Tech() 
    {
        document.getElementById("image").src = "image/Maskot-Act-Tech2.png"; 
        document.body.style.background = "#2CCC8A url('image/bg-kaypoh.png') repeat 0% 0%";
        <%CO=3;%>
        document.getElementById("NamaKeyword").innerHTML = "Keyword <%= topics.get(CO)%>";
        document.getElementById("hiddentopic").value = "<%=topics.get(CO)%>";
        <%Kategori= topicCategories.get(CO); %>
        <% for(int i=0;i<Kategori.size();i++) {%>
                document.getElementById("<%= "NamaK" + i%>").innerHTML = "Kategori <%= Kategori.get(i)%>";
        <%}%>    

    }
</script>
    </head>
    <body>
       <%CO=0;%>
    <div class="TopicArt"> 
       <img alt="" src="image/Maskot-Act-Beauty2.png" 
            style="height: 500px; position:relative;" id="image" />
        <p>
        <input id="Button1" class="btn btn-default" type="button" value="Beauty" onclick="Beauty()" />&nbsp;&nbsp; 
        <input id="Button2" class="btn btn-default" accept=""type="button" value="Entertainment" onclick="Entertainment()" />&nbsp;&nbsp;
        <input id="Button3" class="btn btn-default" type="button" value="Sport" onclick="Sport()" />&nbsp;&nbsp;
        <input id="Button4" class="btn btn-default" type="button" value="Tech" onclick="Tech()" />&nbsp;&nbsp;
    <form action="index11.html">
            <input type="submit" value="About">
        </form>
        </p>
    </div>
        <div class = "searchform" >
            <form class="form-horizontal" action="index2.jsp" method="GET">
                <div class="form-group">
                    <label for="inputCategory" id="NamaKeyword" class="col-sm-2 control-label">Keyword <%=topics.get(CO)%></label>
                    <div class="col-sm-11">
                        <input id="hiddentopic" type="hidden" name="topic" value="<%=topics.get(CO)%>"/>
                        <input type="text" name="keyword" class="form-control"  placeholder="#hiburan">
                    </div>
                </div>
                <!--%List<String> Kategori= topicCategories.get(CO); %-->
                <%Kategori= topicCategories.get(CO); %>
                <% for(int i=0;i<Kategori.size();i++) {%>
                <div class="form-group">
                    <label for="inputCategory" id= "<%= "NamaK" + i%>" class="col-sm-2 control-label" >Kategori <%= Kategori.get(i)%></label>
                    <div class="col-sm-11">
                        <input type="text" name="kategori"class="form-control"  placeholder="TV, Bedak, Mikasa">
                    </div>
                </div>
                <%}%>
                     <input type="hidden" name="mode" class="form-control" value="<%=a%>" >
                <br/>
                <input type="radio" name="group2" value="kmp"> KMP  
                <input type="radio" name="group2" value="bm" checked> BM
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