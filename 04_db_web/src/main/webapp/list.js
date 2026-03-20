function deleteItem(id) {
    const result = confirm("Are you sure you want to delete this item?");

    if (!result) return;

    const url = "/web/restaurant/delete?no=" + id;

    try {
        fetch(url, {
            method: "POST"
        })
            .finally(() => {
                location.reload();
            })
    } catch (e) {
        console.error(e);
    }
}


function updateItemName(id, name) {
    const newName = prompt("수정할 값을 입력해주세요.", name);

    if (!newName || newName === name) return;

    const sp = new URLSearchParams({
        no: id,
        name: newName
    })

    const url = `/web/restaurant/update/name?${sp.toString()}`;

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