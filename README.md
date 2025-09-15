
//// Microservicio de Plataforma Educativa - CI/CD
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Descripción
Este repositorio contiene un microservicio para una plataforma de educación tecnológica (EduTech), desarrollado en ** Java Spring Boot**, con un **pipeline de integración y entrega continua (CI/CD)** configurado mediante **GitHub Actions**.

El objetivo es demostrar un flujo DevOps básico, incluyendo:
- Control de versiones con Git y ramas (`main`, `develop`, `feature/*`, `hotfix/*`)
- Automatización de pruebas y builds
- Integración y despliegue continuo (CI/CD)

// Modelo de ramificación
Se utiliza **GitFlow** debido a que:
- Permite un desarrollo organizado mediante ramas `feature` y `hotfix`.
- Facilita la colaboración en equipo.
- Mantiene `main` estable para producción y `develop` para integración de cambios.

Ramas principales:
- `main`: versión estable lista para producción
- `develop`: integración de todas las funcionalidades antes del release
- `feature/<nombre>`: nuevas funcionalidades
- `hotfix/<nombre>`: correcciones urgentes



// Flujo de trabajo
1. Crear rama `feature/*` para implementar una funcionalidad.
2. Hacer commits claros y descriptivos.
3. Abrir **Pull Request** hacia `develop` para revisión.
4. Merge a `develop` tras aprobación.
5. Para correcciones urgentes, crear `hotfix/*` y merge a `main` y `develop`.

// Pipeline CI/CD (GitHub Actions)
Workflow configurado para:
- **push** a la rama `develop`
- **pull request** hacia `main`

El pipeline realiza:
1. Checkout del repositorio
2. Setup de JDK 17
3. Build con Maven (`mvn clean package`)
4. Ejecución de pruebas automáticas

Archivo del workflow: `.github/workflows/ci.yml`

// Estructura del proyecto
- `src/` → Código fuente del microservicio
- `target/` → Build generado por Maven (no subir al repo)
- `.github/workflows/` → Workflows de GitHub Actions (pipeline CI/CD)
- `pom.xml` → Configuración de Maven y dependencias
- `README.md` → Documentación del proyecto

// Tecnologías y herramientas utilizadas
- **Java 17**
- **Spring Boot 3.x**
- **Maven**
- **Base de datos MySQL**
- **IntelliJ IDEA** (editor de código)
- **Git y GitHub** (control de versiones y colaboración)
- **GitHub Actions** (CI/CD)

## Autor
**Francisco Bascur Arévalo**

---

/ Nota
Este repositorio forma parte de la **Evaluación Parcial N°1 de Ingeniería DevOps**, demostrando buenas prácticas de control de versiones, ramas GitFlow y pipeline CI/CD con GitHub Actions.



