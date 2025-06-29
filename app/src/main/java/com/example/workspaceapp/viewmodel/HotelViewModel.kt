package com.example.workspaceapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workspaceapp.data.model.Hotel
import com.example.workspaceapp.data.repository.HotelRepository
import com.example.workspaceapp.data.repository.FakeHotelRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HotelViewModel(
    private val repository: HotelRepository = FakeHotelRepository()
) : ViewModel() {
    private val _hotels = MutableStateFlow<List<Hotel>>(emptyList())
    val hotels: StateFlow<List<Hotel>> = _hotels

    init {
        viewModelScope.launch {
            _hotels.value = repository.getHotels()
        }
    }
}