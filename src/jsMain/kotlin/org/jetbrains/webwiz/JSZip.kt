package org.jetbrains.webwiz

import org.khronos.webgl.ArrayBuffer
import kotlin.js.Promise

@JsModule("jszip")
@JsNonModule
external class JSZip {
    fun file(name: String, content: String): JSZip
    fun file(name: String, content: String, options: dynamic): JSZip
    fun file(name: String, content: ArrayBuffer): JSZip
    fun <T> generateAsync(type: dynamic): Promise<T>
    fun loadAsync(data: dynamic): Promise<JSZip>
    fun forEach(action: (String, ZipObject) -> Unit)
}


@JsModule("jszip")
@JsNonModule
external class ZipObject {

}