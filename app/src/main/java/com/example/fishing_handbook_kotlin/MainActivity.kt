package com.example.fishing_handbook_kotlin

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var adapter: myAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nav_view = findViewById<NavigationView>(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener (this)
        val rcView = findViewById<RecyclerView>(R.id.rcView)



        var list = ArrayList<ListItem>()

        list.addAll(fillArrays(resources.getStringArray(R.array.fish),
            resources.getStringArray(R.array.fish_content),getImageId(R.array.fish_image_array) ))
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = myAdapter(list,this)
        rcView.adapter = adapter


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){

            R.id.id_fish -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.fish),
                    resources.getStringArray(R.array.fish_content),getImageId(R.array.fish_image_array) ))
                Toast.makeText(this, "id FISH", Toast.LENGTH_SHORT).show()
            }
            R.id.id_na -> {

                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.na),
                    resources.getStringArray(R.array.na_content),getImageId(R.array.na_image_array) ))
                Toast.makeText(this, "id NA", Toast.LENGTH_SHORT).show()
            }
            R.id.id_sna -> {

                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.sna),
                    resources.getStringArray(R.array.sna_content),getImageId(R.array.sna_image_array) ))
                Toast.makeText(this, "id SNA", Toast.LENGTH_SHORT).show()
            }
            R.id.id_history -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.history),
                    resources.getStringArray(R.array.history_content),getImageId(R.array.history_image_array) ))
                Toast.makeText(this, "id HISTORY", Toast.LENGTH_SHORT).show()
            }
        }


        return true
    }


    fun fillArrays(titleArray: Array<String>, contentArray : Array<String>, imageArray : IntArray):List<ListItem>{

        var listItemArray = ArrayList<ListItem>()
            for (n in 0..titleArray.size-1){
                var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
                listItemArray.add(listItem)
            }
            return listItemArray
    }


    fun getImageId(imageArrayId:Int):IntArray{

        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices){
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }

}