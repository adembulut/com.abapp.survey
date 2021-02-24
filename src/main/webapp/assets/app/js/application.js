let dontUse = {success: false, errorMessage: ""};

const DEFAULT_MODAL = $('#modal_default');

function openModal(modal, title, content) {
    if (modal === null) {
        return;
    }
    let titleElement = modal.find(".modal-title");
    titleElement.text(title);
    modal.find(".modal-body").html(content);
    DEFAULT_MODAL.modal("show");
}




$(function () {
    $(".preloader").fadeOut();
});


function changePreloadText(message){
    if(message==null){
        message='Lütfen Bekleyin..';
    }
    $('.loader__label').html(message);
}
function showPreload(message){
    changePreloadText(message);
    let preloader = $('.preloader');
    if(message!=null&&message.trim().length>0) {
        _showPreEvent(preloader);
    }else{
        _hidePreEvent(preloader);
    }
}

function hidePreload(){
    showPreload();
}


function showPleaseWait(){
    showPreload(getBundle("survey.pleaseWait"));
}

function _showPreEvent(preloader){

    preloader.css('display', "block");
    preloader.css('background', "#ffffffc4");
    $('html').css({
        'overflow': 'hidden',
        'height': '100%'
    });
}
function _hidePreEvent(preloader){
    preloader.css('display', "none");
    preloader.css('background', "#fff");
    $('html').css({
        'overflow': 'unset',
        'height': '100%'
    });
}

function isBundleMessage(code){
    if(!code){
        return false;
    }
    return !code.includes(" ");

}



function getBundle(code, ...arg) {
    if(!isBundleMessage(code)){
        return code;
    }
    let msg = code;
    let argData = '';
    for (let i = 0; i < arg.length; i++) {
        argData += "&args=" + arg[i];
    }
    if (msg) {
        $.ajax({
            type: "POST",
            url: "/bundle?bundle=" + code + argData,
            async: false,
            success: function (data) {
                msg = data;
            },
            error: function (xhr, error) {
            }
        });
    }
    return msg;
}

function alphaOnly(event) {
    let key = event.keyCode;
    return ((key >= 65 && key <= 90) || (key >= 97 && key <= 122));
}

function ajaxError(jqXHR, textStatus, errorThrown){
    console.log("error : "+jqXHR);
    console.log("error : "+textStatus);
    console.log("error : "+errorThrown);
}

function showSuccessWithCallBack(callback) {
    swal({
            title: getBundle("survey.general.info"),
            text: getBundle("survey.general.success"),
            confirmButtonColor: "#66BB6A",
            confirmButtonText: getBundle("survey.general.ok"),
            type: "success",
            killer: true,
        }, function () {
            if (isFunction(callback)) {
                callback();
            }
        }
    );
}

function showSuccess(message, callback) {
    swal({
            title: getBundle("survey.general.info"),
            text: message,
            confirmButtonColor: "#66BB6A",
            confirmButtonText: getBundle("survey.general.ok"),
            type: "success",
            killer: true,
        }, function () {
            if (isFunction(callback)) {
                callback();
            }
        }
    );
}

function showError(message, callback) {
    swal({
            title: getBundle("survey.general.error"),
            text: message,
            confirmButtonColor: "#EF5350",
            confirmButtonText: getBundle("survey.general.ok"),
            type: "error",
            killer: true,
        }, function () {
            if (isFunction(callback)) {
                callback();
            }
        }
    );
}

function showConfirm(message, confirmCallback, cancelCallback) {
    swal({
            title: getBundle("survey.general.confirm"),
            text: getBundle(message),
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#EF5350",
            killer: true,
            confirmButtonText: getBundle('survey.general.yes'),
            cancelButtonText: getBundle("survey.general.no"),
            closeOnConfirm: true,
            closeOnCancel: true
        },
        function (isConfirm) {
            if (isConfirm) {
                if (isFunction(confirmCallback)) {
                    confirmCallback();
                }
            } else {
                if (isFunction(cancelCallback)) {
                    cancelCallback();
                }
            }
        });
}


function isFunction(functionToCheck) {
    return functionToCheck && {}.toString.call(functionToCheck) === '[object Function]';
}
