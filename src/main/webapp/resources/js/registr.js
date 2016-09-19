$(document).ready(function () {

    $('#form').submit(function (event) {
        //for(var i=0; i < 200000000; i++);
        //{
        //    var n = noty({
        //        text: 'Проверка данных ...',
        //        animation: {
        //            open: {height: 'toggle'}, // jQuery animate function property object
        //            close: {height: 'toggle'}, // jQuery animate function property object
        //            easing: 'swing', // easing
        //            speed: 100 // opening & closing animation speed
        //        }
        //    });
        //    n.show();
        //}
        if ($("#login").val()!=0 && $("#password").val()!=0 && $("#firstName").val()!=0 && $("#lastName").val()!=0) {
            register(event);
        } else {
            alert("Поля, помеченные звездочкой, обязательны для заполнения");
            return false;
        }
    });

    $('#login').on('blur', function () {

        jQuery.ajax({
            type: "POST",
            url: ctx + "/checkLogin",
            data: {"login": document.getElementById('login').value},
            success: function (data) {
                //check on empty field "user"
                if ($("#login").val() != 0) {
                    if (data == false) {
                        //check on exists user
                        $("#userLoginExist").show().html([["Пользователь с таким логином уже существует!"]]);
                        $("#userLoginFree").html("").hide();
                    } else if (data == true) {
                        $("#userLoginFree").show().html([["Логин свободен"]]);
                        $("#userLoginExist").html("").hide();
                    }
                } else {
                    $("#userLoginExist").html("").hide();
                    $("#userLoginFree").html("").hide();
                }

            }
        })
    });

    $(":password").keyup(function () {
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
        $("#globalError").show().html([["Пароли не совпадают!"]]);
        return;
    }
    var formData= $('#form').serialize();
    $.post(ctx + "/registration",formData ,function(data){
            if(data.message == "success"){
                alert("Регистрация прошла успешно!");
                //var n = noty({
                //    text: 'Регистрация прошла успешно!',
                //    animation: {
                //        open: {height: 'toggle'}, // jQuery animate function property object
                //        close: {height: 'toggle'}, // jQuery animate function property object
                //        easing: 'swing', // easing
                //        speed: 100 // opening & closing animation speed
                //    }
                //});
                //n.show();
                window.location.href = ctx + "/index.jsp";
            }

        })
        .fail(function(data) {
            if(data.responseJSON.error == "UserAlreadyExist"){
                $("#userLoginError").show().html(data.responseJSON.message);
                alert("Пользователь с таким логином уже существует!");
            }
            else if(data.responseJSON.error.indexOf("InternalError") > -1){
                window.location.href = "login_?message=" + data.responseJSON.message;
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