package com.example.noteapp.ui

import android.os.Build
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.noteapp.databinding.FragmentEditBinding
import com.example.noteapp.model.Note
import com.example.noteapp.viewmodels.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding
    private val noteViewModel: NoteViewModel by activityViewModels()
    private val args: EditFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var note = Note("", "", false)
        var isEdit = false
        args.note?.let {
            note = it
            isEdit = true
        }

        binding.titleET.text = SpannableStringBuilder(note.title)
        binding.descriptionET.text = SpannableStringBuilder(note.description)
        binding.okButton.setOnClickListener {
            note.title = binding.titleET.text.toString()
            note.description = binding.descriptionET.text.toString()
            if (isEdit) {
                noteViewModel.updateNote(note)
            } else {
                noteViewModel.addNote(note)
            }
            findNavController().popBackStack()
        }
    }

}