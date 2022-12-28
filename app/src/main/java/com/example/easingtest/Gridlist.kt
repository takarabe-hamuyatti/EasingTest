package com.example.easingtest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.stopScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.ui.foundation.Clickable
import kotlinx.coroutines.launch

@Composable
fun Screen() {
    val listState = rememberLazyGridState()
    val coroutineScope = rememberCoroutineScope()
    val isReachedTop by remember {
        derivedStateOf {
            listState.isScrollInProgress && listState.firstVisibleItemIndex == 0
        }
    }
    LaunchedEffect(isReachedTop) {
        coroutineScope.launch {
            listState.stopScroll()

        }
    }
    Column {
        GridList(listState = listState)
        Clickable(
            onClick = {
                coroutineScope.launch {
                    listState.scrollToItem(0)
                }
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(color = Color.Green)
            ) {
                Text(text = "up")
            }
        }
    }
}

@Composable
fun GridList(
    listState: LazyGridState
) {
    LazyVerticalGrid(columns = GridCells.Fixed(3), state = listState) {
        items(itemList) {
            Image(painter = painterResource(it), contentDescription = "")
        }
    }
}


private val itemList = listOf(
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image4,
    R.drawable.image5,
    R.drawable.image6,
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image4,
    R.drawable.image5,
    R.drawable.image6,
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image4,
    R.drawable.image5,
    R.drawable.image6,
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image4,
    R.drawable.image5,
    R.drawable.image6,
    R.drawable.image1,
    R.drawable.image2,
    R.drawable.image3,
    R.drawable.image4,
    R.drawable.image5,
    R.drawable.image6,
)
