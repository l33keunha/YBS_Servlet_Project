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
    </head>
    <body>
        <div class="wrap">
            <div class="mainHeader">
                <h1>INTERNI AND DECO</h1>
            </div>
                       
			<form action="insertBoard.do" encType="UTF-8"  method="post">			
	            <div class="writeWrap">	            
	                <div class="top">
	                	<input type="text" name="title" >
	                	
	                    <button>Cancle</button>
	                    <button type="submit" value="save">Save</button>	                    	                    
	                </div>
	                
	                <div class="writeconWrap">	                
	                    <div class="left">	                    
	                        <input type="image" name="button" src="resources/img/addPic_2.png">
	                        <button>Add file</button>	                        
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