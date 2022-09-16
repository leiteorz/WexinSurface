package com.example.weixin.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.weixin.MyViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Home(viewModel: MyViewModel){
    Column {
        val pagerState = rememberPagerState()
        //横向滑动Pager
        HorizontalPager(
            count = 4,
            Modifier.weight(1f),
            pagerState
        ) { page ->
            when(page){
                0 -> ChatList(viewModel.chats)
                1 -> ContactList()
                2 -> DiscoveryList()
                3 -> MeList()
            }
        }
        val scope = rememberCoroutineScope()    //创建CoroutineScope
        WeBottomBar(selectId = pagerState.currentPage){ page ->
            //点击页签后,在协程里翻页
            scope.launch {
                pagerState.animateScrollToPage(page)
            }
        }
    }
}