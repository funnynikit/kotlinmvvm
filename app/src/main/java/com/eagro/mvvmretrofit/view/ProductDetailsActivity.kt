package com.eagro.mvvmretrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import com.eagro.mvvmretrofit.R
import com.eagro.mvvmretrofit.adapter.ImageListAdapter
import com.eagro.mvvmretrofit.model.ImageData
import com.eagro.mvvmretrofit.utils.SharedPreference

class ProductDetailsActivity : AppCompatActivity()
{
    private val listImage = ArrayList<ImageData>()
    private lateinit var gridView : GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val sharedPreference : SharedPreference = SharedPreference(this)
        val myname = sharedPreference.getValueString("name")

        Log.e("NIKIT","Preference Value : "+myname)
        gridView = findViewById<GridView>(R.id.gridView)
        val obj1 = ImageData("nikit",R.mipmap.ic_launcher)
        val obj2 = ImageData("nikit",R.mipmap.ic_launcher)
        val obj3 = ImageData("nikit",R.mipmap.ic_launcher)
        val obj4 = ImageData("nikit",R.mipmap.ic_launcher)

        listImage.add(obj1)
        listImage.add(obj2)
        listImage.add(obj3)
        listImage.add(obj4)

        val listAdapter = ImageListAdapter(this,listImage)
        gridView.adapter = listAdapter
    }
}
