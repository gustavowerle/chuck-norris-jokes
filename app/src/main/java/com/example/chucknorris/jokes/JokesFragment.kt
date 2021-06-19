package com.example.chucknorris.jokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.chucknorris.MainViewModel
import com.example.chucknorris.R
import com.example.chucknorris.databinding.FragmentJokesBinding

class JokesFragment : Fragment() {

    private lateinit var binding: FragmentJokesBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_jokes, container, false)
        return binding.root
    }

}