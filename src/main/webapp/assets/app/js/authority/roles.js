$(document).ready(function(){
    $('button[name="btn-role-new"]').bind("click",newRole);
});

function newRole(){
    openModal(DEFAULT_MODAL,"adem bulut",null);
}