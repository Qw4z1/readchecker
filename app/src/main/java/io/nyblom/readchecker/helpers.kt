package io.nyblom.readchecker

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri

private fun blogPostUrl(slug: String) = "${BuildConfig.NYBLOM_IO_BASE_URL_BLOG}${slug}"

fun openBlogPost(context: Context, slug: String) {
    val uri = Uri.parse(blogPostUrl(slug))
    val intent = Intent(Intent.ACTION_VIEW, uri)
    context.startActivity(intent)
}

fun copyBlogPostUrl(context: Context, slug: String) {
    val url = blogPostUrl(slug)
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clipData = ClipData.newPlainText(slug, url)
    clipboard.setPrimaryClip(clipData)
}