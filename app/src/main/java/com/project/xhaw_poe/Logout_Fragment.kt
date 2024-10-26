package com.project.xhaw_poe

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class Logout_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_logout_, container, false)

        // Initialize buttons
        val yes: Button = view.findViewById(R.id.button5)
        val no: Button = view.findViewById(R.id.button6)

        // Set up click listener for the Yes button to exit the app
        yes.setOnClickListener {
            activity?.finishAffinity()
        }

        no.setOnClickListener {
            val intent = Intent(activity, MainActivity2::class.java)
            startActivity(intent)
        }



        return view
    }
}
