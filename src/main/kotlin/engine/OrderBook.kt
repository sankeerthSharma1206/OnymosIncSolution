package main.kotlin.engine


class OrderBook {
    private val buyOrders = mutableListOf<Order>()
    private val sellOrders = mutableListOf<Order>()


    fun addOrder(order: Order){
         when(order.type){
             OrderType.BUY -> {
                 buyOrders.add(order)
                 buyOrders.sortWith(compareByDescending<Order> { it.price }.thenBy { it.timeStamp })
             }

             OrderType.SELL -> {
                 sellOrders.add(order)
                 sellOrders.sortWith(compareBy<Order>{ it.price}.thenBy { it.timeStamp })
             }
         }
    }

    fun getBuyOrders() : List<Order> = buyOrders.toList()  // Return a copy to prevent the external modification
    fun getSellOrders() : List<Order> = sellOrders.toList()

    fun printOrders(){
        println("\n Current Buy Orders:")
        buyOrders.forEach{
            println("BUY ${it.ticker} - ${it.quantity} @ ${it.price}")
        }

        println("\n Current Sell Orders:")
        buyOrders.forEach{
            println("SELL ${it.ticker} - ${it.quantity} @ ${it.price}")
        }
    }

    fun clearCompletedOrders() {
        buyOrders.removeIf { it.quantity == 0 }
        sellOrders.removeIf { it.quantity == 0 }
    }
}