$(document).ready(function () {
    $('#cp').submit(function(event) {
        savePass(event);
    });
    function savePass(event) {
        event.preventDefault();
        $(".alert").html("").hide();
        $(".error-list").html("");
        if ($("#passwordId").val() != $("#matchesPassword").val()) {
            $("#passwordError").show().html([["Пароли не совпадают!"]]);

            return;
        }else {
            $("#passwordError").show().html("").hide();
        }
        $.post(ctx + "/user/update-password", {password:$("#passwordId").val(), oldPassword: $("#oldPassword").val()}, function (data) {
                $("#passwordError").show().html([["Пароли не совпадают!"]]).hide();
            if(data.message == "success") {
                $("#passwordSucc").show().html([["Пароль изменён!"]]);
            }else {
                $("#passwordError").show().html([["Неверный старый пароль!"]]);
            }
            $('form input[type="password"], form textarea').val('');
            })
            .fail(function (data) {
                $("#passwordError").show().html([["Неверный старый пароль!"]]);
            });
    }
});
