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