package com.example.chucknorris.jokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.chucknorris.main.MainViewModel
import com.example.chucknorris.R
import com.example.chucknorris.databinding.FragmentJokesBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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
        setUpRecyclerView()
        setJokeObserver()
        setIsLoadingObserver()
        setMessageObserver()
    }

    private fun setMessageObserver() {
        viewModel.message.observe(viewLifecycleOwner, { message ->
            context?.apply {
                Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setIsLoadingObserver() {
        viewModel.isLoading.observe(viewLifecycleOwner, {
            if (it)
                binding.progressBar.visibility = View.VISIBLE
            else
                binding.progressBar.visibility = View.GONE
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

    private fun setUpRecyclerView() {
        val adapter = JokesAdapter()
        binding.rvHistory.adapter = adapter
        binding.rvHistory.layoutManager = LinearLayoutManager(context)
        lifecycleScope.launch {
            viewModel.history.collectLatest {
                adapter.submitData(it)
                binding.rvHistory.smoothScrollToPosition(0)
            }
        }
    }
}