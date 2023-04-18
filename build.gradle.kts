plugins {
    // REQUIRED: We are writing tests in Java, change this only if you want to use another language
    java
    id("io.qameta.allure") version "2.8.1"
}

// REQUIRED: Declare the dependencies that you want to use in your tests. We are using dynamic version ranges here
//           and later on lock the currently used versions in a lockfile. If you want to use a specific version
//           of a dependency, feel free to adjust the version here.
dependencies {
    testImplementation("io.cucumber:cucumber-java:7.11.2") {
        because("we want to use Cucumber JVM")
    }
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.11.2") {
        because("we want to use Cucumber with JUnit 5")
    }
    testImplementation("org.junit.platform:junit-platform-suite:1.9.2") {
        because("we want to use the JUnit 5 @Suite annotation to select/run Cucumber tests")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2") {
        because("we want to use JUnit 5 assertions - replace this if you want to use another assertions library")
    }
    testImplementation("io.rest-assured:rest-assured:5.3.0") {
        because("we want to use RestAssured for make http request")
    }
    testImplementation("io.rest-assured:json-path:5.3.0") {
        because("we want to use RestAssured for make http request")
    }
    implementation("io.qameta.allure:allure-cucumber5-jvm:2.13.3"){
        because("we want to use Allure Report")
    }
}

allure {
    version = "2.13.3"
    autoconfigure = true
    aspectjweaver = true
    resultsDir = file("allure-results")
    reportDir = file("allure-report")
    configuration = "implementation"
    useJUnit5 {
        version= "2.13.3"
    }
}

tasks {

    withType<JavaCompile> {
        dependsOn("clean")
    }

    test {
        useJUnitPlatform {
            excludeTags("ignore")
            if (project.hasProperty("includeTags")) includeTags(project.property("includeTags") as String?)
        }
        ignoreFailures = true
        systemProperties(project.gradle.startParameter.systemPropertiesArgs)
        systemProperty("cucumber.options", "--plugin io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm, pretty, html:target/cucumber-report/report.html, json:target/cucumber-report/report.json")
        systemProperty("cucumber.junit-platform.naming-strategy", "long")
        systemProperty("cucumber.publish.quiet","true")
        testLogging.showStandardStreams=true
        outputs.upToDateWhen { false }
    }
}




