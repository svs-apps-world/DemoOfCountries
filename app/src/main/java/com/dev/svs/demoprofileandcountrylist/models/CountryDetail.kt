package com.dev.svs.demoprofileandcountrylist.models

class CountryDetail {
    var name: String? = null
    var topLevelDomain = ArrayList<Any>()
    var alpha2Code: String? = null
    var alpha3Code: String? = null
    var callingCodes = ArrayList<Any>()
    var capital: String? = null
    var altSpellings = ArrayList<Any>()
    var region: String? = null
    var subregion: String? = null
    var population: Float = 0.toFloat()
    var latlng = ArrayList<Any>()
    var demonym: String? = null
    var area: Float = 0.toFloat()
    var gini: Float = 0.toFloat()
    var timezones = ArrayList<Any>()
    var borders = ArrayList<Any>()
    var nativeName: String? = null
    var numericCode: String? = null
    var currencies = ArrayList<Any>()
    var languages = ArrayList<Any>()
    var TranslationsObject: Translations? = null
    var relevance: String? = null
}