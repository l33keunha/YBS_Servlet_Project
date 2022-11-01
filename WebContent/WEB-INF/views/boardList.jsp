<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <title>INTERNI AND DECO_list</title>
        <script src ="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/commonStyle.css">
        <link rel="stylesheet" type="text/css" href="resources/css/listStyle.css">
        <script src="resources/js/main.js"></script>
        <script src="resources/js/onclick.js"></script>
    </head>
    <body>
        <div class="wrap">
            <div class="mainHeader">
                <h1><a class="header" href="./main.html">INTERNI AND DECO</a></h1>
                <button class="writeBtn" onclick="goLocation(this)"></button>
            </div>
            
	    	<div class="list">
	            <c:set var="i" value="0" />
		        <c:set var="j" value="4" />
		        <c:forEach items="${bList }" var="list">
			        <c:if test="${i%j == 0 }">
			        	<div class="conwrap">
			        </c:if>
			        <div class="table">
				        <div class="tablehead">
				        	<span><input type="hidden" value="${list.bNo }" name="bNo"></span>
					        <span>${status.index}</span>
					        <span>${list.title}</span>
					        <span>${list.writtenDate }</span>
				        </div>
				        <div class="tablePic" onclick="goLocation(this)">
				        	<c:forEach items="${aList }" var = "aList">
				        		<c:if test="${ list.bNo == aList.bNo &&  aList.rename != null }">
				        			<img src="resources/img/contentImg/${aList.rename}" style="width: 268px; height: 157px;"> 
			        			</c:if>
		        				<c:if test="${ list.bNo == aList.bNo && aList.rename == null }">
		        					<img src="resources/img/icons/addPic_2.png" style="width: 268px; height: 157px;">
		        				</c:if>
				        	</c:forEach>
				        	<button class="mselect" id="mselect" onclick="importantClick(this)"></button>
				        </div>
		            </div>
		            <c:if test="${i%j == j-1 }">
			        	</div>
			        </c:if>
			        <c:set var="i" value="${i+1 }" />
		        </c:forEach>
	        </div>

	        
		</div>
    </body>
</html>