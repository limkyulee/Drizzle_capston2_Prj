package com.example.drizzle_prj.shampoo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.example.drizzle_prj.R

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
            view = this.layoutInflater.inflate(R.layout.shampoo_list_layout, parent, false)
            listRowHolder = ListRowHolder(view)
            listRowHolder.also { view.tag = it }
        } else {
            view = convertView
            listRowHolder = view.tag as ListRowHolder
        }
        listRowHolder.shampooMkNm.text = arrayListDetails.get(position).mkNm
        listRowHolder.shampooPdNm.text = arrayListDetails.get(position).pdNm
        listRowHolder.shampooPrice.text = arrayListDetails.get(position).price
         var ShampooimageList = arrayListDetails.get(position).pdImg
         Glide.with(parent)
             .load(ShampooimageList)
             .into(listRowHolder.shampooImg)
        return view
    }
}

class ListRowHolder(row: View?) {
    public val shampooImg: ImageView = row?.findViewById<View>(R.id.shampooImg) as ImageView
    public val shampooMkNm: TextView = row?.findViewById<View>(R.id.shampooMkNm) as TextView
    public val shampooPdNm: TextView = row?.findViewById<View>(R.id.shampooPdNm) as TextView
    public val shampooPrice: TextView = row?.findViewById<View>(R.id.shampooPrice) as TextView
    public val shampooLayout: LinearLayout = row?.findViewById<LinearLayout>(R.id.shampooLayout) as TableLayout

}