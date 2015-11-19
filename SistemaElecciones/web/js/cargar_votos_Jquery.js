function funcion_cargar_voto(idVotante) {
//                        alert("algo");
//                        var atributos = 'mesa=' + numTable + '&numeroCheckBox=' + boxName;
    var atributos = 'idVotante=' + idVotante;
    $.ajax({
        async: false,
        url: "MarcarVoto",
        data: atributos,
//                            dataType: "json",
        beforeSend: function (objeto) {
            //     alert("me voy a ejecutar.");
        },
        success: function (datos) {
            //    alert("Valor devuelto : " + datos);
        },
        error: function (objeto, mensaje, otroobj) {
            alert(mensaje);
        }});
}
function funcion_marcar_partido(idVotante) {
//                        alert("algo");
//                        var atributos = 'mesa=' + numTable + '&numeroCheckBox=' + boxName;
    var atributos = 'idVotante=' + idVotante;

    $.ajax({
        async: false,
        url: "MarcarPartido",
        data: atributos,
//                            dataType: "json",
        beforeSend: function (objeto) {
            //     alert("me voy a ejecutar.");
        },
        success: function (datos) {
            //    alert("Valor devuelto : " + datos);
        },
        error: function (objeto, mensaje, otroobj) {
            alert(mensaje);
        }});
}