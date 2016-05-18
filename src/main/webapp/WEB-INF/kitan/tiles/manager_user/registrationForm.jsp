<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .loading{
        /*position: absolute;*/
        /*z-index: 2;*/
        display:none;
        /*height: 100%;*/
        /*width: 100%;*/
        /*background-color: rgb(200, 200, 201);*/
    }
    #loader{
        position: absolute;
        top:1px;
        left: 15px;
        margin: auto auto;
        height: 24px;
        width: 24px;
    }
</style>
<div class="center-man">
    <div>
        <h2 style="text-align:center; margin-bottom:40px">РЕГИСТРАЦИЯ В СИСТЕМЕ</h2>
       <div class="form-style-1">
           <div class="center-left" >

               <form id="form" action="/" method="post">

                   <p>
                       <label><span>Фамилия <span class="required">*</span></span><input id="lastName" type="text" class="field-divided" name="lastName" value="" required="required"/></label>
                       <span id="lastNameError" class="alert alert-danger col-sm-4" style="display:none"></span>
                   </p>

                    <p>
                        <label><span>Имя <span class="required">*</span></span><input id="firstName" type="text" class="field-divided" name="firstName" value="" required="required"/></label>
                        <span id="firstNameError" class="alert alert-danger col-sm-4" style="display:none"></span>
                    </p>

                    <p>
                        <label><span>Отчество <span class="required">*</span></span><input id="patronymicName" type="text" class="field-divided" name="patronymicName" value="" required="required"/></label>
                        <span id="patronymicNameError" class="alert alert-danger col-sm-4" style="display:none"></span>
                    </p>

                    <p>
                        <label><span>Предприятие <span class="required">*</span></span><input id="company" type="text" class="field-divided" name="company" value="" required="required"/></label>
                        <span id="companyError" class="alert alert-danger col-sm-4" style="display:none"></span>
                    </p>

                    <p>
                        <label><span>Индекс дела </span><input type="text" class="field-divided" name="index" value=""/></label>
                        <span id="indexError" class="alert alert-danger col-sm-4" style="display:none"></span>
                    </p>

                    <p>
                        <label><span>Рабочий ж.д.телефон <span class="required">*</span></span><input id="workPhone" type="text" class="field-divided" name="workPhone" value="" required="required"/></label>
                        <span id="workPhoneError" class="alert alert-danger col-sm-4" style="display:none"></span>
                    </p>

                    <p>
                        <label><span>Мобильный телефон </span><input type="text" class="field-divided" name="privatePhone" value=""/></label>
                        <span id="privatePhoneError" class="alert alert-danger col-sm-4" style="display:none"></span>
                    </p>

                    <p>
                        <label><span>E-mail </span><input type="email" class="field-divided" name="email" value="" /></label>
                        <span id="emailError" class="alert alert-danger col-sm-4" style="display:none"></span>
                    </p>

                    <p>
                        <label><span>Логин <span class="required">*</span></span><input type="text" id="user" class="field-divided" name="user" value="" required="required"/></label>
                        <span id="userLoginFree" class="isa_success" style="display:none"></span>
                        <span id="userLoginExist" class="isa_error" style="display:none"></span>
                    </p>

                    <p>
                        <label><span>Пароль <span class="required">*</span></span><input id="password" class="field-divided" name="password" value="" type="password" required="required"/></label>
                        <span id="passwordError" class="isa_error" style="display:none"></span>
                    </p>

                    <p>
                        <label><span>Подтвердите пароль<span class="required">*</span></span><input id="matchPassword" class="field-divided" name="matchingPassword" value="" type="password" required="required"/></label>
                        <span id="globalError" class="isa_error" style="display:none"></span>
                    </p>
                    <p>* - звёздочкой помечены поля, обязательные для заполнения</p>
                    <input type="submit" class="great_btn5" value="Зарегистрироваться">
               </form>

           </div>
    </div>
</div>
</div>

