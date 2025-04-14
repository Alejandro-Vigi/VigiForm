# VigiForm - Calculadora Científica ⚡📐⚗️

VigiForm es una aplicación desarrollada en **Kotlin** con **Jetpack Compose**, diseñada para realizar cálculos de fórmulas científicas comunes de forma simple, elegante y multilingüe. Esta app es ideal para estudiantes, docentes o cualquier persona interesada en física, química y biología.

## 📲 Características

- 🧮 **Ley de Ohm** (Corriente, Voltaje, Resistencia)
- ⚗️ **Densidad**
- 💊 **Dosificación de Fármaco**
- 🏃‍♂️ **Energía Cinética**
- 🌐 **Soporte Multilenguaje**: Español, Inglés, Japonés y Ruso
- 🎨 **Diseño moderno con Jetpack Compose**
- 🧠 **Sin hardcoding**: Textos, colores y fórmulas definidos mediante recursos
- 🧪 Íconos personalizados definidos como vectores `ImageVector`

## 🧪 Fórmulas implementadas

### Ley de Ohm
- **V = I × R**
- **I = V / R**
- **R = V / I**

### Densidad
- **ρ = m / V**

### Energía Cinética
- **E = ½ × m × v²**

### Dosificación de Fármaco
- **D = (Dᵣ × m) / Cᶠ**

## 🌐 Idiomas Soportados

- 🇪🇸 Español
- 🇬🇧 Inglés
- 🇯🇵 Japonés
- 🇷🇺 Ruso

Las traducciones están organizadas desde el `translations editor` para asegurar consistencia y accesibilidad global.

## 🧱 Arquitectura del Proyecto

- **Kotlin con Jetpack Compose**
- **Resources separados para textos (`strings.xml`) y colores (`colors.xml`)**
- **Uso de `MaterialTheme` para consistencia visual**
- **Componentes reutilizables y composables claros**
- **Códigos limpios y comentados**
- **Sin Hard-coding**

## 🎨 Capturas de Pantalla

<p align="center">
  <img src="https://github.com/user-attachments/assets/b733b730-51e1-4251-8509-74a33daa369f" width="300" alt="Pantalla principal VigiForm">
</p>

---

## 🛠️ Estructura del Proyecto
```plaintext
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/vigiform/
│   │   │   ├── navigation/
│   │   │   ├── screens/
│   │   │   ├── theme/
│   │   │   └── MainActivity.kt
│   │   └── res/
│   │       ├── values/
│   │       ├── values-en/
│   │       ├── values-ja/
│   │       └── values-ru/
├── build.gradle.kts
└── Gradle Scripts/
    ├── build.gradle.kts (Project: VigiForm)
    └── build.gradle.kts (Module: app)

