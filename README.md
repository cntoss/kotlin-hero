# Jetpack Compose Sample App: Hero

This is a simple Android application built using **Jetpack Compose**. It demonstrates basic navigation, API integration using **Retrofit**, and UI components like **Scaffold**, **TopAppBar**, **LazyColumn**, and **Drawer**.

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

## 🚀 Getting Started

###  Clone the repository

```bash
git clone git remote add origin https://github.com/cntoss/kotlin-hero.git
cd kotlin-hero
```

## 📁 Project Structure
```bash
├── data/remote/
│   api/
│   └── ApiService.kt
│   model/
│   └── User.kt
├── ui/screens/
│   └── HomeScreen.kt
│   └── UsersScreen.kt
│   └── ProfileScreen.kt
├── viewmodel/
│   └── UsersViewModel.kt
└── MainActivity.kt
```
