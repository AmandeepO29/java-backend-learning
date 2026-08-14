package in.strikes.Payment;

public class UPIPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Paying via UPI");
    }
}
