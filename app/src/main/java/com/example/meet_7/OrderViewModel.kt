package com.example.meet_7

import com.example.meet_7.Data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

private const val HARGA_PER_CUP = 5000

class OrderViewModel {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setJumlah(jmlEsJumbo: Int){
        _stateUI.update{
            stateSaatIni -> stateSaatIni.copy(
                jumlah = jmlEsJumbo,
                harga = hitungHarga(jumlah = jmlEsJumbo)
            )
        }
    }
    fun setRasa(rasaPilihan: String){
        _stateUI.update{
                stateSaatIni -> stateSaatIni.copy(
            rasa = rasaPilihan)
        }
    }
    fun resetOrder(){
        _stateUI.value = OrderUIState()
    }
    fun hitungHarga(jumlah: Int = _stateUI.value.jumlah):String{
        val kalkulasiHarga = jumlah * HARGA_PER_CUP

        return NumberFormat.getNumberInstance().format(kalkulasiHarga)

    }

}