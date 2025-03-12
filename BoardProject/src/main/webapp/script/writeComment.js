function writeCoComment(commentNo, boardNo) {

    if(document.getElementById("CoComment" + commentNo).style.display == 'none') {
        document.getElementById("CoComment" + commentNo).style.display = 'table-row';
        const xhr = new XMLHttpRequest();
        xhr.open("GET", "WriteCoComment.jsp?board_no=" + boardNo + "&comment_no=" + commentNo, true);
        xhr.onload = function () {
            if (xhr.status === 200) {
                document.getElementById("writeCoComment" + commentNo).innerHTML = xhr.responseText;
            } else {
                console.error("Failed to load WriteComment.jsp.");
            }
        }
        xhr.send();
    }else {
        document.getElementById("CoComment" + commentNo).style.display = 'none';
    }

}

function changeRow(commentNo, event) {

    event.stopPropagation();

    const xhr = new XMLHttpRequest();
    xhr.open("GET", "SelectMyCommentProcess.jsp?comment_no=" + commentNo, true);
    xhr.onload = function () {
        if(xhr.status === 200) {
            const newContent = xhr.responseText;
            console.log(newContent);  // 응답 받은 HTML 코드 로그 확인

            const container = document.getElementById("selectedComment" + commentNo);
            container.innerHTML = newContent;

                    // 삽입 후 결과 확인
            console.log(container.innerHTML);  // 삽입된 후 HTML 구조 확인
        } else {
            console.error("Failed to load SelectedComment.jsp");
        }
    }
    xhr.send();
}

function eventHandler(event) {
    event.stopPropagation();
}

function goBack() {
    history.back();
}

function goBack(num) {
    history.go(num);
}

function loginFirst() {
    alert("먼저 로그인 해주세요.");
    window.location.href = "Login.jsp";
}
function loginFail() {
    alert("ID 또는 비밀번호가 틀렸습니다.");
    window.location.href = "Login.jsp";
}
function registSuccess() {
    alert("회원가입에 성공했습니다..");
    window.location.href = "main.jsp";
}

function registFail() {
    alert("회원가입에 실패했습니다.. 다시 시도해주세요.");
    window.location.href = "UserRegist.jsp";
}

function deleteCommentSuccess() {
    alert("댓글을 삭제했습니다.");
    goBack(-1);
}

function deleteCommentFail() {
    alert("댓글을 삭제하지 못했습니다.");
    goBack(-1);
}

function writeBoardFail() {
    alert("게시글을 작성하지 못했습니다.");
    window.location.href = "WriteBoard.jsp";
}