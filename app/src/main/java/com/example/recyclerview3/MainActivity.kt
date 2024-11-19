package com.example.recyclerview3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
      private  lateinit var   userArrayList:ArrayList<MyDataClass>
      private  lateinit var   binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding  =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
          val imageArray =  arrayOf(
                R.drawable.man ,
                R.drawable.man ,
                R.drawable.man ,
                R.drawable.man ,
                R.drawable.man ,
                R.drawable.man ,
                R.drawable.man ,
                R.drawable.man ,
                R.drawable.man ,
                R.drawable.man ,
          )


        val nameArray  =  arrayOf(
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
              "Gautam kumar" ,
        )
         userArrayList =  ArrayList()
        for (i in  nameArray.indices)  {
              val view =  MyDataClass(imageArray[i] , nameArray[i])
              userArrayList.add(view)
        }
         binding.recyclerViewId.layoutManager =  LinearLayoutManager(this)
         val setAdapter  =  MyAdapter(userArrayList)
         binding.recyclerViewId.adapter =  setAdapter

        setAdapter.setOnItemClickListener(object  : MyAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity ,  "You clicked $position" , Toast.LENGTH_SHORT).show()
            }
        })
    }
}