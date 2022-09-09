package com.example.demo.controller;
import com.example.demo.dao.ItemDAO;
import com.example.demo.model.Item;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    private ItemDAO itemdao = new ItemDAO();

    @GetMapping("/item/{Id}")
    
    public Item getItem(@PathVariable int Id){
        Item item = itemdao.getItem(Id);
        return item;
        
    }

    @GetMapping("item/item")
    public ArrayList<Item> getItemList(){
        ArrayList<Item> items = itemdao.getItemList();
        return items;
    }

    @PostMapping("/item")
    public String addItem(@RequestBody Item item){
        itemdao.createItem(item);
        return "item added successfully";
    }

    @DeleteMapping("/item")
    public String deleteItem(@RequestBody Item item){
        int success = itemdao.deleteItem(item);
        if(success == 1){
            return "item deleted successfully";
        }
        else{
            return "item not found";
        }
    }

    @PutMapping("/item")
    public String updateItem(@RequestBody Item item){
        int success = itemdao.updateItem(item);
        if(success == 1){
            return "item updated successfully";
        }
        else{
            return "item not found";
        }
    }

}
