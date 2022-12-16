package com.example.drizzle_prj.cart

class CartModel {
    lateinit var pdNm:String
    lateinit var mkNm:String
    lateinit var price:String
    lateinit var pdImg:String

    constructor(pdNm:String,mkNm:String,price:String,pdImg:String){
        this.pdNm = pdNm
        this.mkNm = mkNm
        this.price = price
        this.pdImg = pdImg
    }

    constructor()
}