package com.example.xhaw_poe

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xhaw_poe.CartManager
import com.example.xhaw_poe.CartAdapter

class Cart_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart_, container, false)

        val payButton: Button = view.findViewById(R.id.button3)

        payButton.setOnClickListener {
            val intent = Intent(activity, payment::class.java)
            startActivity(intent)
        }

        // Find and update the total price TextView
        val totalTextView: TextView = view.findViewById(R.id.textView7)
        val discountTextView: TextView =
            view.findViewById(R.id.textViewDiscount)  // Discount text view
        val finalAmountTextView: TextView =
            view.findViewById(R.id.textViewFinalAmount)  // Final amount text view

        // Calculate total, discount, and final amount
        val totalAmount = CartManager.getTotalAmountWithoutDiscount()
        val discount = CartManager.getDiscountAmount()
        val finalAmount = CartManager.getTotalAmount()

        totalTextView.text = "R${totalAmount}"
        discountTextView.text = "R-${discount}"  // Display discount value
        finalAmountTextView.text = "R${finalAmount}"  // Display final amount after discount

        // Find and set up the RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CartAdapter(CartManager.getCartItems())

        return view
    }
}