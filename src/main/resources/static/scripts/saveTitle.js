
/**
 * @description Receives the buttons html node that has been clicked in playground page and save its innerText in sessionStorage to use it later as subtitle. 
 *
 * @param {Node} buttonHTML 
 */
function saveTitle(buttonHTML) {
    const newTitle = buttonHTML.innerText;

    sessionStorage.setItem("title", newTitle);
}