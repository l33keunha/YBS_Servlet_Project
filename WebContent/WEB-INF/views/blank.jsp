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
    </head>
    <body>
        <div class="wrap">
            <div class="mainHeader">
                <h1><a class="header" href="./main.html">INTERNI AND DECO</a></h1>
                <a href="./write.html"><button class="writeBtn"></button></a>
            </div>
            <div class="list">
                <div class="conwrap">
                    <div class="table">
                        <div class="tablehead">
                            <span><%= request.getAttribute("title") %></span>
                            <span>2022.01.01</span>
                        </div>
                        <a href="./reWrite.html">
                            <div class="tablePic">
                                <button class="mselect" id="mselect" onclick="importantClick()"></button>
                            </div>
                        </a>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>