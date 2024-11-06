import org.jetbrains.gradle.ext.settings
import org.jetbrains.gradle.ext.taskTriggers

plugins {
    kotlin("jvm") version "2.0.20-Beta1"
    kotlin("kapt") version "2.0.20-Beta1"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("eclipse")
    id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.8"
}

group = "kr.awr.kdv.ls"
version = "1.21.1-R0.1-SNAPSHOT"


val versionFile = file("version.txt")
var versionNumber: String

if (versionFile.exists()) {
    versionNumber = versionFile.readText().trim()
} else {
    versionNumber = "1.0.0" // 파일이 없으면 기본값 설정
}

// Gradle 버전 설정
version = versionNumber

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")   
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://repo.dmulloy2.net/repository/public/")

    mavenCentral()
}


dependencies {
    //  compileOnly group: "com.comphenix.protocol", name: "ProtocolLib", version: "4.8.0";
    compileOnly ("com.comphenix.protocol:ProtocolLib:5.1.0")
    compileOnly("com.velocitypowered:velocity-api:3.3.0-SNAPSHOT")
    kapt("com.velocitypowered:velocity-api:3.3.0-SNAPSHOT")
    compileOnly("org.spigotmc:spigot-api:1.21.1-R0.1-SNAPSHOT")
    implementation("com.google.code.gson:gson:2.10.1")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    annotationProcessor("com.velocitypowered:velocity-api:3.2.0-SNAPSHOT")
}



val targetJavaVersion = 17
kotlin {
    jvmToolchain(targetJavaVersion)
}

val templateSource = file("src/main/templates")
val templateDest = layout.buildDirectory.dir("generated/sources/templates")
val generateTemplates = tasks.register<Copy>("generateTemplates") {
    val props = mapOf("version" to project.version)
    inputs.properties(props)

    from(templateSource)
    into(templateDest)
    expand(props)
}


tasks.build {
    dependsOn("incrementVersion") // 빌드 전에 버전 증가 작업 실행
}

tasks.register("incrementVersion") {
    doLast {
        val versionParts = versionNumber.split(".").map { it.toInt() }.toMutableList()
        versionParts[2] += 1 // 패치 버전 증가
        versionNumber = versionParts.joinToString(".")
        version = versionNumber

        // 버전 파일에 새 버전 쓰기
        versionFile.writeText(versionNumber)
        println("Version updated to $versionNumber")
    }
}
sourceSets.main.configure { java.srcDir(generateTemplates.map { it.outputs }) }

project.idea.project.settings.taskTriggers.afterSync(generateTemplates)
project.eclipse.synchronizationTasks(generateTemplates)

tasks.register<Exec>("gitPublish") {
    group = "upload"
    description = "GitHub에 커밋하고 푸시합니다."

    commandLine("cmd","/c", "publish.bat"
    )
}
