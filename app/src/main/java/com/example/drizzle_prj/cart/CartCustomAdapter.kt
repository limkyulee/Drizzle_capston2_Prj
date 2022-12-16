package com.example.drizzle_prj.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.example.drizzle_prj.R
import com.example.drizzle_prj.bath.BathModel

class CartCustomAdapter (context: Context, arrayListDetails:ArrayList<CartModel>):
    BaseAdapter() {
    private val layoutInflater: LayoutInflater
    private val arrayListDetails:ArrayList<CartModel>
    init {
        this.layoutInflater = LayoutInflater.from(context)
        this.arrayListDetails=arrayListDetails
    }

    override fun getCount(): Int {
        return arrayListDetails.size
    }

    override fun getItem(position: Int): Any {
        return arrayListDetails.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val listRowHolder: ListCartRowHolder
        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.cart_lsit_layout, parent, false)
            listRowHolder = ListCartRowHolder(view)
            listRowHolder.also { view.tag = it }
        } else {
            view = convertView
            listRowHolder = view.tag as ListCartRowHolder
        }
        listRowHolder.cartMkNm.text = arrayListDetails.get(position).mkNm
        listRowHolder.cartPdNm.text = arrayListDetails.get(position).pdNm
        listRowHolder.cartPrice.text = arrayListDetails.get(position).price
        var CartimageList = arrayListDetails.get(position).pdImg
        Glide.with(parent)
            .load(CartimageList)
            .into(listRowHolder.cartImg)
        return view
    }
}

class ListCartRowHolder(row: View?) {
    public val cartImg: ImageView = row?.findViewById<View>(R.id.cartImg) as ImageView
    public val cartMkNm: TextView = row?.findViewById<View>(R.id.cartMkNm) as TextView
    public val cartPdNm: TextView = row?.findViewById<View>(R.id.cartPdNm) as TextView
    public val cartPrice: TextView = row?.findViewById<View>(R.id.cartPrice) as TextView
    public val cartLaytout: LinearLayout = row?.findViewById<LinearLayout>(R.id.cartLaytout) as LinearLayout

}