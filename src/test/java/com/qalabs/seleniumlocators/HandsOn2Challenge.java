package com.qalabs.seleniumlocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandsOn2Challenge {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.espn.com.mx/");

        //Para obtener toda el arreglo de informacion
        List<WebElement> myList = driver.findElements(By.xpath("//ul[@id= 'leagues']"));
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < myList.size(); i++){
            list.add(myList.get(i).getText());
        }
        //Para obtener todas las ligas
        List<WebElement> Ligas = driver.findElements(By.className("scoreLabel_content"));
        ArrayList<String> ligas = new ArrayList<String>();
        for(int i = 0; i < Ligas.size(); i++){
            ligas.add(Ligas.get(i).getText());
        }
        // Para obtener un arreglo de cadenas con cada elemento de "leagues"
        String renglon = list.toString();
        renglon=renglon.replaceAll("\n", "&");
        String[] renglones=renglon.split("&",0);

        renglones[0]=renglones[0].replace("[", "");
        renglones[renglones.length-1]=renglones[renglones.length-1].replace("]", "");

       //for(int i=0; i<renglones.length;i++)
         //System.out.println("elemento "+ i + " " +renglones[i]);

        // para sacar los indices de las ligas
        int j=0;
        //agregar un elemento al final para acomodar el tamanio del arreglo como ultimo indice
        int[] indices=new int [ligas.size()+1];

        for(int i = 0; i < renglones.length; i++){
            if (j==indices.length-1) {
                break;
            }
            if((renglones[i].compareTo(ligas.get(j).toString())==0)){
                indices[j]=i;
                j++;
            }
        }
        //agregar el ultimo temanio elemento del arreglo renglones como indice
        indices[indices.length-1]=renglones.length-1;
        //Imprimir Salida
        for (int i=0; i<indices.length-1;i++){
            System.out.println("-------------------------------");
            System.out.println("LEAGUE NAME: "+renglones[indices[i]]);
            System.out.println("Winners: ");
            if(i+1>=indices.length) {
                break;
            }
                for (int x = indices[i]; x < indices[i + 1];x++) {
                    if (renglones[x].compareTo("Final") == 0) {
                        renglones[x + 4] = renglones[x + 4].replaceAll(" ", "");
                        renglones[x + 2] = renglones[x + 2].replaceAll(" ", "");
                        if (Integer.parseInt(renglones[x + 4]) > Integer.parseInt(renglones[x + 2])) {
                            System.out.println(renglones[x + 3].toString() + "-" + renglones[x + 4].toString());
                        } else if (Integer.parseInt(renglones[x + 2])>Integer.parseInt(renglones[x + 4])){
                            System.out.println(renglones[x + 1].toString() + "-" + renglones[x + 2].toString());
                        }

                    }
                }
            }


        Thread.sleep(2000);
        driver.quit();
    }
}
