val jupiterVersion = "5.9.0"

plugins {
    id("java")
    idea
    id("io.freefair.lombok") version "6.5.0.2" // TODO double check if it will be really needed
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("software.amazon.awssdk:bom:2.18.6"))
    implementation("software.amazon.awssdk:regions")
    implementation("software.amazon.awssdk:auth")
    implementation("com.google.code.gson:gson:2.10")
    implementation("com.sun.xml.bind:jaxb-impl:4.0.1")
    implementation("org.slf4j:slf4j-api:2.0.3")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jupiterVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$jupiterVersion")
    testImplementation("com.squareup.okhttp3:okhttp:4.10.0")
    testImplementation("org.assertj:assertj-core:3.23.1")
    implementation("org.mockito:mockito-core:4.8.1")
    testRuntimeOnly("ch.qos.logback:logback-classic:1.4.4")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
