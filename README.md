## [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
## Ingeniería Web: Visión General (IWVG)
### Ecosistema Software
> Este proyecto es un apoyo docente de la asignatura. Cada release liberada corresponde al código utilizado en clase del curso indicado

![GitHub](https://img.shields.io/github/license/miw-upm/iwvg-ecosystem)
![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/miw-upm/iwvg-ecosystem?include_prereleases)
![GitHub Release Date](https://img.shields.io/github/release-date/miw-upm/iwvg-ecosystem)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/miw-upm/iwvg-ecosystem)
![GitHub issues](https://img.shields.io/github/issues/miw-upm/iwvg-ecosystem)
![GitHub closed issues](https://img.shields.io/github/issues-closed/miw-upm/iwvg-ecosystem)

### Estado del código
[![Build Status](https://travis-ci.org/miw-upm/iwvg-ecosystem.svg?branch=develop)](https://travis-ci.org/miw-upm/iwvg-ecosystem)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=es.upm.miw%3Aiwvg-ecosystem&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=es.upm.miw%3Aiwvg-ecosystem)
[![BCH compliance](https://bettercodehub.com/edge/badge/miw-upm/iwvg-ecosystem?branch=master)](https://bettercodehub.com/results/miw-upm/iwvg-ecosystem)
[![Heroku broken](https://iwvg-ecosystem.herokuapp.com/system/badge)](https://iwvg-ecosystem.herokuapp.com/swagger-ui.html)

### Tecnologías necesarias
* Java
* Maven
* GitHub
* Travis-ci
* Sonarcloud
* Better Code Hub
* Spring-boot
* Heroku

### Clonar el proyecto
1. Clonar el repositorio en tu equipo, **mediante consola**:
```sh
> cd <folder path>
> git clone https://github.com/miw-upm/iwvg-ecosystem
```
2. Importar el proyecto mediante **IntelliJ IDEA**
   1. **Import Project**, y seleccionar la carpeta del proyecto.
   1. Marcar **Create Project from external model**, elegir **Maven**.
   1. **Next** … **Finish**.

### :book: Diapositivas
* [Diapositivas de Ecosistemas](docs/miw-iwvg-ecosistema-diapositivas.pdf)   

### :movie_camera: Videos (www.youtube.com/miw-upm)
* [Videos 2019-20 (pendientes de grabar)]()

### :page_with_curl: IWVG. Ecosystem. Enunciado de la práctica

#### 1. Crear un proyecto
Crear un proyecto Maven llamado: **iwvg.ecosystem.nombre.apellido**, versión **1.0.0**. Para ello se aporta **zip** de la plantilla. Añadir tipo de **Licencia**.
> Recordar editar el pom y cambiar el nombre del artefacto (artifactId).   
> Recordar cambiar el nombre de la  carpeta.   
> Importarlo desde IntelliJ.   
> Crear un repositorio en GitHub.   

#### 2. Preparar la gestión mediante Scrum
> Crear un proyecto de gestión en GitHub y prepararlo para la metodología de Scrum (columnas, etiquetas, hitos...).   

#### 3. Sprint 1. Preparación del ecosystema
Se crearán las siguientes historias (**Issues**).
* :one: Integración continua con **Travis-CI**. Incluir **Badge** en README.
* :two: Análisis del código con **Sonarcloud**. Incluir **Badge** en README.
* :three: Análisis del código con **Better Code Hub**. Incluir **Badge** en README.
* :four: Desplegar en **Heroku**.
> :one:, :two:... representa el orden temporal de desarrollo de los issues.

#### 4. Release
> Realizar la primera liberación del código (_**v.1.0.0-release**_)

#### 5. Sprint 2. Preparación del software a desarrollar
Se crearán las siguientes historias (**Issues**).
* Clases :one:**Point** & :five:**PointTest**.
* Clases :two:**User** & :three:**UserTest**.
* Clases :four:**DecimalCollection** & :eight:**DecimalCollectionTest**.
* Clases :six:**Fraction** & :seven:**FractionTest**.
> :one:, :two:... representa el orden temporal de desarrollo de los issues. Cuando un issue se termine se debe incorporar a la rama **develop**. Las clases Point, User, DecimalCollection, Fraction se podrán copiar de las dadas en clase.

#### 6. Release
> Realizar la segunda liberación del código (_**v.1.1.0-release**_)

#### 7. Sprint 3. Preparación mejoras del software
Se crearán las siguientes historias (**Issues**).
* **Point**: :one:mejora 1 y :four:mejora 2.
* **User**: :two:mejora 1 y :seven:mejora 2.
* **DecimalCollection**: :three:mejora 1 y :nine:mejora 2.
* **Fraction**: :five:mejora 1, :six:mejora 2 y :eight:mejora 3.
> :one:, :two:... representa el orden temporal de desarrollo de los issues. Cuando un issue se termine se debe incorporar a la rama **develop**.

Las posibles ampliaciones son libres, o podrían ser las siguientes:   
&nbsp;&nbsp;&nbsp;**Point**   
> Aumentar a una tercera coordenada.   
> Limitar los límites posibles: 0..100, -10..+10...   
> Poder modificar las coordenadas.

&nbsp;&nbsp;&nbsp;**User**   
> Presentar el nombre en mayúsculas.   
> Incluir métodos con otras formas de presentar el nombre completo.   
> Permitir nombres compuestos, separados por blancos y controlar las mayúsculas y minúsculas.

&nbsp;&nbsp;&nbsp;**DecimalCollection**   
> Incluir métodos como menor, multiplicar, tamaño, media...

&nbsp;&nbsp;&nbsp;**Fraction**
> Incluir métodos como isPropia, isImpropia. Las fracciones propias son aquellas cuyo numerador es menor que el denominador, y las fracciones impropias el resto.    
> Incluir el método isEquivalente. Dos fracciones son equivalentes cuando el producto de extremos es igual al producto de medios.   
> Incluir métodos para comparar fracciones: mayor, menor.   
> Incluir métodos para sumar, restar, multiplicar o dividir fracciones.      

#### 8. Release
> Realizar la tercera liberación del código (_**v.1.2.0-release**_)

#### 9. Bug
> Suponer que la mejora 3 de la clase Fraction no es buena y se debe proceder a eliminarla. Realizar la cuarta liberación del código (_**v.1.2.1-release**_).

### :dvd: [Plantilla de la práctica en _docs/iwvg-ecosystem-template.zip_](docs/iwvg-ecosystem-template.zip)

### :clap: Entraga de la práctica
Indicar como texto en la subida las siguientes URLs:
* URL de GitHub
* URL de Travis-CI
* URL de Sonarcloud
* URL de Better Code Hub
* URL del despliegue en Heroku
> **NOTA. Acordarse de dar al botón de envío**

### :ballot_box_with_check: Criterios de evaluación (ver rúbrica)
* Completud y corrección de lo entregado respecto al enunciado.
* Adecuación de la temporalidad de desarrollo según el enunciado.
* Mantenimiento de calidad del código según Travis-CI, Sonar, Better Code Hub.
* Uso correcto del flujo de trabajo ramificado.
* Commits correctos y completos.
* Gestión adecuada y completa (estimación, tiempo real...) durante el desarrollo.
* Planificación temporal adecuada y equilibrada en el desarrollo.
* Código limpio, bien formateado y ordenado.
