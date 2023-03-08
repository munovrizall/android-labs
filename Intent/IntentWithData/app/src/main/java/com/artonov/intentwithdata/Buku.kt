package com.artonov.intentwithdata

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Buku(
    var judul: String,
    var isbn: Int,
    var penulis: String
): Parcelable
