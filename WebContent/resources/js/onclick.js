

function goLocation(e){
	var btn = $(e).attr('class');
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
	}
}

