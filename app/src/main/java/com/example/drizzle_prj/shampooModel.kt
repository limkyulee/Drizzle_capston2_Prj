package com.example.drizzle_prj

public class shampooModel {
    lateinit var id:String
    lateinit var pdNm:String
    lateinit var mkNm:String
    lateinit var price:String

    constructor(id:String,pdNm:String,mkNm:String,price:String){
        this.id = id
        this.pdNm = pdNm
        this.mkNm = mkNm
        this.price = price
    }

    constructor()
}