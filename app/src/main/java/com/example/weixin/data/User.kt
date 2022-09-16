package com.example.weixin.data

import androidx.annotation.DrawableRes
import com.example.weixin.R

class User(val id: String,val name: String,@DrawableRes val avatar: Int){
    companion object {
        val Me: User = User(id = "leiteorz",name = "南南",avatar = R.drawable.nannan_touxiang)
    }
}