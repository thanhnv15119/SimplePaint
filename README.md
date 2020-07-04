# Simple Console Paint

This is a simple console Paint have few function:

|Command 		    |Description |
|------------------|-------------------------------------------------------------|
|C w h          | Create a new canvas surface of width w and height h.|
|L x1 y1 x2 y2  | Create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.|
|R x1 y1 x2 y2  | Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.|
|B x y c        | Fill the entire area connected to (x,y) with "colour" c. The behaviour of this is the same as that of the "bucket fill" tool in paint programs.|
|Q               |Quit the program.|

## Config

Config in AppConstant file:

|Property 		    |Description |
|------------------|-------------------------------------------------------------|
|EDGE_CHARACTER          | Character fill lines and rectangle edges.|
|HORIZONTAL_EDGE_CHARACTER  | Top and bottom edges of canvas fill with this char property.|
|VERTICAL_EDGE_CHARACTER  | Side edges of canvas fill with this char property.|


## Example 

  
  ````
enter command: C 20 4
  -----------------------
  |                    |
  |                    |
  |                    |
  |                    |
  -----------------------
  enter command: L 1 1 5 1
  -----------------------
  |xxxxx               |
  |                    |
  |                    |
  |                    |
  -----------------------
  enter command: L 5 1 5 4
  -----------------------
  |xxxxx               |
  |    x               |
  |    x               |
  |    x               |
  -----------------------
  enter command: R 14 1 20 3
  Error Syntax: Do you mean R x1 y1 x2 y2 command?
  enter command: R 14 1 20 3
  -----------------------
  |xxxxx        xxxxxxx|
  |    x        x     x|
  |    x        xxxxxxx|
  |    x               |
  -----------------------
  -----------------------
  |xxxxx        xxxxxxx|
  |    x        x     x|
  |    x        xxxxxxx|
  |    x               |
  -----------------------
  
  enter command: B 20 4 c
-----------------------
  |xxxxxccccccccxxxxxxx|
  |    xccccccccx     x|
  |    xccccccccxxxxxxx|
  |    xccccccccccccccc|
  -----------------------
  ````
  ## Build Environment
  
  + Java version 1.8.
  + Junit 4.12 for test.
  + Intellij IDE.

