package com.example.businesscard

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        FullNameCard(
            fullName = stringResource(id = R.string.my_name),
            title = stringResource(id = R.string.title)
        )

        ContactBusinessCard(
            phoneNumber = stringResource(id = R.string.number_telephone),
            telegram = stringResource(id = R.string.telegram),
            email = stringResource(id = R.string.email)
        )
    }
}

@Composable
fun FullNameCard(fullName: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {
        val image = painterResource(id = R.drawable.android_logo)
        Image(painter = image, contentDescription = null,
        Modifier.size(200.dp))
        Text(
            text = fullName, fontWeight = FontWeight.Bold, color = Color.White,
            fontSize = 40.sp
        )
        Text(text = title, color = Color.White, fontSize = 20.sp)

    }
}

@Composable
fun ContactBusinessCard(
    phoneNumber: String, telegram: String, email: String,
    modifier: Modifier = Modifier
) {
    Column(Modifier.padding(top = dimensionResource(id = R.dimen.padding_20))) {
        Row(Modifier.padding(top = dimensionResource(id = R.dimen.padding_8))) {
            val imagePhone = painterResource(id = R.drawable.baseline_phone_24)
            Image(
                painter = imagePhone, contentDescription = null,
                Modifier.padding(start = dimensionResource(id = R.dimen.padding_16))
            )
            Text(
                text = phoneNumber,
                Modifier.padding(start = dimensionResource(id = R.dimen.padding_4)),
                color = Color.White
            )
        }
        Row(Modifier.padding(top = dimensionResource(id = R.dimen.padding_8))) {
            val imageShare = painterResource(id = R.drawable.baseline_share_24)
            Image(
                painter = imageShare, contentDescription = null,
                Modifier.padding(
                    start = dimensionResource(
                        id = R.dimen.padding_16
                    )
                )
            )
            Text(
                text = telegram,
                Modifier.padding(start = dimensionResource(id = R.dimen.padding_4)),
                color = Color.White
            )

        }
        Row(Modifier.padding(top = dimensionResource(id = R.dimen.padding_8))) {
            val imageEmail = painterResource(id = R.drawable.baseline_email_24)
            Image(
                painter = imageEmail, contentDescription = null,
                Modifier.padding(
                    start = dimensionResource(
                        id = R.dimen.padding_16
                    )
                )
            )
            Text(
                text = email,
                Modifier.padding(start = dimensionResource(id = R.dimen.padding_4)),
                color = Color.White

            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}