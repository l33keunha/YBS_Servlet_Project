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
	                	<input type="text" name="title" id="title">
						<input type="button" class="thumb" id="thumb" value="Thumb" onclick="switchValue(this)">
	                    <button type="button" class="cancleBtn" onclick="goLocation(this)">Cancle</button>
	                    <button type="submit" class="saveBtn">Save</button>
                   </div>
                   
                   <div class="writeconWrap">                   
                       <div class="left">
                           <div>
                              <div class="thumbIcon"></div>
                              <input type="radio" id="check1" name="thumbnail" value="thumb1"><label for="check1" onclick="thumbClick(this)"></label>
                              <img id="contentImg1" src="resources/img/icons/addPic_2.png">
                              <input type="button" class="addImages" id="addImages1" value="Add file" onclick="addClick(this)">
                              <input type="button" class="delImages" id="delImages1" value="Delet file" onclick="delclick(this)">
                              <input type="file" id="thumbnailImg1" multiple="multiple" name="thumbnailImg1" onchange="LoadImg(this,1)">
                              <input type="hidden" name="status1" value="N">
                           </div>
                           <div>
                              <div class="thumbIcon"></div>
                              <input type="radio" id="check2" name="thumbnail" value="thumb2"><label for="check2" onclick="thumbClick(this)"></label>
                              <img id="contentImg2" src="resources/img/icons/addPic_2.png">
                              <input type="button" class="addImages" id="addImages2" value="Add file" onclick="addClick(this)">
                              <input type="button" class="delImages" id="delImages2" value="Delet file" onclick="delclick(this)">
                               <input type="file" id="thumbnailImg2" multiple="multiple" name="thumbnailImg2" onchange="LoadImg(this,2)">
                              <input type="hidden" name="status2" value="N">
                           </div>
                           <div>
                              <div class="thumbIcon"></div>
                              <input type="radio" id="check3" name="thumbnail" value="thumb3"><label for="check3" onclick="thumbClick(this)"></label>
                              <img id="contentImg3" src="resources/img/icons/addPic_2.png">
                              <input type="button" class="addImages" id="addImages3" value="Add file" onclick="addClick(this)">
                              <input type="button" class="delImages" id="delImages3" value="Delet file" onclick="delclick(this)">
                              <input type="file" id="thumbnailImg3" multiple="multiple" name="thumbnailImg3" onchange="LoadImg(this,3)">
                              <input type="hidden" name="status3" value="N">
                           </div>
                           <div>
                              <div class="thumbIcon"></div>
                              <input type="radio" id="check4" name="thumbnail" value="thumb4"><label for="check4" onclick="thumbClick(this)"></label>
                              <img id="contentImg4" src="resources/img/icons/addPic_2.png">
                              <input type="button" class="addImages" id="addImages4" value="Add file" onclick="addClick(this)">
                              <input type="button" class="delImages" id="delImages4" value="Delet file" onclick="delclick(this)">
                              <input type="file" id="thumbnailImg4" multiple="multiple" name="thumbnailImg4" onchange="LoadImg(this,4)">
                              <input type="hidden" name="status4" value="N">
                           </div>           
                       </div>
                       
                       <div class="right">
                           <textarea name="content" id="comment" placeholder="문구입력..."></textarea>
                       </div>        
                   </div>              
               </div>               
            </form>
         
        </div>
    </body>
</html>