try {
	var memberNo = location.href.split('?')[1].split('=')[1];
} catch (error) {
	var memberNo = -1;
}
// header.html을 가져와서 붙인다.
if (memberNo > 0) {
	prepareViewForm();
} else {
	prepareNewForm();
}

function prepareViewForm() {
	// 등록 버튼을 감춘다.
	var tags = document.querySelectorAll('.new-form');
  for (var i = 0; i < tags.length; i++) {
    tags[i].style.display = 'none';
  }
	
	get('../header.html', function(result) {
		document.querySelector('#header').innerHTML = result;
	});
	
	// sidebar.html을 가져와서 붙인다.
	get('../sidebar.html', function(result) {
	  document.querySelector('#sidebar').innerHTML = result;
	});
	
	// 학생 목록 가져와서 tr 태그를 만들어 붙인다.
	get('detail.json?memberNo=' + memberNo, function(jsonText) {
	  // result JSON 문자열을 자바스크립트 객체로 만든다.
	  var resultResult = JSON.parse(jsonText);
	  var status = resultResult.status;
	  
	  if (status != "success") {
		  alert(resultResult.data);
		  return;
	  }
	  
	  var student = resultResult.data;
	  console.log(student);
	  document.querySelector('#email').value = student.email;
	  document.querySelector('#name').value = student.name;
	  document.querySelector('#tel').value = student.tel;
	  if (student.working == true) {
	    document.querySelector('#working').checked = 'checked';
	  } else {
	    document.querySelector('#not-working').checked = 'checked';
	  }
	  document.querySelector('#grade').value = student.grade;
	  document.querySelector('#school-name').value = student.schoolName;
	  document.querySelector('#photo').src = "../upload/" + student.photoPath;
	  
	});
	
	// 삭제, 변경 버튼을 클릭했을 때 호출될 함수(클린 이벤트 핸들러) 등록
	document.querySelector('#delele-btn').onclick = function() {
		get('delete.json?memberNo=' + memberNo, function(jsonText) {
			var ajaxResult = JSON.parse(jsonText);
			if (ajaxResult.status != "success") {
				alert(ajaxResult.data);
				return;
			}
			location.href = 'main.html';
		});
	}
	document.querySelector('#update-btn').onclick = function() {
    var param = {
    	memberNo: memberNo,
    	name: document.querySelector('#name').value,
    	email: document.querySelector('#email').value,
    	tel: document.querySelector('#tel').value,
    	password: document.querySelector('#password').value,
    	working: document.querySelector('#working').checked,
    	grade: document.querySelector('#grade').value,
    	schoolName: document.querySelector('#school-name').value
    };
    
    post('update.json', param, function(jsonText) {
    	var ajaxResult = JSON.parse(jsonText);
    	if (ajaxResult.status != "success") {
    		alert(ajaxResult.data);
    		return;
    	}
    	location.href = 'main.html';
    });
  }
	
} // prepareViewForm()

function prepareNewForm() {
	// 변경, 삭제 버튼을 감춘다.
	var tags = document.querySelectorAll('.view-form');
	for (var i = 0; i < tags.length; i++) {
		tags[i].style.display = 'none';
	}
	
	document.querySelector('#add-btn').onclick = function() {
    var param = {
      name: document.querySelector('#name').value,
      email: document.querySelector('#email').value,
      tel: document.querySelector('#tel').value,
      password: document.querySelector('#password').value,
      working: document.querySelector('#working').checked,
      grade: document.querySelector('#grade').value,
      schoolName: document.querySelector('#school-name').value
    };
    
    post('add.json', param, function(jsonText) {
      var ajaxResult = JSON.parse(jsonText);
      if (ajaxResult.status != "success") {
        alert(ajaxResult.data);
        return;
      }
      location.href = 'main.html';
    });
  }
}

// 목록 버튼을 클릭했을 때 호출될 함수(이벤트 핸들러) 등록
document.querySelector('#list-btn').onclick = function() {
	location.href='main.html';
};