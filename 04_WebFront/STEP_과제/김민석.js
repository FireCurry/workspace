function checkPw(){
    const pw = document.getElementById("pw");
    const pwCh = document.getElementById("pw-ch");
    if(pw.value == "" || pwCh.value == ""){
        alert('비밀번호를 입력해주세요');
    } else{
        if(pw.value == pwCh.value){
            alert("확인 완료");
        } else{
            console.log(pwCh.value);
            pwCh.value = "";
            alert("비밀번호가 일치하지 않습니다");
        }
    }
}