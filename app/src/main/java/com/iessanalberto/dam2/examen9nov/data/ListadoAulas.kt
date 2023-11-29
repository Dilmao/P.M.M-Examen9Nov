package com.iessanalberto.dam2.examen9nov.data

val aula1: Aula = Aula(
    name = "Aula 1",
    description = "Aula con capacidad para 24 alumnos, orientación sur",
    recursos = mutableListOf<String>("Ordenador","Proyector","Pizarra")
)

val aula2: Aula = Aula(
    name = "Aula 2",
    description = "Aula con capacidad para 24 alumnos, orientación sur",
    recursos = mutableListOf<String>("Ordenador","Proyector","Pizarra")
)
val aula3: Aula = Aula(
    name = "Aula 3",
    description = "Aula con capacidad para 22 alumnos, orientación sur",
    recursos = mutableListOf<String>("Ordenador","Proyector","Pizarra")
)
val aula101: Aula = Aula(
    name = "Aula 101",
    description = "Aula con capacidad para 24 alumnos, orientación norte",
    recursos = mutableListOf<String>("Ordenador","Proyector","Pizarra")
)
val aula102: Aula = Aula(
    name = "Aula 102",
    description = "Aula con capacidad para 24 alumnos, orientación sur, primer piso",
    recursos = mutableListOf<String>("Ordenador","Proyector","Pizarra")
)
val aula103: Aula = Aula(
    name = "Aula 103",
    description = "Aula con capacidad para 24 alumnos, orientación sur",
    recursos = mutableListOf<String>("Ordenador","Proyector","Pizarra")
)

val listadoAulas: List<Aula> = listOf(
    aula1,
    aula2,
    aula3,
    aula101,
    aula102,
    aula103
)