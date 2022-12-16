package com.example.drizzle_prj

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceControl
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.drizzle_prj.cart.CartActivity
import com.example.drizzle_prj.databinding.FragmentMypageBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MypageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MypageFragment : Fragment() {
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

    private var _binding: FragmentMypageBinding? = null // 바인딩 초기화
    private val binding get() = _binding!! // 바인딩 선언

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageBinding.inflate(inflater, container, false) // 바인딩 지정

        binding.mypageLikeButton.setOnClickListener{
//            val intent = Intent(context, LikeFragment::class.java)
//            startActivity(intent)

            val likeFragment = LikeFragment()
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fl_container, likeFragment)?.commit()

        }
        binding.mypageCoinButton.setOnClickListener{
            val intent = Intent(context, CartActivity::class.java)
            startActivity(intent)
        }
//        binding.mypageLikeButton.setOnClickListener{
//            val intent = Intent(context, LikeFragment::class.java)
//            startActivity(intent)
//        }
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MypageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MypageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}