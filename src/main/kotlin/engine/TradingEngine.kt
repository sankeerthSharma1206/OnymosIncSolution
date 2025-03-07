package main.kotlin.engine

class TradingEngine(private val orderBook: OrderBook){
    fun addOrder(order: Order){
        orderBook.addOrder(order)
        matchOrders()
    }

    private fun matchOrders() {
        val buyOrders = orderBook.getBuyOrders().toMutableList()
        val sellOrders = orderBook.getSellOrders().toMutableList()

        var i=0
        var j=0

        while ( i < buyOrders.size && j < sellOrders.size){
            val buyOrder = buyOrders[i]
            val sellOrder = sellOrders[j]

            if (buyOrder.price >= sellOrder.price){
                val matchedQuantity = minOf(buyOrder.quantity, sellOrder.quantity)

                println("MATCHED: $matchedQuantity shares of ${buyOrder.ticker} at ${sellOrder.price}")

                //Reduce quantity or remove order if fully matched
                buyOrder.quantity -= matchedQuantity
                sellOrder.quantity -= matchedQuantity

                if (buyOrder.quantity == 0) i++
                if (sellOrder.quantity == 0) j++
            } else{
                break
            }
        }
        orderBook.clearCompletedOrders()
    }

}