var context;
var queue;

// Width and Height of the Canvas
var _W = 1024;
var _H = 768;

// Position of the Mouse
var mouseXPosition;
var mouseYPosition;

var batImage;
var stage;
var animation;
var disappearAnimation;
var spriteSheet;

// Position of the bats
var enemyXPos=100;
var enemyYPos=100;

// Speed of the bats
var enemyXSpeed = 1.5;
var enemyYSpeed = 1.75;

// Game Score
var score = 0;

var scoreText;
var gameTimer;
var gameTime = 0;
var timerText;

window.onload = function()
{
    // Setup Canvas
    canvas = document.getElementById('myCanvas');
    context = canvas.getContext('2d');
    context.canvas.width = _W;
    context.canvas.height = _H;
    stage = new createjs.Stage("myCanvas");

    // Setup Asset Queue and load sounds
    queue = new createjs.LoadQueue(false);
    queue.installPlugin(createjs.Sound);
    queue.on("complete", queueLoaded, this);
    createjs.Sound.alternateExtensions = ["ogg"];

    // Create a load manifest of all assets
    queue.loadManifest([
        {id: 'backgroundImage', src: 'assets/background2.png'},
        {id: 'crossHair', src: 'assets/crosshair.png'},
        {id: 'shot', src: 'assets/shot.ogg'},
        {id: 'background', src: 'assets/bgMusic.mp3'},
        {id: 'gameOverSound', src: 'assets/gameOver.mp3'},
        {id: 'tick', src: 'assets/tick.mp3'},
        {id: 'vanishSound', src: 'assets/vanish.mp3'},
        {id: 'batSpritesheet', src: 'assets/batSpritesheet.png'},
        {id: 'batVanish', src: 'assets/batVanish.png'},
    ]);
    queue.load();

    // Create a timer that updates once a second
    gameTimer = setInterval(updateTime, 1000);

}

function queueLoaded(event)
{
    // Add background image
    var backgroundImage = new createjs.Bitmap(queue.getResult("backgroundImage"))
    stage.addChild(backgroundImage);

    // Add Score
    scoreText = new createjs.Text("1UP: " + score.toString(), "36px Arial", "#FFF");
    scoreText.x = 10;
    scoreText.y = 10;
    stage.addChild(scoreText);

    // Add Timer
    timerText = new createjs.Text("Time: " + gameTime.toString(), "36px Arial", "#FFF");
    timerText.x = 800;
    timerText.y = 10;
    stage.addChild(timerText);

    // Play background sound
    createjs.Sound.play("background", {loop: -1});

    // Create bat spritesheet
    spriteSheet = new createjs.SpriteSheet({
        "images": [queue.getResult('batSpritesheet')],
        "frames": {"width": 198, "height": 117},
        "animations": { "flap": [0,4] }
    });

    // Create bat disappear spritesheet
    batVanishSpriteSheet = new createjs.SpriteSheet({
    	"images": [queue.getResult('batVanish')],
    	"frames": {"width": 198, "height" : 148},
    	"animations": {"vanish": [0,7, false,1 ] }
    });

    // Create bat sprite
    createEnemy();

    // Add ticker
    createjs.Ticker.setFPS(15);
    createjs.Ticker.addEventListener('tick', stage);
    createjs.Ticker.addEventListener('tick', tickEvent);

``    // Set up events AFTER the game is loaded
   // window.onmousemove = handleMouseMove;
    window.onmousedown = handleMouseDown;
}

function createEnemy()
{
	animation = new createjs.Sprite(spriteSheet, "flap");
    animation.regX = 99;
    animation.regY = 58;
    animation.x = enemyXPos;
    animation.y = enemyYPos;
    animation.gotoAndPlay("flap");
    stage.addChildAt(animation,1);
}

function batVanish()
{
  disappearAnimation = new createjs.Sprite(batVanishSpriteSheet, "vanish");
  disappearAnimation.regX = 99;
  disappearAnimation.regY = 58;
  disappearAnimation.x = enemyXPos;
  disappearAnimation.y = enemyYPos;
  disappearAnimation.gotoAndPlay("vanish");
  stage.addChild(disappearAnimation);
}

function tickEvent()
{
	//Make sure enemy bat is within game boundaries and move enemy Bat
	if(enemyXPos < _W && enemyXPos > 0)
	{
		enemyXPos += enemyXSpeed;
	} else
	{
		enemyXSpeed = enemyXSpeed * (-1);
		enemyXPos += enemyXSpeed;
	}
	if(enemyYPos < _H && enemyYPos > 0)
	{
		enemyYPos += enemyYSpeed;
	} else
	{
		enemyYSpeed = enemyYSpeed * (-1);
		enemyYPos += enemyYSpeed;
	}

	animation.x = enemyXPos;
	animation.y = enemyYPos;


}

function handleMouseDown(event)
{
    //Display CrossHair
    crossHair = new createjs.Bitmap(queue.getResult("crossHair"));
    crossHair.x = event.clientX-45;
    crossHair.y = event.clientY-45;
    stage.addChild(crossHair);
    createjs.Tween.get(crossHair).to({alpha: 0},1000);

    //Play spell sound
    createjs.Sound.play("spell");

    //Increase speed of enemy slightly
    enemyXSpeed *= 1.05;
    enemyYSpeed *= 1.06;

    //Obtain Shot position
    var shotX = Math.round(event.clientX);
    var shotY = Math.round(event.clientY);
    var spriteX = Math.round(animation.x);
    var spriteY = Math.round(animation.y);

    // Compute the X and Y distance using absolte value
    var distX = Math.abs(shotX - spriteX);
    var distY = Math.abs(shotY - spriteY);

    // Anywhere in the body or head is a hit - but not the wings
    if(distX < 30 && distY < 59 )
    {
    	//Hit
    	stage.removeChild(animation);
    	batVanish();
    	score += 100;
    	scoreText.text = "1UP: " + score.toString();
    	createjs.Sound.play("vanishSound");

      //Make it harder next time
    	enemyYSpeed *= 1.25;
    	enemyXSpeed *= 1.3;

    	//Create new enemy
    	var timeToCreate = Math.floor((Math.random()*3500)+1);
	    setTimeout(createEnemy,timeToCreate);

    } else
    {
    	//Miss
    	score -= 10;
    	scoreText.text = "1UP: " + score.toString();

    }
}

function updateTime()
{
	gameTime += 1;
	if(gameTime > 60)
	{
		//End Game and Clean up
		timerText.text = "GAME OVER";
		stage.removeChild(animation);
		stage.removeChild(crossHair);
        createjs.Sound.removeSound("background");
        var si =createjs.Sound.play("gameOverSound");
		clearInterval(gameTimer);
	}
	else
	{
		timerText.text = "Time: " + gameTime
    createjs.Sound.play("tick");
	}
}
