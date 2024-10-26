package com.example.xhaw_poe

import android.animation.LayoutTransition
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LifeSkills : AppCompatActivity() {
    private lateinit var detailsText: TextView
    private lateinit var layout: LinearLayout
    private lateinit var expand: CardView
    private var isInCart = false // Track whether the item is in the cart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_skills)

        val backbut = findViewById<ImageView>(R.id.imageView3)
        val pay = findViewById<Button>(R.id.button)
        val cartBtn: ImageView = findViewById(R.id.cartbtn)
        val productName = "Life Skills"
        val productPrice = 1500.00

        // Check if the item is in the cart
        isInCart = CartManager.getCartItems().any { it.name == productName && it.price == productPrice }
        updateCartButton(cartBtn, isInCart)

        cartBtn.setOnClickListener {
            if (isInCart) {
                // Remove the item from the cart
                CartManager.removeFromCart(CartItem(productName, productPrice))
                Toast.makeText(this, "$productName removed from cart", Toast.LENGTH_SHORT).show()
                updateCartButton(cartBtn, false) // Update button to indicate item can be added
            } else {
                // Add the item to the cart
                CartManager.addToCart(CartItem(productName, productPrice))
                Toast.makeText(this, "$productName added to cart", Toast.LENGTH_SHORT).show()
                updateCartButton(cartBtn, true) // Update button to indicate item can be removed
            }
            isInCart = !isInCart // Toggle the state
        }

        pay.setOnClickListener {
            val intent = Intent(this, payment::class.java)
            startActivity(intent)
        }

        backbut.setOnClickListener {
            onBackPressed()
        }

        detailsText = findViewById(R.id.detailsText)
        layout = findViewById(R.id.layouts)
        expand = findViewById(R.id.expandable)

        // Enables layout transition for changes
        layout.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        // visibility of detailsText on click
        expand.setOnClickListener {
            val visibility = if (detailsText.visibility == View.GONE) View.VISIBLE else View.GONE
            detailsText.visibility = visibility
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun updateCartButton(cartBtn: ImageView, isInCart: Boolean) {
        if (isInCart) {
            cartBtn.setImageResource(R.drawable.remove_from_cart) // Change to a remove icon
        } else {
            cartBtn.setImageResource(R.drawable.shopping_cart) // Change to an add icon
        }
    }
}
