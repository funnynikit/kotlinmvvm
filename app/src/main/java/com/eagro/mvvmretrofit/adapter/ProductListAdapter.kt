package com.eagro.mvvmretrofit.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eagro.mvvmretrofit.R
import com.eagro.mvvmretrofit.model.ProductFamily
import com.eagro.mvvmretrofit.view.ProductDetailsActivity

class ProductListAdapter(private val productList: List<ProductFamily>,private val ctx : Context) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(view: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(view?.context).inflate(R.layout.adapter_product_list, view, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.name?.text = productList[position].name
        viewHolder.name.setOnClickListener(View.OnClickListener {
            val intent = Intent(ctx,ProductDetailsActivity::class.java)
            ctx.startActivity(intent)
        })
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tvName)
    }
}