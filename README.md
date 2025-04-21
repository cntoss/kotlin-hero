# Jetpack Compose Sample App: Hero

This is a simple Android application built using **Jetpack Compose**. It demonstrates basic navigation, API integration using **Retrofit**, and UI components like **Scaffold**, **TopAppBar**, **LazyColumn**, and **Drawer**.

---

## 🛠️ Prerequisites

- Android Studio Bumblebee or later.
- Minimum SDK version: 21.
- Recommended: Android Emulator or a physical device for testing.

---

## ✨ Features

- 🏠 **Home Screen**  
  - Contains a navigation drawer.
  - Allows access to other screens (Users, Profile).
  
- 👤 **Users Screen**  
  - Fetches user data from a remote API (`https://reqres.in/api/users`).
  - Displays a list of users using `LazyColumn`.
  - Shows a loading indicator during data fetching.
  
- 🙍 **Profile Screen**  
  - Static screen representing user profile.

---

## 🔧 Tech Stack

| Technology | Usage |
|------------|-------|
| [Jetpack Compose](https://developer.android.com/jetpack/compose) | Declarative UI toolkit |
| [Retrofit](https://square.github.io/retrofit/) | REST API client |
| [OkHttp + LoggingInterceptor](https://square.github.io/okhttp/) | Logging network calls |
| [ViewModel + State](https://developer.android.com/topic/libraries/architecture/viewmodel) | State management |
| [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) | Asynchronous operations |
| [Room Database](https://developer.android.com/training/data-storage/room) | Local database for offline storage |

---

## 📚 Key Concepts

### Jetpack Compose
- A modern toolkit for building native Android UIs declaratively.
- Simplifies and accelerates UI development on Android.

### MVVM Architecture
- The app follows the **Model-View-ViewModel (MVVM)** architecture pattern:
  - **Model**: Handles data operations (e.g., Room, Retrofit).
  - **View**: Displays data and reacts to user interactions (Jetpack Compose UI).
  - **ViewModel**: Manages UI-related data and handles business logic.

---

## 📦 Screens Overview

### 🏠 Home Screen
- Contains a **Scaffold** with a **Drawer**.
- Navigation options:
  - Home
  - Users
  - Profile

### 👥 Users Screen
- Calls API on launch.
- Shows a loading spinner (`CircularProgressIndicator`).
- Lists users using custom `UserItem` components.

### 👤 Profile Screen
- Placeholder for user profile info.

---

## 🗄️ Room Database

The app uses **Room Database** for local data storage. It provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

### Key Components:
- **Entity**: Represents a table in the database.
- **DAO (Data Access Object)**: Contains methods to access the database.
- **Database**: The main access point to the persisted data.

### Benefits:
- Simplifies database operations.
- Provides compile-time verification of SQL queries.
- Supports LiveData and Flow for reactive programming.

---

## 🌐 API Integration

- The app fetches user data from the public API: `https://reqres.in/api/users`.
- Retrofit is used for network calls, and OkHttp handles logging.

---

## 🚀 Getting Started

### Clone the repository

```bash
git clone git remote add origin https://github.com/cntoss/kotlin-hero.git
cd kotlin-hero
```

---

## 🧪 Testing

### Unit Testing
- The app includes unit tests for ViewModel and Repository layers.
- Uses **JUnit** and **Mockito** for testing.

### UI Testing
- UI tests are written using **Jetpack Compose Testing** APIs.
- Example: Verifying UI components like `LazyColumn` and `Scaffold`.

---

## 📁 Project Structure
```bash
├── data/
│   ├── remote/
│   │   ├── api/
│   │   │   └── ApiService.kt
│   │   ├── model/
│   │   │   └── User.kt
│   ├── local/
│   │   ├── database/
│   │   │   ├── AppDatabase.kt
│   │   │   ├── UserDao.kt
│   │   │   └── UserEntity.kt
│   ├── repository/
│       └── UserRepository.kt
├── ui/
│   ├── components/
│   │   └── UserItem.kt
│   ├── screens/
│   │   ├── HomeScreen.kt
│   │   ├── UsersScreen.kt
│   │   ├── ProfileScreen.kt
├── viewmodel/
│   ├── UsersViewModel.kt
├── utils/
│   └── Constants.kt
└── MainActivity.kt
```

---

## 📝 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
