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
        <link rel="stylesheet" type="text/css" href="resources/css/reWriteStyle.css">
        <script src="resources/js/main.js"></script>
        <script src="resources/js/boardDetail.js"></script>
    </head>
    <body>
        <div class="wrap">
            <div class="mainHeader">
                <h1>INTERNI AND DECO</h1>
                <button class="goListBtn"></button>
            </div>
            <div class="writeWrap">
                <div class="top">
                    <p>${bVO.title}</p>
                    <button class="delet"></button>
                    <button class="reWrite"></button>
                    
                </div>
                <div class="writeconWrap">
                    <div class="left">
                    	<div class="slider">
							<div class="slide_viewer">
							    <div class="slide_group">
							    	<c:forEach items="${aList}" var = "aList">
							    		<c:if test="${ bVO.bNo == aList.bNo &&  aList.rename != null }">
							    			<div class="slide" style="background:url(resources/img/contentImg/${aList.rename}); background-size: cover;"></div>
							    		</c:if>
							    		
							    		<c:if test="${ bVO.bNo == aList.bNo &&  aList.rename == null }">
							    			<div class="slide" style="background:url(resources/img/icons/addPic_2.png); background-size: cover;"></div>
							    		</c:if>
									</c:forEach>
								</div>
							</div>
						</div><!-- End // .slider -->
						
						<div class="slide_buttons"></div>
                    </div>
                    
                    <div class="right">
                        <p>${bVO.content}</p>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>