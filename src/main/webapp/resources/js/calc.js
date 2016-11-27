
    var
        _moduleName = "currency",
        _version = "0.0.1",
        _url = ctx + "/product/courses/converter";

    if (typeof jQuery === 'undefined') {
        throw new Error(_moduleName + ' JavaScript requires jQuery')
    }

    function Api() {
        this.info();
        this.init();
    }

    Api.prototype = {
        constructor: Api,
        moduleName: _moduleName,
        version: _version,
        ajaxGet: ajaxGet,
        info: function () {
            console.log(this.moduleName + ":" + this.version);
        },
        init: init
    };

    function init() {}

    function ajaxGet() {
        return $.ajax({
            url: _url,
            dataType: 'json',
            type: "GET"
        })
            .done(function (data) {
                byn = data[0];
                rus = data[1];
                document.getElementById("pricebyn").value = 0;
                document.getElementById("pricerus").value = 0;
                document.getElementById("priceusd").value = 0;
            })
            .fail(function () {
                alert("FAIL!!!")
            })
    }

    ajaxGet();

    var
        byn = 0,
        rus = 0,
        usd = 0, lastChange;

    function calcItLocal(currency) {
        if (currency == "usd") {

            lastChange = "usd";
            if (isNaN(document.getElementById("priceusd").value)) document.getElementById("priceusd").value = 100;
            if ((document.getElementById("priceusd").value == "") || (document.getElementById("priceusd").value == " ")){
                document.getElementById("priceusd").value = "";
                document.getElementById("pricebyn").value = 0;
                document.getElementById("pricerus").value = 0;
                return;
            }
            document.getElementById("pricebyn").value= Math.round(parseFloat(document.getElementById("priceusd").value) * usd * 10000) / 10000;
            document.getElementById("pricerus").value= Math.round(parseFloat(document.getElementById("priceusd").value) * usd / rus * 10000) / 100;
        }

        else if (currency == "rur"){
            lastChange = "rur";
            if (isNaN(document.getElementById("pricerus").value)) document.getElementById("pricerus").value = 100;
            if ((document.getElementById("pricerus").value == "") || (document.getElementById("pricerus").value == " ")){
                document.getElementById("pricerus").value = "";
                document.getElementById("pricebyn").value = 0;
                document.getElementById("priceusd").value = 0;
                return;
            }
            document.getElementById("pricebyn").value= Math.round(parseFloat(document.getElementById("pricerus").value) * rus * 100) / 10000;
            document.getElementById("priceusd").value= Math.round(parseFloat(document.getElementById("pricerus").value) * rus / usd * 100) / 10000;
        }

        else if (currency == "byr"){
            lastChange = "byr";
            if (isNaN(document.getElementById("pricebyn").value)) document.getElementById("pricebyn").value = 100;
            if ((document.getElementById("pricebyn").value == "") || (document.getElementById("pricebyn").value == " ")){
                document.getElementById("pricebyn").value = "";
                document.getElementById("priceusd").value = 0;
                document.getElementById("pricerus").value = 0;
                return;
            }
            document.getElementById("pricerus").value = Math.round(parseFloat(document.getElementById("pricebyn").value) / rus * 10000) / 100;
            document.getElementById("priceusd").value = Math.round(parseFloat(document.getElementById("pricebyn").value) / usd * 10000) / 10000;
        }
    }
