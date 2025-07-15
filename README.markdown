# ThousandsCourses

**ThousandsCourses** is an Android app for browsing and managing IT course information. It fetches course details from an external API and allows users to view, sort, and favorite courses, with persistent storage using Room. Built with Clean Architecture, XML layouts, and modern Android libraries.

---

## 🧰 Key Features

* **Login Screen**:
  * Users can log in with email and password (validation included).
  * Social media login buttons (VK, OK) redirect to respective websites (non-functional placeholders).
* **Home Screen**:
  * Displays a list of courses fetched from the API (https://drive.usercontent.google.com/).
  * Features non-functional search and filter icons (hardcoded per design).
  * Supports sorting courses by `publishDate` in descending order.
  * Limits course description to two lines, truncating longer text.
* **Favorites Screen**:
  * Shows courses marked as favorites (stored locally in Room database).
* **Account Screen**:
  * Placeholder screen for user account information.
* **Bottom Navigation**:
  * Persistent menu with Home (default), Favorites, and Account screens.

---

## 📁 Project Structure

```
ThousandsCourses/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/thousandscourses/
│   │   │   │   ├── data/                 # Data layer
│   │   │   │   │   ├── api/              # API service and DTOs
│   │   │   │   │   ├── local/            # Room database and entities
│   │   │   │   │   ├── mapper/           # Mappers for DTO ↔ Domain ↔ Entity
│   │   │   │   │   ├── repository/       # Repository implementations
│   │   │   │   ├── di/                   # Dependency injection (Hilt)
│   │   │   │   ├── domain/               # Business logic layer
│   │   │   │   │   ├── model/            # Domain models
│   │   │   │   │   ├── repository/       # Repository interfaces
│   │   │   │   │   ├── usecase/          # Use cases for business logic
│   │   │   │   ├── ui/                   # UI layer (XML layouts)
│   │   │   │   │   ├── account/          # Account screen
│   │   │   │   │   ├── favorite/         # Favorites screen
│   │   │   │   │   ├── home/             # Home screen
│   │   │   │   │   ├── login/            # Login screen
│   │   │   ├── res/                      # Resources (layouts, drawables, themes)
│   │   │   │   ├── layout/               # XML layouts
│   │   │   │   ├── values/               # Themes, colors, strings
```

---

## ⚙️ Technologies Used

* **Kotlin** for development.
* **XML Layouts** for UI (per Figma designs).
* **Room** for local storage of course data and favorites.
* **Dagger Hilt** for dependency injection.
* **Retrofit** for API calls to https://drive.usercontent.google.com/.
* **Kotlin Coroutines + Flow** for asynchronous operations and state management.
* **MVVM + Clean Architecture** for modular design.
* **AdapterDelegates** for efficient RecyclerView management.

---

## 📊 Technical Highlights

* **API Integration**:
  * Fetches course data using Retrofit with Gson for JSON parsing.
* **Persistent Storage**:
  * Stores course data and favorite status in a Room database.
* **Interactive UI**:
  * Supports toggling favorite status with local database updates.
  * Clicking the sort button orders courses by `publishDate` (descending).
* **Clean Architecture**:
  * Separates concerns with data, domain, and presentation layers.
* **State Management**:
  * Uses StateFlow in ViewModels for reactive UI updates.

---

## 📃 Code Style and Conventions

* Follows Clean Architecture with clear separation of data, domain, and presentation layers.
* Uses MVVM for UI and business logic separation.
* Employs Dagger Hilt for dependency injection.
* Adheres to Figma designs for UI elements (colors, fonts, icons).
* Ensures type safety with Kotlin’s nullability features.

---

## 🚀 Getting Started

1. Install Android Studio (latest stable version recommended).
2. Clone the repository:

   ```bash
   git clone https://github.com/Bphoenix134/ThousandsCourses.git
   ```
3. Build and run the app:

   ```bash
   ./gradlew assembleDebug
   ```
4. Main entry point: `LoginActivity`.

---

## 📸 Screenshots

Below are placeholders for the app's key screens (to be updated with actual screenshots):

| Login Screen | Home Screen | NavigationBar |
|--------------|-------------|------------------|
| <img src="screenshots/login_screen.jpg" width="200"/> | <img src="screenshots/home_screen.jpg" width="200"/> | <img src="screenshots/navigation_bar.jpg" width="200"/>

---

## 📌 Notes

* Course data is fetched from the provided API and stored locally using Room.
* The `publishDate` field is used for sorting courses in descending order.
* Favorites are persisted locally and can be viewed in the Favorites screen.