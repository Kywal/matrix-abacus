
function changeIcon(buttonHTML) {
    let img = buttonHTML.getElementsByTagName("img");
    // console.log(img);

    img[0].src = "../assets/imgs/matrix-white-icon.svg";
}

function unchangeIcon(buttonHTML) {
    let img = buttonHTML.getElementsByTagName("img");
    // console.log(img);

    img[0].src = "../assets/imgs/matrix-icon.svg";
}
