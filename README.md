# 🚌 BusMate

> **A robust, console-based Bus Booking System built with Java.**
> Efficiently manage bus fleets and book tickets through an interactive command-line interface.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Platform](https://img.shields.io/badge/Platform-Windows%20%7C%20Linux%20%7C%20macOS-lightgrey?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

---

## 📖 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Project Structure](#-project-structure)
- [Technologies](#-technologies)
- [Getting Started](#-getting-started)
- [Testing](#-testing)
- [Default Credentials](#-default-credentials)

---

## 🔎 Overview

**BusMate** is a simulation of a real-world bus reservation system. It provides a clean separation of concerns between **Administrators** (who manage the fleet) and **Users** (who book travel). The application features in-memory data persistence, input validation, and a visual seat selection interface within the console.

---

## 🚀 Features

### 👮 Admin Module
| Feature | Description |
| :--- | :--- |
| **Fleet Management** | Add new buses with comprehensive details (Route, Capacity, Price). |
| **Inventory Control** | View the entire fleet or search for specific buses by ID. |
| **Maintenance** | Remove obsolete buses from the system. |

### 👤 User Module
| Feature | Description |
| :--- | :--- |
| **Secure Auth** | Registration and Login with email regex validation. |
| **Smart Search** | Filter buses by **Source** and **Destination**. |
| **Visual Booking** | Interactive seat layout (`[O]` Available vs `[X]` Booked). |
| **History** | View past booking details including total price and seat numbers. |

---

## 📂 Project Structure

The project follows a modular **MVC (Model-View-Controller)** inspired architecture:

```sh
src/com/teamproject/busmate/
├── 🏁 BusMate.java           # Main Entry Point
├── 🧪 TestDriver.java        # Automated Test Suite
├── 🧱 Base/                  # Abstract View Classes
├── 🔤 Constants/             # Global Strings & Menus
├── 💾 data/                  # Repository Layer (Singleton Pattern)
├── 📦 model/                 # Data Models (Bus, User, Booking)
├── ⚙️ service/               # Business Logic & Validation
├── 🛠️ util/                  # Helper Utilities
└── 🖥️ view/                  # UI/Menu Implementations
```

---

## 🛠 Technologies

*   **Language**: Java SE (JDK 8+)
*   **Architecture**: Singleton Pattern for Repositories
*   **Validation**: Regex (Email), Logic-based (Seat availability)
*   **UI**: Console-based interactive menus

---

## 🏁 Getting Started

Follow these steps to set up the project locally.

### 1. Compile the Project
```bash
javac -d out -sourcepath src src/com/teamproject/busmate/BusMate.java
```

### 2. Run the Application
```bash
java -cp out com.teamproject.busmate.BusMate
```

---

## 🧪 Testing

We have included a built-in `TestDriver` to programmatically verify all core functionalities (Auth, Booking Logic, Edge Cases).

**Run the Test Suite:**
```bash
javac -d out -sourcepath src src/com/teamproject/busmate/TestDriver.java
java -cp out com.teamproject.busmate.TestDriver
```

**Expected Output:**
> PASS: Bus added.
> PASS: User registered.
> PASS: Login successful.
> ...
> PASS: Caught expected exception: Seat 1 is already booked.

---

## 🔑 Default Credentials

Use these pre-configured accounts for quick testing:

| Role | Username | Password |
| :--- | :--- | :--- |
| **Admin** 👮 | `admin` | `admin` |
| **User** 👤 | `user` | `user` |

---

<p align="center">Made with ❤️ by Kutraleeswaran</p>
