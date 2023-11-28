package ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.Quest
import domain.QuestsManager


@Composable
fun QuestsGameScreen(onClick: (Screen) -> Unit) {

    val questsManager = QuestsManager()
    var actualCountry by remember { mutableStateOf<Quest>(questsManager.getRandomQuest()) }
    var answerEditText by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }
    var streak by remember { mutableStateOf(0) }


    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Column(modifier = Modifier.align(alignment = Alignment.Center)) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color(0xFFF9F9F9),
                text = "Definition:",
                style = TextStyle(
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Black,
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color(0xFFF9F9F9),
                text = actualCountry.description,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = answerEditText,
                onValueChange = {
                    answerEditText = it
                },
                placeholder = {
                    Text(
                        text = "Enter Capital",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                },
                modifier = Modifier.padding(all = 16.dp).width(256.dp).align(Alignment.CenterHorizontally),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text,
                ),

                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                maxLines = 2,
                singleLine = true,
            )

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {

                Button(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2E3BE0)),
                    onClick = {

                        if (answerEditText.lowercase() == actualCountry.acronim.lowercase()) {
                            error = false
                            actualCountry = questsManager.getRandomQuest()
                            streak += 1
                            answerEditText = ""
                        } else {
                            streak = 0
                            error = true
                        }


                    }) {
                    Text(color = Color(0xFFF9F9F9), text = "CHECK")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2E3BE0)),
                    onClick = {
                        error = false
                        actualCountry = questsManager.getRandomQuest()
                        answerEditText = ""
                        streak = 0
                    }) {
                    Text(color = Color(0xFFF9F9F9), text = "PASS")
                }
            }

            if (error) {

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "Try Again!",
                    color = Color(0xFFDB2626)
                )
            }

        }

        Text(
            modifier = Modifier.align(Alignment.TopStart), text = "Streak: $streak", color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            fontFamily = FontFamily.SansSerif
        )

        Button(
            modifier = Modifier.align(alignment = Alignment.BottomStart),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2E3BE0)),
            onClick = { onClick(Screen.MainScreen) }) {
            Text(color = Color(0xFFF9F9F9), text = "BACK")
        }


    }


}
