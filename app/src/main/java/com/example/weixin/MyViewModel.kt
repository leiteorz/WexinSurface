package com.example.weixin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.weixin.data.Chat
import com.example.weixin.data.Msg
import com.example.weixin.data.User
import com.example.weixin.ui.theme.WeComposeTheme

class MyViewModel : ViewModel(){
    //控制选中底栏的哪一项
    var selectedTab: Int by mutableStateOf(0)
    //控制切换主题
    var theme by mutableStateOf(WeComposeTheme.Theme.Light)
    //当前聊天
    var currentChat: Chat? by mutableStateOf(null)
    //是否正在聊天
    var chatting by mutableStateOf(false)
    //聊天数据
    var chats: List<Chat> by mutableStateOf(
        listOf(
            Chat(
                friend = User("kurogi","Kurogi",R.drawable.kurogi_touxiang),
                mutableStateListOf(
                    Msg(User("kurogi","Kurogi",R.drawable.kurogi_touxiang),"南南","14:28"),
                    Msg(User.Me,"kurogi","14:30").apply { read = true }
                )
            ),
            Chat(
                friend = User("huayinuo","化一诺",R.drawable.huayinuo_touxiang),
                mutableStateListOf(
                    Msg(User("huayinuo","化一诺",R.drawable.huayinuo_touxiang),"你看见我的奶糖了吗","16:30")
                )
            )
        )
    )
    //联系人数据
    var contacts: List<User> by mutableStateOf(
        listOf(
            User("kurogi","Kurogi",R.drawable.kurogi_touxiang),
            User("huayinuo","化一诺",R.drawable.huayinuo_touxiang)
        )
    )

    /**
     * 点击后进入聊天页面
     */
    fun startChat(chat: Chat){
        chatting = true
        currentChat = chat
    }

    /**
     *从聊天页面点击返回
     */
    fun endChat(): Boolean{
        if (chatting){
            chatting = false
            return true
        }else{
            return false
        }
    }

    fun boom(chat: Chat) {
        chat.msgs.add(Msg(User.Me, "\uD83D\uDCA3", "15:10").apply { read = true })
    }
}