const DEFAULT_MODAL = $('#modal_default');
function openModal(modal,title,content){
    if(modal===null){
        return;
    }
    let titleElement = modal.find(".modal-title");
    titleElement.text(title);
    modal.find(".modal-body").html(content);
    DEFAULT_MODAL.modal("show");
}