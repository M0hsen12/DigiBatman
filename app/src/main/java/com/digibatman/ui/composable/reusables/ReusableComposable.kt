package com.digibatman.ui.composable.reusables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.digibatman.util.getWidthOfScreenInDp

@Composable
fun DisplayProgressbar(state: State<Boolean>) {

    if (state.value) {
        Dialog(
            onDismissRequest = { state.value },
            DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(15.dp)
                    .width(getWidthOfScreenInDp().div(2))
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = Color.Red
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = "لطفا چند لحظه صبر کنید!!",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

            }


        }
    }
}