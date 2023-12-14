
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
        <a href="matrixPlayground.html" id="button-matrix-playground" onmouseover="changeIcon(this)" onmouseout="unchangeIcon(this)" onclick="saveMatrix()">
            <button id="generate-matrix">
                Confirmar
                <img src="../../../../../../../assets/imgs/matrix-icon.svg" alt="">
            </button>
        </a>
        `;
    }

    generateMatrixInput();
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
function generateMatrixInput() {
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

function fillMatrix() {
    const lines = sessionStorage.getItem("lines");
    const columns = sessionStorage.getItem("columns");
    const linesAmount = Number(lines);
    const columnsAmount = Number(columns);

    const matrixString = sessionStorage.getItem("matrix");
    const matrix = jsonToMatrix(matrixString);

    for (let i = 0; i < linesAmount; i++) {
        for (let j = 0; j < columnsAmount; j++) {
            document.getElementById(String(i) + String(j)).value = matrix[i][j];
        }
    }
}

/**
 * 
 */
function saveMatrix() {
    let matrix = getMatrix();
    let matrixString = matrixToJson(matrix);

    sessionStorage.setItem("matrix", matrixString);
}

/**
 * 
 * @returns 
 */
function getMatrix() {
    let matrix = [];
    let line = [];
    
    const linesAmount = sessionStorage.getItem("lines");
    const columnsAmount = sessionStorage.getItem("columns");

    for (let i = 0; i < linesAmount; i++) {
        for (let j = 0; j < columnsAmount; j++) {
            line.push(document.getElementById(String(i) + String(j)).value);
        }

        matrix.push(line);
        line = [];
    }  

    return matrix;
}


/**
 * 
 * @param {*} matrix 
 * @returns 
 */
function matrixToJson(matrix) {
    return JSON.stringify(matrix);  
}

/**
 * 
 * @param {*} jsonMatrix 
 * @returns 
 */
function jsonToMatrix(jsonMatrix) {
    return JSON.parse(jsonMatrix);   
}