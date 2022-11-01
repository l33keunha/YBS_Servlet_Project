

function goLocation(e){
	var btn = $(e).attr('class');
	var bNo = $(e).prev().children().first().children().val();
	console.log(bNo);
	
	switch(btn){
		case "goListBtn":
			window.location.href = "selectBoardList.do";
		break;
		case "writeBtn":
			window.location.href = "goBoardWrite.do";
		break;
		case "cancleBtn":
			window.location.href = "selectBoardList.do";
		break;
		case "tablePic":
			window.location.href = "selectBoardDetail.do?bNo="+bNo;
		break;
	}
}

