function sample6_execDaumPostcode() {
  new daum.Postcode({
      oncomplete: function(data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 각 주소의 노출 규칙에 따라 주소를 조합한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var addr = ''; // 주소 변수

          //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
          if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
              addr = data.roadAddress;
          } else { // 사용자가 지번 주소를 선택했을 경우(J)
              addr = data.jibunAddress;
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          document.getElementById('sample6_postcode').value = data.zonecode;
          document.getElementById("sample6_address").value = addr;
          // 커서를 상세주소 필드로 이동한다.
          document.getElementById("sample6_detailAddress").focus();
      }
  }).open();
}

// -------------------------------------------------------
/* 회원가입 유효성 검사 */
// .confirm : 초록생 / .error : 빨간색 / 아무것도 없으면 : 검은색

/* 모든 입력이 유효성 검사가 진행 되었는지 체크할 객체를 생성 */
const checkObj = {
    "memberEmail" : false,
    "authKey" : false,
    "memberPw" : false,
    "memberPwConfirm" : false,
    "memberNickname" : false,
    "memberTel" : false
};

/* 이메일 유효성 검사 */

// 1) 이메일 유효성 검사에 사용할 요소 모두 얻어오기
const memberEmail = document.getElementById('memberEmail');
const emailMessage = document.getElementById('emailMessage');

// 2) 이메일이 입력 될 때 마다 유효성 검사 실행
memberEmail.addEventListener('input', ()=>{

    // 3) 입력된 이메일이 없을 경우
    if(memberEmail.value.trim().length == 0){
        memberEmail.value = '';
        emailMessage.innerText = '메일을 받을 수 있는 이메일을 입력해주세요'

        // 클래스를 제거해서 글자색을 검은색으로 만들기
        emailMessage.classList.remove('confirm', 'error');

        // checkObj의 memberEmail 값을 false로 변경
        // == 이메일이 유효하지 않음을 의미
        checkObj.memberEmail = false;
        return;
    }

    // 4) 이메일 정규식 검사
    const regEx = /^[A-Za-z\d\-\_]{4,}@[가-힣\w\-\_]+(\.\w+){1,3}$/;

    // 입력받은 이메일이 정규식과 일치하는 경우
    if(regEx.test(memberEmail.value)){

        /* ============이메일 중복 검사(비동기)============= */
        fetch("/member/checkEmail?email=" + memberEmail.value)
        .then(response=>response.text())
        .then( result => {
            if( result == 0 ){ // 중복 X
                emailMessage.innerText = '사용 가능한 이메일 입니다';
                emailMessage.classList.add('confirm'); // 초록색 글씨
                emailMessage.classList.remove('error'); // 빨간 글씨 제거
                checkObj.memberEmail = true; // 유효한 상태임을 기록
            } else { // 중복 O
                emailMessage.innerText = '이미 사용중인 이메일 입니다';
                emailMessage.classList.add('error');
                emailMessage.classList.remove('confirm');
                checkObj.memberEmail = false;
            }
        })
        .catch(e=>console.log(e));

        /* ================================================= */
    } 
    // 입력 받은 이메일이 정규식과 일치하지 않은 경우
    else{
        emailMessage.innerText = '유효하지 않은 이메일 형식입니다';
        emailMessage.classList.add('error'); // 빨간색 글씨
        emailMessage.classList.remove('confirm'); // 초록 글씨 제거
        checkObj.memberEmail = false; // 유효하지 않은 상태임을 기록
    }
});

/* 인증번호 유효성 검사 */
const authKey = document.getElementById('authKey');
const authKeyMessage = document.getElementById('authKeyMessage');

