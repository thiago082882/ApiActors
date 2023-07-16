package com.thiago.actorsapp.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.actorsapp.repository.CharacterRepo
import com.thiago.actorsapp.retrofit.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(
    val characterRepo: CharacterRepo
) : ViewModel() {

    private val _state = MutableStateFlow(emptyList<Character>())
    val state: StateFlow<List<Character>>
        get() = _state

    init {
        viewModelScope.launch {
            val characters = characterRepo.getCharacters()
            _state.value = characters
        }
    }
}