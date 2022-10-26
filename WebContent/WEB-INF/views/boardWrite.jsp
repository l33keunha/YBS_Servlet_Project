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
	                	
						<input type="button" class="thumb" id="thumb" value="Thumb" onclick="switchValue(this)">
	                    <button type="button" class="cancleBtn" onclick="goLocation(this)">Cancle</button>
	                    <button type="submit" class="saveBtn" onclick="save()">Save</button>
	                    	                    

	                </div>
	                
	                <div class="writeconWrap">	                
	                    <div class="left">	                    
	                        <!-- <input type="image" name="button" src="resources/img/addPic_2.png"> -->
	                        <div>
	                        	<div class="thumbIcon"></div>
	                        	<input type="radio" id="check1" name="thumbnail" value="thumb1"><label for="check1" onclick="thumbClick(this)"></label>
		                        <img id="contentImg1" src="resources/img/addPic_2.png">
		                        <input type="button" class="addImages1" id="addImages1" value="Add file" onclick="addClick(this)">
		                        <input type="button" class="delImages1" id="delImages1" value="Delet file" onclick="delclick(this)">
	                        </div>
	                        <div>
	                        	<div class="thumbIcon"></div>
	                        	<input type="radio" id="check2" name="thumbnail" value="thumb2"><label for="check2" onclick="thumbClick(this)"></label>
		                        <img id="contentImg2" src="resources/img/addPic_2.png">
		                        <input type="button" class="addImages2" id="addImages2" value="Add file" onclick="addClick(this)">
		                        <input type="button" class="delImages2" id="delImages2" value="Delet file" onclick="delclick(this)">
	                        </div>
	                        <div>
	                        	<div class="thumbIcon"></div>
	                        	<input type="radio" id="check3" name="thumbnail" value="thumb3"><label for="check3" onclick="thumbClick(this)"></label>
		                        <img id="contentImg3" src="resources/img/addPic_2.png">
		                        <input type="button" class="addImages3" id="addImages3" value="Add file" onclick="addClick(this)">
		                        <input type="button" class="delImages3" id="delImages3" value="Delet file" onclick="delclick(this)">
	                        </div>
	                        <div>
	                        	<div class="thumbIcon"></div>
	                        	<input type="radio" id="check4" name="thumbnail" value="thumb4"><label for="check4" onclick="thumbClick(this)"></label>
		                        <img id="contentImg4" src="resources/img/addPic_2.png">
		                        <input type="button" class="addImages4" id="addImages4" value="Add file" onclick="addClick(this)">
		                        <input type="button" class="delImages4" id="delImages4" value="Delet file" onclick="delclick(this)">
	                        </div>
	                        <!-- <input type="button" class="addImages" id="addImages" value="Add file" onclick="aclick()"> -->                    
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