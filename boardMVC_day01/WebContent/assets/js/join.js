// 주소 찾기(Daum API)
function find() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; // 주소 변수
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addressDetail").focus();
        }
    }).open();
}

// 이용 약관
const $all = $("#term");
const $inputs = $(".terms");

$all.on('click', function(){
    if($(this).is(":checked")){
        $inputs.prop('checked', true);
    }else{
        $inputs.prop('checked', false);
    }
})

$inputs.on('click', function(){
    var check = true;
    if(!$(this).is(":checked")){
        $all.prop('checked', false);
    }

    if($inputs.filter(":checked").length == 2){
        $all.prop('checked', true);
    }
});

// 약관 펼쳐보기
const aTags = $("a.showTerm");
const textAreas = $("textArea.term-content");
aTags.on('click', function(e){
	e.preventDefault();
	
	if($(this).attr("href") == "term1-content"){
		$("#term1-content").slideToggle(function(){
			
		});
		
//		if($(textAreas[0]).css("display") == "none"){
//			$("#term1-content").slideDown();
//			$(this).text("닫기");
//			
//		}else{
//			$("#term1-content").slideUp();
//			$(this).text("펼쳐보기");
//		}
	}else if($(this).attr("href") == "term2-content"){
		$("#term2-content").slideToggle(function(){
			
		});
//		if($(textAreas[1]).css("display") == "none"){
//			$("#term2-content").slideDown();
//			$(this).text("닫기");
//			
//		}else{
//			$("#term2-content").slideUp();
//			$(this).text("펼쳐보기");
//		}
	}
});












