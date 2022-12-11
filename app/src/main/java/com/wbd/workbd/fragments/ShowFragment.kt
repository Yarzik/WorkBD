package com.wbd.workbd.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.wbd.workbd.adapters.NoteListAdapter
import com.wbd.workbd.databinding.FragmentShowBinding
import com.wbd.workbd.localdb.NotesDb
import com.wbd.workbd.localdb.NotesRespository

class ShowFragment : Fragment() {
    lateinit var binding: FragmentShowBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = Room.databaseBuilder(requireContext(), NotesDb::class.java, "db").build()
        val respository = NotesRespository(db)
        val adapter = NoteListAdapter()
        respository.notes.observe(viewLifecycleOwner) {
            adapter.updateList(it)
        }
        binding.recyclerView.adapter = adapter
    }
}