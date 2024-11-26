package io.marelso.marketmanagement.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import io.marelso.marketmanagement.R

@Composable
fun AppImage(
    modifier: Modifier = Modifier,
    url: String? = null,
    icon: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_no_image)
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .size(Size.ORIGINAL)
            .build()
    )

    AppImage(modifier = modifier, painter = painter, icon = icon)
}

@Composable
fun AppLocalImage(
    modifier: Modifier = Modifier,
    painter: Painter,
) {
    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = "",
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun AppImage(modifier: Modifier = Modifier, painter: AsyncImagePainter, icon: ImageVector) {
    when (painter.state) {
        is AsyncImagePainter.State.Loading -> Box(
            modifier = modifier
                .fillMaxSize()
                .shimmerLoadingAnimation(),
        )

        is AsyncImagePainter.State.Success -> Image(
            modifier = modifier,
            painter = painter,
            contentDescription = ""
        )

        else -> Image(
            modifier = modifier,
            imageVector = icon,
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}