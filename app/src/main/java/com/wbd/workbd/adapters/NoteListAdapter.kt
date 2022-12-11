package com.wbd.workbd.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wbd.workbd.R
import com.wbd.workbd.databinding.NoteShowBinding
import com.wbd.workbd.localdb.Notes

class NoteListAdapter : RecyclerView.Adapter<NoteListAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var binding: NoteShowBinding = NoteShowBinding.bind(view)
    }
    var notes: List<Notes> = mutableListOf()
    fun updateList (notes: List<Notes>){
        this.notes = notes
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_show, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.note = notes[position]
    }
    override fun getItemCount(): Int {
        return notes.size
    }
}