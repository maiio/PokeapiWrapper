README

Desafio bankaya

Este proyecto expone los siguientes endpoints: 
● abilities
● base_experience
● held_items
● id
● name
● location_area_encounters
Todo esto a partir del WSDL http://localhost:8080/PokeapiWrapperSoapService?wsdl

Seguir los siguientes pasos para correr el proyecto:

1.- Clonar el proyecto:
git clone https://github.com/maiio/PokeapiWrapper.git

2.- Cambiarse a la raiz del proyecto:
cd PokeapiWrapper

3.- Cambiarse al branch feature-bankaya-challenge
git checkout -b feature-bankaya-challenge

4.- Construir la magen con docker:
docker build -t pokeapiwrapper-challenge .

5.- Ejecutar con docker
docker run -p 8080:8080 pokeapiwrapper-challenge

6.- Con soap ui crear un proyecto con el wsdl http://localhost:8080/PokeapiWrapperSoapService?wsdl

7.- Probar los endpoints

8.- Enviarme retro al correo mayolo.miranda@gmail.com

