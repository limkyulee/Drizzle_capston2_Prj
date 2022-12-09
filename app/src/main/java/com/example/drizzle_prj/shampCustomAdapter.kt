package com.example.drizzle_prj

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView

 class shampCustomAdapter(context: Context, arrayListDetails:ArrayList<shampooModel>):
    BaseAdapter() {
    private val layoutInflater: LayoutInflater
    private val arrayListDetails:ArrayList<shampooModel>
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
        val listRowHolder: ListRowHolder
        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.activity_shampoo_list, parent, false)
            listRowHolder = ListRowHolder(view)
            view.tag = listRowHolder
        } else {
            view = convertView
            listRowHolder = view.tag as ListRowHolder
        }
        listRowHolder.shampooMkNm.text = arrayListDetails.get(position).mkNm
        listRowHolder.shampooPdNm.text = arrayListDetails.get(position).pdNm
        listRowHolder.shampooPrice.text = arrayListDetails.get(position).price
        return view
    }
}

private class ListRowHolder(row: View?) {
    public val shampooMkNm: TextView
    public val shampooPdNm: TextView
    public val shampooPrice: TextView
    public val shampooLayout: LinearLayout

    init {
        this.shampooPrice = row?.findViewById<TextView>(R.id.shampooPrice) as TextView
        this.shampooMkNm = row?.findViewById<TextView>(R.id.shampooMkNm) as TextView
        this.shampooPdNm = row?.findViewById<TextView>(R.id.shampooPdNm) as TextView
        this.shampooLayout = row?.findViewById<LinearLayout>(R.id.shampooLayout) as LinearLayout
    }
}