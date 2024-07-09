package com.example.contactlistv2

import androidx.annotation.DrawableRes

data class Contact(
    val name: String,
    val phone: String,
    @DrawableRes val image: Int
)
