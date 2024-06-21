package com.me.data

import com.me.model.Fact
import com.me.scrollandgridview.R

class DataSource {
    fun loadFacts(): List<Fact> {
        return listOf<Fact> (
            Fact(R.string.fact1, R.drawable.cplusplus),
            Fact(R.string.fact2, R.drawable.csharp),
            Fact(R.string.fact3, R.drawable.java),
            Fact(R.string.fact4, R.drawable.kotlin),
            Fact(R.string.fact5, R.drawable.python),
            Fact(R.string.fact6, R.drawable.javascript),
            Fact(R.string.fact7, R.drawable.swift),

            )
    }
}