package com.intellectsoft.gridview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var adapter:FoodAdapter?=null
    var listOfFoods = ArrayList<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Load foods
        listOfFoods.add(Food("coffee","Coffee preparation is the process of turning coffee beans into a beverage. While the particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain time (brewed), and finally the liquid coffee must be separated from the used grounds",R.drawable.coffee_pot))
        listOfFoods.add(Food("Black tea","Coffee preparation is the process of turning coffee beans into a beverage. While the particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain time (brewed), and finally the liquid coffee must be separated from the used grounds",R.drawable.espresso))
        listOfFoods.add(Food("KFC","Coffee preparation is the process of turning coffee beans into a beverage. While the particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain time (brewed), and finally the liquid coffee must be separated from the used grounds",R.drawable.french_fries))
        listOfFoods.add(Food("Ice Cream","Coffee preparation is the process of turning coffee beans into a beverage. While the particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain time (brewed), and finally the liquid coffee must be separated from the used grounds",R.drawable.honey))
        listOfFoods.add(Food("sugar","Coffee preparation is the process of turning coffee beans into a beverage. While the particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain time (brewed), and finally the liquid coffee must be separated from the used grounds",R.drawable.strawberry_ice_cream))
        listOfFoods.add(Food("Ice cubes","Coffee preparation is the process of turning coffee beans into a beverage. While the particular steps vary with the type of coffee and with the raw materials, the process includes four basic steps; raw coffee beans must be roasted, the roasted coffee beans must then be ground, the ground coffee must then be mixed with hot water for a certain time (brewed), and finally the liquid coffee must be separated from the used grounds",R.drawable.sugar_cubes))

        adapter=FoodAdapter(this,listOfFoods)
        //Assign our list to the griview
        findViewById<GridView>(R.id.gridview)

    }
}

class FoodAdapter:BaseAdapter{
    var listOfFoods =ArrayList<Food>()
    var context:Context?=null
    constructor(context:Context,listOfFoods:ArrayList<Food>):super(){
        this.context=context
        this.listOfFoods=listOfFoods

}

    override fun getCount(): Int {
        return listOfFoods.size
    }

    override fun getItem(p0: Int): Any {
        return listOfFoods [p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val food = this.listOfFoods[p0]
        val inflator =context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
        val foodview = inflator.inflate(R.layout.grid_item,null)
        foodview.findViewById<ImageView>(R.id.itemimage).setImageResource(food.Image!!)
        foodview.findViewById<ImageView>(R.id.itemimage).setOnClickListener {
            val intent = Intent(context,Fooddetails::class.java)
            intent.putExtra("name",food.name!!)
            intent.putExtra("des",food.des!!)
            context!!.startActivity(intent)
        }
        foodview.findViewById<TextView>(R.id.itemtext).text=food.name!!
        return foodview
    }

}
//Generated automatically
