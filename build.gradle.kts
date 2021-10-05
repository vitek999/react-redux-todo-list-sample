import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig.*

plugins {
    kotlin("js") version "1.5.31"
}

group = "react-redux-todo-list-sample"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers") }
}

dependencies {
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.252-kotlin-1.5.31")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.252-kotlin-1.5.31")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-redux:4.1.0-pre.252-kotlin-1.5.31")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-redux:7.2.4-pre.252-kotlin-1.5.31")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:5.3.1-pre.252-kotlin-1.5.31")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:5.2.0-pre.252-kotlin-1.5.31")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-ring-ui:4.0.47-pre.252-kotlin-1.5.31")

    // for kotlin-ring-ui
    implementation(npm("core-js", "^3.16.0"))
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                mode = if(project.hasProperty("prod")) Mode.PRODUCTION else Mode.DEVELOPMENT
            }
        }
        useCommonJs()
    }
}