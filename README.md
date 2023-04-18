## Workshop Gherkin + Automatización
### Objetivos de Workshop
- Organizar  los Gherkin en archivos feature según buenas prácticas
- Automatizar archivos feature con Cucumber

### Requisitos
- Tener instalado GIT
- Tener instalado Java
- Tener instalado Intellij IDEA o algún IDE similar

### Intrucciones
- Clonar el repositorio
- Abrir el proyecto con el IDE, se empezarán a descargar las dependencias de Gradle.
- Los tests se pueden ejecutar:
    - Desde la task <code>test</code> de Gradle.
    - Desde terminal ejecutando el comando <code>./gradlew test</code>.
- Se deberían crear los siguientes reportes:
    - Dentro de las carpeta <code>target</code>, se crean los reportes de cucumber en formato json y html.
    - Para abrir el reporte Allure, es necesario:
      - Ejecutar la task <code>downloadAllure</code> de Gradle para bajar la dependencias restantes. (Solo es necesario hacer esto la primera vez por única vez)
      - Ejecutar la task <code>allureServe</code> de Gradle