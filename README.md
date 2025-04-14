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
  <img src="https://github.com/user-attachments/assets/a48c141f-038b-4f85-a0b5-31cb07a53831" width="300" alt="Pantalla principal VigiForm">
</p>

---

## 🛠️ Estructura del Proyecto
```plaintext
app
├── manifests
├── kotlin+java
│ ├── com.example.vigiform
│ │ ├── navigation
│ │ ├── DrawerItems.kt ✓
│ │ ├── icons.kt ✓
│ │ ├── items.kt ✓
│ │ ├── NavigationHost.kt ✓
│ │ └── Routes
├── screens
│ ├── AboutScreen.kt ✓
│ ├── DensityScreen.kt ✓
│ ├── DosageScreen.kt ✓
│ ├── KineticEnergyScreen.kt ✓
│ └── OhmsLawScreen.kt ✓
├── ui.theme
│ └── MainActivity.kt ✓
├── res
├── font (4)
| ├── josefinsans_bold.ttf
| ├── josefinsans_light.ttf
| ├── josefinsans_medium.ttf
| ├── josefinsans_regular.ttf
├──── values
│ ├── colors.xml ✓
│ ├── ic_launcher_background.xml ✓
├── strings (4)
│ ├── strings.xml ✓
│ ├── strings.xml (en) ✓
│ ├── strings.xml (ja) ✓
│ ├── strings.xml (ru) ✓
