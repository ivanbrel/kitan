/**
 * Created by ibrel on 08/07/16.
 */
$('#add').click(function(){
    var i = '<div class="form-group">'+
        '<label class="control-label col-md-3 col-sm-3 col-xs-12"></label><div class="col-md-6 col-sm-6 col-xs-12">'+
        '<input id="listnote" class="list monedate-picker form-control col-md-7 col-xs-12" required="required" type="text">'+
        '</div>'+
        '</div>';
    $('#list').append(i);
    $('#list input:last-child').focus();
});

$('#demo-form2').submit(function test(){
    var arr=[];
    $.each($('#list .listnote'),function(idx,element){
        var a1 = {};
        a1= $(element).val();
        arr.push(a1);
    });
    var jsonfile={json:JSON.stringify(arr)};
    $.post(ctx + "/product/add/atrr",jsonfile,"json");
    console.log('url',arr);
});
