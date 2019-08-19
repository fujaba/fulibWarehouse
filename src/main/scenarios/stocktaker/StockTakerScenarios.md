
# StockTaker for books. 

## Basic elements. 

There is a Storage with name SE-Store. 

There is a Product with id book-4004, book-5005, beer-1 
and with name "Story Driven Modeling", "Java is also an Island", Veltins
and with items 1, 1, 24. 

There is a Board with id b-r1-c1 and b-r1-c2.

SE-Store has boards and is store of b-r1-c1 and b-r1-c2.
SE-Store has products and is store of book-4004, book-5005, beer-1.
B-r1-c1 has products and is board of book-4004, book-5005.
B-r1-c2 has products beer-1.

Xavier is a Person with job hiwi. 

![SE-Store](objects.svg)


## GUI

There are Content with id name-in, pass-in
and with description "input name?", "input password?".
There is a Content with id login-button and with description "button login"
and with action "do-login pal-in product-in items-in Scan".

There is a Element with id product-code, product-name, product-items, product-board, del-button and 
with text "book-4004", "Story Driven Modeling", "1", "b-r1-c1", "button Del". 
Del-button has action "del-log-entry".
There is a Content with id log-line1 and with elements product-code, product-name, product-items, product-board, del-button.

There is a Page with id login-page 
and with description "Login | button Scan | button Log"
and with content name-in, pass-in, login-button.

There is a Stock-App with id stock-taker 
and with description "Stock Taker"
and with content login-page 
and with user unknown.


![stock-taker](stock01.html)


## Controller

Stock-taker has storage SE-Store. 


## Prototype

### builder

We call find-board on stock-taker with board-id "b-r1-c1". 
Find-board takes board b-r1-c1 from boards of storage of stock-taker 
and as id of board is board-id, find-board answers with board.
Find-board creates a Board new-board with id board-id. 
Find-board writes new-board into boards of storage of stock-taker.
Find-board answers with new-board. 

### gui

We call login on stock-taker.
login creates a Page with id login-screen 
and with description "Login | button Scan | button Log".
login writes login-screen into content of stock-taker.
login creates a Content with id login-in, password-in, login-button-in
and with description "input user?", "input password?", "button login".
login writes login-in, password-in, login-button-in into content of login-screen. 
login writes "runLogin login-in password-in scan" into action of login-button-in.

We call run-login on stock taker with login-name "Albert" and with password "geheim". 
Run-login writes "Albert's Stock Taker" into description of stock taker. 
Run-login writes login-name into user of stock taker. 

We call scan on stock-taker.
Scan creates a Content with id location-in, product-code-in, items-in, scan-button 
and with description 
  "input location bar code",
  "input product bar code?", 
  "input number of items?",
  "button Done".
Scan writes "run-scan location-in product-code-in items-in log" into action of scan-button.   
Scan creates a Page with id scan-screen 
and with description "button Login | Scan | button Log"
and with content location-in, product-code-in, items-in, scan-button.
Scan writes scan-screen into content of stock-taker.

We call run-scan on stock-taker with location f1, with product p1, with items 42.
Run-scan calls find-board with board-id f1.

We call init on stock-taker.
Init creates a Storage theStore with name "SE-Store".
Init writes theStore into storage of stock-taker.
Init writes "stock-taker" into id of stock-taker.
Init writes "Stock Taker" into description of stock-taker. 
Init calls login.

