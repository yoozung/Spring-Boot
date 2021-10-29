/* 유효성 검사 ajax 출력 */
var code = "";				//이메일전송 인증번호 저장위한 코드
 /* 유효성 검사 통과유무 변수 */
 var idCheck = false;			// 아이디
 var idckCheck = false;			// 아이디 중복 검사
 var pwCheck = false;			// 비번
 var pwckCheck = false;			// 비번 확인
 var pwckcorCheck = false;		// 비번 확인 일치 확인
 var nameCheck = false;
 var mobileCheck = false;
 var mailCheck = false;			// 이메일
 
$(document).ready(function(){
	//회원가입 버튼(회원가입 기능 작동)
	$(".join_button").click(function(){
		
		/* 입력값 변수 */
		var id = $('.id_input').val(); 				// id 입력란
		var pw = $('.pw_input').val();				// 비밀번호 입력란
		var pwck = $('.pwck_input').val();			// 비밀번호 확인 입력란
		var name = $('.user_input').val();			// 이름 입력란
		var mobile = $('.mobile_input').val();
		var mail = $('.mail_input').val();			// 이메일 입력란
		
		/* 아이디 유효성검사 */
		if(id == ""){
			$('.final_id_ck').css('display','block');
			idCheck = false;
		}else{
			$('.final_id_ck').css('display', 'none');
			idCheck = true;
		}
		
		/* 비밀번호 유효성 검사 */
		if(pw == ""){
			$('.final_pw_ck').css('display','block');
			pwCheck = false;
		}else{
			$('.final_pw_ck').css('display', 'none');
			pwCheck = true;
		}
		
		/* 비밀번호 확인 유효성 검사 */
		if(pwck == ""){
			$('.final_pwck_ck').css('display','block');
			pwckCheck = false;
		}else{
			$('.final_pwck_ck').css('display', 'none');
			pwckCheck = true;
		}
		
		/* 이름 유효성 검사 */
		if(name == ""){
			$('.final_name_ck').css('display','block');
			nameCheck = false;
		}else{
			$('.final_name_ck').css('display', 'none');
			nameCheck = true;
		}		
		
		/* 휴대폰 유효성 검사 */
		if(mobile == ""){
			$('.final_mobile_ck').css('display','block');
			mobileCheck = false;
		}else{
			$('.final_mobile_ck').css('display', 'none');
			mobileCheck = true;
		}
		
		/* 이메일 유효성 검사 */
		if(mail == ""){
			$('.final_mail_ck').css('display','block');
			mailCheck = false;
		}else{
			$('.final_mail_ck').css('display', 'none');
			mailCheck = true;
		}		
				
		/* 최종 유효성 검사 */
		if(idCheck&&idckCheck&&pwCheck&&pwckCheck&&pwckcorCheck&&nameCheck&&mobileCheck&&mailCheck){
			$("#join_form").attr("action", "join");
			$("#join_form").submit();			
			
		}		
		
		return false;
	});
});

/* 유효성 검사 alert창 출력 */
window.onload =function(){
     document.getElementById("Send").onclick = chkData;
}

function chkData(){
	
	if(document.frm.memberId.value === "" || frm.memberId.value.length <= 3){
        frm.memberId.focus();
        alert("아이디는 필수 입력항목이며 4글자 이상 30글자 이하여야만 합니다.");
        return;
   }
     
     if(document.frm.memberPw.value === "" || frm.memberPw.value.length <= 3){
         frm.memberPw.focus();
         alert("비밀번호는 필수 입력항목이며 4글자 이상 30글자 이하여야만 합니다.");
         return;
    }
     
     if(document.frm.memberPw.value != document.frm.memberPw2.value){
         frm.memberPw2.focus();
         alert("비밀번호가 서로 일치하지 않습니다.");
         return;
    }
     
     var name = /^[가-힣]+$/
    	 if(!frm.username.value.match(name)){
             frm.username.focus();
             alert("이름은 필수 입력항목이며 한글만 입력가능합니다.");
             return;
        }
     
     var aa=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
     if(!frm.email.value.match(aa)){
         alert("이메일은 필수입력 항목이며 양식에 맞춰 정확히 입력해야합니다.\n(ex. wecamp@wecamp.com)");
         frm.email.focus();
         return;   
     }
     
     if(document.frm.mobile.value === ""){
         frm.mobile.focus();
         alert("휴대폰은 필수 입력항목입니다.");
         return;
    }
    
    alert("내정보변경이 완료되었습니다. 재로그인 후 이용해주세요.");          
     //frm.action = "join";
     //frm.method = "post";
     frm.submit();
     }