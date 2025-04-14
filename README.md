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

[VigiForm](https://github.com/user-attachments/assets/b733b730-51e1-4251-8509-74a33daa369f)

---

## 📁 Estructura del Proyecto

VigiForm/
├── app/
│   ├── manifests/
│   │   └── AndroidManifest.xml
│   ├── kotlin+java/
│   │   └── com.example.vigiform/
│   │       ├── navigation/
│   │       │   ├── DrawerItems.kt
│   │       │   ├── icons.kt
│   │       │   ├── items.kt
│   │       │   └── NavigationHost.kt
│   │       ├── Routes.kt
│   │       ├── screens/
│   │       │   ├── AboutScreen.kt
│   │       │   ├── DensityScreen.kt
│   │       │   ├── DosageScreen.kt
│   │       │   ├── KineticEnergyScreen.kt
│   │       │   └── OhmsLawScreen.kt
│   │       ├── ui.theme/
│   │       │   ├── Color.kt
│   │       │   ├── Theme.kt
│   │       │   └── Type.kt
│   │       └── MainActivity.kt
│   ├── (androidTest)/
│   │   └── com.example.vigiform/
│   │       └── ExampleInstrumentedTest.kt
│   └── (test)/
│       └── com.example.vigiform/
│           └── ExampleUnitTest.kt
├── res/
│   ├── drawable/
│   │   └── (íconos vectoriales)
│   ├── mipmap/
│   │   └── (íconos de launcher)
│   ├── values/
│   │   ├── colors.xml
│   │   ├── ic_launcher_background.xml
│   │   ├── strings.xml (es)
│   │   ├── strings.xml (en)
│   │   ├── strings.xml (ja)
│   │   ├── strings.xml (ru)
│   │   └── themes.xml
│   └── xml/
│       ├── backup_rules.xml
│       └── data_extraction_rules.xml
└── Gradle Scripts/
    ├── build.gradle.kts (Project: VigiForm)
    └── build.gradle.kts (Module: app)

