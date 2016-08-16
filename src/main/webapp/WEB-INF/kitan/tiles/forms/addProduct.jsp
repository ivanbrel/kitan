<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- jQuery -->
<script src="${ctx}/resources/bootstrap/vendors/jquery/dist/jquery.js"></script>
<script src="${ctx}/resources/js/select2.full.js"></script>

<!-- page content -->
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Добавить товар </h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Settings 1</a>
                                    </li>
                                    <li><a href="#">Settings 2</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <p class="text-muted font-13 m-b-30">
                            Заполните форму для добавление нового товара
                        </p>

                        <!-- start id-form -->

                        <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="${ctx}/product/add" method="POST" enctype="multipart/form-data">

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nameProduct">Наименование продукта </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="nameProduct" name="nameProduct" required="required" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="model">Модель </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="model" name="model" required="required" class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="color" class="control-label col-md-3 col-sm-3 col-xs-12">Цвет </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <%--<input id="color" class="form-control col-md-7 col-xs-12" type="text" name="color">--%>
                                        <select id="color" name="color" class="js-example form-control select2-hidden-accessible" tabindex="-1" aria-hidden="true">
                                            <option value="Красный">Красный</option>
                                            <option value="Синий">Синий</option>
                                            <option value="Чёрный">Чёрный</option>
                                            <option value="Зелёный">Зелёный</option>
                                        </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="countryProduct" class="control-label col-md-3 col-sm-3 col-xs-12">Страна производитель </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <%--<input id="countryProduct" name="countryProduct" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">--%>
                                        <select id="countryProduct" name="countryProduct" class="js-example form-control select2-hidden-accessible" tabindex="-1" aria-hidden="true">
                                            <option value="Польша">Польша</option>
                                            <option value="Италия">Италия</option>
                                            <option value="Китай">Китай</option>
                                            <option value="Россия">Россия</option>
                                        </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="category" class="control-label col-md-3 col-sm-3 col-xs-12">Категория </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <%--<input id="category" name="category" class="date-picker form-control col-md-7 col-xs-12 js-example-data-array" required="required" type="text">--%>
                                        <select id="category" name="category" class="js-example form-control select2-hidden-accessible" tabindex="-1" aria-hidden="true">
                                            <option value="Коляски">Коляски</option>
                                            <option value="Стульчики">Стульчики</option>
                                            <option value="Кроватки-люльки">Кроватки-люльки</option>
                                            <option value="Качели">Качели</option>
                                            <option value="Ходунки">Ходунки</option>
                                            <option value="Автокресла">Автокресла</option>
                                            <option value="Манежи">Манежи</option>
                                            <option value="Аксессуары">Аксессуары</option>
                                        </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="price" class="control-label col-md-3 col-sm-3 col-xs-12">Цена </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="price" name="price" class="date-picker form-control col-md-7 col-xs-12" required="required" type="number">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="quantity" class="control-label col-md-3 col-sm-3 col-xs-12">Количество </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="quantity" name="quantity" class="date-picker form-control col-md-7 col-xs-12" required="required" type="number">
                                </div>
                            </div>

                            <%--<div id="list">--%>

                            <%--</div>--%>

                            <%--<div class="form-group">--%>
                                <%--<a class="btn btn-default" id="add">Добавить</a>--%>
                            <%--</div>--%>

                            <%--<br><br><br>--%>

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Изображение </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input id="file-3" name="fileUpload" type="file" multiple=false>
                                    <%--<input name="fileUpload" type="file" class="file" multiple>--%>
                                </div>
                            </div>

                           <div class="ln_solid"></div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <input type="submit" value="Добавить" class="btn btn-success" />
                                    <input type="reset" value="Очистить форму" class="btn btn-default"  />
                                    <input type="button" value="Назад" onclick="history.back()" class="btn btn-danger"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<script type="text/javascript">
    var data = [{ id: 0, text: 'enhancement' }, { id: 1, text: 'bug' }, { id: 2, text: 'duplicate' }, { id: 3, text: 'invalid' }, { id: 4, text: 'wontfix' }];

    $(".js-example-data-array").select2({
        data: data
    })

</script>