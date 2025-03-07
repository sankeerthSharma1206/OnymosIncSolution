package main.kotlin

import main.kotlin.engine.Order
import main.kotlin.engine.OrderBook
import main.kotlin.engine.OrderType
import main.kotlin.engine.TradingEngine

fun main(){
    val orderBook = OrderBook()

    val tradingEngine = TradingEngine(orderBook)

    tradingEngine.addOrder(Order(OrderType.BUY, "onymos", 100, 150.0))
    tradingEngine.addOrder(Order(OrderType.SELL, "Onymos", 50, 145.0))
    tradingEngine.addOrder(Order(OrderType.SELL, "Onymos", 60, 148.0))
    tradingEngine.addOrder(Order(OrderType.BUY, "Onymos", 200, 152.0))
    tradingEngine.addOrder(Order(OrderType.SELL, "Onymos", 120, 151.0))
    tradingEngine.addOrder(Order(OrderType.BUY, "Onymos", 50, 153.0))

    orderBook.printOrders()

}