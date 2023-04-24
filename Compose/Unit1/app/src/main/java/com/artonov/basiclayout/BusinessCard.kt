package com.artonov.basiclayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.ColorFilter
import com.artonov.basiclayout.ui.theme.BasicLayoutTheme

class BusinessCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowBusinessCard()
                }
            }
        }
    }
}

@Composable
fun ShowBusinessCard(modifier: Modifier = Modifier) {
    Logo()
    ContactInfo()
}

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .height(120.dp)
        )

        Text(
            text = "Jeniffer Doe",
            fontSize = 40.sp,
            color = Color.White
        )

        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 14.sp,
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactInfo(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom
    ) {
        ContactDetail(
            imageVector = Icons.Filled.Phone,
            text = "+11 (123) 444 555 666"
        )
        ContactDetail(
            imageVector = Icons.Filled.Share,
            text = "@AndroidDev"
        )
        ContactDetail(
            imageVector = Icons.Filled.Email,
            text = "jend.doe@android.com"
        )
    }
}

@Composable
fun ContactDetail(imageVector: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .padding(start = 48.dp, bottom = 8.dp)
    ) {
        Icon(
            imageVector,
            contentDescription = null,
            tint = Color(0xFF3ddc84)
        )
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(0xFF3ddc84),
            modifier = Modifier
                .padding(start = 16.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    BasicLayoutTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            ShowBusinessCard()
        }
    }
}