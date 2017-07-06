package teerayut.dev.vlife.fragment.firstpage.adapter;

import java.util.ArrayList;
import java.util.List;

import teerayut.dev.vlife.fragment.firstpage.item.Item;

/**
 * Created by teerayut.k on 7/6/2017.
 */

public class ItemConverter {

    /*public static BeerProductItemGroup createBeerGroupItemFromResult( BeerProductResultGroup result ){
        BeerProductItemGroup group = new BeerProductItemGroup();
        group.setStatus( result.getStatus() );
        group.setMessage( result.getMessage() );
        group.setNextBeerAvailable( result.isNextBeerAvailable() );
        group.setNextBeerIndex( result.getNextBeerIndex() );
        group.setBeers( BeerConverter.createBeerProductItemsFromResult( result.getBeers() ) );
        return group;
    }*/

    public static List<Item> createBeerProductItemsFromResult(List<Item> result){
        List<Item> items = new ArrayList<>();
        /*for( BeerProductResult beerProductResult : result ){
            BeerProductItem item = new BeerProductItem()
                    .setId( beerProductResult.getId() )
                    .setAlcohol( beerProductResult.getAlcohol() )
                    .setImage( beerProductResult.getImage() )
                    .setName( beerProductResult.getName() )
                    .setPrice( beerProductResult.getPrice() )
                    .setAmount( beerProductResult.getAmount() )
                    .setVolume( beerProductResult.getVolume() );
            items.add( item );
        }*/
        return items;
    }
}
