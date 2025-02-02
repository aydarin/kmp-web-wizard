package org.jetbrains.webwiz.generator.files

import org.jetbrains.webwiz.generator.ProjectFile

class GradleProperties : ProjectFile {
    override val path = "gradle.properties"
    override val content: String
        get() = """
#Gradle
org.gradle.jvmargs=-Xmx2048M -Dkotlin.daemon.jvm.options\="-Xmx2048M"

#Kotlin
kotlin.code.style=official

#Android
android.useAndroidX=true

#MPP
kotlin.mpp.enableGranularSourceSetsMetadata=true
kotlin.native.enableDependencyPropagation=false
kotlin.mpp.enableCInteropCommonization=true
    """.trimIndent()
}