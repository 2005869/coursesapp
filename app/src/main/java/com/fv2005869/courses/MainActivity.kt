package com.fv2005869.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fv2005869.courses.data.Datasource
import com.fv2005869.courses.model.Topic
import com.fv2005869.courses.ui.theme.CoursesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoursesApp()
                }
            }
        }
    }
}

@Composable
fun CoursesCardApp(course: Topic, modifier: Modifier = Modifier) {
    val imageSize = 68.dp
    val iconSize = 16.dp
    val paddingCard = 5.dp


    Card(
        modifier = Modifier
            .padding(paddingCard)
    ) {
        Row(
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
                    .height(imageSize)
                    .width(imageSize)
//                    .border(1.dp, Color.Red)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = course.drawableRes),
                    contentDescription = course.course.toString(),
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
            Column(
                modifier = Modifier
//                    .border(1.dp, Color.Green)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Row(
                    modifier = Modifier
//                        .border(1.dp, Color.Green)
                        .padding(16.dp, 16.dp, 16.dp, 8.dp)
                ) {
                    Text(
                        text = stringResource(id = course.stringResourceId),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Row(
                    modifier = Modifier
//                        .border(1.dp, Color.Magenta)
                ) {
                    Column(
                        modifier = Modifier
//                            .border(1.dp, Color.Cyan)
                            .padding(16.dp, 0.dp, 8.dp, 0.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
                            contentDescription = null,
                            modifier = Modifier
                                .height(iconSize)
                                .width(iconSize)
                        )
                    }
                    Column(
                        modifier = Modifier
//                            .border(1.dp, Color.Blue)
                    ) {
                        Text(
                            text = course.course.toString(),
                            style = MaterialTheme.typography.labelMedium
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun CourseGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = Modifier
            .padding(5.dp)
    ) {
        items(Datasource.topics) { topic ->
            CoursesCardApp(course = topic)

        }
    }

}

@Preview
@Composable
fun CoursesApp() {
    Column {
        Text(
            text="Courses App",
            fontSize = 20.sp,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
        CourseGrid()
    }

}