package com.thiago.actorsapp.repository

import com.thiago.actorsapp.retrofit.Character
import com.thiago.actorsapp.retrofit.CharacterApi

class CharacterRepo(
    private val characterApi: CharacterApi
) {
    suspend fun getCharacters():List<Character>{
       return characterApi.getCharacters()
    }
}