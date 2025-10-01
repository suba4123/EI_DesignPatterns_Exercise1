package Exercise1.structural.adapter;

public class PlugAdapterMain {
    public static void main(String[] args) {
        USPlug usPlug = new USPlug();
        IndianPlug adapter = new PlugAdapter(usPlug);

        adapter.supplyPower();
    }
}
