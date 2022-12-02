package com.ibrahimpesen.catsapp.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ibrahimpesen.catsapp.model.CatsItem


@Dao
interface CatsDAO {

    @Insert
    suspend fun insertAll(vararg catsitem: CatsItem) : List<Long>

    /*@Query("SELECT * FROM catsitem WHERE uuid = :isSelected ")
    suspend fun getFavCat(isSelected: Array<CatsItem>): List<CatsItem>*/

    @Query("SELECT * FROM catsitem")
    suspend fun getAllCats() : List<CatsItem>

    @Query("SELECT * FROM catsitem WHERE uuid = :catId")
    suspend fun getCat(catId : Int ) : CatsItem

    @Query("DELETE FROM catsitem")
    suspend fun deleteAllCats()

}

/* @Query("SELECT * FROM catsitem WHERE favuuid = :favuuid")
    suspend fun checkCats(favuuid: String): Int

    @Query("SELECT * FROM catsitem WHERE favuuid = :favuuid")
    suspend fun deleteCats(favuuid: String): Int*/