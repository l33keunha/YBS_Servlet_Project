

function goLocation(e){
	var btn = $(e).attr('class');
	var str = "OK";
	switch(btn){
		case "goListBtn":
			location.href = "selectBoardList.do?confirmKey="+str;
		break;
	}
}