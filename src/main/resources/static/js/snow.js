(function() {
  function snow(left, height, src) {
    var div = document.createElement("div");
    var img = document.createElement("img");
    div.appendChild(img);
    img.className = "roll";
    img.src = src;
    img.style.width = "30px";
    img.style.height = "20px";
    div.style.left = left + "px";
    div.style.height = height + "px";
    div.className = "div";
    document.getElementById("snowzone").appendChild(div);
    setTimeout(function() {
      document.getElementById("snowzone").removeChild(div);
      // console.log(window.innerHeight);
    }, 100000);
  }
  setInterval(function() {
    var left = Math.random() * window.innerWidth;
    var height = Math.random() * window.innerHeight;
    var src = "../images/q2.png";//" + Math.floor(Math.random() * 11+ 1) + "
    snow(left, height, src);
  }, 500);
})();