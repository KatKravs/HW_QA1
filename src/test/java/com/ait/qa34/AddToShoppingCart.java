package com.ait.qa34;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToShoppingCart extends BasePage {

    @BeforeMethod
    public void ensurePrecondition() {
   
        click(By.cssSelector("[href='/login']"));

        type(By.cssSelector("#Email"),"manuel1734usenko18@gmail.com");

        type(By.id("Password"), "Pochemu_to123");

        click(By.cssSelector(".button-1.login-button"));
    }

    @Test
    public void addItemToShoppingCartPositiveTest(){
        int sizeBefore = sizeOfItemInShoppinCart();   
        click(By.cssSelector("div[data-productid='31'] input"));
       
        click(By.cssSelector("#topcartlink a"));
//       click(By.cssSelector("[name='updatecart']"));
        int sizeAfter = sizeOfItemInShoppinCart();
        Assert.assertEquals(sizeAfter,sizeBefore + 1);
        System.out.println(sizeAfter);
    }


}
