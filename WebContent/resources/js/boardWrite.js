/*처음 파일 열었을때*/
$(function(){
	$("#fileArea").hide();
	
	$("#addImages2").hide();
	$("#addImages3").hide();
	$("#addImages4").hide();
	
	$("#delImages1").hide();
	$("#delImages2").hide();
	$("#delImages3").hide();
	$("#delImages4").hide();
	
	
	});
	
/*add file 버튼 클릭할때*/	
function addClick(e){
	var btn = $(e).attr('class');
	switch(btn){
		case "addImages1":
			$("#thumbnailImg1").click();
		break;
		case "addImages2":
			$("#thumbnailImg2").click();
		break;
		case "addImages3":
			$("#thumbnailImg3").click();
		break;
		case "addImages4":
			$("#thumbnailImg4").click();
		break;
	}
}

/*첨부파일 이미지 띄우기*/
function LoadImg(value, num){ // num에 따라 src에 이미지를 집어넣는 작업
	if(value.files && value.files[0]){
		var reader = new FileReader();
							
		reader.onload = function(e){								
			switch(num){
				case 1: 
					$("#contentImg1").attr("src", e.target.result);
					$("#delImages1").show();
					$("#addImages2").show();
					$("#contentImg1").siblings("input[type=hidden]").attr('value','O');
				break;
				case 2:
					$("#contentImg2").attr("src", e.target.result);
					$("#delImages2").show();
					$("#addImages3").show();
					$("#contentImg2").siblings("input[type=hidden]").attr('value','O');
				break;
				case 3: 
					$("#contentImg3").attr("src", e.target.result);
					$("#delImages3").show();
					$("#addImages4").show();
					$("#contentImg3").siblings("input[type=hidden]").attr('value','O');
				break;
				case 4:
					$("#contentImg4").attr("src", e.target.result);
					$("#delImages4").show();
					$("#contentImg4").siblings("input[type=hidden]").attr('value','O');
				break;
			}
		}
							
		reader.readAsDataURL(value.files[0]); // 여러 개중 0번째 있는 1개만 집어넣겠다
	}
}
/*Delet file 버튼 클릭시*/
function delclick(e){
	var btn = $(e).attr('class');
	switch(btn){
		case "delImages1":
			$(e).siblings("input[type=hidden]").attr('value','N');
			$("#thumbnailImg1").val("");
			$("#contentImg1").attr("src","resources/img/icons/addPic_2.png");
			$("#delImages1").css("display","none");
			$(e).siblings(".thumbIcon").css("display", "none");
			$(e).siblings("input:radio[name=thumbnail]:checked").attr("checked", false);
		break;
		case "delImages2":
			$(e).siblings("input[type=hidden]").attr('value','N');
			$("#thumbnailImg2").val("");
			$("#contentImg2").attr("src","resources/img/icons/addPic_2.png");
			$("#delImages2").css("display","none");
			$(e).siblings(".thumbIcon").css("display", "none");
			$(e).siblings("input:radio[name=thumbnail]:checked").attr("checked", false);
		break;
		case "delImages3":
			$(e).siblings("input[type=hidden]").attr('value','N');
			$("#thumbnailImg3").val("");
			$("#contentImg3").attr("src","resources/img/icons/addPic_2.png");
			$("#delImages3").css("display","none");
			$(e).siblings(".thumbIcon").css("display", "none");
			$(e).siblings("input:radio[name=thumbnail]:checked").attr("checked", false);
		break;
		case "delImages4":
			$(e).siblings("input[type=hidden]").attr('value','N');
			$("#thumbnailImg4").val("");
			$("#contentImg4").attr("src","resources/img/icons/addPic_2.png");
			$("#delImages4").css("display","none");
			$(e).siblings(".thumbIcon").css("display", "none");
			$(e).siblings("input:radio[name=thumbnail]:checked").attr("checked", false);
		break;
	}
}

// 라디오 lavel 썸 체크

