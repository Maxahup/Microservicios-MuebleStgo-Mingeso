# Microservicios-MuebleStgo-Mingeso
Aquí se encuentran los microservicios diseñados, los  cuales deben cumplir con permitir subir un archivo .txt con las marcas de ingreso y salida de los trabajadores registrados en las bd correspondientes, el sistema ademas permite el calculo de una planilla de sueldos en base a esto.


Estos microservicios se encuentran diseñados para obtener sus configuraciones y puertos desde el microservicio config-service, así como también la aplicación se encuentra dockerizada para funcionar a travéz de dos archivos .yml de dockercompose, uno encargado de levantar inicialmente el configservice junto a eureka, mientras que el otro se encarga de levantar las bases de datos y el resto de los microservicios (sin considerar al frontend).

El frontend también se encuentra dockerizado disponible para ser ejecutado en el puerto estático 3001 del localhost.
