package component;

import java.util.ArrayList;
import java.util.List;

public class Container extends BasicView {
    private final List<View> views;

    public Container(String label) {
        super(label);
        views = new ArrayList<>();
    }

    public void addView(View view) {
        views.add(view);
    }

    @Override
    public void draw() {
        super.draw();
        views.forEach(View::draw);
    }
}
