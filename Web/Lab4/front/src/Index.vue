<template>
  <div id="header">
    <div>
      <p>Группа: P3206</p>
    </div>
    <div>
      <p id="name">Зинченко Антон Андреевич</p>
    </div>
    <div>
      <p>Вариант: 1918</p>
    </div>
  </div>
  <div id="main">
    <div>
      <canvas height="450" width="450" id="graph"></canvas>
    </div>
    <div class="form">
      <div class="field">
        <p>Координата X:</p>
        <div id="x-block">
          <label for="x-5">-5<br />
            <input type="radio" name="x" value="-5" id="x-5"></label>
          <label for="x-4">-4<br />
            <input type="radio" name="x" value="-4" id="x-4"></label>
          <label for="x-3">-3<br />
            <input type="radio" name="x" value="-3" id="x-3"></label>
          <label for="x-2">-2<br />
            <input type="radio" name="x" value="-2" id="x-2"></label>
          <label for="x-1">-1<br />
            <input type="radio" name="x" value="-1" id="x-1"></label>
          <label for="x0">0<br />
            <input type="radio" name="x" value="0" id="x0" checked="checked"></label>
          <label for="x1">1<br />
            <input type="radio" name="x" value="1" id="x1"></label>
          <label for="x2">2<br />
            <input type="radio" name="x" value="2" id="x2"></label>
          <label for="x3">3<br />
            <input type="radio" name="x" value="3" id="x3"></label>
        </div>
      </div>
      <div class="field">
        <p>Координата Y:</p>
        <input type="text" maxlength="10" name="y" id="y" value="0" placeholder="Введите значение от -5 до 5">
        <p id="y_error"></p>
      </div>
      <div class="field">
        <p>Значение R:</p>
        <div id="r-block">
          <label for="r1">1<br />
            <input type="radio" name="r" value="1" id="r1" checked></label>
          <label for="r2">2<br />
            <input type="radio" name="r" value="2" id="r2"></label>
          <label for="r3">3<br />
            <input type="radio" name="r" value="3" id="r3"></label>
        </div>
      </div>
      <div>
        <p id="serverError"></p>
      </div>
      <div class="buts">
        <button id="submit" @click="validateValues()">Отправить</button>
        <button id="toStart" @click="toStart()">Go to start</button>
      </div>
    </div>
  </div>
  <div id="cellResTable">
    <table id="resTable" >
      <tr>
        <td><p>R</p></td>
        <td><p>X</p></td>
        <td><p>Y</p></td>
        <td><p>Текущее время</p></td>
        <td><p>Время выполнения</p></td>
        <td><p>Результат</p></td>
        <td><p>Владелец</p></td>
      </tr>
    </table>
  </div>
</template>


