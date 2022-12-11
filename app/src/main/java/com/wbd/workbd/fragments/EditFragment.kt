package com.wbd.workbd.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.room.Room
import com.wbd.workbd.R
import com.wbd.workbd.adapters.NoteListAdapter
import com.wbd.workbd.databinding.FragmentEditBinding
import com.wbd.workbd.localdb.Notes
import com.wbd.workbd.localdb.NotesDb
import com.wbd.workbd.localdb.NotesRespository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class EditFragment : Fragment() {
    lateinit var binding: FragmentEditBinding
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentEditBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            var title = binding.editTitle.text.toString()
            var body = binding.editBody.text.toString()
            val db = Room.databaseBuilder(requireContext(), NotesDb::class.java, "db").build()
            val respository = NotesRespository(db)
            GlobalScope.launch {
                respository.insert(Notes(title, body))
            }
            val adapter = NoteListAdapter()
            respository.notes.observe(viewLifecycleOwner) {
                adapter.updateList(it)
            }
            Navigation.findNavController(it).navigate(R.id.action_editFragment_to_showFragment)
        }
    }
}