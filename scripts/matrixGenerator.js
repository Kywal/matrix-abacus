
/**
 * 
 */
function updateMatrixDimensionBox() {
    let areValueValids = saveDimensions();

    if(areValueValids) {
        const matrixDimensionBox = document.getElementsByClassName("matrix-dimension");
        matrixDimensionBox[0].innerHTML = 
        `
        <div id="form-title">Por favor insira os valores iniciais da matriz:</div>
        <div class="matrix"></div>
        <a href="matrixPlayground.html" id="button-matrix-playground" onmouseover="changeIcon(this)" onmouseout="unchangeIcon(this)" >
            <button id="generate-matrix">
                Confirmar
                <img src="../assets/imgs/matrix-icon.svg" alt="">
            </button>
        </a>
        `;
    }

    generateMatrix();
}

/**
 * 
 */
function saveDimensions() {
    const lines = document.getElementById("linhas");
    const columns = document.getElementById("colunas");

    const linesAmount = lines.value;
    const columnsAmount = columns.value;

    if(linesAmount >= 1 && columnsAmount >= 1) {
        sessionStorage.setItem("lines", linesAmount);
        sessionStorage.setItem("columns", columnsAmount);
        return true;
    } else {
        alert("Os valores inseridos não são válidos!");
        return false;
    }

}

/**
 * 
 */
function generateMatrix() {
    const lines = sessionStorage.getItem("lines");
    const columns = sessionStorage.getItem("columns");
    const linesAmount = Number(lines);
    const columnsAmount = Number(columns);

    let newLine = "";

    for (let i = 0; i < linesAmount; i++) {
        newLine += `<div class="matrix-line">`;
        for (let j = 0; j < columnsAmount; j++) {
            newLine += `<input type="number" id=${String(i)+String(j)} class="matrix-cell">`;
        }
        newLine += `</div>`
    }

    const matrix = document.getElementsByClassName("matrix");
    matrix[0].innerHTML += newLine;  

}

