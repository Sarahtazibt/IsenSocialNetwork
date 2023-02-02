package fr.isen.tazibt.isensocialnetwork

class Post {
    /**set Data*/
    var userId:String? = null
    var carImg:String? = null
    var carYear:String? = null
    var carRetro:Boolean? = null
    var carBrand:String? = null
    var carColor:String? = null
    var carModel:String? = null
    var carHorsepower:String? = null

    constructor(){}

    constructor(
        userId:String?,
        carImg:String?,
        carYear:String?,
        carRetro:Boolean?,
        carBrand:String?,
        carColor:String?,
        carModel:String?,
        carHorsepower:String?
    ){
        this.userId = userId
        this.carImg = carImg
        this.carYear = carYear
        this.carRetro = carRetro
        this.carBrand = carBrand
        this.carColor = carColor
        this.carModel = carModel
        this.carHorsepower = carHorsepower
    }
}