<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <title>INTERNI AND DECO</title>
        <script src ="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/commonStyle.css">
        <link rel="stylesheet" type="text/css" href="resources/css/mainetyle.css">
        <script src="resources/js/main.js"></script>
        <script src="resources/js/onclick.js"></script>
    </head>
    <body>
        <div class="wrap">
            <div class="mainHeader">
                <h1>INTERNI AND DECO</h1>
                <p>Ian will bring damaging winds and threats of flooding to inland Florida overnight, 
                    hours after making landfall in southwest Florida before weakening to a still dangerous Category 
                    1 storm. The storm’s intensity at landfall was Category 4, 
                    tied for the fifth-strongest hurricane on record to strike the United States.
                </p>
            </div>

            <div class="goList">
                <button class="goListBtn" onclick="goLocation(this)"></button>
            </div>
            
            <div id="slider-wrapper">
                <div class="overflow-wrapper">
                    <a href="./reWrite.html">
                        <div class="con" id="con1">
                            <div class="pic">
                                <button class="conBtn" id="btn" onclick="clickCounter()"></button>
                            </div>
                            <div class="title">
                                <h1>blablablabla</h1>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. 
                                    Inventore deserunt voluptates veritatis maxime est expedita doloremque. 
                                    Nulla harum molestiae sint natus dolore aut, iste perspiciatis. Odit id minima sapiente impedit.</p>
                            </div>
                            <div class="date">
                                <span>2022.09.29 Gura Lee</span>
                            </div>
                            <div class="conHover" style="background:#45454593;">
                                <button class="reWrite"></button>
                                <button class="del"></button>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </body>
</html>