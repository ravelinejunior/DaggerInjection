package br.com.raveline.daggerinjection.mvvm.data.model.artist


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PeopleList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val artists: List<Artist>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.createTypedArrayList(Artist)!!,
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(page)
        parcel.writeInt(totalPages)
        parcel.writeInt(totalResults)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<PeopleList> {
        override fun createFromParcel(parcel: Parcel): PeopleList {
            return PeopleList(parcel)
        }

        override fun newArray(size: Int): Array<PeopleList?> {
            return arrayOfNulls(size)
        }
    }
}