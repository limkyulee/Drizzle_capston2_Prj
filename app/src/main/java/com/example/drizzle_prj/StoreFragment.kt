package com.example.drizzle_prj

import android.os.Bundle
import android.text.util.Linkify
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.regex.Pattern

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StoreFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.activity_store_list, container, false)

        var text1 : TextView = view.findViewById(R.id.text1)
        val pattern1: Pattern = Pattern.compile("지구샵")

        var text2 : TextView = view.findViewById(R.id.text2)
        val pattern2: Pattern = Pattern.compile("톤28")

        var text3 : TextView = view.findViewById(R.id.text3)
        val pattern3: Pattern = Pattern.compile("Toliving")

        var text4 : TextView = view.findViewById(R.id.text4)
        val pattern4: Pattern = Pattern.compile("HAYAN")

        var text5 : TextView = view.findViewById(R.id.text5)
        val pattern5: Pattern = Pattern.compile("아임에코")

        var text6 : TextView = view.findViewById(R.id.text6)
        val pattern6: Pattern = Pattern.compile("동구밭")

        var text7 : TextView = view.findViewById(R.id.text7)
        val pattern7: Pattern = Pattern.compile("자연상점")

//        var text8 : TextView = findViewById(R.id.text8)
//        val pattern8: Pattern = Pattern.compile("자연상점")

        val transformFilter =
            Linkify.TransformFilter { _,_-> "" }

        Linkify.addLinks(text1, pattern1, "https://www.jigushop.co.kr/", null, transformFilter);
        Linkify.addLinks(text2, pattern2, "https://www.toun28.com/renew/product", null, transformFilter);
        Linkify.addLinks(text3, pattern3, "https://smartstore.naver.com/toliving", null, transformFilter);
        Linkify.addLinks(text4, pattern4, "https://www.hayanlifestyle.com/", null, transformFilter);
        Linkify.addLinks(text5, pattern5, "https://imecomall.co.kr/v2/", null, transformFilter);
        Linkify.addLinks(text6, pattern6, "https://www.donggubat.co.kr/main/index.php", null, transformFilter);
        Linkify.addLinks(text7, pattern7, "http://onlyeco.co.kr/", null, transformFilter);
//        Linkify.addLinks(text8, pattern8, "http://onlyeco.co.kr/", null, transformFilter);
        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StoreFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StoreFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}