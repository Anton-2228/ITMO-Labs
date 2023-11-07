var valueX = 0;
var multiplier = 100;

function start() {
    listeners();
    drawCanvas();
    getTable();
    drawPoint();
}

function drawCanvas() {
    var graph = document.getElementById("graph");
    ctx = graph.getContext("2d");
    ctx.clearRect(0, 0, graph.width, graph.height);
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
    ctx.fillText("y", graph.width/2-30, 20);
    ctx.fillText("x", graph.width-20, graph.height/2+30);

    ctx.beginPath();
    ctx.moveTo(graph.width/2, graph.height/2);
    ctx.lineTo(graph.width/2, graph.height/2 + multiplier);
    ctx.lineTo(graph.width/2 + multiplier*2, graph.height/2 + multiplier);
    ctx.lineTo(graph.width/2 + multiplier*2, graph.height/2);
    ctx.lineTo(graph.width/2 + multiplier, graph.height/2);
    ctx.lineTo(graph.width/2, graph.height/2 - multiplier);
    ctx.lineTo(graph.width/2, graph.height/2 - multiplier*2);
    ctx.arc(graph.width/2, graph.height/2, multiplier*2, -Math.PI/2, -Math.PI, anticlockwise=true);
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
}

function listeners() {
    let elems = document.getElementsByName("x");
    for (let i=0;i<9;i++) {
        let value = elems.item(i).getAttribute("value");
        elems.item(i).addEventListener('click', {
            handleEvent(event) {
                $("#selectedX").text("Выбрано: " + value);
                valueX = parseFloat(value);
            }
        })
    }

    let r_select = document.getElementById("r");
    r_select.addEventListener('click', {
        handleEvent(object) {
            drawCanvas();
            drawPoint();
        }
    })

    let graph = document.getElementById("graph");
    ctx = graph.getContext("2d");
    graph.addEventListener('click', (e) =>{
        let r_all = document.getElementById("r");
        let r = r_all.options[r_all.selectedIndex].value;
        let x = (e.offsetX - graph.width/2)/multiplier/2*r;
        let y = (graph.height/2 - e.offsetY)/multiplier/2*r;
        submitValues(x, y, r);
    })
}

function validateY(yVal) {
    let y = parseFloat(yVal);
    if (Number.isNaN(y) || y.toString() !== yVal) {
        return "Значение должно быть числом";
    } else if (y < -5 || y > 3) {
        return "Значение должно быть -5 <= x <= 3";
    } else {
        return "";
    }
}

function validateValues() {
    let yVal = $("#y").val();
    let yError = $("#y_error");
    let y_ret = validateY(yVal);
    if (y_ret === "") {
        let r_all = document.getElementById("r");
        let r = r_all.options[r_all.selectedIndex].value;
        submitValues(valueX, yVal, r);
    } else {
        yError.text(y_ret);
    }
}

function submitValues(x, y, r) {
    // console.log(typeof x);
    // console.log(typeof y);
    // console.log(typeof r);
    $.ajax({
        url: '/webLab2/controller',
        method: 'get',
        data: {"x": x, "y": y, "r": r, "type": "addHit"},
        dataType: 'text',
        success: [function(data) {
            // console.log(x);
            // console.log(y);
            $("#serverError").text("");
            getTable();
            drawPoint();
        }],
        error: [function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            $("#serverError").html(jqXHR.responseText);
        }]
    });
}

function getTable() {
    $.ajax({
        url: '/webLab2/controller',
        method: 'get',
        data: {"type": "getTable"},
        dataType: 'html',
        success: function(data) {
            if (data !== undefined) {
                $("#cellResTable").html(data);
            }
        }
    });
}

function drawPoint() {
    $.ajax({
        url: '/webLab2/controller',
        method: 'get',
        data: {"type": "getJson"},
        dataType: 'json',
        success: function(data) {
            console.log(data);
            let elems = data["elems"];
            let r_all = document.getElementById("r");
            let cur_r = r_all.options[r_all.selectedIndex].value;
            for (let i=0; i < elems.length; i++) {
                let r = +elems[i][0].replace(",", ".");
                let x = +elems[i][1].replace(",", ".");
                let y = +elems[i][2].replace(",", ".");
                if (cur_r == r) {
                    let graph = document.getElementById("graph");
                    ctx = graph.getContext("2d");
                    ctx.beginPath();
                    console.log(12456);
                    ctx.arc(graph.width/2 + x/r*2*multiplier, graph.height/2 - y/r*2*multiplier, 10, 0, Math.PI * 2, true);
                    ctx.fill();
                }
            }
        }
    });
}