authKey.addEventListener('input', ()=>{
    
    // 미입력 시
    if(authKey.value.trim().length == 0){
        authKey.value = '';
        authKeyMessage.innerText = '';
        authKeyMessage.classList.remove('error', 'confirm');
        checkObj.authKey = false;
        return;
    }

    // 입력한 인증번호 6글자인 경우 (유효 O)
    // -> 유효한 인증번호 형식입니다 (초록색)
    // checkObj.authKey = true;
    if(authKey.value.trim().length == 6){
        authKeyMessage.innerText = '유효한 인증번호 형식입니다';
        authKeyMessage.classList.add('confirm');
        authKeyMessage.classList.remove('error');
        checkObj.authKey = true;
    }
    // 입력한 인증번호 6글자 미만인 경우 (유효 X)
    // -> 유효하지 않은 인증번호 형식입니다(빨간색)
    // checkObj.authKey = false;
    else{
        authKeyMessage.innerText = '유효하지 않은 인증번호 형식입니다';
        authKeyMessage.classList.add('error');
        authKeyMessage.classList.remove('confirm');
        checkObj.authKey = false;
    }
});

/* 비밀번호 유효성 검사 */

/*  비밀번호/비밀번호 확인 유효성 검사 */
const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const pwMessage = document.getElementById("pwMessage");

