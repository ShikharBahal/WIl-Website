package com.example.xhaw_poe

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Contact_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contact_, container, false)

        // Get references to the buttons
        val btnCall: Button = view.findViewById(R.id.btnCall)
        val btnEmail: Button = view.findViewById(R.id.btnEmail)
        val btnTwitter: Button = view.findViewById(R.id.btnTwitter)
        val btnInstagram: Button = view.findViewById(R.id.btnInstagram)
        val btnFacebook: Button = view.findViewById(R.id.btnFacebook)
        val btnWhatsApp: Button = view.findViewById(R.id.btnWhatsApp)
        val btnGithub: Button = view.findViewById(R.id.btnGithub)

        // Location buttons
        val btnLocation1: Button = view.findViewById(R.id.btnLocation1)
        val btnLocation2: Button = view.findViewById(R.id.btnLocation2)
        val btnLocation3: Button = view.findViewById(R.id.btnLocation3)

        // Phone button action
        btnCall.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:+1234567890")
            startActivity(dialIntent)
        }

        // Email button action
        btnEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:support@example.com")
            startActivity(Intent.createChooser(emailIntent, "Send Email"))
        }

        // Social Media Actions
        btnTwitter.setOnClickListener {
            val twitterIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://x.com/i/flow/login"))
            startActivity(twitterIntent)
        }

        btnInstagram.setOnClickListener {
            val instaIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/accounts/login/"))
            startActivity(instaIntent)
        }

        btnFacebook.setOnClickListener {
            val fbIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/login.php/"))
            startActivity(fbIntent)
        }

        btnWhatsApp.setOnClickListener {
            val whatsappIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/0815764488"))
            startActivity(whatsappIntent)
        }

        btnGithub.setOnClickListener {
            val githubIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ShikharBahal/WIl-Website.git"))
            startActivity(githubIntent)
        }

        // Location button actions
        btnLocation1.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=123+Main+St,+Johannesburg")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        btnLocation2.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=456+Oak+St,+Pretoria")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        btnLocation3.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=789+Pine+St,+Cape+Town")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        return view
    }
}
