package main.kotlin.engine

data class Order (
    val type: OrderType, // Buy or sell
    val ticker: String,  // Stock symbol/name
    var quantity: Int,   // Number of shares
    val price: Double,   // Order price
    val timeStamp: Long = System.nanoTime()  // Unique timestamp for ordering
)

enum class OrderType{
    BUY, SELL
}