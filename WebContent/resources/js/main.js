
let cnt = 0;
const button = document.getElementById("btn");
function clickCounter(){
    cnt+=1;
    if(cnt % 2 === 1){
      $("#btn").parents('div').siblings('.conHover').addClass('run')
      $('.del').css("display","block")
      $('.reWrite').css("display","block")
    } else{
      $(".conHover").removeClass("run");
      $('.del').css("display","none")
      $('.reWrite').css("display","none")
    }
}

const btn = document.getElementById("mselect");
function importantClick(){
  cnt+=1;
  if(cnt % 2 === 1){
    $('.mselect').addClass('important')
  } else{
    $('.mselect').removeClass('important')
  }
}