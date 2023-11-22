
function saveDimensions() {
    const lines = document.getElementById("linhas");
    const columns = document.getElementById("colunas");
    
    sessionStorage.setItem("lines", lines.value);
    sessionStorage.setItem("columns", columns.value);
}