<script>
import router from "@/router/index.js";
var MD5 = function(d){var r = M(V(Y(X(d),8*d.length)));return r.toLowerCase()};function M(d){for(var _,m="0123456789ABCDEF",f="",r=0;r<d.length;r++)_=d.charCodeAt(r),f+=m.charAt(_>>>4&15)+m.charAt(15&_);return f}function X(d){for(var _=Array(d.length>>2),m=0;m<_.length;m++)_[m]=0;for(m=0;m<8*d.length;m+=8)_[m>>5]|=(255&d.charCodeAt(m/8))<<m%32;return _}function V(d){for(var _="",m=0;m<32*d.length;m+=8)_+=String.fromCharCode(d[m>>5]>>>m%32&255);return _}function Y(d,_){d[_>>5]|=128<<_%32,d[14+(_+64>>>9<<4)]=_;for(var m=1732584193,f=-271733879,r=-1732584194,i=271733878,n=0;n<d.length;n+=16){var h=m,t=f,g=r,e=i;f=md5_ii(f=md5_ii(f=md5_ii(f=md5_ii(f=md5_hh(f=md5_hh(f=md5_hh(f=md5_hh(f=md5_gg(f=md5_gg(f=md5_gg(f=md5_gg(f=md5_ff(f=md5_ff(f=md5_ff(f=md5_ff(f,r=md5_ff(r,i=md5_ff(i,m=md5_ff(m,f,r,i,d[n+0],7,-680876936),f,r,d[n+1],12,-389564586),m,f,d[n+2],17,606105819),i,m,d[n+3],22,-1044525330),r=md5_ff(r,i=md5_ff(i,m=md5_ff(m,f,r,i,d[n+4],7,-176418897),f,r,d[n+5],12,1200080426),m,f,d[n+6],17,-1473231341),i,m,d[n+7],22,-45705983),r=md5_ff(r,i=md5_ff(i,m=md5_ff(m,f,r,i,d[n+8],7,1770035416),f,r,d[n+9],12,-1958414417),m,f,d[n+10],17,-42063),i,m,d[n+11],22,-1990404162),r=md5_ff(r,i=md5_ff(i,m=md5_ff(m,f,r,i,d[n+12],7,1804603682),f,r,d[n+13],12,-40341101),m,f,d[n+14],17,-1502002290),i,m,d[n+15],22,1236535329),r=md5_gg(r,i=md5_gg(i,m=md5_gg(m,f,r,i,d[n+1],5,-165796510),f,r,d[n+6],9,-1069501632),m,f,d[n+11],14,643717713),i,m,d[n+0],20,-373897302),r=md5_gg(r,i=md5_gg(i,m=md5_gg(m,f,r,i,d[n+5],5,-701558691),f,r,d[n+10],9,38016083),m,f,d[n+15],14,-660478335),i,m,d[n+4],20,-405537848),r=md5_gg(r,i=md5_gg(i,m=md5_gg(m,f,r,i,d[n+9],5,568446438),f,r,d[n+14],9,-1019803690),m,f,d[n+3],14,-187363961),i,m,d[n+8],20,1163531501),r=md5_gg(r,i=md5_gg(i,m=md5_gg(m,f,r,i,d[n+13],5,-1444681467),f,r,d[n+2],9,-51403784),m,f,d[n+7],14,1735328473),i,m,d[n+12],20,-1926607734),r=md5_hh(r,i=md5_hh(i,m=md5_hh(m,f,r,i,d[n+5],4,-378558),f,r,d[n+8],11,-2022574463),m,f,d[n+11],16,1839030562),i,m,d[n+14],23,-35309556),r=md5_hh(r,i=md5_hh(i,m=md5_hh(m,f,r,i,d[n+1],4,-1530992060),f,r,d[n+4],11,1272893353),m,f,d[n+7],16,-155497632),i,m,d[n+10],23,-1094730640),r=md5_hh(r,i=md5_hh(i,m=md5_hh(m,f,r,i,d[n+13],4,681279174),f,r,d[n+0],11,-358537222),m,f,d[n+3],16,-722521979),i,m,d[n+6],23,76029189),r=md5_hh(r,i=md5_hh(i,m=md5_hh(m,f,r,i,d[n+9],4,-640364487),f,r,d[n+12],11,-421815835),m,f,d[n+15],16,530742520),i,m,d[n+2],23,-995338651),r=md5_ii(r,i=md5_ii(i,m=md5_ii(m,f,r,i,d[n+0],6,-198630844),f,r,d[n+7],10,1126891415),m,f,d[n+14],15,-1416354905),i,m,d[n+5],21,-57434055),r=md5_ii(r,i=md5_ii(i,m=md5_ii(m,f,r,i,d[n+12],6,1700485571),f,r,d[n+3],10,-1894986606),m,f,d[n+10],15,-1051523),i,m,d[n+1],21,-2054922799),r=md5_ii(r,i=md5_ii(i,m=md5_ii(m,f,r,i,d[n+8],6,1873313359),f,r,d[n+15],10,-30611744),m,f,d[n+6],15,-1560198380),i,m,d[n+13],21,1309151649),r=md5_ii(r,i=md5_ii(i,m=md5_ii(m,f,r,i,d[n+4],6,-145523070),f,r,d[n+11],10,-1120210379),m,f,d[n+2],15,718787259),i,m,d[n+9],21,-343485551),m=safe_add(m,h),f=safe_add(f,t),r=safe_add(r,g),i=safe_add(i,e)}return Array(m,f,r,i)}function md5_cmn(d,_,m,f,r,i){return safe_add(bit_rol(safe_add(safe_add(_,d),safe_add(f,i)),r),m)}function md5_ff(d,_,m,f,r,i,n){return md5_cmn(_&m|~_&f,d,_,r,i,n)}function md5_gg(d,_,m,f,r,i,n){return md5_cmn(_&f|m&~f,d,_,r,i,n)}function md5_hh(d,_,m,f,r,i,n){return md5_cmn(_^m^f,d,_,r,i,n)}function md5_ii(d,_,m,f,r,i,n){return md5_cmn(m^(_|~f),d,_,r,i,n)}function safe_add(d,_){var m=(65535&d)+(65535&_);return(d>>16)+(_>>16)+(m>>16)<<16|65535&m}function bit_rol(d,_){return d<<_|d>>>32-_}


