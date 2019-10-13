

function init() {
  var c=document.getElementById("myCanvas");
  var ctx = c.getContext("2d");

  var image = new Image();

  // Images in JavaSCript get loaded asynchronously.
  // If we need to do something after an image has loaded, we'll need to
  //  use this function below
  image.onload = function() {
    console.log("Loaded Image");
    // do something after the image is loaded
    // doSomething();
    ctx.drawImage(image, 0, 0, c.width, c.height);
    // ctx.fillStyle = "blue";
    // ctx.fillText("Hello World", 60, 30);

  }

  image.src = "images/vintage.jpg";
}
