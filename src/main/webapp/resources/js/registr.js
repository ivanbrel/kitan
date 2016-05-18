$(document).ready(function () {
    $('regform').submit(function(event) {
        register(event);
    });

    //$('#login').on('blur', function(){
    //    jQuery.ajax({
    //        type:"POST",
    //        url:"/checkLogin",
    //        data:{"login":document.getElementById('login').value} ,
    //        success: function(data){
    //            if( data == true) {
    //                $("#userLoginExist").show().html([["Пользователь с таким логином уже существует!"]]);
    //                $("#userLoginFree").html("").hide();
    //            }else if(data == false){
    //                $("#userLoginFree").show().html([["Логин свободен"]]);
    //                $("#userLoginExist").html("").hide();
    //            }
    //
    //        }
    //    })
    //});

    $(":password").keyup(function(){
        //if($("#password").val() != $("#matchPassword").val()){
        //    $("#globalError").show().html([["Пароли не совпадают!"]]);
        //}else{
        //    $("#globalError").html("").hide();
        //}
        $("#globalError").html("").hide();
    });

    //options = {
    //    common: {minChar:6},
    //    ui: {
    //        showVerdictsInsideProgressBar:true,
    //        showErrors:true,
    //        errorMessages:{
    //            wordLength: [["Длинна пароля меньше 6-ми символов"]],
    //            wordNotEmail: [["Нельзя использовать логин в качестве пароля"]],
    //            //wordSequences: [["Ваш пароль содержит последовательности"]],
    //            //wordLowercase: [["Используйте символы нижнего регистра"]],
    //            //wordUppercase: [["Используйте символы верхнего регистра"]],
    //            wordOneNumber: [["Используйте цифры"]],
    //            //wordOneSpecialChar: [["Используйте спец. символы (пример: _ @ # $ %)"]]
    //        }
    //    }
    //};
    //$('#password').pwstrength(options);
});

function register(event){
    event.preventDefault();
    $(".alert").html("").hide();
    $(".error-list").html("");
    if($("#password").val() != $("#matchPassword").val()){
        //$("#globalError").show().html([["Пароли не совпадают!"]]);
        return;
    }
    var formData= $('regform').serialize();
    $.post("/registration",formData ,function(data){
            if(data.message == "success"){
                alert("Регистрация прошла успешно!");
                window.location.href = "/login";
            }

        })
        .fail(function(data) {
            if(data.responseJSON.error == "UserAlreadyExist"){
                $("#userLoginError").show().html(data.responseJSON.message);
                alert("Пользователь с таким логином уже существует!");
            }
            else if(data.responseJSON.error.indexOf("InternalError") > -1){
                window.location.href = "login?message=" + data.responseJSON.message;
            }
            else{
                var errors = $.parseJSON(data.responseJSON.message);
                $.each( errors, function( index,item ){
                    $("#"+item.field+"Error").show().html(item.defaultMessage);
                });
                errors = $.parseJSON(data.responseJSON.error);
                $.each( errors, function( index,item ){
                    $("#globalError").show().append(item.defaultMessage+"<br/>");
                });
            }
        });
}