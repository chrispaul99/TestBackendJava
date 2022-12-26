<a name="readme-top"></a>

<br />
<div align="center">
  <h3 align="center">Instalación rápida de la aplicación/servicio en SpringBoot</h3>
</div>


## Acerca de la aplicación/servicio
En la base de datos de comercio electrónico de la compañía disponemos de la tabla PRICES que refleja el precio final (pvp) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. A continuación se muestra un ejemplo de la tabla con los campos relevantes:

PRICES
-------

| BRAND_ID      | START_DATE           | END_DATE            | PRICE_LIST|PRODUCT_ID|PRIORITY|PRICE |CURR |
| ------------- | -------------------- |---------------------|-----------|----------|--------|------|-----|
| 1             | 2020-06-14-00.00.00  | 2020-12-31-23.59.59 |  1        |35455     | 0      |35.50 | EUR |
| 1             | 2020-06-14-15.00.00  | 2020-06-14-18.30.00 |  2        |35455     | 1      |25.45 | EUR |
| 1             | 2020-06-15-00.00.00  | 2020-06-15-11.00.00 |  3        |35455     | 1      |30.50 | EUR |
| 1             | 2020-06-15-16.00.00  | 2020-12-31-23.59.59 |  4        |35455     | 1      |38.95 | EUR |

 
Campos: 
 
* BRAND_ID: foreign key de la cadena del grupo (1 = ZARA).
* START_DATE , END_DATE: rango de fechas en el que aplica el precio tarifa indicado.
* PRICE_LIST: Identificador de la tarifa de precios aplicable.
* PRODUCT_ID: Identificador código de producto.
* PRIORITY: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico).
* PRICE: precio final de venta.
* CURR: iso de la moneda.

Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta  tal que:
 
Acepte como parámetros de entrada:
* fecha de aplicación
* identificador de producto
* identificador de cadena.

Devuelva como datos de salida: 
* identificador de producto
* identificador de cadena
* tarifa a aplicar
* fechas de aplicación
* precio final a aplicar.
 
Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los mismos).

##  Primeros Pasos

A continuación se detallan los pasos respectivos para la instalación de la aplicación/servicio

##  Datos Técnicos

* Java 11
* Spring Boot version 2.7.7

### Prerequisitos

* Debe tener instalado Spring Boot
* Debe tener instalado Postman

### Instalación

1. Primero clone el repositorio
* git
  ```sh
  git clone https://github.com/chrispaul99/TestBackendJava.git
  ```

Ejecutar proyecto Spring Boot

2. En la carpeta del repositorio buscamos una carpeta llamada testbackend.  Abrimos el proyecto con nuestro IDE o editor de preferencia que puede ser Eclipse IDE o en mi caso Visual Studio Code previo a una configuración.  

3. A continuación ejecutamos el proyecto Spring Boot que se ejecuta en el puerto 9001 y se accede a su API a través del siguiente enlace:
   * web
    ```sh
    http://localhost:9001/api/
    ```
4. Para ejecutar el endpoint solicitado debemos usar la siguiente ruta:
    Prices
    * GET 
     ```sh
     http://localhost:9001/api/prices/getPriceInDate?product={product_id}&brand={brand_id}&date={date}
     ```
    | Parámetros    | Tipo de Dato  |
    | ------------- | ------------- |
    | product       | Integer       |
    | brand         | Integer       |
    | date          | String      |


### Pruebas Realizadas
1. Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)

    ENTRADA:
    * product_id: 35455
    * date: 2020-06-14 10:00:00
    * brand_id : 1

    SALIDA:
    <image src="/tests/test1.png" alt="Test1">

2. Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)

    ENTRADA:
    * product_id: 35455
    * date: 2020-06-14 16:00:00
    * brand_id : 1

    SALIDA:
    <image src="/tests/test2.png" alt="Test2">

3. Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)

    ENTRADA:
    * product_id: 35455
    * date: 2020-06-14 21:00:00
    * brand_id : 1

    SALIDA:
    <image src="/tests/test3.png" alt="Test3">

4. Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
    ENTRADA:
    * product_id: 35455
    * date: 2020-06-15 10:00:00
    * brand_id : 1

    SALIDA:
    <image src="/tests/test4.png" alt="Test4">

5. Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)

    ENTRADA:
    * product_id: 35455
    * date: 2020-06-16 21:00:00
    * brand_id : 1

    SALIDA:
    <image src="/tests/test5.png" alt="Test5">


<p align="right">(<a href="#readme-top">back to top</a>)</p>

