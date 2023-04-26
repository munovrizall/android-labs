package com.artonov.lemonade

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artonov.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    var randomSqueeze = (1..3).random()
    var squeeze = 0

    when (currentStep) {
        1 -> Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.lemon1)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.lemon_tree),
                contentDescription = stringResource(id = R.string.lemon1desc),
                modifier = Modifier
                    .border(2.dp, Color.Cyan)
                    .clickable { currentStep++ }
            )
        }

        2 -> Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.lemon2)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.lemon_squeeze),
                contentDescription = stringResource(id = R.string.lemon2desc),
                modifier = Modifier
                    .border(2.dp, Color.Cyan)
                    .clickable {
                        squeeze++
                        if (squeeze == randomSqueeze){
                            currentStep++
                        }
                    }
            )
        }

        3 -> Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.lemon3)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.lemon_drink),
                contentDescription = stringResource(id = R.string.lemon3desc),
                modifier = Modifier
                    .border(2.dp, Color.Cyan)
                    .clickable { currentStep++ }
            )
        }

        4 -> Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.lemon4)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.lemon_restart),
                contentDescription = stringResource(id = R.string.lemon4desc),
                modifier = Modifier
                    .border(2.dp, Color.Cyan)
                    .clickable { currentStep = 1 }
            )
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}