package controller;

import model.PriceRange;
import model.ShopItem;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class ItemsController {

    private List<String> brands;
    private List<String> colors;
    private List<ShopItem> shopItems;
    private Map<String, PriceRange> priceRange;

    public ItemsController() {
        initializeBrands();
        initializeColors();
        initializePriceRanges();
        shopItems = new ArrayList<>();
        initializeItems();
        Collections.shuffle(shopItems);
    }


    private void initializeBrands (){
        brands = new ArrayList<>();
        brands.add("Adodos");
        brands.add("Mike");
        brands.add("Tim Tailor");
        brands.add("Buma");
        brands.add("Calvin Groß");
        brands.add("Superwet");
        brands.add("Bsics");
    }

    private void initializeColors(){
        colors = new ArrayList<>();
        colors.add("blue");
        colors.add("brown");
        colors.add("red");
        colors.add("black");
        colors.add("white");
        colors.add("grey");
        colors.add("green");
    }

    private void initializeItems(){
        generateItem("001","Chucks","Shoes",true,true);
        generateItem("002","Backpack","Accessories",true,true);
        generateItem("003","HeelsBoots","Shoes",false,true);
        generateItem("004","Boxers","Underwear",true,false);
        generateItem("005","Dress","Dress",false,true);
        generateItem("006","ChelseaBoots","Shoes",true,true);
        generateItem("007","ToteBag","Accessories",true,true);
        generateItem("008","CowboyBoots","Shoes",true,true);
        generateItem("009","JeansJacket","Jackets and Coats",true,true);
        generateItem("010","Pants","Trousers",true,true);
        generateItem("011","BusinessShoes","Shoes",true,false);
        generateItem("012","Top","Shirt",false,true);
        generateItem("013","EveningDress","Dress",false,true);
        generateItem("014","Espadrille","Shoes",false,true);
        generateItem("015","Flats","Shoes",false,true);
        generateItem("016","FlipFlops","Shoes",true,true);
        generateItem("017","Sunglasses","Accessories",true,true);
        generateItem("018","Gloves","Accessories",true,true);
        generateItem("019","Beanie","Accessories",true,true);
        generateItem("020","Hoodie","Pullovers",true,true);
        generateItem("021","JeanswithTears","Trousers",true,true);
        generateItem("022","Jeans","Trousers",true,true);
        generateItem("023","Kaki","Trousers",true,true);
        generateItem("024","Loafers","Shoes",true,true);
        generateItem("025","Purse","Accessories",false,true);
        generateItem("026","SummerDress","Dress",false,true);
        generateItem("027","Skirt","Skirts",false,true);
        generateItem("028","Skirtwithslitshort","Skirts",false,true);
        generateItem("029","Overall","Other",false,true);
        generateItem("030","Skirtwithslitlong","Skirts",false,true);
        generateItem("031","PencilSkirt","Skirts",false,true);
        generateItem("032","PoloShirt","Shirt",true,true);
        generateItem("033","HeelsLow","Shoes",false,true);
        generateItem("034","Briefcase","Accessories",true,true);
        generateItem("035","RainBoots","Shoes",true,true);
        generateItem("036","Pursesmall","Accessories",false,true);
        generateItem("037","RunningShoes","Shoes",true,true);
        generateItem("038","Sandals","Shoes",false,true);
        generateItem("039","Shirtwithpattern","Shirt",true,true);
        generateItem("040","Shorts","Trousers",true,true);
        generateItem("041","SkinnyJeans","Trousers",true,true);
        generateItem("042","Sneakers","Shoes",true,true);
        generateItem("043","Socks","Accessories",true,true);
        generateItem("044","SportBra","Underwear",false,true);
        generateItem("045","TShirtwithLines","Shirt",true,true);
        generateItem("046","Jacket","Jackets and Coats",true,false);
        generateItem("047","PamelaHat","Accessories",false,true);
        generateItem("048","Sweater","Pullovers",true,true);
        generateItem("049","Cardigan","Pullovers",true,true);
        generateItem("050","TShirtwithRocket","Shirt",true,false);
        generateItem("051","Top","Shirt",false,true);
        generateItem("052","ToteBagBig","Accessories",false,true);
        generateItem("053","TrenchCoat","Jackets and Coats",true,true);
        generateItem("054","SnowBoots","Shoes",false,true);
        generateItem("055","Tanga","Underwear",false,true);
        generateItem("056","UnderwearSet","Underwear",false,true);
        generateItem("057","Vest","Other",true,false);
        generateItem("058","Slip","Underwear",true,false);
        generateItem("059","Blazer","Jackets and Coats",false,true);
        generateItem("060","BriefcaseSmall","Accessories",true,true);
    }

    private void generateItem(String itemNo, String description, String itemType, boolean male, boolean female){
        for(String color: colors){
            for(String brand : brands){

                String shopItemId;
                String shopItemDescription = description;
                String shopItemType = itemType;
                String shopItemSuitedFor;
                String shopItemBrand = brand;
                String shopItemColor = color;
                String imgPath = "images/shopItems/" + itemNo +".png";
                double shopItemPrice = generateItemPrice(shopItemBrand, shopItemType);

                if (male){
                    shopItemId = itemNo + "-" + brand.charAt(0) + "-"+ color + "-M";
                    shopItemSuitedFor = "male";
                    shopItems.add(new ShopItem(shopItemId, shopItemDescription, shopItemType, shopItemSuitedFor, shopItemBrand, shopItemColor, imgPath, shopItemPrice));
                }

                if(female){
                    shopItemId = itemNo + "-" + brand.charAt(0) + "-"+ color + "-F";
                    shopItemSuitedFor = "female";
                    shopItems.add(new ShopItem(shopItemId, shopItemDescription, shopItemType, shopItemSuitedFor, shopItemBrand, shopItemColor, imgPath, shopItemPrice));
                }
            }
        }
    }

    private void initializePriceRanges(){
        priceRange = new TreeMap<>();
        priceRange.put("Shoes", new PriceRange(30,150));
        priceRange.put("Underwear", new PriceRange(5,50));
        priceRange.put("Dress", new PriceRange(30,150));
        priceRange.put("Accessories", new PriceRange(5,50));
        priceRange.put("Jackets and Coats", new PriceRange(30,200));
        priceRange.put("Shirt", new PriceRange(5,30));
        priceRange.put("Trousers", new PriceRange(30,80));
        priceRange.put("Pullovers", new PriceRange(20,80));
        priceRange.put("Skirts", new PriceRange(10,30));
        priceRange.put("Other", new PriceRange(20,50));
    }

    private double generateItemPrice(String brand, String type){
        PriceRange priceRange = this.priceRange.get(type);
        Random r = new Random();
        int low = (int) priceRange.getMin();
        int high = (int) priceRange.getMax();
        double result = r.nextInt(high-low) + low;

        //brand specific costs
        switch(brand) {
            case "Adodos":
                result = result + (0.2*result);
                break;
            case "Mike":
                result = result + (0.2*result);
                break;
            case "Tim Tailor":
                break;
            case "Buma":
                result = result + (0.1*result);
                break;
            case "Calvin Groß":
                result = result + (0.3*result);
                break;
            case "Superwet":
                result = result + (0.3*result);
                break;
            case "Bsics":
                break;
        }

        result = result-0.01d;
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ENGLISH);
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        return Double.valueOf(df.format(result));
    }



    public List<String> getBrands() {
        return brands;
    }

    public List<String> getColors() {
        return colors;
    }

    public List<ShopItem> getShopItems() {
        return shopItems;
    }



}
