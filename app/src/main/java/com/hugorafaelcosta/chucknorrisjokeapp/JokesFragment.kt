package com.hugorafaelcosta.chucknorrisjokeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hugorafaelcosta.chucknorrisjokeapp.databinding.FragmentChuckNorrisJokesBinding
import com.hugorafaelcosta.chucknorrisjokeapp.jokesViewModel.JokesMainViewModel

class JokesFragment : Fragment() {

    private val viewModel: JokesMainViewModel by viewModels()
    private lateinit var binding: FragmentChuckNorrisJokesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChuckNorrisJokesBinding.inflate(layoutInflater)
        return (binding.root)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.giveMeAJokeBtn.setOnClickListener {
            viewModel.getJokes()
        }

        viewModel._liveJoke.observe(viewLifecycleOwner) {
            binding.chuckNorri.text = it
        }

    }

}