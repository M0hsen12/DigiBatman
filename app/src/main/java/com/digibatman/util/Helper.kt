package com.digibatman.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp


@Composable
fun getHeightOfScreen() = LocalConfiguration.current.screenHeightDp

@Composable
fun getHeightOfScreenInDp() = LocalConfiguration.current.screenHeightDp.dp

@Composable
fun getWidthOfScreen() = LocalConfiguration.current.screenWidthDp

@Composable
fun getWidthOfScreenInDp() = LocalConfiguration.current.screenWidthDp.dp

