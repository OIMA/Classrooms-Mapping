/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(".delete").click(function() {
    var e = $(this).attr("idButton");
    console.log(e);
    eliminarAjax(e);
});

function eliminarAjax(idButton) {
    
    $.ajax({
        type: "POST",
        url: "EliminarEspecialidad.xx",
        data: {
            id : idButton
        },
        success: function(data) {
            if(data === "ok"){
                $.$(location).attr('href','index.xx');
            }
            $("#divvv").html("<strong>" + data + "</strong> degrees");
        }
    });
}



