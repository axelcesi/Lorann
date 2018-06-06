
<H1>LORANN</H1>

#THIS IS THE README.MD FILE FOR THE LORANN PROJECT, PLEASE READ IT ENTIRELY.

<H2>CONTRIBUTORS</H2>
AIGRET Nathanaël - nathanael.aigret@viacesi.fr <br>
DE CASTRO Axel - axel.decastro@viacesi.fr <br>
DOITTEE Anthime - anthime.doittee@viacesi.fr <br>
JASSERRAND Maxime - maxime.jasserand@viacesi.fr <br>

<H2>THE GAME</H2>

This project's main purpose was to re-program the abandonware Lorann, developped by Novasoft and produced by Loriciel in 1985. Lorann is an arcade game, where you control a character whose goal is to escape a crypt guarded by four monsters using is mighty spell. He needs to collect the blue orb to open the door and can collect gold purses on his way as treasure.

The Project is programmed using tbhe JAVA language, and using the MAVEN MVC architecture. All dependencies and libraires needed are already included in this project. If you need any documention, look in the target directory of each module, it is generated using the JavaDoc Plugin. At this path you can also find our Test Report and JXR report. Le Über Jar is located in the main/target module. But for some obscure reason it doesn't work. So you'll have to launch it from any IDE such as Eclipse Oxygen for example.

NB : If it stills doesn't work, try to transform cyclic dependencies from errors to warning, it helps sometimes.

<H2>HOW TO PLAY</H2>

You can go UP and DOWN, RIGHT and LEFT, and in diagonals using the ZQSD keys. Diagonals use different keys, AEWC, that stand respectively for UpLeft, UpRight, DownLeft and DownRight. Cast your spell using the LEFT CTRL key. Be careful you only have one to kill a monster, but don't worry, you can pick it up.

Kill monsters using your spell, collect purses to increase your gold, pick up the blue crystal orb and escape using the door. Currently there are only 6 levels in our game so far, you will need to change the STATIC INT LEVEL variable from 1 to 6 in the Model Class from the Model Module.

<H2>Database</H2>

The game levels are stored in a database. If you want to have the database in order to play, simply create a Database named "lorann" then import the LORANN.SQL script featured in the project. It should create all the tables with the DATA as well as the procedure.

<H3>ALL RIGHT RESERVED</H3>

If you have any question, please email Nathanaël AIGRET via his email address featured above.