var multiplier = 90;

export default {
  beforeCreate() {
    document.body.className = 'index';
  },
  mounted() {
    let login = localStorage.getItem("login");
    let password = localStorage.getItem("password");
    if (login == null || password == null) {
      router.push({path: '/start', reload: true});
    }
    this.start();
  },
  methods: {
    start() {
    this.listeners();
    this.drawCanvas();
    this.getTable();
    this.drawPoint();
    },
    listeners() {
      let r_select = document.getElementsByName("r");
      let self = this;
      r_select.forEach(e => {
        e.addEventListener('click', {
          handleEvent(object) {
            self.drawCanvas();
            self.drawPoint();
          }
        })
      })

      let graph = document.getElementById("graph");
      graph.addEventListener('click', (e) =>{
        let r = document.querySelector('input[name="r"]:checked').value;
        let x = (e.offsetX - graph.width/2)/multiplier/2*r;
        let y = (graph.height/2 - e.offsetY)/multiplier/2*r;
        console.log(r);
        console.log(x,y,r);
        this.submitValues(x, y, r);
      })
    },
    drawCanvas() {
      let graph = document.getElementById("graph");
      let ctx = graph.getContext("2d");
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
      ctx.moveTo(graph.width/2, graph.height/2 + multiplier);
      ctx.lineTo(graph.width/2 + 2*multiplier, graph.height/2);
      ctx.arc(graph.width/2, graph.height/2, multiplier*2, 0, -Math.PI/2, true);
      ctx.lineTo(graph.width/2, graph.height/2);
      ctx.lineTo(graph.width/2 - 2*multiplier, graph.height/2);
      ctx.lineTo(graph.width/2 - 2*multiplier, graph.height/2 + multiplier);
      ctx.lineTo(graph.width/2, graph.height/2 + multiplier);

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
    },
    validateY(yVal) {
      let y = parseFloat(yVal);
      if (Number.isNaN(y) || y.toString() !== yVal) {
          return "Значение должно быть числом";
      } else if (y < -5 || y > 5) {
          return "Значение должно быть -5 <= x <= 5";
      } else {
          return "";
      }
    },
    validateValues() {
      let yVal = document.getElementById("y").value;
      let yError = document.getElementById("y_error");
      let y_ret = this.validateY(yVal);
      console.log(y_ret);
      if (y_ret === "") {
        let x = document.querySelector('input[name="x"]:checked').value;
        let r = document.querySelector('input[name="r"]:checked').value;
        this.submitValues(x, yVal, r);
      } else {
        yError.innerHTML = y_ret;
      }
    },
    submitValues(x, y, r) {
      console.log(x);
      console.log(y);
      console.log(r);
      let login = localStorage.getItem("login");
      let password = localStorage.getItem("password");
      const article = {x: x, y: y, r: r, login:login, password:password};
      fetch('http://localhost:8080/api/check/point', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          "Access-Control-Allow-Origin": "*"
        },
        body: JSON.stringify(article)
      }).then(res=> {
        if (res.status !== 200) {
          res.text().then(data=>{
            document.getElementById("serverError").innerHTML = data;
          });
        } else {
          document.getElementById("serverError").innerHTML = "";
          this.getTable();
          this.drawPoint();
        }
      });
    },
    getTable() {
      let login = localStorage.getItem("login");
      let password = localStorage.getItem("password");
      const article = {login:login, password:password};
      //console.log(article)
      fetch('http://localhost:8080/api/check/getTable', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          "Access-Control-Allow-Origin": "*"
        },
        body: JSON.stringify(article)
      }).then(res=> {
        if (res.status !== 200 && res.status !== 201) {
          res.text().then(data => {
          });
        } else {
          res.text().then(d => {
            let data = JSON.parse(d);
            let html = "<table>" +
                "<tr><td>R</td><td>X</td><td>Y</td><td>Текущее время</td><td>Время выполнения</td><td>Результат</td><td>Владелец</td></tr>";
            data.forEach(e => {
              let x = Math.round(e.x * 100) / 100;
              let y = Math.round(e.y * 100) / 100;
              let r = Math.round(e.r * 100) / 100;
              html += `<tr><td>${r}</td><td>${x}</td><td>${y}</td><td>${e.time}</td><td>${e.runTime}</td><td>${e.result}</td><td>${e.user.login}</td></tr>`;
            });
            html += "</table>";
            document.getElementById("cellResTable").innerHTML = html;
          })
        }
      });
    },
    drawPoint() {
      let login = localStorage.getItem("login");
      let password = localStorage.getItem("password");
      const article = {login:login, password:password};
      fetch('http://localhost:8080/api/check/getTable', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          "Access-Control-Allow-Origin": "*"
        },
        body: JSON.stringify(article)
      }).then(res=> {
        if (res.status !== 200 && res.status !== 201) {
          res.text().then(data => {
            document.getElementById("serverError").innerHTML = data;
          });
        } else {
          res.text().then(d => {
            let data = JSON.parse(d);
            data.forEach(e => {
              let x = e.x;
              let y = e.y;
              let r = e.r;
              let graph = document.getElementById("graph");
              let ctx = graph.getContext("2d");
              if (r === parseFloat(document.querySelector('input[name="r"]:checked').value)) {
                console.log(parseFloat(document.querySelector('input[name="r"]:checked').value));
                ctx.beginPath();
                ctx.arc(graph.width / 2 + x / r * 2 * multiplier, graph.height / 2 - y / r * 2 * multiplier, 10, 0, Math.PI * 2, true);
                if (e.result === true) {
                  ctx.fillStyle = "rgb(0,0,0)";
                } else {
                  ctx.fillStyle = "rgb(255,255,255)";
                }
                ctx.fill();
              }
            });
            let graph = document.getElementById("graph");
            let ctx = graph.getContext("2d");
            ctx.fillStyle = "rgb(0,0,0)";
          })
        }
      });
    },
    toStart() {
      router.push({path: '/start', reload: true});
    }
  }
}
</script>

