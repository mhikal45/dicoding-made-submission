package com.wal.winteranimelist2021.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.wal.winteranimelist2021.core.data.Resource
import com.wal.winteranimelist2021.core.ui.AnimeAdapter
import com.wal.winteranimelist2021.databinding.FragmentHomeBinding
import com.wal.winteranimelist2021.ui.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel : HomeViewModel by viewModel()
    private var binding: FragmentHomeBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val animeAdapter = AnimeAdapter()

            animeAdapter.onItemClicked = {
                val intent = Intent(activity,DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA,it)
                startActivity(intent)
            }

            with(binding?.rvHome) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = animeAdapter
            }

            homeViewModel.anime.observe(viewLifecycleOwner,{anime ->
                if (anime != null) {
                    when(anime) {
                        is Resource.Success -> {animeAdapter.setData(anime.data)}
                    }
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}