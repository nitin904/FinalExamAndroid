package org.finalexam.final_patel_991489983

class Product{

    var id: Int = 0;
    var prodName: String? = null
    var price: String? = null
    var description: String? = null

    constructor(name: String, pri: String, desc: String) {
        this.prodName = name
        this.price = pri
        this.description = desc
    }
}