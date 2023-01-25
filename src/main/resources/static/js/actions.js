function showAlert() {
    alert("Yakında aktif olacak!!!");
}

var count = 1;
var table = document.getElementById("table_body");

function addColumn() {
    var tableBody = document.getElementById("table_body");
    if (!tableBody) {
        console.error("There is no element with the id 'table_body' in the document.");
        return;
    }

    var newRow = tableBody.insertRow(-1);
    var newCell1 = newRow.insertCell(0);
    var newCell2 = newRow.insertCell(1);
    var newCell3 = newRow.insertCell(2);
    newCell1.innerHTML = "<input type='number' name='unit' th:field=\"*{unit}\" />";
    newCell2.innerHTML = "<input type='number' name='width' th:field=\"*{width}\" />";
    newCell3.innerHTML = "<input type='number' name='height' th:field=\"*{height}\" />";
    count++;
}

function remove_tr(This) {
    This.closest('tr').remove();
}






