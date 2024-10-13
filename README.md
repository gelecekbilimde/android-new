# Gelecek Bilimde Community Science Communication App

This repository provides a starting point for Android applications following the **MVVM architecture pattern** (Model-View-ViewModel). It aims to promote clean code practices, separation of concerns, and ease of testing.

## 📐 Project Architecture

This app is built on the **MVVM architecture pattern**, which ensures a well-structured and maintainable codebase. Here's an overview of the three key components:

- **Model**:  
  Responsible for data handling and business logic. It is independent of the UI and handles tasks like fetching remote or local data.

- **View**:  
  Displays the UI and interacts with the user. It observes the data from the ViewModel and reflects the changes accordingly.

- **ViewModel**:  
  Acts as a bridge between the Model and View. It manages the data for the UI and handles user actions. It ensures the UI logic is independent of the UI components and survives configuration changes (like screen rotation).

### Why MVVM?
- **Separation of Concerns**: Organized code that is easier to maintain.
- **Data Binding**: Synchronizes the data between the ViewModel and View automatically.
- **Testability**: Each component can be tested independently.

---

## ⚙️ Technologies and Libraries Used

- **Kotlin**: Main programming language for Android development.
- **Hilt-Dagger**: Dependency injection framework to provide dependencies across the app.
- **Retrofit**: Type-safe HTTP client for making network requests.
- **Room**: Object-relational mapping (ORM) library for local SQLite database access.
- **Coroutines**: Asynchronous programming with Kotlin's coroutines for smooth background operations.
- **LiveData**: Lifecycle-aware observable data holder for UI components.
- **ViewModel**: Manages UI-related data that survives configuration changes.
- **ViewBinding**: Type-safe access to XML layout elements without `findViewById()`.
- **Jetpack Navigation**: Handles navigation and simplifies fragment and activity transitions.

---

## 🚀 Getting Started

Follow these steps to set up the project on your local machine:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ferhatozcelik/android-mvvm-template.git

## 📄 License

This version is now in **Markdown (.md)** format, ready to be used as a `README.md` file. Let me know if further changes are needed!

