package com.example.standardthree_fragment.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.standardthree_fragment.R
import com.example.standardthree_fragment.databinding.FragmentNotificationsBinding
import com.example.standardthree_fragment.viewModel.FlowerViewModel

class NotificationsFragment : Fragment() {

    private lateinit var binding: FragmentNotificationsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationsBinding.inflate(inflater, container,false)

        val flowerModel = ViewModelProvider(requireActivity()).get(FlowerViewModel::class.java)
        flowerModel.flowerData.observe(viewLifecycleOwner, Observer {
            binding.flowerNameContentTv2.text = it
        })

        flowerModel.flowerData.observe(viewLifecycleOwner, Observer {
            binding.flowerDescriptionContentTv2.text = it
        })


        return binding.root
    }

}