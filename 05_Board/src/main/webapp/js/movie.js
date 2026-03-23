function deleteMovie(no) {
    const result = confirm('Are you sure you want to delete this movie?');

    if (!result) return;


    const sp = new URLSearchParams({no});

    const url = `/movie-delete?${sp.toString()}`;

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


function updateMovie(no, movie) {

}