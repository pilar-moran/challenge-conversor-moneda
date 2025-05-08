# 💱 Conversor de Monedas - Java

Este es un proyecto de consola desarrollado en Java que permite realizar conversiones entre diferentes monedas utilizando una API de tasas de cambio en tiempo real.


## 🚀 Características

- Conversión en tiempo real entre las siguientes monedas:
    - Dólar estadounidense (USD)
    - Peso chileno (CLP)
    - Peso argentino (ARS)
    - Peso colombiano (COP)
    - Real brasileño (BRL)
- Interfaz de usuario interactiva por consola.
- Consulta automática a la API, para obtener la conversión de la cantidad que el usuario ingrese.
- Estructura del proyecto organizada por paquetes:
    - `modelo` – Clases que representan los datos.
    - `logica` – Clase que gestiona la interacción con el usuario.
    - `servicio` – Lógica para conectarse con la API externa.
    - `util` – Clase de utilidad que proporciona métodos estáticos, para ser reutilizados.
    - `principal` – Punto de entrada de la aplicación.


## 🛠 Tecnologías utilizadas

- Java 17
- IDE recomendado: IntelliJ IDEA
- API: [ExchangeRate-API](https://www.exchangerate-api.com/)
- Biblioteca para parseo JSON: `Gson`


## ✅ Cómo ejecutar la aplicación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/pilar-moran/challenge-conversor-moneda.git
