package com.project.xhaw_poe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class Six_week_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_six_week_, container, false)


        val cookingbut = rootView.findViewById<ImageView>(R.id.imageView15)
        val childminding_but = rootView.findViewById<ImageView>(R.id.imageView14)
        val garden_but = rootView.findViewById<ImageView>(R.id.imageView17)


        cookingbut?.setOnClickListener {
            val intent = Intent(activity, cooking::class.java)
            startActivity(intent)
        }


        childminding_but?.setOnClickListener {
            val intent = Intent(activity, ChildMinding::class.java)
            startActivity(intent)
        }

        garden_but?.setOnClickListener {
            val intent = Intent(activity, Gardening::class.java)
            startActivity(intent)
        }




        return rootView
    }
}
