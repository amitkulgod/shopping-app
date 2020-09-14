/**
 * 
 */
package com.shopping.app.product.catalogue;

/**
 * @author AK
 *
 */
public class Product {
	
	    private Integer skuId;
	    private String name;
	    private Double price;
	    
	    
	    
		public Integer getSkuId() {
			return skuId;
		}
		public void setSkuId(Integer skuId) {
			this.skuId = skuId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((price == null) ? 0 : price.hashCode());
			result = prime * result + ((skuId == null) ? 0 : skuId.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product other = (Product) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (price == null) {
				if (other.price != null)
					return false;
			} else if (!price.equals(other.price))
				return false;
			if (skuId == null) {
				if (other.skuId != null)
					return false;
			} else if (!skuId.equals(other.skuId))
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "Product [skuId=" + skuId + ", name=" + name + ", price=" + price + "]";
		}
		
		
		public Product(Integer skuId, String name, Double price) {
			super();
			this.skuId = skuId;
			this.name = name;
			this.price = price;
		}
	    
	    
		
	    

}
