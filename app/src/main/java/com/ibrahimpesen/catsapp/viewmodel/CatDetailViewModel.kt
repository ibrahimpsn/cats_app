package com.ibrahimpesen.catsapp.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ibrahimpesen.catsapp.local.CatsDatabase
import com.ibrahimpesen.catsapp.model.CatsItem
import kotlinx.coroutines.launch

class CatDetailViewModel(application: Application): BaseViewModel(application) {

    val catLiveData = MutableLiveData<CatsItem>()

    fun dataFromRoom(uuid : Int){

        launch {

            val dao = CatsDatabase(getApplication()).catsDao()
            val cat = dao.getCat(uuid)
            catLiveData.value=cat

        }

    }


}