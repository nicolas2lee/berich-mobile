package com.xinrui.berich.presentation.dashboard.fortune.model

import android.os.Parcel
import android.os.Parcelable

data class FundModel(val name: String, val code: String, val value: String) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(code)
        parcel.writeString(value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FundModel> {
        override fun createFromParcel(parcel: Parcel): FundModel {
            return FundModel(parcel)
        }

        override fun newArray(size: Int): Array<FundModel?> {
            return arrayOfNulls(size)
        }
    }
}