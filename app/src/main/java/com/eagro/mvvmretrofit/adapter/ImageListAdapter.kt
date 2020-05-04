package com.eagro.mvvmretrofit.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.eagro.mvvmretrofit.R
import com.eagro.mvvmretrofit.model.ImageData
import java.util.ArrayList

class ImageListAdapter(var ctx: Context, private var imageDataList : ArrayList<ImageData>) : BaseAdapter(){

    override fun getItem(position: Int): Any {
        return imageDataList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return imageDataList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view : View = View.inflate(ctx,R.layout.grid_item,null)

        val tv_num = view.findViewById<TextView>(R.id.tv_number) as TextView
        val img_lang=view.findViewById<ImageView>(R.id.im_lang)
        val tv_lang = view.findViewById<TextView>(R.id.tv_lang) as TextView

        tv_lang.text= imageDataList!!.get(position).text
        val pic=imageDataList!!.get(position).image
        tv_num.text= (position+1).toString()+"."
        img_lang!!.setImageResource(pic!!)
        return view
    }

}