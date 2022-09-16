package com.example.weixin.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weixin.MyViewModel
import com.example.weixin.R
import com.example.weixin.ui.theme.WeComposeTheme

@Composable
fun WeTopBar(title: String,onBack: (() -> Unit)? = null){
    Box(
        Modifier
            .background(WeComposeTheme.colors.background)
            .fillMaxWidth()
    ) {
        Row(Modifier.fillMaxWidth()) {
            //返回键
            if (onBack != null){
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                    Modifier
                        .clickable(onClick = onBack)
                        .align(Alignment.CenterVertically)
                        .size(36.dp)
                        .padding(8.dp),
                    tint = WeComposeTheme.colors.icon
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            val viewModel: MyViewModel = viewModel()

            //切换主题
            Icon(
                painter = painterResource(id = R.drawable.ic_palette),
                contentDescription = "切换主题",
                Modifier
                    .clickable {
                        viewModel.theme = when(viewModel.theme){
                            WeComposeTheme.Theme.Light -> WeComposeTheme.Theme.Dark
                            WeComposeTheme.Theme.Dark -> WeComposeTheme.Theme.NewYear
                            WeComposeTheme.Theme.NewYear -> WeComposeTheme.Theme.Light
                        }
                    }
                    .align(Alignment.CenterVertically)
                    .size(36.dp)
                    .padding(8.dp),
                tint = WeComposeTheme.colors.icon
            )
        }
        Text(title, Modifier.align(Alignment.Center), color = WeComposeTheme.colors.textPrimary)
    }
}