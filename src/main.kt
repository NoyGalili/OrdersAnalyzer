import java.math.BigDecimal
import java.time.DayOfWeek

import java.time.LocalDateTime
import java.time.Month
import java.util.*

class OrdersAnalyzer {

    data class Order(val orderId: Int, val creationDate: LocalDateTime, val orderLines: List<OrderLine>)

    data class OrderLine(val productId: Int, val name: String, val quantity: Int, val unitPrice: BigDecimal)

    fun totalDailySales(orders: List<Order>): Map<DayOfWeek, Int> {

        val quantityMap: MutableMap<DayOfWeek, Int> = hashMapOf();

        orders.forEach { order ->
            order.orderLines.forEach { orderLine ->
                quantityMap[order.creationDate.dayOfWeek] =
                    quantityMap.getOrDefault(order.creationDate.dayOfWeek, 0) + orderLine.quantity;
            }
        }
        return quantityMap;
    }
}
