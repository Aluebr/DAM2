package com.example.myapplication_compose

import androidx.annotation.DrawableRes

data class CheckInfo(
    @DrawableRes var imagen:Int,
    var selected:Boolean,
    var title:String,
    var onCheckedChange:(Boolean)->Unit
    )