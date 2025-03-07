# OnymosIncSolution

Stock Trading Engine
Overview
This project implements a basic stock trading engine that matches Buy and Sell orders. The engine adds orders to an order book and matches them based on price and quantity.

Files
Order.kt: Defines the Order class and OrderType enum.
OrderBook.kt: Manages buy and sell orders.
TradingEngine.kt: Matches buy and sell orders.
App.kt: Main file to test the engine with sample orders.


How to Run
Clone this repository:
git clone https://github.com/yourusername/StockTradingEngine.git
cd StockTradingEngine
Build and run the project:
./gradlew run
This will add orders and match them, then print the order book.

Example Output

Current Buy Orders:
BUY Onymos - 200 @ 152.0
BUY Onymos - 100 @ 150.0

Current Sell Orders:
SELL Onymos - 50 @ 145.0
SELL Onymos - 60 @ 148.0
MATCHED: 50 shares of Onymos at 145.0


Design and Approach
Order Matching: When a buy order’s price is greater than or equal to the lowest sell order's price, they are matched and removed from the order book.
Sorting: Orders are sorted to facilitate quick matching:
Buy orders are sorted in descending order by price (highest first).
Sell orders are sorted in ascending order by price (lowest first).
Efficiency: The matching algorithm operates with O(n) time complexity where n is the number of orders in the book.
Assumptions
Orders are matched as soon as a valid match (buy price ≥ sell price) is found.
Matched orders are removed from the order book.
The order book can handle multiple orders for the same stock ticker at different prices.
