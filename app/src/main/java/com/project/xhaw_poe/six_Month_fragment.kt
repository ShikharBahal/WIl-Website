package com.project.xhaw_poe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class six_Month_fragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_six_month, container, false)

        val firstaid = rootView.findViewById<ImageView>(R.id.imageView15)
        val landscaping = rootView.findViewById<ImageView>(R.id.imageView14)
        val lifeskills = rootView.findViewById<ImageView>(R.id.imageView17)
        val sewing = rootView.findViewById<ImageView>(R.id.imageView2)

        firstaid.setOnClickListener {
            val intent = Intent(activity, FirstAid::class.java)
            startActivity(intent)
        }

        landscaping.setOnClickListener {
            val intent = Intent(activity, Landscaping::class.java)
            startActivity(intent)
        }

        lifeskills.setOnClickListener {
            val intent = Intent(activity, LifeSkills::class.java)
            startActivity(intent)
        }

        sewing.setOnClickListener {
            val intent = Intent(activity, Sewing::class.java)
            startActivity(intent)
        }


        return rootView
    }
}
