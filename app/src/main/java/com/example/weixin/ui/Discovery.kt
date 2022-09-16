package com.example.weixin.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weixin.R
import com.example.weixin.ui.theme.WeComposeTheme

@Composable
fun DiscoveryListTopBar(){
    WeTopBar(title = "发现")
}

@Composable
fun DiscoveryListItem(
    @DrawableRes icon: Int,
    title: String,
    modifier: Modifier = Modifier,
    badge: @Composable (() -> Unit)? = null,
    endBadge: @Composable (() -> Unit)? = null
){
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "标题",
            Modifier
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .size(36.dp)
                .padding(8.dp)
        )
        Text(
            text = title,
            fontSize = 17.sp,
            color = WeComposeTheme.colors.textPrimary
        )

        badge?.invoke()
        Spacer(Modifier.weight(1f))
        endBadge?.invoke()
        Icon(
            painterResource(R.drawable.ic_arrow_more), contentDescription = "更多",
            Modifier
                .padding(0.dp, 0.dp, 12.dp, 0.dp)
                .size(16.dp),
            tint = WeComposeTheme.colors.more
        )
    }
}

@Composable
fun DiscoveryList(){
    Column(Modifier.fillMaxSize()) {
        DiscoveryListTopBar()

        Box(
            Modifier
                .background(WeComposeTheme.colors.background)
                .fillMaxSize()
        ) {
            Column(
                Modifier
                    .background(WeComposeTheme.colors.listItem)
                    .fillMaxWidth()
            ) {
                DiscoveryListItem(icon = R.drawable.ic_moments, title = "朋友圈",badge = {
                    Box(
                        Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(50))
                            .size(18.dp)
                            .background(WeComposeTheme.colors.badge)
                    ) {
                        Text(
                            text = "3",
                            Modifier.align(Alignment.Center),
                            fontSize = 12.sp,
                            color = WeComposeTheme.colors.onBadge
                        )
                    }
                },endBadge = {
                    Image(
                        painter = painterResource(id = R.drawable.kurogi_touxiang),
                        contentDescription = "头像",
                        Modifier
                            .padding(8.dp, 0.dp)
                            .size(32.dp)
                            .unread(false, WeComposeTheme.colors.badge)
                            .clip(RoundedCornerShape(4.dp))
                    )
                })

                Spacer(
                    modifier = Modifier
                        .background(WeComposeTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )

                DiscoveryListItem(icon = R.drawable.ic_channels, title = "视频号",endBadge = {
                    Image(
                        painter = painterResource(id = R.drawable.huayinuo_touxiang),
                        contentDescription = "头像",
                        Modifier
                            .padding(8.dp, 8.dp)
                            .size(32.dp)
                            .unread(false, WeComposeTheme.colors.badge)
                    )
                    Text(
                        text = "赞过",
                        Modifier.padding(0.dp,0.dp,4.dp,0.dp),
                        fontSize = 14.sp,
                        color = WeComposeTheme.colors.textSecondary
                    )
                })

                Spacer(
                    modifier = Modifier
                        .background(WeComposeTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )

                DiscoveryListItem(icon = R.drawable.ic_ilook, title = "看一看")
                Divider(
                    startIndent = 56.dp,
                    color = WeComposeTheme.colors.chatListDivider,
                    thickness = 0.8f.dp
                )
                
                DiscoveryListItem(icon = R.drawable.ic_isearch, title = "搜一搜")
                Spacer(
                    modifier = Modifier
                        .background(WeComposeTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )

                DiscoveryListItem(icon = R.drawable.ic_nearby, title = "直播和附近")
            }
        }
    }
}