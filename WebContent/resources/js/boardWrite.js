$(function(){
	$("#fileArea").hide();
	});
function aclick(){
	cnt++;
	alert(cnt);
	if((cnt % 5) === 1)
		{$("#thumbnailImg1").click();} 
		else if((cnt % 5) === 2)
		{$("#thumbnailImg2").click();}
		else if((cnt % 5) === 3)
		{$("#thumbnailImg3").click();}
		else if((cnt % 5) === 4)
		{$("#thumbnailImg4").click();}
		/*else((cnt % 5) === 0)*/
}

function LoadImg(value, num){ // num에 따라 src에 이미지를 집어넣는 작업
	if(value.files && value.files[0]){
		var reader = new FileReader();
							
		reader.onload = function(e){								
			switch(num){
				case 1: 
					$("#contentImg1").attr("src", e.target.result);
				break;
				case 2:
					$("#contentImg2").attr("src", e.target.result);
				break;
				case 3: 
					$("#contentImg3").attr("src", e.target.result);
				break;
				case 4:
					$("#contentImg4").attr("src", e.target.result);
				break;
			}
		}
							
		reader.readAsDataURL(value.files[0]); // 여러 개중 0번째 있는 1개만 집어넣겠다
	}
}
