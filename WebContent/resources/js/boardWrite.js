/*처음 파일 열었을때*/
$(function(){
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
	var btn = $(e).attr('value');
	$(e).siblings("input[type=file]").click();
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
	var btn = $(e).attr('value');
			$(e).siblings("input[type=hidden]").attr('value','N');
			$(e).siblings("img").attr("src","resources/img/icons/addPic_2.png");
			$(e).css("display","none");
			$(e).siblings(".thumbIcon").css("display", "none");
			$(e).siblings("input[type=file]").val(""); //file 초기화
			$(e).siblings("input:radio[name=thumbnail]").prop("checked", false);
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
			if(($("input[name=status1]").val() === ("N")) && ($("input[name=status2]").val() === ("N")) && ($("input[name=status3]").val() === ("N")) && ($("input[name=status4]").val() === ("N"))){
					$(z).disabled = true;
				} else(
					$("label").css("display", "block"),
					$(z).disabled = false
					)
			$(".saveBtn").attr("disabled", "disabled");
			$(".cancleBtn").attr("disabled", "disabled");
			
		break;
		
		
		case 'Confirm':
			$("label").css("display", "none");
			$("#thumb").attr('value','Thumb');
			$(".saveBtn").attr("disabled",false);
			$(".cancleBtn").attr("disabled", false);
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
	let cnt = 0;
	const button = $("input[value=Thumb]");
    $('.saveBtn').click(function() {
		if($("#title").val().length==0 && $("#comment").val().length!=0)
			{ alert("제목을 입력하세요."); $("#title").focus(); return false; }
		else if($("#title").val().length!=0 && $("#comment").val().length==0)
			{ alert("내용을 입력하세요."); $("#comment").focus(); return false; }
		else if($("#comment").val().length==0 && $("#title").val().length==0)
			{ alert("제목과 내용을 입력하세요."); $("#title").focus(); return false; }
			
		if(($("input[name=status1]").val() === ("N")) && ($("input[name=status2]").val() === ("N")) && ($("input[name=status3]").val() === ("N")) && ($("input[name=status4]").val() === ("N")))
			{alert("이미지를 넣어주세요."); return false;}
		else if(($("input[name=status1]").val() !== ("Y")) && ($("input[name=status2]").val() !== ("Y")) && ($("input[name=status3]").val() !== ("Y")) && ($("input[name=status4]").val() !== ("Y")))
			{alert("썸네일 이미지를 넣어주세요."); return false;}
	})
});