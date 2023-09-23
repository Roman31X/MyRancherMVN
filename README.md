# __MyRancher V2.0.0__ ||:computer:||:cow:||:tractor:

## DESCRIPCION

Segunda Versión Software Desktop reforzando temas de estructura __MVC__ y una escalabilidad en 
su desarrollo con Patrones __SOLID__. Para que el software conservara la información ingresada 
se le agrego nuevas tecnologías en su estructura. Partiendo en el lenguaje __JAVA__ e implementando 
paquetes swing para la interfaz gráfica, __JAR__ de paquetes para conexión a base de datos 
__MySQL WorkBench 8.0__, __JAR__ de paquetes para poder generar graficas estadísticas con la 
información almacenada en la base de datos, Tecnología __MAVEN__ para la importación y descarga 
de los JAR necesarios para el funcionamiento del software. 

## ARCHIVOS EXTRA:

* DIAGRAMA UML || :book:

<a href="https://github.com/Roman31X/MyRancherMVN/tree/master/src/main/resources/DiagramaUML" >Diagrama UML trabajado Draw.io</a>

* ARCHIVO TEXT CON CODIGO MySQL || :book:

<a href="https://github.com/Roman31X/MyRancherMVN/tree/master/src/main/resources/ArchivoMySQL" >Archivo text con codigo fuente para ejecutar en MySQL</a>


### DISEÑO INTERFAZ 

<di>
<table>
<tr>
<th>LOGIN</th>
<th>REGISTRO</th>
</tr>
<tr>
<td><img src="https://github.com/Roman31X/MyRancherMVN/blob/master/src/main/resources/Capturas_Aplicacion/Login.png" />
</td></td>
<td><img src="https://github.com/Roman31X/MyRancherMVN/blob/master/src/main/resources/Capturas_Aplicacion/Registro.png" /></td>
</tr>
</table>
</div>

### DISEÑO DE MENU

<div align="center" valign="middle" >
<table>
<tr>
<th>MENU LOGIN</th>
</tr>
<tr>
<td><img width="800" heigth="400" src="https://github.com/Roman31X/MyRancherMVN/blob/master/src/main/resources/Capturas_Aplicacion/MenuInicio.png" /></td>
</tr>
<tr>
<th>MENU MODIFICACAR</th>
</tr>
<tr>
<td><img width="800" heigth="400" src="https://github.com/Roman31X/MyRancherMVN/blob/master/src/main/resources/Capturas_Aplicacion/MenuModificar.png" /></td>
</tr>
<tr>
<th>MENU PRINCIPAL</th>
</tr>
<tr>
<td><img width="800" heigth="400" src="https://github.com/Roman31X/MyRancherMVN/blob/master/src/main/resources/Capturas_Aplicacion/MenuPricipalInterfaces.png" /></td>
</tr>
</table>
</div>

## FUNCIONALIDAD

* LOGIN DE SEGURIDAD DE USUARIO || :closed_lock_with_key:

Para  una mejor seguridad del software se previo de que los datos del usuario no se encuentren en código duro, Por ende se optó por almacenar y 
consultar a un gestor de base de datos en este caso MySQL Workbench 8.0.

* REGISTRO DE NUEVO USUARIO A LA BASE DE DATOS || :memo:

Para no limitar la poca información de nuestros usuarios, se adaptó la interfaz de registro para que este tenga  un mejor control de información 
con el gestor datos, almacenando información individual por nuevo usuario a trabajar con el software y control de su información.

* MENU MODIFICAR || :writing_hand:

Se brinda una opción en el menú para proporcionar información del usuario a través de la interfaz, donde se puede apreciar los campos a modificar
 con su información personal. Manejo se verán reflejados tiempo real en nuestro gestor de datos. 

* MENU PRINCIPAL || :bar_chart:

Para  una mejor gestión de la información se optó por segmentar las interfaces en la gestión de información agrícola con la Gestión de Terrenos, 
la información con insumos almacenados en la propiedad con la Gestión de Almacén, la información del sector ganadero con el segmento de Gestión 
de Ganado para una mejor administración de las cabezas de res y su producción.

* CERRAR SESION || :lock:

Por último, la opción de cerrar sesión nos permitirá cerrar la interfaz de menú redirigiéndonos a la interfaz de Login.

## PRUEBAS DE EJECUCIÓN

<div>
<table>
<tr>
<th>PRIMERA PARTE</th>
</tr>
<tr>
<td><img width="800" heigth="400" src="https://github.com/Roman31X/MyRancherMVN/blob/master/src/main/resources/Capturas_Aplicacion/Prueba1.gif" /></td>
</tr>
<tr>
<th>SEGUNDA PARTE</th>
</tr>
<tr>
<td><img width="800" heigth="400" src="https://github.com/Roman31X/MyRancherMVN/blob/master/src/main/resources/Capturas_Aplicacion/Prueba2.gif" /></td>
</tr>
</table>
</div>

