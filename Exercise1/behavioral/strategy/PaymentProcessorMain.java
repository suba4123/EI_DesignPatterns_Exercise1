package Exercise1.behavioral.strategy;

public class PaymentProcessorMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(500);

        cart.setPaymentStrategy(new PaypalPayment());
        cart.checkout(300);
    }
}
