let cnt = 0;
const button = document.getElementById("btn");
function clickCounter(a){
	var btn = $(a).attr('class');
    cnt+=1;
    if((cnt % 2) === 1){
	$(a).parent().siblings('.conHover').addClass('run');
     $(a).parent().siblings('.conHover').children().css("display","block");
    } else{
      $(a).parent().siblings('.conHover').removeClass("run");
      $(a).parent().siblings('.conHover').children().css("display","none");
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

