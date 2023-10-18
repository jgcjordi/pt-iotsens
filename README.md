# Technical prove to IoT Sens 🧮

This have two parts, this is the backend side.
On the folder others is the description

## How to run it

```shell
docker-compose up --build
```

## Endpoint Curl


getPriceOfProduct:
```shell
curl --location 'http://localhost:8080/price/35455?applicationDate=2020-06-20T12%3A00%3A00'
```

getAllPrices:
```shell
curl --location 'http://localhost:8080/price/all'
```

## Tests 

I used the same db to work locally by now to execute the tests because I set a transactional to not persist the information
To execute it you must rise up the db first

```shell
docker-compose up db
```

after this you can execute the tests with the ▶️

## Observations

Como en el enunciado (dentro de la carpeta others) en el punto 3, pone que puedo cambiar los datos del ejemplo. He sacado brand_id de la tabla price ya que creo que esto debería ir dentro de product, ya que cada producto tiene una marca. Y price ya se relaciona con product a través del id y por consiguiente con la marca en concreto.

De la misma forma creo que la petición del precio REST del punto 1 no necesitaría que se le pase también el identificador de la marca porque esto ya va implícito en él id del producto.

Hago el filtro del local date en la capa de aplicación porque aplica lógica de negocio y en principio no debería haber muchos precios, si no fuera así lo podría añadir también en la query.

He añadido un test más para comprobar el caso de que no encuentra un precio para esa fecha.

En condiciones normales haría los test de integración que testean toda la api como el que esta hecho. Y por otro lado haría test unitarios mockeando lo que no tiene que ver con el funcionamiento de la clase, en este caso al ser una prueba me limito ha hacer lo que dice el enunciado.

He usado la misma base de datos que usamos para hacer las pruebas en local, para ejecutar los tests, en condiciones normales crearía una nueva solo para esto. Pero actualmente lo dejo así con un @Transactional para que no persista los cambios en la bd local.