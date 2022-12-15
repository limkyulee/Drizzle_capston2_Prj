package com.example.drizzle_prj.bath

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.example.drizzle_prj.R

class BathCustomAdapter (context: Context, arrayListDetails:ArrayList<BathModel>):
    BaseAdapter() {
    private val layoutInflater: LayoutInflater
    private val arrayListDetails:ArrayList<BathModel>
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
        val listRowHolder: ListBathRowHolder
        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.bath_list_layout, parent, false)
            listRowHolder = ListBathRowHolder(view)
            listRowHolder.also { view.tag = it }
        } else {
            view = convertView
            listRowHolder = view.tag as ListBathRowHolder
        }
        listRowHolder.bathMkNm.text = arrayListDetails.get(position).mkNm
        listRowHolder.bathPdNm.text = arrayListDetails.get(position).pdNm
        listRowHolder.bathPrice.text = arrayListDetails.get(position).price
        var BathimageList = arrayListDetails.get(position).pdImg
        Glide.with(parent)
            .load(BathimageList)
            .into(listRowHolder.bathImg)
        return view
    }
}

class ListBathRowHolder(row: View?) {
    public val bathImg: ImageView = row?.findViewById<View>(R.id.bathImg) as ImageView
    public val bathMkNm: TextView = row?.findViewById<View>(R.id.bathMkNm) as TextView
    public val bathPdNm: TextView = row?.findViewById<View>(R.id.bathPdNm) as TextView
    public val bathPrice: TextView = row?.findViewById<View>(R.id.bathPrice) as TextView
    public val bathLayout: LinearLayout = row?.findViewById<LinearLayout>(R.id.bathLayout) as TableLayout

}