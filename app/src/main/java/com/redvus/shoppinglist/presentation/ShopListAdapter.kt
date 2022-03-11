package com.redvus.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.redvus.shoppinglist.R
import com.redvus.shoppinglist.domain.ShopItem

class ShopListAdapter: RecyclerView.Adapter<ShopListAdapter.ShopListViewHolder>() {

    val list = listOf<ShopItem>()

    class ShopListViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val tvName= view.findViewById<TextView>(R.id.tv_name)
        val tvCount= view.findViewById<TextView>(R.id.tv_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shop_enabled, parent, false)
        return ShopListViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ShopListViewHolder, position: Int) {
        val shopItem = list[position]
        viewHolder.tvName.text = shopItem.name
        viewHolder.tvCount.text = shopItem.count.toString()
        viewHolder.view.setOnClickListener {
            true
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}