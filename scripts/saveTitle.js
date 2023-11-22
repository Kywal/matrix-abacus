
/**
 * @description Receives the buttons html node and save its innerText in sessionStorage. 
 *
 * @param {*} buttonHTML 
 */
function saveTitle(buttonHTML) {
    const newTitle = buttonHTML.innerText;

    sessionStorage.setItem("title", newTitle);
}