package com.example.androidenitp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidenitp.R

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

// Constante du dégradé primaire des bouton
val primaryGradientColor = Brush.horizontalGradient(
    listOf(
        Color(0xFF8bc2ff),
        Color(0xFFa670b8)
    )
);

/**
 * content = les vues qu'on injectes en parametre
 */
@Composable
fun EniTemplatePage(content: @Composable () -> Unit){
    AndroidEniTPTheme {
        Scaffold { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                EniBackgroundPage()
                content()
            }
        }
    }
}

@Composable
fun FragmentTemplatePage(content: @Composable () -> Unit){
    Box() {
        EniBackgroundPage()
        content()
    }
}

@Composable
fun EniBackgroundPage(){
    Image(
        painter = painterResource(id = R.drawable.background_1),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun EniGradientButton(label: String, onClick : () -> Unit = {}){
    Button(
        border = BorderStroke(3.dp, Color(0x77FFFFFF)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clip(RoundedCornerShape(40.dp)),
        contentPadding = PaddingValues(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(primaryGradientColor)
                .fillMaxWidth()
                .padding(vertical = 15.dp)
        ) {
            Text(label)
        }
    }
}

@Composable
fun EniTitleTextPage(title: String, paddingTitle: Dp = 120.dp){
    Text(
        title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = paddingTitle),
        textAlign = TextAlign.Center,
        style = TextStyle(fontSize = 46.sp, color = Color(0xFF282f57),
            shadow = Shadow(color = Color(0x99000000), offset = Offset(0f, 0f), blurRadius = 10f)
        )
    )
}

@Composable
fun EniTextField(label: String, value: String = "", onValueChange: (String) -> Unit = {}){
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        value = value, onValueChange = onValueChange,
        label = { Text(label, style = TextStyle(color = Color.White)) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0x44000000),
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(40.dp)
    )
}

@Composable
fun AndroidEniTPTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}