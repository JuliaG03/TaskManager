package services;

import utility.Data;

import java.text.ParseException;

public class ShopService {

    private utility.Data data;

    public ShopService(Data data) {
        this.data = data;
    }


  //from shopping task


//can't add all of the model.ShopObj method here because they are mainly based on a certain model.ShoppingTask.

    //public void

//getters and setters
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


}
