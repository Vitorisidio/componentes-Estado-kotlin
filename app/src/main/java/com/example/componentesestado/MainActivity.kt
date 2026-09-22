package com.example.componentesestado

import android.graphics.drawable.Icon
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.componentesestado.ui.theme.ComponentesEstadoTheme
import com.example.componentesestado.ui.theme.Righteous


// Classe principal da aplicação
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            ComponentesEstadoTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    BasicComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


// Tela principal com os componentes básicos
@Composable
fun BasicComponentsScreen(modifier: Modifier = Modifier) {

    // Estados dos campos de texto
    var textFieldValue by remember {
        mutableStateOf("")
    }

    val textFieldValue2 = remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }


    // Estados dos Checkboxes
    var kotlin by remember {
        mutableStateOf(false)
    }

    var jetpackCompose by remember {
        mutableStateOf(false)
    }

    var android by remember {
        mutableStateOf(false)
    }


    // Estado do RadioButton selecionado
    var sistemaSelecionado by remember {
        mutableStateOf(0)
    }


    // Estado da cor de fundo
    var corFundo by remember {
        mutableStateOf(Color(239, 247, 207))
    }


    // Estado do botão de favorito
    var favoritado by remember {
        mutableStateOf(false)
    }


    // Container principal da tela
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(corFundo)
    ) {

        // Título principal
        Text(
            text = "Aulas android",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84),
            fontFamily = FontFamily.Serif,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            letterSpacing = 4.sp
        )


        // Subtítulo
        Text(
            text = "com Jetpack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(66, 133, 244),
            fontFamily = Righteous,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )


        // Campo de texto para nome
        TextField(
            value = textFieldValue,

            onValueChange = { novoValor ->
                textFieldValue = novoValor
            },

            modifier = Modifier.fillMaxWidth(),

            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            ),

            label = {
                Text("Nome e Sobrenome")
            },

            // Ícone no lado esquerdo
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Icone pessoa",
                    tint = Color(66, 133, 244)
                )
            },

            // Ícone no lado direito
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Icone pessoa",
                    tint = Color(66, 133, 244)
                )
            }
        )


        // Campo de texto para quantidade
        TextField(
            value = textFieldValue2.value,

            onValueChange = { novoValor ->
                textFieldValue2.value = novoValor
            },

            modifier = Modifier.fillMaxWidth(),

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),

            placeholder = {
                Text(text = "Qual a quantidade")
            },

            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Blue,
                unfocusedTextColor = Color.Red,
                unfocusedPlaceholderColor = Color.Magenta
            )
        )


        // Espaçamento entre os componentes
        Spacer(
            modifier = Modifier.height(16.dp)
        )


        // Campo de texto para email
        OutlinedTextField(
            value = email,

            onValueChange = {
                email = it
            },

            singleLine = true,

            modifier = Modifier.fillMaxWidth(),

            label = {
                Text("Email")
            },

            placeholder = {
                Text(text = "Digite seu email")
            },

            shape = RoundedCornerShape(
                topStart = 32.dp,
                bottomEnd = 32.dp
            ),

            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Red
            )
        )


        // Checkbox - Kotlin
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = kotlin,

                onCheckedChange = {
                    kotlin = it
                },

                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text(
                text = "Kotlin"
            )
        }


        // Checkbox - Jetpack Compose
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = jetpackCompose,

                onCheckedChange = {
                    jetpackCompose = it
                },

                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text(
                text = "Jetpack compose"
            )
        }


        // Checkbox - Android
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = android,

                onCheckedChange = {
                    android = it
                },

                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )

            Text(
                text = "Android"
            )
        }


        // RadioButton - MacOS
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = sistemaSelecionado == 0,

                onClick = {
                    sistemaSelecionado = 0
                }
            )

            Text(
                text = "MacOs"
            )
        }


        // RadioButton - Windows
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = sistemaSelecionado == 1,

                onClick = {
                    sistemaSelecionado = 1
                }
            )

            Text(
                text = "Windows"
            )
        }


        // RadioButton - Linux
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = sistemaSelecionado == 2,

                onClick = {
                    sistemaSelecionado = 2
                }
            )

            Text(
                text = "Linux"
            )
        }


        // Linha com os dois botões
        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceAround
        ) {

            // Botão normal
            Button(
                onClick = {
                    corFundo = Color.White
                },

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ),

                border = BorderStroke(
                    4.dp,
                    Color.Black
                ),

                shape = RoundedCornerShape(
                    topEnd = 12.dp,
                    bottomStart = 12.dp
                )
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star"
                    )

                    Text(
                        text = "Clique aqui!"
                    )
                }
            }


            // Botão com borda
            OutlinedButton(
                onClick = {
                    corFundo = Color.Cyan
                }
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Clique aqui!"
                    )
                }
            }
        }


        // Botão de favorito
        Row(
            modifier = Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.Center
        ) {

            // Verifica se está favoritado
            if (favoritado) {

                // Ícone de favorito preenchido
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            favoritado = false
                        },

                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite Icon"
                )

            } else {

                // Ícone de favorito vazio
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            favoritado = true
                        },

                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite Icon"
                )
            }
        }
    }
}


// Componente que exibe a imagem do Android
@Composable
fun AndroidEnemy(
    color: Color,
    modifier: Modifier = Modifier
) {

    Image(
        painter = painterResource(
            R.drawable.ic_launcher_foreground
        ),

        colorFilter = ColorFilter.tint(color),

        contentDescription = "Android Enemy"
    )
}