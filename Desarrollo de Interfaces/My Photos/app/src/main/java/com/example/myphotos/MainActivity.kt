package com.example.myphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myphotos.ui.theme.MyPhotosTheme
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

data class DataPhotos(@DrawableRes var photo: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPhotosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Photos()
                }
            }
        }
    }
}

@Composable
fun Photos() {
    var selectedPhoto by remember { mutableStateOf<DataPhotos?>(null) }
    val scrollState = rememberLazyListState()

    LazyRow(
        modifier = Modifier.fillMaxSize(),
        state = scrollState
    ) {
        item {
            Spacer(modifier = Modifier.size(10.dp))
        }
        items(getPhoto()) { dataPhoto ->
            ItemPhoto(dataPhoto) {
                selectedPhoto = dataPhoto
            }
        }
    }

    selectedPhoto?.let { dataPhoto ->
        ImagenSeleccionada(dataPhoto)
    }
}
fun getPhoto(): List<DataPhotos> {
    return listOf(
        DataPhotos(R.drawable.image1),
        DataPhotos(R.drawable.image2),
        DataPhotos(R.drawable.image3),
        DataPhotos(R.drawable.image4),
        DataPhotos(R.drawable.image5),
        DataPhotos(R.drawable.image6),
        DataPhotos(R.drawable.image7),
        DataPhotos(R.drawable.image8)
    )
}
@Composable
fun ItemPhoto(dataPhoto: DataPhotos, onClick: () -> Unit) {

    Row(
        modifier = Modifier.clickable {
            onClick()
        }
    ) {
        Image(
            painter = painterResource(id = dataPhoto.photo),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
    }
}
@Composable
fun ImagenSeleccionada(dataPhoto: DataPhotos) {

    Image(
        painter = painterResource(id = dataPhoto.photo),
        contentDescription = null,
        modifier = Modifier.padding(10.dp).height(300.dp)
    )
}