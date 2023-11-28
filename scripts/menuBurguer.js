
/**
 * 
 */
function showMenu(menuButton) {
    let aside = document.querySelector("aside");
    let asideDisplay = aside.style.display;
    let buttonImg = document.querySelector("#menu-burguer > img");

    if(asideDisplay == "") {
        aside.style.display = "flex";
        aside.style.justifyContent = "center";
        menuButton.style.right = "10rem";
        menuButton.style.borderColor = "white";

        buttonImg.src = "../assets/imgs/menu-button-of-three-horizontal-lines-white.png"
    } else if (asideDisplay != "") {
        aside.style.display = "";
        menuButton.style.right = "3rem";
        menuButton.style.borderColor = "black";
        buttonImg.src = "../assets/imgs/menu-button-of-three-horizontal-lines.png"
    }
}

