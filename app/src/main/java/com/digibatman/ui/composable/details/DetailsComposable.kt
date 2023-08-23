package com.digibatman.ui.composable.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.digibatman.R
import com.digibatman.model.details.Details
import com.digibatman.ui.theme.DetailItemGradient
import com.digibatman.util.DetailItemsFontSize
import com.digibatman.util.DetailsItemsShadowHeight
import com.digibatman.util.getHeightOfScreen

@Composable
fun DetailsView(movieDetailsState: State<Details>) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            placeholder = painterResource(id = R.drawable.placeholder),
            modifier = Modifier.fillMaxWidth(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(movieDetailsState.value.poster ?: "")
                .diskCachePolicy(CachePolicy.DISABLED)
                .memoryCachePolicy(CachePolicy.DISABLED)
                .build(),
            contentDescription = movieDetailsState.value.imdbID,
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(getHeightOfScreen().div(DetailsItemsShadowHeight).dp)
                .background(DetailItemGradient), verticalArrangement = Arrangement.Bottom
        ) {
            val detail = movieDetailsState.value
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    ) {
                        append(detail.title ?: "")
                    }
                    withStyle(style = SpanStyle(fontSize = DetailItemsFontSize)) {
                        append(" (${detail.year ?: ""})")
                    }

                }
            )
            Text(text = detail.plot ?: "", fontSize = DetailItemsFontSize)
            Text(text = detail.rated ?: "", fontSize = DetailItemsFontSize)
            Text(text = detail.runtime ?: "", fontSize = DetailItemsFontSize)
            Text(text = detail.language ?: "", fontSize = DetailItemsFontSize)
        }
    }
}