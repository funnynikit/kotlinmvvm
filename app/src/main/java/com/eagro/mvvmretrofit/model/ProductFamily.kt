package com.eagro.mvvmretrofit.model

import androidx.room.Entity
import java.io.Serializable

@Entity
data class ProductFamily(
    var id: Int,
    var products: List<Products>,
    var name: String,
    var description: String,
    var totalPages: Int
) : Serializable