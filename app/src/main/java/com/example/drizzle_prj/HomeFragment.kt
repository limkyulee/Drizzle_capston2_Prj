package com.example.drizzle_prj

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.drizzle_prj.databinding.ActivityMainBinding
import com.example.drizzle_prj.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
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
// 요기부터 보면됩니당

    private var _binding: FragmentHomeBinding? = null // 바인딩 초기화
    private val binding get() = _binding!! // 바인딩 선언

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false) // 바인딩 지정
        //intent에 저장되어 있는 엑티비티 쪽으로 이동한다
        binding.mainShampooButton.setOnClickListener {
            val intent = Intent(context, shampooListActivity::class.java)
            startActivity(intent)
        }

        binding.mainBathButton.setOnClickListener {
            val intent = Intent(context, BathListActivity::class.java)
            startActivity(intent)
        }

        binding.mainChopstickButton.setOnClickListener {
            val intent = Intent(context, LifeListActivity::class.java)
            startActivity(intent)
        }

        binding.mainKitchenButton.setOnClickListener {
            val intent = Intent(context, KitchenListActivity::class.java)
            startActivity(intent)
        }
        binding.mainNoteButton.setOnClickListener {
            val intent = Intent(context, NoteListActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
// 요기까지
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}