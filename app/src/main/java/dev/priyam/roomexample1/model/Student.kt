package dev.priyam.roomexample1.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val firstname: String,
    val lastName: String,
    val rollNo: Int
) : Parcelable
