function showAlert() {
    alert("Yakında aktif olacak!!!");
}
function create_tr(table_body){
    let table_id = document.getElementById(table_body);
        first_tr = table_id.firstElementChild
        tr_clone = first_tr.cloneNode(true);
        tr_clone.firstElementChild.textContent = table_id.childElementCount +1;
    table_id.append(tr_clone);
}

function remove_tr(This){
    if(This.closest('tbody').childElementCount==1){
        alert("1 Pozdan daha küçük poz olamaz!")
    }
    else{
        This.closest('tr').remove();
    }
}





