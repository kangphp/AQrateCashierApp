import controllers.ItemController;
import models.Item;

public class Driver {
    public static void main(String[] args){
        ItemController uc = new ItemController();
        System.out.println(uc.getAllItems().toString());
    }   
}
