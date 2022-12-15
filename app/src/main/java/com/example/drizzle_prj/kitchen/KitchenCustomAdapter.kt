package com.example.drizzle_prj.kitchen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.example.drizzle_prj.R

class KitchenCustomAdapter (context: Context, arrayListDetails:ArrayList<kitchenModel>):
    BaseAdapter() {
    private val layoutInflater: LayoutInflater
    private val arrayListDetails:ArrayList<kitchenModel>
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
        val listRowHolder: ListKitchenRowHolder
        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.kitchen_list_layout, parent, false)
            listRowHolder = ListKitchenRowHolder(view)
            listRowHolder.also { view.tag = it }
        } else {
            view = convertView
            listRowHolder = view.tag as ListKitchenRowHolder
        }
        listRowHolder.kitchenMkNm.text = arrayListDetails.get(position).mkNm
        listRowHolder.kitchenPdNm.text = arrayListDetails.get(position).pdNm
        listRowHolder.kitchenPrice.text = arrayListDetails.get(position).price
        var KitchenimageList = arrayListDetails.get(position).pdImg
        Glide.with(parent)
            .load(KitchenimageList)
            .into(listRowHolder.kitchenImg)
        return view
    }
}

class ListKitchenRowHolder(row: View?) {
    public val kitchenImg: ImageView = row?.findViewById<View>(R.id.kitchenImg) as ImageView
    public val kitchenMkNm: TextView = row?.findViewById<View>(R.id.kitchenMkNm) as TextView
    public val kitchenPdNm: TextView = row?.findViewById<View>(R.id.kitchenPdNm) as TextView
    public val kitchenPrice: TextView = row?.findViewById<View>(R.id.kitchenPrice) as TextView
    public val kitchenLayout: LinearLayout = row?.findViewById<LinearLayout>(R.id.kitchenLayout) as TableLayout

}