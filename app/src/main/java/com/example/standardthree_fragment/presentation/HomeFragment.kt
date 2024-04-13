package com.example.standardthree_fragment.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.example.standardthree_fragment.R
import com.example.standardthree_fragment.data.DataSource
import com.example.standardthree_fragment.data.Flower
import com.example.standardthree_fragment.data.flowerList
import com.example.standardthree_fragment.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout.TabGravity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val TAG = HomeFragment::class.java.simpleName


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)



        // 1. Bundle 사용해서 전달
        binding.sendBtn.setOnClickListener {

            // 데이터리스트 가져옴
            val dataSoure = DataSource.getDataSoures().getFlowerList()
            val bundle = Bundle()

            bundle.putString("name", dataSoure.get(0).name)
            bundle.putString("description", dataSoure.get(0).description)
            Log.d(TAG, dataSoure.get(0).name)

            DashboardFragment().arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_framelayout, DashboardFragment())
                .commit()
        }



        // 3. Result API 사용해서 보낸 데이터 받아옴
        setFragmentResultListener("name") { requestKey, bundle ->
            val name = bundle.getString("name")
            binding.flowerNameContentTv3.text = "꽃이름: $name"
        }

        setFragmentResultListener("description") { requestKey, bundle ->
            val description = bundle.getString("description")
            binding.flowerDescriptionContentTv3.text = "설명: $description"
        }



        return binding.root
    }





}