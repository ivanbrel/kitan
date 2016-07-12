/**
 * Created by ibrel on 07/07/16.
 */
var i = 0; /* Set Global Variable i */
function increment(){
    i += 1; /* Function for automatic increment of field's "Name" attribute. */
}
/*
 ---------------------------------------------

 Function to Remove Form Elements Dynamically
 ---------------------------------------------

 */
function resetElementsCus(parentDiv, childDiv){
    if (childDiv == parentDiv){
        alert("The parent div cannot be removed.");
    }
    else if (document.getElementById(childDiv)){
        var child = document.getElementById(childDiv);
        var parent = document.getElementById(parentDiv);
        parent.removeChild(child);
    }
    else{
        alert("Child div has already been removed or does not exist.");
        return false;
    }
}
/*
 ----------------------------------------------------------------------------

 Functions that will be called upon, when user click on the Name text field.

 ----------------------------------------------------------------------------
 */
function textareaFunction(){
    var r = document.createElement('span');
    var y = document.createElement("INPUT");
    y.setAttribute("type", "text");
    y.setAttribute("class", "date-picker form-control col-md-7 col-xs-12");
    var g = document.createElement("IMG");

    increment();
    y.setAttribute("Name", "textelement_" + i);
    r.appendChild(y);
    g.setAttribute("onclick", "removeElement('newAtrr','id_" + i + "')");
    r.appendChild(g);
    r.setAttribute("id", "id_" + i);
    document.getElementById("newAtrr").appendChild(r);
}

function resetElementsCus(){
    document.getElementById('newAtrr').innerHTML = '';
}
