package com.demo.nytimes.presentation.view

import android.annotation.SuppressLint
import android.content.*
import android.os.Bundle
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import androidx.core.view.isVisible
import com.demo.nytimes.R
import com.demo.nytimes.databinding.ActivityNewsDetailsBinding
import com.demo.nytimes.domain.model.*
import com.demo.nytimes.presentation.viewmodel.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NyNewsDetailActivity : AppCompatActivity() {

    companion object {

        private const val NEWS_EXTRA = "news"

        fun getStartIntent(context: Context, news: NyNews): Intent {
            return Intent(context, NyNewsDetailActivity::class.java).apply {
                putExtra(NEWS_EXTRA, news)
            }
        }
    }


    private lateinit var binding: ActivityNewsDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        load()
    }

    private fun load() {
        val news = intent.extras?.get(NEWS_EXTRA) as NyNews
        setUpToolbar(news.title!!)
        drawContent(news)
    }

    private fun setUpToolbar(repository: String) {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.title = repository
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    @SuppressLint("SetTextI18n")
    private fun drawContent(news: NyNews) {
        with(binding) {
            content.isVisible = true
            labelId.text = getString(R.string.id).htmlText(news.id.toString())
            labelName.text = getString(R.string.name).htmlText(news.title.toString())
            labelDescription.text =
                getString(R.string.description).htmlText(news.abstract.toString())
            labelUrl.text = getString(R.string.url).htmlLink(news.url.toString())
            labelUrl.movementMethod = LinkMovementMethod.getInstance()
            labelPublishedDate.text =
                getString(R.string.published_date).htmlText(news.publishedDate.toString())
            labelUpdated.text =
                getString(R.string.updated).htmlText(news.updated.toString())
        }
    }

    private fun String.htmlText(value: String): Spanned {
        return HtmlCompat.fromHtml("$this<br/><b>$value</b>", FROM_HTML_MODE_COMPACT)
    }

    private fun String.htmlLink(value: String): Spanned {
        return HtmlCompat.fromHtml(
            "$this<br/><b><a href=\"$value\">$value</a></b>",
            FROM_HTML_MODE_COMPACT
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}