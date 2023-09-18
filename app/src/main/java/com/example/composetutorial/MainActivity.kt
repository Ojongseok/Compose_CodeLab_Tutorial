package com.example.composetutorial

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTutorialTheme {
                AlignYourBodyRow()
            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .padding(all = 8.dp),
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.onSurface
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        }
    )
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            modifier = modifier
                .padding(top = 24.dp, bottom = 8.dp)
                .background(color = Color.Blue, shape = RoundedCornerShape(8.dp))
                .padding(all = 4.dp),
            text = stringResource(text),
            color = Color.White
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp),
                text = stringResource(text),
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    val alignYourBodyData = mutableListOf<AlignYourBodyData>()
    alignYourBodyData.add(AlignYourBodyData(R.drawable.sameple_image2, R.string.image_string))
    alignYourBodyData.add(AlignYourBodyData(R.drawable.sameple_image2, R.string.image_string))
    alignYourBodyData.add(AlignYourBodyData(R.drawable.sample_image, R.string.image_string))
    alignYourBodyData.add(AlignYourBodyData(R.drawable.sameple_image2, R.string.image_string))
    alignYourBodyData.add(AlignYourBodyData(R.drawable.sample_image, R.string.image_string))

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp)
    ) {
        items(alignYourBodyData) {
            AlignYourBodyElement(it.drawable, it.text)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun OnboardingPreview() {
    ComposeTutorialTheme {
        AlignYourBodyRow()
    }
}

//@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
//@Composable
//fun OnboardingPreview2() {
//    ComposeTutorialTheme {
//        SearchBar()
//    }
//}
//
//@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
//@Composable
//fun OnboardingPreview3() {
//    ComposeTutorialTheme {
//        AlignYourBodyElement()
//    }
//}