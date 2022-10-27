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
				break;
				case 2:
					$("#contentImg2").attr("src", e.target.result);
					$("#delImages2").show();
					$("#addImages3").show();
				break;
				case 3: 
					$("#contentImg3").attr("src", e.target.result);
					$("#delImages3").show();
					$("#addImages4").show();
				break;
				case 4:
					$("#contentImg4").attr("src", e.target.result);
					$("#delImages4").show();
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
			$("#contentImg1").attr("src","resources/img/addPic_2.png");
			$("#delImages1").css("display","none");
			$(e).siblings(".thumbIcon").css("display", "none");
			$(e).siblings("input:radio[name=thumbnail]:checked")[0].checked = false;
		break;
		case "delImages2":
			$("#contentImg2").attr("src","resources/img/addPic_2.png");
			$("#delImages2").css("display","none");
			$(e).siblings(".thumbIcon").css("display", "none");
			$(e).siblings("input:radio[name=thumbnail]:checked")[0].checked = false;
		break;
		case "delImages3":
			$("#contentImg3").attr("src","resources/img/addPic_2.png");
			$("#delImages3").css("display","none");
			$(e).siblings(".thumbIcon").css("display", "none");
			$(e).siblings("input:radio[name=thumbnail]:checked")[0].checked = false;
		break;
		case "delImages4":
			$("#contentImg4").attr("src","resources/img/addPic_2.png");
			$("#delImages4").css("display","none");
			$(e).siblings(".thumbIcon").css("display", "none");
			$(e).siblings("input:radio[name=thumbnail]:checked")[0].checked = false;
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
	
	if($(e).siblings("input[type=image]").attr("src")==="resources/img/addPic_2.png"){
			 $(e).siblings("input[name=thumbnail]").attr('onclick','return(false);')
	}
}
//thum 버큰 클릭 이벤트
function switchValue(z){
	var btn = $(z).attr('value');
	var inpt = $("input[name=thumbnail]:checked").attr('value');
	switch(btn){
		case 'Thumb':
			if($("input[type=image]").attr("src") === "resources/img/addPic_2.png"){
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
					$("input[value=thumb4]").siblings(".thumbIcon").css("display", "none");
					
					$("input[value=thumb1]").siblings("input[type=image]").attr('name','test');
					$("input[value=thumb2]").siblings("input[type=image]").removeAttr('name');
					$("input[value=thumb3]").siblings("input[type=image]").removeAttr('name');
					$("input[value=thumb4]").siblings("input[type=image]").removeAttr('name');
				break;
				case 'thumb2':
					$("input[value=thumb2]").siblings(".thumbIcon").css("display", "block");
					$("input[value=thumb1]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb3]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb4]").siblings(".thumbIcon").css("display", "none");
					
					$("input[value=thumb2]").siblings("input[type=image]").attr('name','test');
					$("input[value=thumb1]").siblings("input[type=image]").removeAttr('name');
					$("input[value=thumb3]").siblings("input[type=image]").removeAttr('name');
					$("input[value=thumb4]").siblings("input[type=image]").removeAttr('name');
				break;
				case 'thumb3':
					$("input[value=thumb3]").siblings(".thumbIcon").css("display", "block");
					$("input[value=thumb1]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb2]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb4]").siblings(".thumbIcon").css("display", "none");
					
					$("input[value=thumb3]").siblings("input[type=image]").attr('name','test');
					$("input[value=thumb1]").siblings("input[type=image]").removeAttr('name');
					$("input[value=thumb2]").siblings("input[type=image]").removeAttr('name');
					$("input[value=thumb4]").siblings("input[type=image]").removeAttr('name');
				break;
				case 'thumb4':
					$("input[value=thumb4]").siblings(".thumbIcon").css("display", "block");
					$("input[value=thumb1]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb2]").siblings(".thumbIcon").css("display", "none");
					$("input[value=thumb3]").siblings(".thumbIcon").css("display", "none");
					
					$("input[value=thumb4]").siblings("input[type=image]").attr('name','test');
					$("input[value=thumb1]").siblings("input[type=image]").removeAttr('name');
					$("input[value=thumb2]").siblings("input[type=image]").removeAttr('name');
					$("input[value=thumb3]").siblings("input[type=image]").removeAttr('name');
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