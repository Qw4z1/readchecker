package io.nyblom.readchecker.ui

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.nyblom.readchecker.GetReadsQuery
import io.nyblom.readchecker.ReadsState
import io.nyblom.readchecker.copyBlogPostUrl
import io.nyblom.readchecker.openBlogPost

@Preview(showBackground = true)
@Composable
fun ReadsList(@PreviewParameter(ReadsPreviewProvider::class) readState: ReadsState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        readState.reads.forEach {
            ItemRow(slug = it.slug, count = it.read_count.toString())
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemRow(slug: String, count: String) {
    val context = LocalContext.current
    Card(
        border = BorderStroke(Dp.Hairline, MaterialTheme.colorScheme.secondary),
        modifier = Modifier.combinedClickable(
            onClick = { openBlogPost(context, slug) },
            onLongClick = { copyBlogPostUrl(context, slug) },
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
        ) {
            Text(
                text = slug,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = count,
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

class ReadsPreviewProvider : PreviewParameterProvider<ReadsState> {
    override val values = sequenceOf(
        ReadsState(
            listOf(
                GetReadsQuery.Read(
                    slug = "left_and_right",
                    read_count = 12
                ),
                GetReadsQuery.Read(
                    slug = "effortless",
                    read_count = 120
                ),
                GetReadsQuery.Read(
                    slug = "why_blog",
                    read_count = 47
                ),
            )
        )
    )
}