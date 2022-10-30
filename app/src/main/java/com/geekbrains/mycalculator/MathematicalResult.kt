package com.geekbrains.mycalculator

import android.os.Parcel
import android.os.Parcelable

class MathematicalResult() : Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MathematicalResult> {
        override fun createFromParcel(parcel: Parcel): MathematicalResult {
            return MathematicalResult(parcel)
        }

        override fun newArray(size: Int): Array<MathematicalResult?> {
            return arrayOfNulls(size)
        }
    }
}