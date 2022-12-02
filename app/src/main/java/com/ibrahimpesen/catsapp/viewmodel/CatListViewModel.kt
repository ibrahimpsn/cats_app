package com.ibrahimpesen.catsapp.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.ibrahimpesen.catsapp.local.CatsDatabase
import com.ibrahimpesen.catsapp.model.Cats
import com.ibrahimpesen.catsapp.model.CatsItem
import com.ibrahimpesen.catsapp.service.ApiService
import com.ibrahimpesen.catsapp.util.CatsSharedPrefences
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch


class CatListViewModel(application: Application) : BaseViewModel(application) {

    val cats = MutableLiveData<List<CatsItem>>()
    val favCats = arrayListOf<CatsItem>()
    val errorMessage = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    private var updateTime = 1.1 * 60 * 1000 * 1000 * 1000L

    private val catApiService = ApiService()
    private val disposable = CompositeDisposable()
    private val catsSharedPrefences = CatsSharedPrefences(getApplication())

    fun refreshData() {

        val saveTime = catsSharedPrefences.getTime()
        if ((saveTime != null) && (saveTime != 0L) && ((System.nanoTime() - saveTime) < updateTime)) {
            dataFromSql()
        } else {
            dataFromInternet()
        }

    }

    fun refreshDataFromInternet() {
        dataFromInternet()
    }

    fun dataFromSql() {
        loading.value = true

        launch {
            val catList = CatsDatabase(getApplication()).catsDao().getAllCats()
            showCats(catList)
            Toast.makeText(getApplication(), "Kedileri Roomdan Aldık", Toast.LENGTH_LONG).show()

        }


    }

    private fun dataFromInternet() {
        loading.value = true

        disposable.add(
            catApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<CatsItem>>() {
                    override fun onSuccess(t: List<CatsItem>) {
                        //
                        saveToSql(t)
                        /*cats.value=t
                        errorMessage.value=false
                        loading.value=false*/
                        Toast.makeText(getApplication(),"Kedileri Internetten Aldık",Toast.LENGTH_LONG).show()

                    }

                    override fun onError(e: Throwable) {
                        errorMessage.value = true
                        loading.value = false
                        e.printStackTrace()

                    }

                })

        )
    }

    private fun showCats(catsList: List<CatsItem>) {
        cats.value = catsList
        errorMessage.value = false
        loading.value = false
    }

    private fun saveToSql(catList: List<CatsItem>) {

        launch {
            val dao = CatsDatabase(getApplication()).catsDao()
            dao.deleteAllCats()
            val uuidList = dao.insertAll(*catList.toTypedArray())

            var i = 0
            while (i < catList.size) {
                catList[i].uuid = uuidList[i].toInt()
                i = i + 1
            }
            showCats(catList)

        }
        catsSharedPrefences.saveTime(System.nanoTime())

    }


    /*private fun saveFavToSql(favCatList : List<CatsItem>){
        launch {
            val favDao = CatsDatabase(getApplication()).catsDao()
            favDao.deleteAllCats()
            val favuuidList = favDao.getFavCat(*favCatList.t)
            var i = 0
            while (i<favCatList.size){
                favCatList[i].favuuid=favuuidList[i].to()
            }


        }



    }*/

   /*rivate fun getData(): ArrayList<CatsItem>{
        for(i in favCats.indices){
            arrayListOf<CatsItem>().add(CatsItem(favCats[i],))
        }
    }*/


}




