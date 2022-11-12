import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.compose.compose

group "com.example"
version "1.0-SNAPSHOT"

plugins {
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.compose") apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
