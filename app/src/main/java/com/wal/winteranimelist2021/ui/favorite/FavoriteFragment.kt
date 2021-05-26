package com.wal.winteranimelist2021.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.wal.winteranimelist2021.core.ui.AnimeAdapter
import com.wal.winteranimelist2021.databinding.FragmentFavoriteBinding
import com.wal.winteranimelist2021.ui.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private val favoriteViewModel : FavoriteViewModel by viewModel()
    private var binding: FragmentFavoriteBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val favoriteAdapter = AnimeAdapter()
            favoriteAdapter.onItemClicked= {
                val intent = Intent(activity,DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA,it)
                startActivity(intent)
            }

            with(binding?.rvFavorite) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = favoriteAdapter
            }

            favoriteViewModel.favAnime.observe(viewLifecycleOwner,{anime ->
                favoriteAdapter.setData(anime)
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}