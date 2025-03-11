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