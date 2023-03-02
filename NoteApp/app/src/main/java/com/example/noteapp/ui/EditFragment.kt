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
    private var note: Note = Note("", "", false)
    private var isEdit = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.note?.let {
            note = it
            isEdit = true
        }

        initText()
        initActions()
    }

    private fun initActions() {
        binding.okButton.setOnClickListener {
            if (!validateNote()) return@setOnClickListener

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

    private fun initText() {
        binding.titleET.text = SpannableStringBuilder(note.title)
        binding.descriptionET.text = SpannableStringBuilder(note.description)
    }

    private fun validateNote(): Boolean {
        var isValid = true
        if (binding.titleET.text.toString().isBlank()) {
            binding.titleET.error = "Required"
            isValid = false
        }
        if (binding.descriptionET.text.toString().isBlank()) {
            binding.descriptionET.error = "Required"
            isValid = false
        }
        return isValid
    }

}