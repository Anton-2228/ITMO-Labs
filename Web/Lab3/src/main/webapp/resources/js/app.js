  function moveHands() {
      with(new Date()) {
          if ((getHours()*24*60 + getMinutes()*60 + getSeconds()) % 7 === 0) {
              h = 30 * (getHours() % 12 + getMinutes() / 60);
              m = 6 * getMinutes();
              s = 6 * getSeconds();
              document.getElementById('seconds').style.cssText = "-webkit-transform:rotate(" + s + "deg);";
              document.getElementById('minutes').style.cssText = "-webkit-transform:rotate(" + m + "deg);";
              document.getElementById('hours').style.cssText = "-webkit-transform:rotate(" + h + "deg);";
          }

          let time = document.getElementById("time");
          time.innerHTML = getHours() + ":" + getMinutes() + ":" + getSeconds();

          setTimeout(moveHands, 1000);
      }
  }

  window.onload = moveHands;
