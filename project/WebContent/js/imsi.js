function wordOpen(){
    var wordList = $('.wordList');
    var wordWrap = wordList.find('.wordWrap');
    var wordPop = wordList.find('.layerPop');
    var wordOpen = wordList.find('.popOpen');
    var wordClose = wordList.find('.popClose');

    wordOpen.hide();
    wordWrap.animate({
		width:'690px',
		height: '445px'
    });
    wordPop.fadeIn('slow');


    //팝업초기화
    wordWrap.find('.words >li').first().addClass('on');
    wordPop.find('.imgTxt_en').html('Brazil');
    wordPop.find('.imgTxt_ko').html('브라질');
}

function wordClose(){
    var wordList = $('.wordList');
    var wordWrap = wordList.find('.wordWrap');
    var wordPop = wordList.find('.layerPop');
    var wordOpen = wordList.find('.popOpen');
    var wordClose = wordList.find('.popClose');

    wordOpen.fadeIn(500);
    wordWrap.animate({
        width:'220px',
        height: '375px'
    });
    wordPop.fadeOut();
    wordWrap.find('.on').removeClass('on');
}

$('.wordList .popOpen').click(function(){
    wordOpen();
    var wordList = $(this).parents('.wordList').find('.words li');


})

$('.wordList .popClose').click(function(){
    wordClose();
})

$('.words li').click(function(){

    var en_txt = $(this).html();
    var ko_txt = $(this).attr('data-ko');
    var imgnum = $(this).index() +1;
    var wordImg ='images/common/lesson_cover/word/word'+imgnum+'.png'
    var wordPop = $('.wordPop');


    if($('.wordPop').css('display') != 'none'){
        $(this).siblings('li').removeClass('on');
        $(this).addClass('on');

        $('.wordPop').find('.imgTxt_en').html(en_txt);
        $('.wordPop').find('.imgTxt_ko').html(ko_txt);
        $('.wordPop').find('.imgView img').attr('src',wordImg)
    }



})


//9페이지

var canBox = $('.icanWrap .can_mid > .icanBox');

canBox.find('.can_title').click(function(){
  $('div.yesi').next().hide();
  $('div.yesi').text('예시 보기');

  $('.boxWrap p.ply').removeClass('on');
    var box = $(this).parent('.icanBox');

    var otherBox = box.siblings('.icanBox');
    var openBox = box.find('.can_txt');

    otherBox.find('.can_title').show('slow');
    otherBox.find('.can_txt').slideUp('slow');

    $(this).hide('slow');
    openBox.slideDown('slow');

});


var canInner = $('.icanWrap .can_mid .icanBox > .can_txt');

canInner.find('.planArea').click(function(){

  $('div.yesi').next().hide();
  $('div.yesi').text('예시 보기');

  var hideBox = $(this).parent();

  var showBox = $(this).parents().find('.can_title');

  hideBox.hide('slow');
  showBox.slideDown('slow');

});


/*selfChekc2 Audio*/

var sc2Ado = $('#sChk2_ado');
$('.boxWrap p.ply').click(function(){
  if($(this).hasClass('on')) return false;
  $('.boxWrap p.ply').removeClass('on');
  var mpAtt = $(this).attr('self2-ado');
  sc2Ado.attr('src', mpAtt);
  sc2Ado[0].play();
  $(this).addClass('on');

  sc2Ado[0].onended= function(){
    $(this).parent().find('.ply').removeClass('on');
  }
})

/* OOO click */

$('.chkBox1 ul li').click(function(){
    var chkLeng =$(this).index();
    var liLeng = $('.chkBox1chkBox1 ul li').length;
    var chkItem = $('.chkBox1 ul li');

    $('.chkBox1 ul li').each(function(i){
        if(i > chkLeng) $(this).removeClass('on');
        else $(this).addClass('on');
    });
})

$('.chkBox2 ul li').click(function(){
    var chkLeng =$(this).index();
    var liLeng = $('.chkBox2 ul li').length;
    var chkItem = $('.chkBox2 ul li');

    $('.chkBox2 ul li').each(function(i){
        if(i > chkLeng) $(this).removeClass('on');
        else $(this).addClass('on');
    });
})

$('.chkBox3 ul li').click(function(){
    var chkLeng =$(this).index();
    var liLeng = $('.chkBox3 ul li').length;
    var chkItem = $('.chkBox3 ul li');

    $('.chkBox3 ul li').each(function(i){
        if(i > chkLeng) $(this).removeClass('on');
        else $(this).addClass('on');
    });
})


/*yesi*/

var yesiSec = $('.icanWrap .can_mid .icanBox > .can_txt');

yesiSec.find('div.yesi').click(function(){
  var thisInner = $(this).next();
  var ts = $(this);
  // console.log(ts);

  if(thisInner.is(':hidden')){
    thisInner.show();
    ts.text('예시 닫기');
  }else{
    thisInner.hide();
    ts.text('예시 보기');
  }
})
