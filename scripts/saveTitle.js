
function saveTitle(buttonHTML) {
    const newTitle = buttonHTML.innerText;

    sessionStorage.setItem("title", newTitle);
}