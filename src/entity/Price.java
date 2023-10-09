
package entity;

import java.io.Serializable;

public class Price implements Serializable {

    private Integer id;
    private String price;

    public Price() {
    }

    public Price(Integer id) {
        this.id = id;
    }

    public Price(Integer id, String price) {
        this.id = id;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price{" + "id=" + id + ", price=" + price + '}';
    }

    
    
    
}
