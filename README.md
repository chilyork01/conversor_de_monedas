Conversor de Monedas - Java
Este es un proyecto de un Conversor de Monedas desarrollado en Java. Utiliza la Exchange Rate API para obtener las tasas de conversión en tiempo real entre diferentes monedas. El usuario puede interactuar con el programa a través de un menú en consola, eligiendo entre diferentes conversiones.

Requisitos
Antes de empezar, asegúrate de tener lo siguiente:

Java JDK 8+ instalado en tu máquina.
Un editor de código como IntelliJ IDEA o cualquier otro que soporte proyectos Java.
Maven (si es que usas dependencias externas como Gson) o asegúrate de agregar la dependencia de Gson manualmente al proyecto.
Dependencias
Este proyecto utiliza la biblioteca Gson para manejar el formato JSON devuelto por la API. Si estás utilizando Maven, asegúrate de agregar la siguiente dependencia en tu archivo pom.xml:

xml
Copy code
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.9</version>
</dependency>
Si no usas Maven, puedes descargar Gson y agregarla manualmente a tu proyecto.

Instalación y Configuración
Clonar el Repositorio

Clona este repositorio en tu máquina local usando el siguiente comando:

bash
Copy code
git clone https://github.com/tu_usuario/conversor_de_monedas.git
Abrir en IntelliJ IDEA

Abre el proyecto clonado en IntelliJ IDEA o en el editor de tu preferencia.

Agregar tu API Key

Para usar este proyecto, necesitas una API Key válida de la Exchange Rate API. Regístrate en su sitio web y obtén tu clave.

Reemplaza la siguiente línea en el archivo Main.java con tu propia clave API:

java
Copy code
String apiKey = "TU_API_KEY";
Ejecutar el Proyecto

Una vez que hayas agregado la clave API, puedes ejecutar el programa desde IntelliJ IDEA o desde la terminal con el siguiente comando:

bash
Copy code
java -cp target/conversor_de_monedas-1.0-SNAPSHOT.jar Main
Funcionamiento del Programa
El programa funciona de la siguiente manera:

Al ejecutar el programa, verás un menú con diferentes opciones de conversión entre monedas como USD, ARS, BRL, COP, y CLP.

Elige una opción, luego ingresa la cantidad de dinero que deseas convertir.

El programa hará una solicitud a la Exchange Rate API y obtendrá la tasa de conversión actual.

Finalmente, se mostrará el monto convertido en la moneda seleccionada.

Ejemplo de Ejecución:
markdown
Copy code
***************************
Sea bienvenido/a al conversor de moneda =]

1) Dólar =>> Peso Argentino
2) Peso Argentino =>> Dólar
3) Dólar =>> Real Brasileño
4) Real Brasileño =>> Dólar
5) Dólar =>> Peso Colombiano
6) Peso Colombiano =>> Dólar
7) Dólar =>> Peso Chileno
8) Peso Chileno =>> Dólar
9) Salir

Elija una opción válida: 1
Ingrese la cantidad de dinero: 100
100 USD es equivalente a 97483.0 ARS
***************************
Estructura del Proyecto
El proyecto tiene la siguiente estructura básica:

bash
Copy code
.
├── src/
│   ├── ApiClient.java        # Clase para hacer las solicitudes a la API de Exchange Rate
│   ├── CurrencyConverter.java# Clase que realiza la conversión de moneda
│   ├── Main.java             # Clase principal donde se ejecuta el programa
│   └── ApiExchangeRateResponse.java  # Clase para manejar la respuesta JSON de la API
├── pom.xml                   # Archivo de configuración de Maven
└── README.md                 # Documento de ayuda del proyecto (este archivo)
Autor
Proyecto desarrollado por Leonardo vergara. Para más información, contáctame en leonardo_vergara531@hotmail.com.
