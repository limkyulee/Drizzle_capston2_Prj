package com.example.drizzle_prj.kitchen

public class kitchenModel {
    lateinit var id:String
    lateinit var pdNm:String
    lateinit var mkNm:String
    lateinit var price:String
    lateinit var pdImg:String

    constructor(id:String,pdNm:String,mkNm:String,price:String,pdImg:String){
        this.id = id
        this.pdNm = pdNm
        this.mkNm = mkNm
        this.price = price
        this.pdImg = pdImg
    }

    constructor()
}