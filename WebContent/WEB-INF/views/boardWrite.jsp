<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8">
        <title>INTERNI AND DECO_list</title>
        <script src ="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/commonStyle.css">
        <link rel="stylesheet" type="text/css" href="resources/css/writeStyle.css">
        <script src="resources/js/main.js"></script>
        <script src="resources/js/onclick.js"></script>
        <script src="resources/js/boardWrite.js"></script>
    </head>
    <body>
        <div class="wrap">
            <div class="mainHeader">
                <h1>INTERNI AND DECO</h1>
            </div>
                       
			<form action="insertBoard.do" method="post" enctype="multipart/form-data">			
	            <div class="writeWrap">	            
	                <div class="top">
	                	<input type="text" name="title" >
	                	

	                    <button type="button" class="cancleBtn" onclick="goLocation(this)">Cancle</button>
	                    <button type="submit" class="saveBtn" >Save</button>
	                    	                    

	                </div>
	                
	                <div class="writeconWrap">	                
	                    <div class="left">	                    
	                        <!-- <input type="image" name="button" src="resources/img/addPic_2.png"> -->
	                        <img id="contentImg1" width="120" height="100">
	                        <img id="contentImg2" width="120" height="100">
	                        <img id="contentImg3" width="120" height="100">
	                        <img id="contentImg4" width="120" height="100">
	                        <input type="button" class="addImages" id="addImages" value="Add file" onclick="aclick()">Add file                       
	                    </div>
	                    
	                    <div class="right">
	                        <textarea name="content" id="comment" placeholder="문구입력..."></textarea>
	                    </div>        
	                </div>
	                <div id="fileArea">
						<input type="file" id="thumbnailImg1" multiple="multiple" name="thumbnailImg1" onchange="LoadImg(this,1)">
						<input type="file" id="thumbnailImg2" multiple="multiple" name="thumbnailImg2" onchange="LoadImg(this,2)">
						<input type="file" id="thumbnailImg3" multiple="multiple" name="thumbnailImg3" onchange="LoadImg(this,3)">
						<input type="file" id="thumbnailImg4" multiple="multiple" name="thumbnailImg4" onchange="LoadImg(this,4)">
					</div> 	                
	            </div>	            
            </form>
			
        </div>
    </body>
</html>