package com.fv2005869.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId:Int,
    val course:Int,
    @DrawableRes val drawableRes: Int
)
