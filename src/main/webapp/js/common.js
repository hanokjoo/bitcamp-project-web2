$(function() {
	// header.html을 가져와서 붙인다.
	$.get('../header.html', function(result) {
	  // 서버에서 로그인 사용자 정보를 가져온다.
	  $.getJSON('../auth/loginUser.json', function(ajaxResult) {
	    $('#header').html(result);

	    if (ajaxResult.status == "fail") { // 로그인 되지 않았으면,
	    	// 로그온 상태 출력 창을 감춘다.
	    	$('#logon-div').css('display', 'none');
	    
	    	// 로그인 버튼의 클릭 이벤트 핸들러 등록하기
	    	$('#login-btn').click(function(event) {
	    		event.preventDefault();
	    		location.href = '../auth/main.html';
	    	});
	    	return;
	    }
	    // 로그인 되었으면 로그오프 출력 창을 감춘다.
	    $('#logoff-div').css('display', 'none');
	    $('#logon-div img').attr('src', '../upload/' + ajaxResult.data.photoPath);
	    $('#logon-div span').text(ajaxResult.data.name);
	    
	    // 로그아웃 버튼의 클릭 이벤트 핸들러 등록하기
	    $('#logout-btn').click(function(event) {
	    	event.preventDefault();
	    	$.getJSON('../auth/logout.json', function(ajaxResult) {
	    		location.href = '../auth/main.html';
	    	});
	    });
	  });
	});
	
	// sidebar.html을 가져와서 붙인다.
	$.get('../sidebar.html', function(result) {
	  $('#sidebar').html(result);
	});
	
	//footer.html을 가져와서 붙인다.
	$.get('../footer.html', function(result) {
	  $('#footer').html(result);
	});
});
// main.html에서 이 js를 호출하는 script의 위치가 header, sidebar, footer 가 
// 생기기 전에 호출되게하면 이 js에서 객체를 찾을 수 없어서 내용 출력이 안됨.
// 속도에 따라 되다 안되다 하는 문제가 발생한다.
// window.onload는 모든 html이 다 로딩되고 난 후에 발생하는 이벤트이므로
// 이 때 이 get들을 호출하게 함수를 만들면 문제가 해결된다.
// 그러나 main.html에서 window.onload를 덮어쓰게되면 또 같은 문제가 발생한다.
// 그래서 addEventListener를 사용한다.