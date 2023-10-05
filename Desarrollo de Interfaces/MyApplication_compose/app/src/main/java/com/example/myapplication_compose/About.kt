import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication_compose.R

data class DataAbout(
    @DrawableRes var imagen: Int,
    var name:String,
    var points:String,
)
@Composable
fun about() {

    var selectedTitles by rememberSaveable { mutableStateOf(emptyList<String>()) }
    val scrollState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = scrollState
    ) {
        item {
            Spacer(modifier = Modifier.size(10.dp))
        }
        items(getInfoAbout()) { dataAbout ->
            ItemAbout(dataAbout = dataAbout)
        }
    }
}

fun getInfoAbout(): List<DataAbout> {
    return listOf(
        DataAbout(R.drawable.image1, "Alejandro Sanchez", "Puntos: 2014"),
        DataAbout(R.drawable.image2, "Isabel Fernandez", "Puntos: 2056"),
        DataAbout(R.drawable.image3, "Juan Gomez", "Puntos: 5231"),
        DataAbout(R.drawable.image4, "Marta Jimenez", "Puntos: 1892"),
        DataAbout(R.drawable.image5, "Pedro Ruiz", "Puntos: 3150"),
        DataAbout(R.drawable.image6, "Carmen Soto", "Puntos: 2678"),
        DataAbout(R.drawable.image7, "Luisa Torres", "Puntos: 4325"),
        DataAbout(R.drawable.image8, "Raul Morales", "Puntos: 1746")
    )
}

@Composable
fun ItemAbout(dataAbout: DataAbout) {
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = dataAbout.imagen),
            contentDescription = null,
            modifier = Modifier.size(150.dp).clickable{
                Toast.makeText(context, dataAbout.name, Toast.LENGTH_SHORT).show()
            },
            contentScale = ContentScale.Inside
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = dataAbout.name,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 22.sp
            )
            Text(
                text = dataAbout.points,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 16.sp
            )
        }
    }
}