<style v-if="true">

body.index, body {
  font-family: monospace, sans-serif;
  margin: 0px;
  padding: 0px;
  background-color: burlywood;
  width: 100%;
}

#app {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100%;
}
#body {
  width: 100%;
}

.form {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
}

.buts {
  display: flex;
  justify-content: center;
}

table:last-child {
  margin-left: auto;
  margin-right: auto;
}

#header {
  width: 80%;
  font-family: monospace, sans-serif;
  display: flex;
  justify-content: space-between;
}

.field {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  width: 100%;
}

td {
  text-align: center;
}

label {
  display: inline-block;
  padding: 0 2px;
  text-align: center;
}
#main {
  width: 80%;
  display: flex;
  justify-content: space-around;
  align-items: center;
}

#x-block {
  margin-left: auto;
  margin-right: auto;
}

#cellResTable > table {
  width: 100%;
  border: 2px solid black;
}

#cellResTable {
  width: 80%;
}
@media screen and (max-width: 1179px) {
  p {
    font-size: 25px;
  }
  #main {
    width: 80%;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    flex-wrap: wrap;
  }

  .form {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-evenly;
    width: 600px;
  }
  button {
    width: 100px;
    height: 40px;
  }
  label {
    font-size: 25px;
  }
}
.field {
  border: 2px solid black;
  border-radius: 30px;
  padding: 10px;
}

#name:hover {
  transform: rotate(360deg);
  transition: 1s;
}

@media (max-width: 743px) {
  #main {
    width: 80%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
    flex-wrap: wrap;
  }
  .field {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    width: 100%;
  }
  .form {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-evenly;
    width: 400px;
  }
}

</style>