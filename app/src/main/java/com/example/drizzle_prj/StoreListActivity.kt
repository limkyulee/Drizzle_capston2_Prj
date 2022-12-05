package com.example.drizzle_prj

import android.os.Bundle
import android.text.util.Linkify
import android.text.util.Linkify.TransformFilter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern


class StoreListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_list)

        var text1 : TextView = findViewById(R.id.text1)
        val pattern1: Pattern = Pattern.compile("지구샵")

        var text2 : TextView = findViewById(R.id.text2)
        val pattern2: Pattern = Pattern.compile("톤28")

        var text3 : TextView = findViewById(R.id.text3)
        val pattern3: Pattern = Pattern.compile("Toliving")

        var text4 : TextView = findViewById(R.id.text4)
        val pattern4: Pattern = Pattern.compile("HAYAN")

        var text5 : TextView = findViewById(R.id.text5)
        val pattern5: Pattern = Pattern.compile("아임에코")

        var text6 : TextView = findViewById(R.id.text6)
        val pattern6: Pattern = Pattern.compile("동구밭")

        var text7 : TextView = findViewById(R.id.text7)
        val pattern7: Pattern = Pattern.compile("자연상점")

//        var text8 : TextView = findViewById(R.id.text8)
//        val pattern8: Pattern = Pattern.compile("자연상점")

        val transformFilter =
            TransformFilter { matcher, s -> "" }

        Linkify.addLinks(text1, pattern1, "https://www.jigushop.co.kr/", null, transformFilter);
        Linkify.addLinks(text2, pattern2, "https://www.toun28.com/renew/product", null, transformFilter);
        Linkify.addLinks(text3, pattern3, "https://smartstore.naver.com/toliving", null, transformFilter);
        Linkify.addLinks(text4, pattern4, "https://www.hayanlifestyle.com/", null, transformFilter);
        Linkify.addLinks(text5, pattern5, "https://imecomall.co.kr/v2/", null, transformFilter);
        Linkify.addLinks(text6, pattern6, "https://www.donggubat.co.kr/main/index.php", null, transformFilter);
        Linkify.addLinks(text7, pattern7, "http://onlyeco.co.kr/", null, transformFilter);
//        Linkify.addLinks(text8, pattern8, "http://onlyeco.co.kr/", null, transformFilter);
    }
}