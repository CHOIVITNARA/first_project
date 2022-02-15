/**
 * 작성자: 최빛나라
 */
 
$(function(){
	var container = $('.container'),
		slideGroup = container.find('.slides'),
		slides = slideGroup.find('li'),
		nav = container.find('.img-con'),
		indicator=container.find('.indicator'),
		slideCount = slides.length,
		currentIndex = 0, //현재위
		indicatorHtml='',
		duration = 500, //움직이는시간
		easing = 'easeInOutExpo', //제이쿼리??뭐?
		interval = 6000, //일정시간마다 멈추는 
		timer = undefined; //마우스가 올라가면 멈추는 
		
	//슬라이드를 가로로 배열
	//slides마다 할 일, 0%, 100%, 200%...
	
	slides.each(function(i){
		var newLeft = i * 100 + '%';
		$(this).css({left: newLeft});
		
		//var i=2; i = i+2; i +=2
		indicatorHtml += (i+1)
		console.log(indicatorHtml);
	});	
	
	//A.text(B); a요소의 내용을 글씨 형태로 추가 ex)<p>내용<p>
	//A.html(B); a요소의 b의 내용을 html 형태로 추가 ex)(위와 동일할 경우) 내용
	indicator.text(indicatorHtml);
	
	//슬라이드 이동 함수
	function goToSlide(index){
		// i 0 left: 0%, i 1 left:-100%
		slideGroup.animate({left:-100*index+'%'}, duration);
		currentIndex = index;
		
		updateNav();//처음인지 마지막인지 검사
		
		//자동 슬라이드 함수
		function startTimer(){
			//일정시간 마다 할일
			//setInterval(할일, 시간), clearInterval(이름)
			//할일(함수) function(){실제로 할일}
			if(!timer){
				timer = setInterval(function(){
					//nextIndex c0 ,c1, c2,  ... c3 n0
					var nextIndex = (currentIndex + 1) % slideCount;
					goToSlide(nextIndex);
				}, interval);
			}
		}
		startTimer();
		
		function stopTimer(){
			clearInterval(timer);
			timer=undefined;
		}
		
		//마우스가 올라가면 멈추고 나가면 다시 시작
		container.mouseenter(function(){
			stopTimer();
		})
		.mouseleave(function(){
			startTimer();
		});
	}
	//버튼클릭으로 이동, 정지
	function updateNav(){
		var navPrev = nav.find('.prev');
		var navNext = nav.find('.next');
		//처음 currentIndex 0, 이전버튼이 안보이도록
		if(currentIndex == 0){
			navPrev.addClass('disabled');
		}else{
			navPrev.removeClass('disabled');
		}
		//마지막 currentIndex 3, 다음버튼이 안보이도록
		if(currentIndex == slideCount-1){
			navNext.addClass('disabled');
		}else{
			navNext.removeClass('disabled');
		}
	}
	
	//인디케이터로 이동하기
	indicator.find('a').click(function(){
		e.preventDefault();
		var idx= $(this).index();
		//console.log(idx);
		goToSlide(idx);
	});
	//좌우버튼으로 이동하기
	//다음 버튼 클릭 c+1->goToSlide(?);
	//이전         c-1->goToSlide(?);
	nav.find('a').click(function(e){
		e.preventDefault();
		if($(this).hasClass('prev')){
			goToSlide(currentIndex-1);
		}else{
			goToSlide(currentIndex+1);
		}
	});
});