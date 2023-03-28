package com.hyun.coin_monitoring_project.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyun.coin_monitoring_project.R
import com.hyun.coin_monitoring_project.databinding.FragmentIntro2Binding
import com.hyun.coin_monitoring_project.view.SelectActivity


class IntroFragment2 : Fragment() {

    private var _binding: FragmentIntro2Binding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIntro2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextBtn.setOnClickListener {
            val selectMoveIntent = Intent(requireActivity(), SelectActivity::class.java)
            startActivity(selectMoveIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}