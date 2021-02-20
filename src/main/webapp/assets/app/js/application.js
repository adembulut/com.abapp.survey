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

function getBundle(code,...arg) {
    let msg = code;
    let argData='';
    for (let i = 0; i < arg.length; i++) {
        argData+="&args="+arg[i];
    }
    if (msg) {
        $.ajax({
            type: "POST",
            url: "/bundle?bundle="+code+argData,
            async:false,
            success: function(data) {
                msg = data;
            },
            error: function(xhr, error) {
            }
        });
    }
    return msg;
}