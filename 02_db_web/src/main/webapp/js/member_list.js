function deleteMember(memberNo) {
    const result = confirm("정말 삭제할까요?");

    if (result) {

        const url = "/web/member?no=" + memberNo;

        try {
            fetch(url, {
                method: "DELETE"
            })
                .finally(() => {
                    location.reload();
                })
        } catch (e) {
            console.error(e);
        }

    }
}

function updateMemberName(memberNo, name) {
    const newName = prompt("수정할 값을 입력해주세요.", name);

    console.log(newName);
    if (!newName || newName === name) return;

    const sp = new URLSearchParams({
        no: memberNo,
        name: newName
    })

    const url = `/web/member/update?${sp.toString()}`;

    console.log(url);

    try {
        fetch(url, {
            method: "POST",
        })
            .catch(console.error)
            .finally(() => {
                location.reload();
            })
    } catch (e) {
        console.error(e);
    }

}