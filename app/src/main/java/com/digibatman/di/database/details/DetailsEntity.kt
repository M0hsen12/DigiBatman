package com.digibatman.di.database.details

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "details")
class DetailsEntity(
    @PrimaryKey
    @ColumnInfo(name = "detailsImdbId")
    var detailsImdbId: String,
    @ColumnInfo(name = "detailsTitle")
    var detailsTitle: String,
    @ColumnInfo(name = "detailsPoster")
    var detailsPoster: String,
    @ColumnInfo(name = "detailsType")
    var detailsType: String,
    @ColumnInfo(name = "detailsYear")
    var detailsYear: String,
    @ColumnInfo(name = "detailsPlot")
    var detailsPlot: String,
    @ColumnInfo(name = "detailsRated")
    var detailsRated: String,
    @ColumnInfo(name = "detailsRuntime")
    var detailsRuntime: String,
    @ColumnInfo(name = "detailsLang")
    var detailsLang: String,


    )