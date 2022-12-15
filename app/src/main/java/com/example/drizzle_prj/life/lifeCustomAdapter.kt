package com.example.drizzle_prj.life

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.example.drizzle_prj.R

class lifeCustomAdapter (context: Context, arrayListDetails:ArrayList<lifeModel>):
    BaseAdapter() {
    private val layoutInflater: LayoutInflater
    private val arrayListDetails:ArrayList<lifeModel>
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
        val listRowHolder: ListLifeRowHolder
        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.life_list_layout, parent, false)
            listRowHolder = ListLifeRowHolder(view)
            listRowHolder.also { view.tag = it }
        } else {
            view = convertView
            listRowHolder = view.tag as ListLifeRowHolder
        }
        listRowHolder.lifeMkNm.text = arrayListDetails.get(position).mkNm
        listRowHolder.lifePdNm.text = arrayListDetails.get(position).pdNm
        listRowHolder.lifePrice.text = arrayListDetails.get(position).price
        var LifeimageList = arrayListDetails.get(position).pdImg
        Glide.with(parent)
            .load(LifeimageList)
            .into(listRowHolder.lifeImg)
        return view
    }
}

class ListLifeRowHolder(row: View?) {
    public val lifeImg: ImageView = row?.findViewById<View>(R.id.lifeImg) as ImageView
    public val lifeMkNm: TextView = row?.findViewById<View>(R.id.lifeMkNm) as TextView
    public val lifePdNm: TextView = row?.findViewById<View>(R.id.lifePdNm) as TextView
    public val lifePrice: TextView = row?.findViewById<View>(R.id.lifePrice) as TextView
    public val lifeLayout: LinearLayout = row?.findViewById<LinearLayout>(R.id.lifeLayout) as TableLayout

}