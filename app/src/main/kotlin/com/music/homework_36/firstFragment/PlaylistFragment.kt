package com.music.homework_36.firstFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.music.homework_36.model.Music
import com.music.homework_36.secondFragment.PlayerFragment
import com.music.homework_36.R
import com.music.homework_36.adapter.PlaylistAdapter
import com.music.homework_36.databinding.FragmentPlaylistBinding


class PlaylistFragment : Fragment() {
    private lateinit var binding: FragmentPlaylistBinding

    private lateinit var playListAdapter: PlaylistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaylistBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playListAdapter = PlaylistAdapter(loadData(), this::onItemClick)

        binding.recyclerPlaylist.adapter = playListAdapter
    }

    private fun loadData() = listOf(
        (Music(1, "Blank Space", "Taylor Swift", "3:22")),
        (Music(1, "Blank Space", "Taylor Swift", "3:22")),
        (Music(1, "Blank Space", "Taylor Swift", "3:22")),
        (Music(1, "Blank Space", "Taylor Swift", "3:22")),
        (Music(1, "Blank Space", "Taylor Swift", "3:22")),
        (Music(1, "Blank Space", "Taylor Swift", "3:22")),
        (Music(1, "Blank Space", "Taylor Swift", "3:22")),
        (Music(1, "Blank Space", "Taylor Swift", "3:22")),
        (Music(1, "Blank Space", "Taylor Swift", "3:22")),
        (Music(1, "Blank Space", "Taylor Swift", "3:22"))
    )

    private fun onItemClick(title: String?) {
        val bundle = Bundle()
        bundle.putString("songTitle", title)
        val playerFragment = PlayerFragment()
        playerFragment.arguments = bundle
        requireActivity().supportFragmentManager.findFragmentById(R.id.cover_album)?.view?.isGone =
            true
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.playlist, playerFragment).commit()
    }
}