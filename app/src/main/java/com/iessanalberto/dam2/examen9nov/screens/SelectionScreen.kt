package com.iessanalberto.dam2.examen9nov.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.iessanalberto.dam2.examen9nov.R
import com.iessanalberto.dam2.examen9nov.data.Aula
import com.iessanalberto.dam2.examen9nov.data.listadoAulas

@Composable
fun SelectionScreen(navController: NavController) {
    Scaffold(
        topBar = { MyTopBar(navController) }
    ) { paddingValues ->
        SelectionScreenBodyContent(modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun SelectionScreenBodyContent(modifier: Modifier) {
    //Declaracion de variables
    var texto by rememberSaveable { mutableStateOf("") }
    var aulaName by rememberSaveable { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 70.dp)) {

        //Busqueda por nombre del aula
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(10.dp)
        ) {
            //Se introduce el nombre del aula a buscar
            OutlinedTextField(
                value = texto,
                onValueChange = {texto = it},
                label = { Text(text = "Nombre de aula") })

            //Se cambia la variable aulaName para buscar las aulas cuyo nombre coincida
            Button(onClick = {
                aulaName = texto
                texto = ""
            }) {
                Text(text = "Buscar")
            }
        }

        //Se muestran las aulas
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 80.dp, bottom = 10.dp, start = 10.dp, end = 10.dp
                )
        ) {
                items(listadoAulas) { aula ->
                    if (aulaName.equals("")) {
                        //Si el OutlinedTextField esta vacio se mostrararn todas las aulas
                        CardRecurso(aula = aula)
                    } else if (aulaName.equals(aula.name)) {
                        //Si no, se mostraran las aulas cuyo nombre coincida
                        CardRecurso(aula = aula)
                    }
                }
        }
    }
}

@Composable
fun CardRecurso(aula: Aula) {
    ElevatedCard(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Image(
                painter = painterResource(id = R.drawable.reserva_aulas),
                contentDescription = "Aulas",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Column {
                //Se muestra la informacion del aula (nombre, descripcion y recursos)
                Text(text = aula.name, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Text(text = aula.description)
                Text(text = "Recursos:")
                for (recurso in aula.recursos) {
                    Text(text = "   * ${recurso}")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(navController: NavController) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Aulas") },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        })
}