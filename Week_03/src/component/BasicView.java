package component;

public class BasicView implements View {
    protected String label;

    public BasicView(String label) {
        this.label = label;
    }

    @Override
    public void draw() {
        System.out.println("print " + this.getClass().getSimpleName() + "(" + label + ")");
    }
}
