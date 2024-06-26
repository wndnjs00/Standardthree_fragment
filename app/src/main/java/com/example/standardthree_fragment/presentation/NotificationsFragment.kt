package com.example.standardthree_fragment.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.standardthree_fragment.R
import com.example.standardthree_fragment.data.DataSource
import com.example.standardthree_fragment.databinding.FragmentNotificationsBinding
import com.example.standardthree_fragment.viewModel.FlowerViewModel

class NotificationsFragment : Fragment() {

    private lateinit var binding: FragmentNotificationsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationsBinding.inflate(inflater, container,false)


        // viewModel로 전달한 데이터 받아와서 뿌려주기
        val dataSoure = DataSource.getDataSoures().getFlowerList()

        val flowerModel = ViewModelProvider(requireActivity()).get(FlowerViewModel::class.java)
        flowerModel.flowerData.observe(viewLifecycleOwner, Observer {
            binding.flowerNameContentTv2.text = "꽃이름: ${dataSoure.get(1).name}"
        })

        flowerModel.flowerData.observe(viewLifecycleOwner, Observer {
            binding.flowerDescriptionContentTv2.text = "설명: ${dataSoure.get(1).description}"
        })



        // 3. Result API를 사용해서 데이터 전달
        binding.sendBtn3.setOnClickListener {

            setFragmentResult("Name", bundleOf("name" to dataSoure.get(2).name))
            setFragmentResult("Description", bundleOf("description" to dataSoure.get(2).description))

            parentFragmentManager.beginTransaction()
                .replace(R.id.main_framelayout, HomeFragment())
                .commit()
        }



        return binding.root
    }

}