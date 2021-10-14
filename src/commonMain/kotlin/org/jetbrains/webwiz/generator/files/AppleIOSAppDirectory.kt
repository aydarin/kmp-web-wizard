package org.jetbrains.webwiz.generator.files

import org.jetbrains.webwiz.generator.ProjectDirectoryFromResources

class AppleIOSAppDirectory : ProjectDirectoryFromResources {
    override val resourcePath: String = "./apple/swiftUIAppFiles.zip"
    override val path: String = "iosApp/src/iosAppMain/apple/"
}