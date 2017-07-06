package teerayut.dev.vlife.fragment.firstpage.item;

import android.os.Parcel;
import android.os.Parcelable;

import teerayut.dev.vlife.base.adapter.BaseItem;

import static teerayut.dev.vlife.fragment.firstpage.adapter.ItemAdapter.TYPE_PRODUCT;

/**
 * Created by teerayut.k on 7/6/2017.
 */

public class Item extends BaseItem implements Parcelable {

    private String id;
    private String name;
    private String image;
    private int pv;
    private int price;
    private String volume;
    private int amount = 1;
    private boolean isAdded = false;

    public Item() {
        super( TYPE_PRODUCT );
    }

    public String getId() {
        return id;
    }

    public Item setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Item setImage(String image) {
        this.image = image;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Item setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getVolume() {
        return volume;
    }

    public Item setVolume(String volume) {
        this.volume = volume;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public Item setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public void increaseAmount(){
        amount++;
    }

    public void decreaseAmount(){
        amount--;
        if( amount < 1 ) amount = 1;
    }

    public void clearAmount(){
        amount = 1;
    }

    public boolean isAdded(){
        return isAdded;
    }

    public void setAdded( boolean added ){
        isAdded = added;
    }

    @Override
    public boolean equals( Object o ){
        if( this == o ) return true;
        if( o == null || getClass() != o.getClass() ) return false;

        Item that = (Item) o;

        if( price != that.price ) return false;
        if( pv != that.pv ) return false;
        if( amount != that.amount ) return false;
        if( isAdded != that.isAdded ) return false;
        if( id != null ? !id.equals( that.id ) : that.id != null ) return false;
        //if( alcohol != null ? !alcohol.equals( that.alcohol ) : that.alcohol != null ) return false;
        if( image != null ? !image.equals( that.image ) : that.image != null ) return false;
        if( name != null ? !name.equals( that.name ) : that.name != null ) return false;
        return volume != null ? volume.equals( that.volume ) : that.volume == null;

    }

    @Override
    public int hashCode(){
        int result = id != null ? id.hashCode() : 0;
        //result = 31 * result + ( alcohol != null ? alcohol.hashCode() : 0 );
        result = 31 * result + ( image != null ? image.hashCode() : 0 );
        result = 31 * result + ( name != null ? name.hashCode() : 0 );
        result = 31 * result + price;
        result = 31 * result + pv;
        result = 31 * result + ( volume != null ? volume.hashCode() : 0 );
        result = 31 * result + amount;
        result = 31 * result + ( isAdded ? 1 : 0 );
        return result;
    }

    @Override
    public BaseItem clone() throws CloneNotSupportedException{
        Item item = new Item()
                .setId( id )
                .setImage( image )
                .setName( name )
                .setPrice( price )
                .setPv( pv )
                .setVolume( volume )
                .setAmount( amount );
        item.setAdded( isAdded );
        return item;
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags ){
        super.writeToParcel( dest, flags );
        dest.writeString( this.id );
        dest.writeString( this.image );
        dest.writeString( this.name );
        dest.writeInt( this.price );
        dest.writeInt( this.pv );
        dest.writeString( this.volume );
        dest.writeInt( this.amount );
        dest.writeByte( this.isAdded ? (byte) 1 : (byte) 0 );
    }

    protected Item(Parcel in ){
        super( in );
        this.id = in.readString();
        this.image = in.readString();
        this.name = in.readString();
        this.price = in.readInt();
        this.pv = in.readInt();
        this.volume = in.readString();
        this.amount = in.readInt();
        this.isAdded = in.readByte() != 0;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>(){
        @Override
        public Item createFromParcel(Parcel source ){
            return new Item( source );
        }

        @Override
        public Item[] newArray(int size ){
            return new Item[size];
        }
    };

    public int getPv() {
        return pv;
    }

    public Item setPv(int pv) {
        this.pv = pv;
        return this;
    }
}
