package com.iessanalberto.dam2.examen9nov.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iessanalberto.dam2.examen9nov.R
import com.iessanalberto.dam2.examen9nov.navigation.AppScreens
import kotlin.system.exitProcess

@Composable
fun LoginScreen(navController: NavController) {
    //Declaracion de variables
    var user by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var intentos by rememberSaveable { mutableStateOf(3) }
    var showAlert by rememberSaveable { mutableStateOf(false) }
    var context = LocalContext.current


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = painterResource(id = R.drawable.logo_ies),
            contentDescription = "Logo instituto",
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(30.dp)),
            contentScale = ContentScale.Crop
        )

        //Entrada de usuario y contraseña
        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text(text = "Introduce usuario") })
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Introduce contraseña") })

        //Boton para entrar
        Button(onClick = {
            //Comprobacion de usuario, contraseña e intentos
            if (user.equals("admin") && password.equals("admin") && intentos > 0) {
                navController.navigate(AppScreens.SelectionScreen.route)

            //Distintos mensajes dependiendo si le quedan o no intentos
            } else if (intentos > 0) {
                Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                intentos--
            } else {
                showAlert = true
            }

            //Se vacian los OutlinedTextField
            user = ""
            password = ""
        }) {
            Text(text = "Entrar")
        }

        //Alerta por fallar 3 veecs y cierre de aplicacion
        if (showAlert) {
            AlertDialog(
                title = { Text(text = "Mensaje") },
                text = { Text(text = "Has fallado 3 veces y se cerrara la aplicacion") },
                onDismissRequest = { exitProcess(0) },
                confirmButton = {
                    TextButton(
                        onClick = { exitProcess(0) }
                    ) {
                        Text(text = "Ok")
                    }
                }
            )
        }
    }
}