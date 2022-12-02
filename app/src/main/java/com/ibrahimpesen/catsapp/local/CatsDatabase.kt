package com.ibrahimpesen.catsapp.local

import android.content.Context
import androidx.room.*
import com.ibrahimpesen.catsapp.model.CatsItem

@Database(entities = arrayOf(CatsItem::class), version = 6)
@TypeConverters(Converters::class)
abstract class CatsDatabase: RoomDatabase() {

    abstract fun catsDao() : CatsDAO

    companion object{

        @Volatile private var  instance : CatsDatabase? =null
        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance ?: createDatabase(context).also {
                instance=it
            }
        }

        private fun createDatabase(context: Context)= Room.databaseBuilder(context.applicationContext
            , CatsDatabase::class.java,"catsdatabase").fallbackToDestructiveMigration().build()
    }

}






/*class SourceTypeConverter {
    @TypeConverter
    fun toBitmap(bytes: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    @TypeConverter
    fun fromBitmap(bmp: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }
}*/