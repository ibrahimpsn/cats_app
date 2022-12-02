package com.ibrahimpesen.catsapp.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class CatsSharedPrefences {

    companion object{

        private val TIME = "time"
        private var sharedPrefences: SharedPreferences? =null

        @Volatile private var instance: CatsSharedPrefences? =null
        private val lock = Any()
        operator fun invoke(context: Context) : CatsSharedPrefences= instance ?: synchronized(lock){
            instance ?: createCatsSharedPrefences(context).also {
                instance=it
            }

        }

        private fun createCatsSharedPrefences(context: Context): CatsSharedPrefences{
            sharedPrefences = PreferenceManager.getDefaultSharedPreferences(context)
            return CatsSharedPrefences()
        }

    }

    fun saveTime(time: Long){
        sharedPrefences?.edit(commit = true){
            putLong(TIME,time)
        }
    }

    fun getTime() = sharedPrefences?.getLong(TIME,0)

}