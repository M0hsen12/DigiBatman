package com.digibatman.di.database.detail

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail")
class DetailsEntity(
    @PrimaryKey
    @ColumnInfo(name = "detailImdbId")
    var detailImdbId: String,
    @ColumnInfo(name = "detailTitle")
    var detailTitle: String,
    @ColumnInfo(name = "detailPoster")
    var detailPoster: String,
    @ColumnInfo(name = "detailType")
    var detailType: String,
    @ColumnInfo(name = "detailYear")
    var detailYear: String,
    @ColumnInfo(name = "detailPlot")
    var detailPlot: String,
    @ColumnInfo(name = "detailRated")
    var detailRated: String,
    @ColumnInfo(name = "detailRuntime")
    var detailRuntime: String,
    @ColumnInfo(name = "detailLang")
    var detailLang: String,


    )