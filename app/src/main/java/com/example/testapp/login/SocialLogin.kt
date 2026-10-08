package com.example.testapp.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldLabelPosition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.R

@Preview(showSystemUi = true , showBackground = true)
@Composable
fun SocialLogins() {

    val usernameState = rememberTextFieldState("") // MOST OPTIMIZED WAY FOR WORKING WITH OUTLINEDTEXTFIELD OR TEXTFIELD
    val passwordState = rememberTextFieldState("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 55.dp),
        verticalArrangement = Arrangement.spacedBy(
            space = 20.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.image),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(100.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Welcome Back",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(space = 10.dp)
        ) {
            OutlinedTextField(
                state = usernameState,
                label = { Text("Username") },
                labelPosition = TextFieldLabelPosition.Above(),
                placeholder = { Text("Enter your username") },
                lineLimits = TextFieldLineLimits.SingleLine
            )
            Box(
                contentAlignment = Alignment.CenterEnd
            ) {
                OutlinedSecureTextField(
                    state = passwordState,
                    label = { Text("Password") },
                    labelPosition = TextFieldLabelPosition.Above(),
                    placeholder = { Text("Enter your password") },
                    textObfuscationMode = TextObfuscationMode.Hidden
                )

                Icon(
                    imageVector = Icons.Default.RemoveRedEye,
                    contentDescription = "Show",
                    modifier = Modifier
                        .padding(top = 23.dp, end = 10.dp)
                        .size(18.dp)
                        .clickable(onClick = {}),
                    tint = Color.DarkGray
                )
            }
            FilledTonalButton(
                enabled = usernameState.text.trim().isNotEmpty() && passwordState.text.trim().isNotEmpty(),
                onClick = {},
                modifier = Modifier.fillMaxWidth(0.95f),
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.filledTonalButtonElevation(
                    defaultElevation = 2.dp,
                    pressedElevation = 5.dp
                ),
                shape = RoundedCornerShape(6.dp)

            ) {
                Text(
                    text = "Login"
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black, shape = RoundedCornerShape(size = 10.dp))
                .border(width = 2.dp, color = Color.Red, shape = RoundedCornerShape(size = 10.dp))
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
//            BUTTONS BY DEFAULT HAVE HEIGHT OF 48DP TO COVER THE FINGER TIPS
//            NEVER MODIFIER BACKGROUND TO COLOR ANY BUTTONS AS IT BREAKS THE RIPPLE COLOR EFFECT OF BUTTONS
            TextButton(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(Color.White)
            ) {
                Text(
                    text = "Google",
                    color = Color.Black,
                    fontSize = 14.sp,
                )
            }
            TextButton(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(Color.White)
            ) {
                Text(
                    text = "Twitter",
                    color = Color.Black,
                    fontSize = 14.sp,
                )
            }
            TextButton(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(Color.White)
            ) {
                Text(
                    text = "Facebook",
                    color = Color.Black,
                    fontSize = 14.sp,
                )
            }
        }
    }
}