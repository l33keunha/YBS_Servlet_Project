

function goLocation(e){
	var btn = $(e).attr('class');
	
	switch(btn){
		case "goListBtn":
			location.href = "selectBoardList.do";
		break;
		case "writeBtn":
			location.href = "goBoardWrite.do";
		break;
		case "saveBtn":
			location.href = "insertBoard.do";
		break;
		case "cancleBtn":
			location.href = "selectBoardList.do";
		break;
	}
}

