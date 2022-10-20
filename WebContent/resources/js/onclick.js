

function goLocation(e){
	var btn = $(e).attr('class');
	
	switch(btn){
		case "goListBtn":
			location.href = "selectBoardList.do";
		break;
		case "writeBtn":
			location.href = "goBoardWrite.do";
		break;
	}
}