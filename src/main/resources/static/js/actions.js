function showAlert() {
    alert("Yakında aktif olacak!!!");
}
    function addColumn(){
    var table_body = document.getElementById("table_body");
    var new_row = document.createElement("tr");
    new_row.innerHTML = '<td><input type="number" th:field="*{unit}"/></td>' +
    '<td><input type="number" th:field="*{width}"/></td>' +
    '<td><input type="number" th:field="*{height}"/></td>' +
    '<td><button type="button" class="btn btn-danger" onclick="remove_tr(this)">Sil</button></td>';
    table_body.appendChild(new_row);
}

    function remove_tr(element){
    var tr = element.parentNode.parentNode;
    tr.parentNode.removeChild(tr);
}