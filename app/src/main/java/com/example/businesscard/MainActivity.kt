package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black) // Define o fundo como preto
                ) { innerPadding ->
                    BusinessCard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .heightIn(min = 400.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.DarkGray)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.rap_profile), // Coloque sua imagem aqui
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(160.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp, topEnd = 16.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Ricardo Araújo Pereira",
                fontSize = 24.sp,
                color = Color.White // Nome em branco
            )
            Text(
                text = "Humorista e Jornalista",
                fontSize = 16.sp,
                color = Color.LightGray // Texto secundário em cinza claro
            )
            //cria espaco vazio de 16dp
            Spacer(modifier = Modifier.height(50.dp))

            // Definindo a Column que irá conter os ContactInfo alinhados à esquerda
            Column(
                modifier = Modifier
                    .fillMaxWidth() // Garante que ocupe toda a largura
                    .padding(horizontal = 16.dp), // Um pequeno padding para manter espaço nas laterais
                horizontalAlignment = Alignment.CenterHorizontally
                        //horizontalAlignment = Alignment.Start alinha a esquerda
            ) {
                ContactInfo(icon = Icons.Default.Phone, info = "910254884")
                ContactInfo(icon = Icons.Default.MailOutline, info = "ricardoap@gmail.com")
                ContactInfo(icon = Icons.Default.Share, info = "@ricardo_araujo_pereira")
            }
        }
    }
}

@Composable
fun ContactInfo(icon: ImageVector, info: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF66BB6A)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = info,
            fontSize = 14.sp,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
