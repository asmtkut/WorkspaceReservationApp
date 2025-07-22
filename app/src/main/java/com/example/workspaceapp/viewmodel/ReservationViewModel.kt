package com.example.workspaceapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.workspaceapp.data.model.Reservation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import java.util.*

@HiltViewModel
class ReservationViewModel @Inject constructor() : ViewModel() {

    private val _reservations = MutableStateFlow<List<Reservation>>(emptyList())
    val reservations: StateFlow<List<Reservation>> = _reservations

    fun addReservation(hotelName: String, roomName: String, price: Int) {
        val newReservation = Reservation(
            reservationId = UUID.randomUUID().toString(),
            hotelName = hotelName,
            roomName = roomName,
            price = price,
            timestamp = System.currentTimeMillis()
        )
        _reservations.value = _reservations.value + newReservation
    }
}
