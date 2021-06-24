package br.com.raveline.daggerinjection.mvvm.data.model.movie


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.createTypedArrayList(Movie)!!,
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(page)
        parcel.writeTypedList(movies)
        parcel.writeInt(totalPages)
        parcel.writeInt(totalResults)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<MovieList> {
        override fun createFromParcel(parcel: Parcel): MovieList {
            return MovieList(parcel)
        }

        override fun newArray(size: Int): Array<MovieList?> {
            return arrayOfNulls(size)
        }
    }
}