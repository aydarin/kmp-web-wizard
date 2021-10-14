package org.jetbrains.webwiz.generator.files

import org.jetbrains.webwiz.generator.ProjectFile
import org.jetbrains.webwiz.generator.ProjectFileFromResources

class GradleWrapperProperties(val gradleVersion: String) : ProjectFile {
    override val path = "gradle/wrapper/gradle-wrapper.properties"
    override val content: String
        get() = """
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-$gradleVersion-bin.zip
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
""".trimIndent()
}

class GradleWrapperJar : ProjectFileFromResources {
    override val path = "gradle/wrapper/gradle-wrapper.jar"
    override val content = "/* binary file */"
    override val resourcePath = "./binaries/gradle-wrapper"
}