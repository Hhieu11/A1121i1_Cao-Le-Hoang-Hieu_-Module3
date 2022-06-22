function onDelete(id) {
    document.getElementById("idDel").value = id;
}

function onEdit(id) {
    document.getElementById(id+"").value = id;
}

function activePage(id) {
    document.getElementById("page"+id).className = "active";

}