/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var Script_Uno = {
    /*Makes the AJAX calll (synchronous) to load a Student Data*/
    cargarDatosTorta: function () {

        var datosPie = [];
        $.ajax({
            async: false,
            url: "Grafico_Uno",
            dataType: "json",
            success: function (resultadoJsonData) {

                $.each(resultadoJsonData, function (index, aResultado) {
                    datosPie = [
                        {y: aResultado.resultado5, label: ''+aResultado.nombre5},
                        {y: aResultado.resultado4, label: ''+aResultado.nombre4},
                        {y: aResultado.resultado3, label: ''+aResultado.nombre3},
                        {y: aResultado.resultado2, label: ''+aResultado.nombre2},
                        {y: aResultado.resultado1, label: ''+aResultado.nombre1}
                    ];
                });
            }
        });
        return datosPie;
    },
    /*Renders the Chart on a canvas and returns the reference to chart*/
    graficoTorta: function (data) {

        var context2D = document.getElementById("canvas").getContext("2d"),
                myPie = new Chart(context2D).
                Pie(data, {
                    scaleShowLabels: false,
                    pointLabelFontSize: 10,
                    animationSteps: 250, //cantidad de pasos en la animacion
                    segmentShowStroke: false, //linea blanca entre las tortas
                    animateRotate: true//animacion de rotacion al crear
                });
        return myPie;
    },
    /*Inicializar chart*/
    initPieChart: function () {

        var data = Script_Uno.cargarDatosTorta();

        pieChartObj = Script_Uno.graficoTorta(data);

    }
};