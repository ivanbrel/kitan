/**
 * Created by ibrel on 08/07/16.
 */
$('#add').click(function(){
    var i = '<input class="listnote" type = "text"/>';
    $('#list').append(i);
    $('#list input:last-child').focus();
});

$('#send').click(function test(){
    var arr=[];
    $.each($('#list .listnote'),function(idx,element){
        var a1 = {};
        a1= $(element).val();
        arr.push(a1);
    });
    var jsonfile={json:JSON.stringify(arr),name:document.getElementById('nameProduct').value};
    $.post(ctx + "/test",jsonfile,"json");
    console.log('url',arr);
});
