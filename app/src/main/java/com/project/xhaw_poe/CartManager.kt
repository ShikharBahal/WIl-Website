package com.project.xhaw_poe  // Ensure this matches your package structure

object CartManager {
    private val cartItems = mutableListOf<CartItem>()
    private var totalAmount = 0.0

    fun addToCart(item: CartItem) {
        cartItems.add(item)
        totalAmount += item.price
    }

    fun removeFromCart(item: CartItem) {
        if (cartItems.remove(item)) {
            totalAmount -= item.price
        }
    }

    fun getCartItems(): List<CartItem> {
        return cartItems
    }

    fun getTotalAmountWithoutDiscount(): Double {
        return totalAmount
    }

    fun getDiscountAmount(): Double {
        val itemCount = cartItems.size
        return when {
            itemCount == 2 -> totalAmount * 0.05
            itemCount == 3 -> totalAmount * 0.10
            itemCount > 3 -> totalAmount * 0.15
            else -> 0.0
        }
    }

    fun getTotalAmount(): Double {
        return totalAmount - getDiscountAmount()
    }
}


// Data class representing a cart item
data class CartItem(val name: String, val price: Double)
