package teerayut.dev.vlife.profile.order_history.item;

import com.android.tonyvu.sc.model.Saleable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by teerayut.k on 7/16/2017.
 */

public class OrderHistoryItem implements Saleable, Serializable {
    private static final long serialVersionUID = -4073256626483275668L;



    public OrderHistoryItem() {
        super();
    }
    @Override
    public BigDecimal getPrice() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
