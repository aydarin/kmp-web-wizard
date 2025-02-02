package org.jetbrains.webwiz.generator.files

import org.jetbrains.webwiz.generator.NAN
import org.jetbrains.webwiz.generator.ProjectFile
import org.jetbrains.webwiz.generator.deleteNans
import org.jetbrains.webwiz.models.KmpLibrary
import org.jetbrains.webwiz.models.KotlinVersion
import org.jetbrains.webwiz.models.ProjectInfo
import org.jetbrains.webwiz.models.Target

class RootBuildGradle(val projectInfo: ProjectInfo) : ProjectFile {
    override val path = "build.gradle.kts"
    override val content: String
        get() =
            """
buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        ${if (projectInfo.kotlinVersion == KotlinVersion.EAP) "maven(\"https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/\")" else NAN}
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${projectInfo.kotlinVersion.versionName}")
        ${if (projectInfo.dependencies.contains(KmpLibrary.SERIALIZATION)) "classpath(\"org.jetbrains.kotlin:kotlin-serialization:${projectInfo.kotlinVersion.versionName}\")" else NAN}
        ${if (projectInfo.targets.contains(Target.ANDROID)) "classpath(\"com.android.tools.build:gradle:7.0.2\")" else NAN}
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        ${if (projectInfo.kotlinVersion == KotlinVersion.EAP) "maven(\"https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/\")" else NAN}
    }
}
    """.trimIndent().deleteNans()
}