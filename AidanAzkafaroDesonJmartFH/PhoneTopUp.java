package AidanAzkafaroDesonJmartFH;

public class PhoneTopUp extends Invoice{

	public String phoneNumber;
	public String status;
	
	public PhoneTopUp(int buyerId, int productId, String phoneNumber) {
		super(buyerId, productId);
		this.phoneNumber = phoneNumber;
	}

    @Override
	public double getTotalPay(Product product) {
		// TODO Auto-generated method stub
		return product.price + product.shipmentPlans;
	}

}
