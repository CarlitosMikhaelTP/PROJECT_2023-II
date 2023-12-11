package com.delvin.menunav.ui.calculadora

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.delvin.menunav.R

class CalculadoraFragment : Fragment() {

    companion object {
        fun newInstance() = CalculadoraFragment()
    }

    private lateinit var viewModel: CalculadoraViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculadora, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CalculadoraViewModel::class.java)
        // TODO: Use the ViewModel
    }

}