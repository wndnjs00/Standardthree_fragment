package com.example.standardthree_fragment.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.standardthree_fragment.R
import com.example.standardthree_fragment.data.DataSource
import com.example.standardthree_fragment.databinding.FragmentDashboardBinding
import com.example.standardthree_fragment.viewModel.FlowerViewModel

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    lateinit var flowerViewModel : FlowerViewModel

    private val TAG = DashboardFragment::class.java.simpleName



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater,container,false)

        // 1. bundle로 보낸 데이터 받아오기
        val name = arguments?.getString("name1").toString()
        val description = arguments?.getString("description1").toString()
        binding.flowerNameContentTv.text = "꽃이름: $name"
        binding.flowerDescriptionContentTv.text = "설명: $description"



        // 2. viewModle 사용해서 데이터 전달
        // 데이터리스트 가져옴
        val dataSoure = DataSource.getDataSoures().getFlowerList()

        flowerViewModel = ViewModelProvider(requireActivity()).get(FlowerViewModel::class.java)

        binding.sendBtn2.setOnClickListener {

            flowerViewModel.sendFlowerData("name", dataSoure.get(1).name)
            flowerViewModel.sendFlowerData("description", dataSoure.get(1).description)
            Log.d(TAG, dataSoure.get(1).name)           // 리시안셔스
            Log.d(TAG, dataSoure.get(1).description)    //'변치 않는 사랑'이라는 꽃말을 가지고있습니다

            parentFragmentManager.beginTransaction()
                .replace(R.id.main_framelayout, NotificationsFragment())
                .commit()
        }


        return binding.root
    }

}