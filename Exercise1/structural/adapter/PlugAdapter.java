package Exercise1.structural.adapter;

public class PlugAdapter implements IndianPlug {
    private USPlug usPlug;

    public PlugAdapter(USPlug usPlug) {
        this.usPlug = usPlug;
    }

    @Override
    public void supplyPower() {
        System.out.println("Converting power...");
        usPlug.provideElectricity();
    }
}
