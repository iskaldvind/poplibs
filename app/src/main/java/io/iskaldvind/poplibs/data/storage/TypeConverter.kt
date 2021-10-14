package io.iskaldvind.poplibs.data.storage

import androidx.room.TypeConverter
import io.iskaldvind.poplibs.data.repo.Owner

class TypeConverter {

    @TypeConverter
    fun fromOwner(owner: Owner): String {
        return owner.home
    }

    @TypeConverter
    fun toOwner(home: String): Owner {
        return Owner(home)
    }
}