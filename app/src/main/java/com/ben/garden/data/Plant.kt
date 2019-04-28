package com.ben.garden.data

import android.os.Parcel
import android.os.Parcelable

data class Plant(val name: String, val imgId: Int) : Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString()!!, parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(imgId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Plant> {
        override fun createFromParcel(parcel: Parcel): Plant {
            return Plant(parcel)
        }

        override fun newArray(size: Int): Array<Plant?> {
            return arrayOfNulls(size)
        }
    }
}