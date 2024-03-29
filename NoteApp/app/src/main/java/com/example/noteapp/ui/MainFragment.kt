package com.example.noteapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.R
import com.example.noteapp.adapter.NoteAdapter
import com.example.noteapp.adapter.NoteAdapter2
import com.example.noteapp.databinding.FragmentMainBinding
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodels.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val noteViewModel: NoteViewModel by activityViewModels()
    private lateinit var adapter: NoteAdapter2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initActions()
        initObserve()
    }

    private fun initRecyclerView() {
        adapter = NoteAdapter2(onDelete, onUpdate, onEdit)
        binding.recyclerNote.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerNote.adapter = adapter
    }

    private fun initActions() {
        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_editFragment)
        }
    }

    private fun initObserve() {
        noteViewModel.allNotes.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private val onDelete: (Note) -> Unit = { note ->
        noteViewModel.deleteNote(note)
    }

    private val onUpdate: (Note) -> Unit = { note ->
        noteViewModel.updateNote(note)
    }

    private val onEdit: (Note) -> Unit = { note ->
        val action = MainFragmentDirections.actionMainFragmentToEditFragment(note)
        findNavController().navigate(action)
    }
}