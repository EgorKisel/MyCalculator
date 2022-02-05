package com.geekbrains.mycalculator

import android.os.Parcel
import android.os.Parcelable

public class MatchematicResult() : Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MatchematicResult> {
        override fun createFromParcel(parcel: Parcel): MatchematicResult {
            return MatchematicResult(parcel)
        }

        override fun newArray(size: Int): Array<MatchematicResult?> {
            return arrayOfNulls(size)
        }
    }
}