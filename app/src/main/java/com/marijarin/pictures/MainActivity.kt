package com.marijarin.pictures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.marijarin.pictures.dto.ImgRes
import com.marijarin.pictures.dto.picsResList
import com.marijarin.pictures.dto.testImgRes
import com.marijarin.pictures.ui.theme.PicturesTheme
import com.marijarin.pictures.ui.theme.md_theme_light_onSurfaceVariant
import com.marijarin.pictures.ui.theme.md_theme_light_outline

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PicturesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PicturesLayout()
                }
            }
        }
    }
}

@Composable
fun PicturesLayout() {
    val picList = mutableListOf(testImgRes)
    picList.addAll(picsResList)
    var imageResource by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .background(md_theme_light_outline)
            .padding(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(10))
                .border(16.dp, md_theme_light_onSurfaceVariant, RoundedCornerShape(10)),
            painter = painterResource(id = picList[imageResource].image),
            contentDescription = stringResource(id = R.string.picture),
            contentScale = ContentScale.Fit
        )
        Text(text = stringResource(id = R.string.author),
            modifier = Modifier
            .padding(top = 16.dp),
            textAlign = TextAlign.Center,
        fontSize = 14.sp)
        Text(
            text = picList[imageResource].author,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp,
        )
        Text(text = picList[imageResource].year.toString(),
            modifier = Modifier
                .padding(top = 4.dp),
            textAlign = TextAlign.Center,
            fontSize = 14.sp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ){
            Button(onClick = {
                if (imageResource < picList.size){
                    imageResource++
                } else if (imageResource == picList.size){
                    imageResource = 0
                }
            }) {
                Text(stringResource(id = R.string.previous), fontSize = 20.sp)
            }
            Button(onClick = {
                if (imageResource > 0){
                    imageResource--
            } else if (imageResource == 0) {
                imageResource = picList.size-1
            }
            }) {
                Text(stringResource(id = R.string.next), fontSize = 20.sp)
            }
        }
}
}

@Preview(showBackground = true)
@Composable
fun PicturesLayoutPreview() {
    PicturesTheme {
        PicturesLayout()
    }
}