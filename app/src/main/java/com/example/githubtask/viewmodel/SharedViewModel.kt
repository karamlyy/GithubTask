package com.example.githubtask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtask.model.Repository
import com.example.githubtask.network.RetrofitClient
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SharedViewModel :ViewModel() {
    private val api = RetrofitClient.githubApi

    var day = MutableLiveData<List<Repository>>()
    var week = MutableLiveData<List<Repository>>()
    var month = MutableLiveData<List<Repository>>()

    lateinit var handleError: (Throwable) -> Unit
    fun getRepository(filter: DateFilter){
        this.viewModelScope.launch {
            try {
                val createDate = getCreateDate(filter)
                when(filter){
                   DateFilter.DAY -> {
                       if (day.value == null){
                           day.value = api.getRepo(createDate).items
                       }
                   }
                   DateFilter.WEEK -> {
                       if (week.value == null){
                           week.value = api.getRepo(createDate).items
                       }
                   }
                   DateFilter.MONTH -> {
                       if (month.value == null){
                           month.value = api.getRepo(createDate).items
                       }
                   }
                }
            }catch (e:Throwable){
               handleError(e)
            }
        }
    }
    private fun getCreateDate(filter: DateFilter) : String{
        val date = LocalDate.now()
        val difference : Long = when(filter){
            DateFilter.DAY -> 2
            DateFilter.WEEK -> 7
            DateFilter.MONTH -> 30
        }
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formattedDate = date.minusDays(difference).format(formatter)
        println(formattedDate)
        return "created:>${formattedDate}"
    }
}
enum class DateFilter{
    DAY,
    WEEK,
    MONTH,
}

