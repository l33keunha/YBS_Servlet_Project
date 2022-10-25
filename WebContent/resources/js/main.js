let cnt = 0;
const button = document.getElementById("btn");
function clickCounter(e){
	var btn = $(e).attr('class');
    cnt+=1;
    if((cnt % 2) === 1){
	$(e).parent().siblings('.conHover').addClass('run');
     $(e).parent().siblings('.conHover').children().css("display","block");
    } else{
      $(e).parent().siblings('.conHover').removeClass("run");
      $(e).parent().siblings('.conHover').children().css("display","none");
    }
}

const btn = document.getElementById("mselect");
function importantClick(b){
	var btn = $(b).attr('class');
  cnt+=1;
  if(cnt % 2 === 1){
    $(b).addClass('important')
  } else{
    $(b).removeClass('important')
  }
}

function goBack() {
        window.history.back();
    }