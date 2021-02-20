let validator = null;
$(document).ready(function(){
    const MIN_CHAR = 5;
    let requiredMessage=getBundle("survey.validate.required");
    let minLength = getBundle("survey.validate.minLength",MIN_CHAR);
    validator = $('.needs-validation').validate({
        ignore: 'input[type=hidden], .select2-search__field', // ignore hidden fields
        rules:{
            roleCode:{
                required:true,
                minlength:MIN_CHAR
            },
            roleName:{
                required:true,
                minlength:MIN_CHAR
            },
            roleDescription:{
                required:true,
                minlength:MIN_CHAR
            }
        },
        messages:{
            roleCode:{
                required:requiredMessage,
                minlength:minLength
            },
            roleName:{
                required:requiredMessage,
                minlength:minLength
            },
            roleDescription:{
                required:requiredMessage,
                minlength:minLength
            }
        }
    });
    $('button[name="role-save"]').on("click",function(){roleSave()});
})
function roleSave(){
    if(!validator.form()){
        return;
    }
    let data = $('form[name="new-role"]').serialize();
    $.ajax({
        url:'/authority/role-save',
        type:'POST',
        data:data,
        dataType:'JSON',
        success:function(result){
            if(result.success){
                alert("başarılı");
                location.reload();
            }else{
                alert(result.errorMessage);
            }
        },
        error:function(xhr,error){
            alert("error");
        },
        complete:function(){

        }
    })
}