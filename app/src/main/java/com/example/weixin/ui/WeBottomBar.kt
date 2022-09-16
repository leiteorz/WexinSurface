package com.example.weixin.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weixin.R.drawable
import com.example.weixin.ui.theme.WeComposeTheme

/**
 * 微信底部选项卡元素,需要传入图标和text
 */
@Composable
fun TabItem(@DrawableRes iconId: Int, title: String, modifier: Modifier = Modifier, tint: Color){
    //横向需要比重weight,纵向需要边距
    Column(
        modifier
            .width(55.dp)
            .height(55.dp)
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = title,
            tint = tint
        )
        Text(text = title,fontSize = 11.sp,color = tint)
    }
}

/**
 * 微信底栏
 */
@Composable
fun WeBottomBar(selectId: Int,onSelectedChange: (Int) -> Unit){
    Row(
        Modifier
            .background(WeComposeTheme.colors.bottomBar)
            .fillMaxWidth()
    ){
        TabItem(
            iconId = if (selectId == 0) drawable.message_ui_filled else drawable.message_ui,
            tint = if (selectId == 0) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            title = "微信",
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onSelectedChange(0)
                }
        )

        TabItem(
            iconId = if (selectId == 1) drawable.friend_ui_filled else drawable.friend_ui,
            tint = if (selectId == 1) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            title = "通讯录",
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onSelectedChange(1)
                }
        )

        TabItem(
            iconId = if (selectId == 2) drawable.find_ui_filled else drawable.find_ui,
            tint = if (selectId == 2) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            title = "发现",
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onSelectedChange(2)
                }
        )

        TabItem(
            iconId = if (selectId == 3) drawable.me_ui_filled else drawable.me_ui,
            tint = if (selectId == 3) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            title = "我",
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onSelectedChange(3)
                }
        )
    }
}

/**
 * 以下皆为预览,阿弥陀佛
 */

/**
 * 用于预览底部item
 */
@Preview(showBackground = true)
@Composable
fun TabItemPreview(){
    TabItem(iconId = drawable.message_ui, title = "微信",tint = WeComposeTheme.colors.icon)
}


/**
 * 用于预览底部bar
 */
@Preview(showBackground = true)
@Composable
fun WeBottomBarPreview(){
    WeComposeTheme(WeComposeTheme.Theme.Dark){
        var selectedTab by remember {
            mutableStateOf(0)
        }
        WeBottomBar(selectId = selectedTab){ selectedTab = it }
    }
}

