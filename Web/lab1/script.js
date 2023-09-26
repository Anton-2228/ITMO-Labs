function start() {
    var multiplier = 100;

    var graph = document.getElementById("graph");
    ctx = graph.getContext("2d");
    ctx.lineWidth = 4;
    ctx.strokeRect(0, 0, graph.width, graph.height);
    ctx.lineWidth = 1;

    ctx.beginPath();
    ctx.moveTo(graph.width/2-10, 10);
    ctx.lineTo(graph.width/2, 0);
    ctx.lineTo(graph.width/2+10,10);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(graph.width-10, graph.height/2-10);
    ctx.lineTo(graph.width, graph.height/2);
    ctx.lineTo(graph.width-10,graph.height/2+10);
    ctx.stroke();

    ctx.font = "24px Arial";
    ctx.fillText("x", graph.width/2-30, 20);
    ctx.fillText("y", graph.width-20, graph.height/2+30);

    ctx.beginPath();
    ctx.moveTo(graph.width/2+multiplier*2, graph.height/2);
    ctx.arc(graph.width/2, graph.height/2, multiplier*2, 0, -Math.PI/2, anticlockwise=true);
    ctx.lineTo(graph.width/2-multiplier*2, graph.height/2-multiplier*2);
    ctx.lineTo(graph.width/2-multiplier*2, graph.height/2);
    ctx.lineTo(graph.width/2-multiplier, graph.height/2)
    ctx.lineTo(graph.width/2, graph.height/2+multiplier);
    ctx.lineTo(graph.width/2, graph.height/2);
    ctx.fillStyle = "rgb(255,165,0)";
    ctx.fill();
    ctx.stroke();

    ctx.strokeRect(0, graph.height/2, graph.width, graph.height/2);
    ctx.strokeRect(graph.width/2, 0, graph.width/2, graph.height);

    ctx.font = "15px Arial";
    ctx.fillStyle = "black";
    ctx.fillText("R/2", graph.width/2+multiplier, graph.height/2-10);
    ctx.fillText("R", graph.width/2+multiplier*2, graph.height/2-10);

    ctx.fillText("-R/2", graph.width/2-multiplier, graph.height/2-10);
    ctx.fillText("-R", graph.width/2-multiplier*2, graph.height/2-10);


    ctx.fillText("R/2", graph.width/2+10, graph.height/2-multiplier);
    ctx.fillText("R", graph.width/2+10, graph.height/2-multiplier*2);


    ctx.fillText("-R/2", graph.width/2+10, graph.height/2+multiplier);
    ctx.fillText("-R", graph.width/2+10, graph.height/2+multiplier*2);
    getTable();
}

function validateY() {
    var yVal = parseFloat($("#y").val());
    console.log(yVal);
    var yError = $("#y_error");
    if (Number.isNaN(yVal)) {
        yError.text("Значение должно быть числом");
    } else if (yVal < -3 || yVal > 5) {
        yError.text("Значение должно быть -3 <= x <= 5");
    } else {
        yError.text("");
        submitValues();
    }
}

function submitValues() {
    $.ajax({
        url: './validate.php',
        method: 'post',
        data: $("#form").serialize(),
        dataType: 'html',
        success: function(data) {
            $("#cellResTable").html(data);
        }
    });
}

function getTable() {
    $.ajax({
        url: './getTable.php',
        method: 'post',
        dataType: 'html',
        success: function(data) {
            $("#cellResTable").html(data);
        }
    });
}