function thumbClick(e){
	var btn = $(e).attr('for');
	if($("input[name=thumbnail]:checked")){
		$("#thumb").attr('value','Confirm')
	} else(
		$("#thumb").attr('value','Thumb')
	)
	
	if($(e).siblings("img").attr("src")==="resources/img/icons/addPic_2.png"){
			 $(e).siblings("input[name=thumbnail]").attr('onclick','return(false);')
	}
}
//thum 버큰 클릭 이벤트
function switchValue(z){
	var btn = $(z).attr('value');
	var inpt = $("input[name=thumbnail]:checked").attr('value');
	var hidden1 =$("input[value=thumb1]").siblings("input[type=hidden]");
	var hidden2 =$("input[value=thumb2]").siblings("input[type=hidden]");
	var hidden3 =$("input[value=thumb3]").siblings("input[type=hidden]");
	var hidden4 =$("input[value=thumb4]").siblings("input[type=hidden]");
	
	switch(btn){
		case 'Thumb':
			if($("img").attr("src") === "resources/img/icons/addPic_2.png"){
		$(z).disabled = true;
	} else(
			$("label").css("display", "block"),
			$(z).disabled = false
			)
		break;
		
		
		case 'Confirm':
			$("label").css("display", "none");
			$("#thumb").attr('value','Thumb');
			switch(inpt){
				case 'thumb1':
					$("input[value=thumb1]").siblings(".thumbIcon").css("display", "block");
					$("input[value=thumb2]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb3]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb4]").siblings(".thumbIcon").css("display", "none"); /*confim 눌렀을 때 그림에 썸네일 표시하기*/
					
					/*confim 눌렀을 때 input type hidden에 y 값 주기*/
					hidden1.attr('value','Y');
					/*썸네일 재설정 할 때 input type hidden에 N 이나 O 값 주기*/
					if($("input[value=thumb2]").siblings("img").attr("src") === "resources/img/icons/addPic_2.png"){
						hidden2.attr('value','N');
					} else(hidden2.attr('value','O'))
					
					if($("input[value=thumb3]").siblings("img").attr("src") === "resources/img/icons/addPic_2.png"){
						hidden3.attr('value','N');
					} else(hidden3.attr('value','O'))
					
					if($("input[value=thumb4]").siblings("img").attr("src") === "resources/img/icons/addPic_2.png"){
						hidden4.attr('value','N');
					} else(hidden4.attr('value','O'))
				break;
				case 'thumb2':
					$("input[value=thumb2]").siblings(".thumbIcon").css("display", "block");
					$("input[value=thumb1]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb3]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb4]").siblings(".thumbIcon").css("display", "none"); /*confim 눌렀을 때 그림에 썸네일 표시하기*/
					
					/*confim 눌렀을 때 input type hidden에 y 값 주기*/
					hidden2.attr('value','Y');
					/*썸네일 재설정 할 때 input type hidden에 N 이나 O 값 주기*/
					if($("input[value=thumb1]").siblings("img").attr("src") === "resources/img/icons/addPic_2.png"){
						hidden1.attr('value','N');
					} else(hidden1.attr('value','O'))
					
					if($("input[value=thumb3]").siblings("img").attr("src") === "resources/img/icons/addPic_2.png"){
						hidden3.attr('value','N');
					} else(hidden3.attr('value','O'))
					
					if($("input[value=thumb4]").siblings("img").attr("src") === "resources/img/icons/addPic_2.png"){
						hidden4.attr('value','N');
					} else(hidden4.attr('value','O'))
				break;
				case 'thumb3':
					$("input[value=thumb3]").siblings(".thumbIcon").css("display", "block");
					$("input[value=thumb1]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb2]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb4]").siblings(".thumbIcon").css("display", "none"); /*confim 눌렀을 때 그림에 썸네일 표시하기*/
					
					/*confim 눌렀을 때 input type hidden에 y 값 주기*/
					hidden3.attr('value','Y');
					/*썸네일 재설정 할 때 input type hidden에 N 이나 O 값 주기*/
					if($("input[value=thumb2]").siblings("img").attr("src") === "resources/img/icons/addPic_2.png"){
						hidden2.attr('value','N');
					} else(hidden2.attr('value','O'))
					
					if($("input[value=thumb1]").siblings("img").attr("src") === "resources/img/icons/addPic_2.png"){
						hidden1.attr('value','N');
					} else(hidden1.attr('value','O'))
					
					if($("input[value=thumb4]").siblings("img").attr("src") === "resources/img/icons/addPic_2.png"){
						hidden4.attr('value','N');
					} else(hidden4.attr('value','O'))
				break;
				case 'thumb4':
					$("input[value=thumb4]").siblings(".thumbIcon").css("display", "block");
					$("input[value=thumb1]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb2]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb3]").siblings(".thumbIcon").css("display", "none"); /*confim 눌렀을 때 그림에 썸네일 표시하기*/
					
					/*confim 눌렀을 때 input type hidden에 y 값 주기*/
					hidden4.attr('value','Y');
					/*썸네일 재설정 할 때 input type hidden에 N 이나 O 값 주기*/
					if($("input[value=thumb2]").siblings("img").attr("src") === "resources/img/icons/addPic_2.png"){
						hidden2.attr('value','N');
					} else(hidden2.attr('value','O'))
					
					if($("input[value=thumb3]").siblings("img").attr("src") === "resources/img/icons/addPic_2.png"){
						hidden3.attr('value','N');
					} else(hidden3.attr('value','O'))
					
					if($("input[value=thumb1]").siblings("img").attr("src") === "resources/img/icons/addPic_2.png"){
						hidden1.attr('value','N');
					} else(hidden1.attr('value','O'))
				break;
				
			}
			
		break;
	}
	
	

}

/* 빈칸 알람 띄우기*/
$( document ).ready(function() {
    $('.saveBtn').click(function() {
		if($("#title").val().length==0 && $("#comment").val().length!=0)
			{ alert("제목을 입력하세요."); $("#title").focus(); return false; }
		else if($("#title").val().length!=0 && $("#comment").val().length==0)
			{ alert("내용을 입력하세요."); $("#comment").focus(); return false; }
		else if($("#comment").val().length==0 && $("#title").val().length==0)
			{ alert("제목과 내용을 입력하세요."); $("#title").focus(); return false; }
	})
});