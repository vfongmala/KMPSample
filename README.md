This is a Kotlin Multiplatform project targeting Android, iOS, Web, Server.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* `/server` is for the Ktor server application.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [GitHub](https://github.com/JetBrains/compose-multiplatform/issues).

You can open the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task.


## Learning note
#### Note #1
##### 1.  To run server us command
```
./gradlew :server:run
```
##### 2. IDE
Fleet IDE is slightly better integrated with KMP than Android Studio


##### 3. Set response type to JSON
```
call.respondText(
  contentType = ContentType.Application.Json,
  text = /*Text*/
)
```

##### 4. To connect Android emulator with localhost on machine
```
adb reverse tcp:<port> tcp:<port> // port is the same value as in Constants.SERVER_PORT
```
```
adb reverse --reset-all // to reset tcp to default
```

#### Note #2
##### 1. IDE
Even though Fleet IDE is better integrated but Android Studio can handle gradle sync in UI better, in case I don't want to use command line

##### 2. Module dependency
Better not to get confused on where to implement the dependency

##### 3. Json Serialization
First time using kotlin serialization instead of Gson.

#### Note #3
[Ktor fullstack docs](https://ktor.io/docs/full-stack-development-with-kotlin-multiplatform.html#add-update-functionality)
##### 1. DI
Use Koin for Dependencies Injection

##### 2. Logic
Keep logic part in `shared` module
`composeApp` module is for app related feature

##### 3. Using Ktor for multiplatform
In `shared/build.gradle.kts` need to add client for each platform in dependencies too

```
sourceSets {
    androidMain.dependencies {
        implementation(libs.ktor.client.android)
    }
    commonMain.dependencies {
        // put your Multiplatform dependencies here
        implementation(libs.ktor.serialization.json)
        implementation(libs.ktor.client.core)
        implementation(libs.ktor.client.content.negotiation)
    }
    iosMain.dependencies {
        implementation(libs.ktor.client.darwin)
    }
}
```

##### 4. Calling localhost from emulator
No need to use `adb reverse` but can set host address on client to machine local IP address
```
defaultRequest {
    host = "192.168.1.109" // local ip address
    port = 8080
}
```

##### 5. Android network call setup
Needing to set `usesCleartextTraffic` to be able to call localhost
```
<application
    android:usesCleartextTraffic="true"
```
and set permission for internet
```
<uses-permission android:name="android.permission.INTERNET"/>
```