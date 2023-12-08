
/**
 * 
 * @param {*} buttonHTML 
 */
function changeIcon(buttonHTML) {
    let img = buttonHTML.getElementsByTagName("img");
    let form_box = document.getElementsByClassName("matrix-dimension");

    form_box[0].style.borderColor = "black";
    img[0].src = "../assets/imgs/matrix-white-icon.svg";
}

/**
 * Receives the DOM Node to the clicked button in matrixGenerator page and change the src of tag img to the original image.  
 *
 * @param {Node} buttonHTML 
 */
function unchangeIcon(buttonHTML) {
    let img = buttonHTML.getElementsByTagName("img");
    let form_box = document.getElementsByClassName("matrix-dimension");

    form_box[0].style.borderColor = "white";
    img[0].src = "../assets/imgs/matrix-icon.svg";
}
