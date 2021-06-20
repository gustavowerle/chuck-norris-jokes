package com.example.chucknorris.jokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.chucknorris.MainViewModel
import com.example.chucknorris.R
import com.example.chucknorris.databinding.FragmentJokesBinding
import org.koin.android.viewmodel.ext.android.viewModel

class JokesFragment : Fragment() {

    private lateinit var binding: FragmentJokesBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_jokes, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setJokeObserver()
        setIsLoadingObserver()
    }

    private fun setIsLoadingObserver() {
        viewModel.isLoading.observe(viewLifecycleOwner, {
            if (it) {
                binding.imgJoke.visibility = View.VISIBLE
                binding.txtJoke.visibility = View.VISIBLE
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        })
    }

    private fun setJokeObserver() {
        viewModel.joke.observe(viewLifecycleOwner, {
            binding.txtJoke.text = it.value
            Glide.with(this)
                .load(it.icon_url)
                .centerCrop()
                .placeholder(R.color.gray)
                .into(binding.imgJoke)
        })
    }
}