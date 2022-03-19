package com.example.viewmodelexample.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewmodelexample.R
import kotlinx.android.synthetic.main.main_fragment.*
import androidx.databinding.DataBindingUtil
import com.example.viewmodelexample.databinding.MainFragmentBinding
import com.example.viewmodelexample.BR.myViewModel //BR = binding root

class MainFragment : Fragment() {
//data binding project example
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.setLifecycleOwner(this) //can also use setter binding.lifeCycleOwner = this

        return binding.root //can also use binding.getRoot()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.setVariable(myViewModel, viewModel)
       //was missing this line
  /*      resultText.text = viewModel.getResult().toString()
        // TODO: Use the ViewModel
        convertButton.setOnClickListener {
            if (dollarText.text.isNotEmpty()) {

                viewModel.setAmount(dollarText.text.toString())

                resultText.text = viewModel.getResult().toString()

            } else {

                resultText.text = "No Value"

            }


        }*/
    }

}