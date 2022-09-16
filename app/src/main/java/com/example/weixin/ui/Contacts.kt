package com.example.weixin.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weixin.MyViewModel
import com.example.weixin.R
import com.example.weixin.data.User
import com.example.weixin.ui.theme.WeComposeTheme

/**
 * 顶栏
 */
@Composable
fun ContactListTopBar(){
    WeTopBar(title = "通讯录")
}

/**
 * 联系人Item
 */
@Composable
fun ContactListItem(
    contact: User,
    modifier: Modifier = Modifier
){
    Row(
        Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(contact.avatar),
            contentDescription = "头像",
            Modifier
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .size(36.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Text(
            text = contact.name,
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            fontSize = 17.sp,
            color = WeComposeTheme.colors.textPrimary
        )
    }
}

/**
 * 列表
 */
@Composable
fun ContactList(viewModel: MyViewModel = viewModel()) {
    Column(Modifier.fillMaxSize()) {
        ContactListTopBar()
        Box(
            Modifier
                .background(WeComposeTheme.colors.background)
                .fillMaxSize()
        ) {
            ContactList(viewModel.contacts)
        }
    }
}

@Composable
fun ContactList(contacts: List<User>){
    LazyColumn(
        Modifier
            .background(WeComposeTheme.colors.listItem)
            .fillMaxWidth()
    ){
        //好友列表上面的部分
        //数据
        val buttons = listOf<User>(
            User("contact_add","新的朋友",R.drawable.ic_contact_add),
            User("contact_chat","仅聊天",R.drawable.ic_contact_chat),
            User("contact_group", "群聊",R.drawable.ic_contact_group),
            User("contact_tag", "标签",R.drawable.ic_contact_tag),
            User("contact_official", "公众号",R.drawable.ic_contact_official)
        )
        itemsIndexed(buttons) { index,contact ->
            ContactListItem(contact = contact)
            if (index < buttons.size - 1){
                Divider(
                    startIndent = 56.dp,
                    color = WeComposeTheme.colors.chatListDivider,
                    thickness = 0.8f.dp
                )
            }
        }

        //好友
        item {
            Text(
                text = "朋友",
                Modifier
                    .background(WeComposeTheme.colors.background)
                    .fillMaxWidth()
                    .padding(12.dp, 8.dp),
                fontSize = 14.sp,
                color = WeComposeTheme.colors.onBackground
            )
        }

        itemsIndexed(contacts){ index,contact ->
            ContactListItem(contact)
            if (index < contacts.size - 1){
                Divider(
                    startIndent = 56.dp,
                    color = WeComposeTheme.colors.chatListDivider,
                    thickness = 0.8f.dp
                )
            }
        }
    }
}