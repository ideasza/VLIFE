package teerayut.dev.vlife.api;

import java.util.ArrayList;
import java.util.List;

import teerayut.dev.vlife.api.result.ProductItemResult;
import teerayut.dev.vlife.api.result.ProductItemResultGroup;
import teerayut.dev.vlife.home.Item.ProductItem;
import teerayut.dev.vlife.home.Item.ProductItemGroup;


/**
 * Created by teerayut.k on 7/17/2017.
 */

public class ConvertItem {

    public static ProductItemGroup createProductItemGroupFromResult(ProductItemResultGroup resultGroup) {
        ProductItemGroup group = new ProductItemGroup();
        group.setSTATUS( resultGroup.getSTATUS() );
        group.setPRODUCT( ConvertItem.createListProductItemFromResultGroup(resultGroup.getPRODUCT()) );
        return group;
    }

    public static List<ProductItem>  createListProductItemFromResultGroup(List<ProductItemResult> results) {
        List<ProductItem> items = new ArrayList<>();
        for (ProductItemResult itemResult : results) {
            ProductItem item = new ProductItem();
            item.setPRODUCT_ID( itemResult.getPRODUCT_ID() );
            item.setPRODUCT_NAME1( itemResult.getPRODUCT_NAME1() );
            item.setPRODUCT_NAME2( itemResult.getPRODUCT_NAME2() );
            item.setPRODUCT_DETAIL1( itemResult.getPRODUCT_DETAIL1() );
            item.setPRODUCT_DETAIL2( itemResult.getPRODUCT_DETAIL2() );
            item.setPRODUCT_DETAIL3( itemResult.getPRODUCT_DETAIL3() );
            item.setPRODUCT_DETAIL4( itemResult.getPRODUCT_DETAIL4() );
            item.setPRODUCT_PRICE( itemResult.getPRODUCT_PRICE() );
            item.setPRODUCT_PV( itemResult.getPRODUCT_PV() );
            item.setPRODUCT_STATUS_RECOMMEND( itemResult.getPRODUCT_STATUS_RECOMMEND() );
            item.setPRODUCT_STATUS_BESTSELLER( itemResult.getPRODUCT_STATUS_BESTSELLER() );
            item.setPRODUCT_IMAGE( itemResult.getPRODUCT_IMAGE() );
            item.setGROUP_ID( itemResult.getGROUP_ID() );

            items.add(item);
        }
        return items;
    }

}
