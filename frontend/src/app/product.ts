export class Product {
   public id:Number;
   public name :String;
   public  category:String;
   public  pic:String;
   public  price:Number;
    constructor(name :String,category:String,pic:String,price:Number) {
        this.name=name;
        this.category=category;
        this.pic=pic;
        this.price=price;
    }
}