// 비밀번호 입력 시 유효성 검사
memberPw.addEventListener("input", () => {

    // 비밀번호가 입력되지 않은 경우
    if(memberPw.value.trim().length == 0){
        memberPw.value = ""; // 띄어쓰지 못넣게 하기

        pwMessage.innerText = "영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이로 입력해주세요.";
        pwMessage.classList.remove("confirm", "error"); // 검정 글씨

        checkObj.memberPw = false; // 빈칸 == 유효 X
        return;
    }


    // 정규 표현식을 이용한 비밀번호 유효성 검사

    // 영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이
    const regEx = /^[a-zA-Z0-9\!\@\#\-\_]{6,20}$/;

    // 입력한 비밀번호가 유효한 경우
    if(regEx.test(memberPw.value)){
        checkObj.memberPw = true; 
        
        // 비밀번호가 유효하게 작성된 상태에서
        // 비밀번호 확인이 입력되지 않았을 때
        if(memberPwConfirm.value.trim().length == 0){

            pwMessage.innerText = "유효한 비밀번호 형식입니다";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");
        }
        
        // 비밀번호가 유효하게 작성된 상태에서
        // 비밀번호 확인이 입력되어 있을 때
        else{
            // 비밀번호 == 비밀번호 확인  (같을 경우)
            if(memberPw.value == memberPwConfirm.value){
                pwMessage.innerText = "비밀번호가 일치합니다";
                pwMessage.classList.add("confirm");
                pwMessage.classList.remove("error");
                checkObj.memberPwConfirm = true;
                
            } else{ // 다를 경우
                pwMessage.innerText = "비밀번호가 일치하지 않습니다";
                pwMessage.classList.add("error");
                pwMessage.classList.remove("confirm");
                checkObj.memberPwConfirm = false;
            }
        }

        
    } else{ // 유효하지 않은 경우
        
        pwMessage.innerText = "비밀번호 형식이 유효하지 않습니다";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
        checkObj.memberPw = false; 
    }
});


// 비밀번호 확인 유효성 검사
memberPwConfirm.addEventListener('input', ()=>{

    if(checkObj.memberPw){ // 비밀번호가 유효하게 작성된 경우에

        // 비밀번호 == 비밀번호 확인  (같을 경우)
        if(memberPw.value == memberPwConfirm.value){
            pwMessage.innerText = "비밀번호가 일치합니다";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");
            checkObj.memberPwConfirm = true;
            
        } else{ // 다를 경우
            pwMessage.innerText = "비밀번호가 일치하지 않습니다";
            pwMessage.classList.add("error");
            pwMessage.classList.remove("confirm");
            checkObj.memberPwConfirm = false;
        }

    } else { // 비밀번호가 유효하지 않은 경우
        checkObj.memberPwConfirm = false;
    }
});


/* 닉네임 유효성 검사 */
const memberNickname = document.getElementById('memberNickname');
const nickMessage =document.getElementById('nickMessage');

memberNickname.addEventListener('input', ()=>{
    // 닉네임 정규표현식
    const regEx = /^[가-힣\w\d]{2,10}$/;

    // 미입력 시
    if(memberNickname.value.trim().length == 0){
        memberNickname.value = '';
        nickMessage.innerText = '한글,영어,숫자로만 2~10글자';
        nickMessage.classList.remove('confirm', 'error');
        checkObj.memberNickname = false;
        return;
    }

    if(regEx.test(memberNickname.value)){

        /* =====================닉네임 중복 검사====================== */

        fetch("/member/checkNickname?nickname=" + memberNickname.value)
        .then(resp => resp.text())
        .then(result => {
            if(result == 0){ // 중복 X
                nickMessage.innerText = '사용 가능한 닉네임 입니다';
                nickMessage.classList.add('confirm');
                nickMessage.classList.remove('error');
                checkObj.memberNickname = true;
            } else {
                nickMessage.innerText = '이미 사용중인 닉네임 입니다';
                nickMessage.classList.add('error');
                nickMessage.classList.remove('confirm');
                checkObj.memberNickname = false;
            }
        })
        .catch(e=>console.log(e));

        /* =========================================================== */
    }
    else{
        nickMessage.innerText = '유효하진 않은 닉네임 형식입니다';
        nickMessage.classList.add('error');
        nickMessage.classList.remove('confirm');
        checkObj.memberNickname = false;
    }

});

/* 전화번호 유효성 검사 */
const memberTel = document.getElementById('memberTel');
const telMessage = document.getElementById('telMessage');

memberTel.addEventListener('input', ()=>{

    // 전화번호 정규 표현식
    const regEx = /^0(1[01679]|2|[3-6][1-5]|70)[1-9]\d{2,3}\d{4}$/;

    // 미입력 시
    if(memberTel.value.trim().length == 0){
        memberTel.value = '';
        telMessage.innerText = '전화번호를 입력해주세요.(- 제외)';
        telMessage.classList.remove('confirm', 'error');
        checkObj.memberTel = false;
        return;
    }

    if(regEx.test(memberTel.value)){
        telMessage.innerText = '유효한 전화번호 형식입니다.';
        telMessage.classList.add('confirm');
        telMessage.classList.remove('error');
        checkObj.memberTel = true;
    }
    else{
        telMessage.innerText = '유효하지 않은 전화번호 형식입니다.';
        telMessage.classList.add('error');
        telMessage.classList.remove('confirm');
        checkObj.memberTel = false;
    }
});


/* 회원 가입 버튼이 클릭 되었을 때 */
document.getElementById('signUpFrm').addEventListener('submit', e=>{

    /* checkObj의 모든 값을 검사해서 
    하나라도 false이면 가입 시도를 못 하게 한다 */
    
    // 객체 전용 향상된 for문 : ( for ... in )
    for(let key in checkObj){

        // 객체에서 얻어온 값이 false인 경우
        // (유효하지 않은 것이 있을 경우)
        if( !checkObj[key] ){

            let str;
            switch(key){
            case "memberEmail" : str = "이메일이 유효하지 않습니다"; break;
            case "authKey" : str = "인증번호가 유효하지 않습니다"; break;
            case "memberPw" : str = "비밀번호가 유효하지 않습니다"; break;
            case "memberPwConfirm" : str = "비밀번호가 일치하지 않습니다"; break;
            case "memberNickname" : str = "닉네임이 유효하지 않습니다"; break;
            case "memberTel" : str = "전화번호가 유효하지 않습니다"; break;
            default : break;
            }

            alert(str);

            // key == input id 속성 값
            // 유효하지 않은 input 태그로 focus 맞춤
            document.getElementById(key).focus();

            e.preventDefault(); // form 제출 X
            return;
        }
    }

});