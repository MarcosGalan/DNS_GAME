package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.loadSvgPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.File


@Composable
fun MainScreen(onClick: ()-> Unit) {
    val file = File(System.getProperty("user.dir")+"\\src\\main\\resources\\images\\internet-connection.svg")
    val imageSvg = remember{ loadSvgPainter(file.inputStream(), Density(64f)) }


    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                tint = Color(0xFFF9F9F9),
                modifier = Modifier.size(248.dp),
                painter = imageSvg,
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                color = Color(0xFFF9F9F9),
                text = "DNS GAME",
                style = TextStyle(fontSize = 48.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2E3BE0)), onClick = {onClick()}) {
                Text(color = Color(0xFFF9F9F9), text = "PLAY!")
            }
        }
    }
}