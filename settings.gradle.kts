import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

rootProject.name = "gherkin-automation-workshop"

dependencyResolutionManagement {
    repositories {
        // REQUIRED: All of our dependency are available in maven central
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}