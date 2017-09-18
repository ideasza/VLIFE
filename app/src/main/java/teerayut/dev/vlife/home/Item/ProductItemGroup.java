package teerayut.dev.vlife.home.Item;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import teerayut.dev.vlife.base.adapter.BaseItem;

/**
 * Created by teerayut.k on 9/6/2017.
 */

public class ProductItemGroup implements Parcelable {

    private String STATUS;
    private List<ProductItem> PRODUCT;

    public ProductItemGroup() {

    }

    protected ProductItemGroup(Parcel in) {
        STATUS = in.readString();
        PRODUCT = (List<ProductItem>) in.readSerializable();
    }

    public static final Creator<ProductItemGroup> CREATOR = new Creator<ProductItemGroup>() {
        @Override
        public ProductItemGroup createFromParcel(Parcel in) {
            return new ProductItemGroup(in);
        }

        @Override
        public ProductItemGroup[] newArray(int size) {
            return new ProductItemGroup[size];
        }
    };

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public List<ProductItem> getPRODUCT() {
        return PRODUCT;
    }

    public void setPRODUCT(List<ProductItem> PRODUCT) {
        this.PRODUCT = PRODUCT;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(STATUS);
        parcel.writeSerializable((Serializable) PRODUCT);
    }
}
