function writeSave() {
    if(document.writeForm.write.value == "") {
        alert("작성자를 입력하십시오.");
        document.writeForm.write.focus();
        return false;
    }
    if(document.writeForm.subject.value == "") {
        alert("제목을 입력하십시오.");
        document.writeForm.subject.focus();
        return false;
    }
    if(document.writeForm.content.value == "") {
        alert("내용을 입력하십시오.");
        document.writeForm.content.focus();
        return false;
    }
    if(document.writeForm.pass.value == "") {
        alert("비밀번호를 입력하십시오.");
        document.writeForm.pass.focus();
        return false;
    }
}

function deleteSave() {
    if(document.delForm.pass.value == "") {
        alert("비밀번호를 입력하십시오.");
        document.delForm.pass.focus();
        return false;
    }
}

function check() {
	if(document.find_frm.find_box.value == "") {
		alert("검색어를 입력해주세요.");
		return false;
	}
}

function frm_sub(i) {
	i_frm.action = "/boardmvc/list.bdo?pageNum=" + i;
	i_frm.submit();
}