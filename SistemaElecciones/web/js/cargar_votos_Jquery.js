/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function funcion_cargar_voto(boxName) {
//                        alert("algo");
//                        var atributos = 'mesa=' + numTable + '&numeroCheckBox=' + boxName;
    var atributos = 'numeroCheckBox=' + boxName;

    $.ajax({
        async: false,
        url: "ServletCargarVoto",
        data: atributos,
//                            dataType: "json",
        beforeSend: function(objeto) {
            //     alert("me voy a ejecutar.");
        },
        success: function(datos) {
            //    alert("Valor devuelto : " + datos);
        },
        error: function(objeto, mensaje, otroobj) {
            alert(mensaje);
        }});
}
function funcion_marcar_partido(boxName) {
//                        alert("algo");
//                        var atributos = 'mesa=' + numTable + '&numeroCheckBox=' + boxName;
    var atributos = 'numeroCheckBox=' + boxName;

    $.ajax({
        async: false,
        url: "ServletMarcarPartido",
        data: atributos,
//                            dataType: "json",
        beforeSend: function(objeto) {
            //     alert("me voy a ejecutar.");
        },
        success: function(datos) {
            //    alert("Valor devuelto : " + datos);
        },
        error: function(objeto, mensaje, otroobj) {
            alert(mensaje);
        }});
}