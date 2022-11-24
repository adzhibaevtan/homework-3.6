package com.music.homework_36.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.music.homework_36.model.Music
import com.music.homework_36.databinding.ItemMusicBinding


class PlaylistAdapter(
    private val musicList: List<Music>,
    private val onItemClick: (title: String?) -> Unit
) :
    RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(
            ItemMusicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = musicList.size

    inner class PlaylistViewHolder(private val binding: ItemMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = musicList[adapterPosition]
            binding.musicId.text = item.index.toString()
            binding.musicName.text = item.title
            binding.artist.text = item.artist
            binding.musicTime.text = item.time
        }

        init {
            binding.root.setOnClickListener {
                onItemClick(musicList[adapterPosition].title)
            }
        }
    }
}