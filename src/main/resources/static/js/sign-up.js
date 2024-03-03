function signUp() {
    $('#form-sign-up').submit();
}
function emailSend() {
    // 이메일 정규식
    let regex = new RegExp("([!#-'*+/-9=?A-Z^-~-]+(\.[!#-'*+/-9=?A-Z^-~-]+)*|\"\(\[\]!#-[^-~ \t]|(\\[\t -~]))+\")@([!#-'*+/-9=?A-Z^-~-]+(\.[!#-'*+/-9=?A-Z^-~-]+)*|\[[\t -Z^-~]*])");
    let email = $(`#email`);

    if(!email.val() || !regex.test(email.val())) {
        alert(`이메일 형식에 맞춰 입력해주세요.`);
    } else {
        $.ajax({
            type: `get`,
            url: `/email/send`,
            data: {"email" : email.val()},
            success: [
                function (result) {
                    if (result === 2) {
                        alert(`이미 가입된 이메일입니다. 다른 이메일을 입력해주세요.`);
                    } else if (result === 1) {
                        alert(`이메일 확인 후 인증 코드를 입력해주세요.`);
                        $('#tr-email-auth').css(`display`, `block`); // 이메일 인증 코드 폼 활성화
                        email.data(`auth-btn-click-fl`, 1);
                        console.log(`auth-btn-click-fl = `, email.data(`auth-btn-click-fl`));
                    } else {
                        alert(`잠시 후 다시 시도해주세요.`);
                    }
                }
            ]
        })
    }
}

function emailAuthCodeCheck() {
    let email = $(`#email`);
    const authBtnClickFl = email.data(`auth-btn-click-fl`);
    const dto = {
        "code" : $(`#code`).val(),
        "email" : email.val()};

    if(dto.code && dto.email) {
        $.ajax({
            type: `post`,
            url: `/email/check`,
            contentType: `application/json`,
            data: JSON.stringify(dto),
            success: [
                function (result) {
                    if (result === 1) {
                        alert("이메일 인증이 완료되었습니다.");
                        email.data(`auth-check-fl`, 1); // data-set 속성 변경
                        console.log(email.data('auth-check-fl')); // data-set 속성 확인
                    } else {
                        alert("이메일 인증 코드가 일치하지 않습니다.");
                        email.data('auth-check-fl', 0);
                        console.log(email.data('auth-check-fl'));
                    }
                }
            ]
        })
    } else if(authBtnClickFl === 0) {
        alert(`이메일 인증 후 시도해주세요.`);
    }
}

function nameCheck() {
    const name = $(`#name`);
    console.log(`name = `, name.val());

    if(!name.val()) {
        alert(`닉네임을 입력하지 않으셨습니다. 작성 후 중복 확인 해주세요.`);
    } else {
        $.ajax({
            type: `get`,
            url: `/name-check`,
            data: {"name" : name.val()},
            success: [
                function (result) {
                    if (result === 1) {
                        alert(`사용 가능한 닉네임입니다.`);
                        name.data(`name-check`, 1);
                        console.log(name.data('name-check'));
                    } else {
                        alert(`이미 존재하는 닉네임입니다. 다른 닉네임으로 변경해주세요.`);
                        name.data('name-check', 0);
                        console.log(name.data('name-check'));
                    }
                }
            ]
        })
    }
}