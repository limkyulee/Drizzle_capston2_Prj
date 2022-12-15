package com.example.drizzle_prj.note

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.example.drizzle_prj.R

class NoteCustomAdapter (context: Context, arrayListDetails:ArrayList<noteModel>):
    BaseAdapter() {
    private val layoutInflater: LayoutInflater
    private val arrayListDetails:ArrayList<noteModel>
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
        val listRowHolder: ListNoteRowHolder
        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.note_list_layout, parent, false)
            listRowHolder = ListNoteRowHolder(view)
            listRowHolder.also { view.tag = it }
        } else {
            view = convertView
            listRowHolder = view.tag as ListNoteRowHolder
        }
        listRowHolder.noteMkNm.text = arrayListDetails.get(position).mkNm
        listRowHolder.notePdNm.text = arrayListDetails.get(position).pdNm
        listRowHolder.notePrice.text = arrayListDetails.get(position).price
        var NoteimageList = arrayListDetails.get(position).pdImg
        Glide.with(parent)
            .load(NoteimageList)
            .into(listRowHolder.noteImg)
        return view
    }
}

class ListNoteRowHolder(row: View?) {
    public val noteImg: ImageView = row?.findViewById<View>(R.id.noteImg) as ImageView
    public val noteMkNm: TextView = row?.findViewById<View>(R.id.noteMkNm) as TextView
    public val notePdNm: TextView = row?.findViewById<View>(R.id.notePdNm) as TextView
    public val notePrice: TextView = row?.findViewById<View>(R.id.notePrice) as TextView
    public val noteLayout: LinearLayout = row?.findViewById<LinearLayout>(R.id.noteLayout) as TableLayout

}