package com.example.weixin.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weixin.MyViewModel
import com.example.weixin.data.Chat
import com.example.weixin.ui.theme.WeComposeTheme

//列表
@Composable
fun ChatList(chats: List<Chat>){
    Column(
        Modifier
            .fillMaxSize()
            .background(WeComposeTheme.colors.background)
    ){
        WeTopBar(title = "微信")
        LazyColumn(Modifier.background(WeComposeTheme.colors.listItem)){
            itemsIndexed(chats){ index,chat ->
                ChatListItem(chat = chat)
                if (index < chats.lastIndex){
                    Divider(
                        startIndent = 68.dp,
                        color = WeComposeTheme.colors.chatListDivider,
                        thickness = 0.8f.dp
                    )
                }
            }
        }
    }
}

//列表item
@Composable
private fun ChatListItem(chat: Chat){
    val viewModel: MyViewModel = viewModel()
    Row(
        Modifier
            .fillMaxWidth()
            .clickable {
                viewModel.startChat(chat)
            }
    ) {
        Image(
            painter = painterResource(id = chat.friend.avatar),
            contentDescription = chat.friend.name,
            Modifier
                .padding(8.dp)
                .size(48.dp)
                .unread(!chat.msgs.last().read, color = WeComposeTheme.colors.badge)
                .clip(RoundedCornerShape(4.dp))
        )
        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(chat.friend.name, fontSize = 17.sp, color = WeComposeTheme.colors.textPrimary)
            Text(chat.msgs.last().text, fontSize = 14.sp, color = WeComposeTheme.colors.textSecondary)
        }
        Text(
            chat.msgs.last().time,
            Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp),
            fontSize = 11.sp, color = WeComposeTheme.colors.textSecondary
        )
    }
}

//显示未读小红标
fun Modifier.unread(show: Boolean,color: Color): Modifier = this.drawWithContent{
    drawContent()
    if (show){
        drawCircle(color = color,5.dp.toPx(), Offset(size.width - 1.dp.toPx(),1.dp.toPx()))
    }
}