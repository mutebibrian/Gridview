package com.intellectsoft.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Fooddetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fooddetails)

        val bundle = intent.extras
        findViewById<ImageView>(R.id.ivfoodimage).setImageResource(bundle!!.getInt("image"))
        findViewById<TextView>(R.id.tvname).text=bundle.getString("name")
        findViewById<TextView>(R.id.tvdetails).text =bundle.getString("des")
    }

}