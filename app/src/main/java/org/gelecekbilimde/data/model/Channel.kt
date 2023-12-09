package org.gelecekbilimde.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.Keep
import org.gelecekbilimde.R

@Keep
data class PushNotification(
    @DrawableRes val smallIcon: Int = R.drawable.icon,
    val channelList: List<Channel> = emptyList(),
)

@Keep
data class Channel(
    val id: String,
    val name: String
)

