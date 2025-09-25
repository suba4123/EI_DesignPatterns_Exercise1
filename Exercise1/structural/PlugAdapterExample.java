// Target interface
package Exercise1.structural;

interface IndianPlug {
    void supplyPower();
}

// Adaptee
class USPlug {
    public void provideElectricity() {
        System.out.println("Electricity from US plug (110V).");
    }
}

// Adapter
class PlugAdapter implements IndianPlug {
    private USPlug usPlug;
    public PlugAdapter(USPlug usPlug) { this.usPlug = usPlug; }
    public void supplyPower() {
        System.out.println("Converting power...");
        usPlug.provideElectricity();
    }
}

// Demo
public class PlugAdapterExample {
    public static void main(String[] args) {
        USPlug usPlug = new USPlug();
        IndianPlug adapter = new PlugAdapter(usPlug);

        adapter.supplyPower();
    }
}
