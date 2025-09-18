plugins {
    id("java")
    application
}

group = "app.belgarion.tech.expr_eval"
version = "1.0-SNAPSHOT"
tasks.jar {
    manifest {
        attributes["Main-Class"] = "app.belgarion.tech.expr_eval.Main" // <-- your main class here
    }
}
repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:15.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
application {
    mainClass.set("app.belgarion.tech.expr_eval.Main")
}
tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}