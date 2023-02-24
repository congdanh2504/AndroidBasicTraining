package com.example.databinding

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotesViewModel() : ViewModel(), Observable {
    val isStringEmpty = MutableLiveData<Boolean>()

    @Bindable
    val inputTitle = MutableLiveData<String>()

    @Bindable
    val inputDescription = MutableLiveData<String>()
    val list = MutableLiveData<ArrayList<NoteItem>>()
    private val arraylist = ArrayList<NoteItem>()

    init {
        isStringEmpty.value = false
    }

    fun addData() {
        val title = inputTitle.value!!
        val description = inputDescription.value!!
        if (title.isBlank() || description.isBlank()) {
            isStringEmpty.value = true
        } else {
            inputTitle.value = " "
            inputDescription.value = " "
            val noteItem = NoteItem(title, description)
            arraylist.add(noteItem)
            list.value = arraylist
        }

    }

    fun clearData() {
        arraylist.clear()
        list.value = arraylist
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}