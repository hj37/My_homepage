<%@page import="org.jsoup.nodes.Element"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="java.io.IOException"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset= UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		Document doc = Jsoup.connect("https://www.koreabaseball.com/TeamRank/TeamRank.aspx").get();

		Elements elements = doc.select("table.tData");
		
		Element element = elements.get(0);
		
		Elements lis1 = element.select("th");
		Elements lis2 = element.select("tbody");

%>
	
<% 
		for(Element e : lis1){
%>
<% 
		out.print("<th>" + e.select("th").get(0).text() + "</th>");

		}
%>
		
<% 
		for(Element e : lis2){
			for(int i = 0 ; i < 120; i++){
				if(i % 12 == 0){
					out.print("<br><tr>");
				}
				out.print(e.select("td").get(i).text() + "\t");
				if(i % 12 == 0){
					out.print("<br></tr>");
				}
			
			}
		}
		
		

%>
</body>
</html>