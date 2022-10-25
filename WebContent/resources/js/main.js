var cnt = 0;
var button = document.getElementById("btn");
function clickCounter(a){
	var btn = $(a).attr('class');
    cnt+=1;
    if((cnt % 2) === 1){
	$(e).parent().siblings('.conHover').addClass('run');
     $(e).parent().siblings('.conHover').children().css("display","block");
    } else{
      $(e).parent().siblings('.conHover').removeClass("run");
      $(e).parent().siblings('.conHover').children().css("display","none");
    }
}

var btn = document.getElementById("mselect");
function importantClick(b){
	var btn = $(b).attr('class');
  cnt+=1;
  if(cnt % 2 === 1){
    $(b).addClass('important')
  } else{
    $(b).removeClass('important')
  }
}

