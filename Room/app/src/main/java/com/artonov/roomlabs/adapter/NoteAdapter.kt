package com.artonov.roomlabs.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artonov.roomlabs.R
import com.artonov.roomlabs.database.Note
import com.artonov.roomlabs.R.layout.adapter_main
import com.artonov.roomlabs.databinding.AdapterMainBinding

class NoteAdapter (private val notes: ArrayList<Note>, private val listener: OnAdapterListener):
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(private val binding: AdapterMainBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(note: Note) {
                binding.apply {
                    textTitle.text = note.title

                    rvList.setOnClickListener() {
                        listener.onClick(note)
                    }

                    iconDelete.setOnClickListener() {
                        listener.onDelete(note)
                    }

                    iconEdit.setOnClickListener() {
                        listener.onUpdate(note)
                    }
                }
            }
        }

    interface OnAdapterListener {
        fun onClick(note: Note)
        fun onUpdate(note: Note)
        fun onDelete(note: Note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowBinding = AdapterMainBinding.inflate(layoutInflater, parent, false)
        return NoteViewHolder(rowBinding)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        return holder.bind(notes[position])
    }

    fun setData(list: List<Note>) {
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }
}


